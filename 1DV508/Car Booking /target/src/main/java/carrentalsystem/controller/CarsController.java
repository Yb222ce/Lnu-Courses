package org.code.carrentalsystem.controller;

import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.model.Car;
import org.code.carrentalsystem.model.Rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CarsController {

    public ArrayList<Car> cars = new ArrayList<>();

    public CarsController(){
        load_cars();
    }

    void load_cars(){
        String sql = "select * from car;";

        try {
            ResultSet result = Singleton.getInstance().database.getConnection().createStatement().executeQuery(sql);

            while(result.next()){
                Car car = new Car();
                car.setId(result.getInt("id"));
                car.setCar_image(result.getBlob("car_image"));
                car.setModel_name(result.getString("model_name"));
                car.setTotal_seats(result.getInt("total_seats"));
                car.setRegistration_number(result.getString("registration_number"));
                car.setRental_id(result.getInt("rental_id"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addCar(Car car) {
        String sql = "insert into car(car_image, model_name, total_seats, registration_number) values(?,?,?,?);";
        boolean cond = false;
        try {
            PreparedStatement statement = Singleton.getInstance().database.getConnection().prepareStatement(sql);
            statement.setBlob(1, car.fileInputStream, car.image_length);
            statement.setString(2, car.getModel_name());
            statement.setInt(3, car.getTotal_seats());
            statement.setString(4, car.getRegistration_number());
            cond = !statement.execute();

            sql = "SELECT LAST_INSERT_ID();";

            ResultSet result = Singleton.getInstance().database.getConnection().createStatement().executeQuery(sql);

            if(result.next()){
                car.setId(result.getInt("LAST_INSERT_ID()"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cond;
    }

    public boolean update_car(Car car){
        String sql = "UPDATE car SET "+(car.fileInputStream == null ? "" : "car_image = ?,")+
                "model_name = ?, total_seats = ?, registration_number = ? WHERE id = "+car.getId()+";";
        boolean cond = false;
        try{
            PreparedStatement statement = Singleton.getInstance().database.getConnection().prepareStatement(sql);
            int n = 1;
            if(car.fileInputStream != null)
                statement.setBlob(n++, car.fileInputStream, car.image_length);
            statement.setString(n++, car.getModel_name());
            statement.setInt(n++, car.getTotal_seats());
            statement.setString(n, car.getRegistration_number());
            cond = !statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cond;
    }

    public boolean remove(Car car) {
        String sql = "DELETE from car WHERE id="+car.getId()+";";
        try{
            return !Singleton.getInstance().database.getConnection().createStatement().execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean rent_car(Rent rent){
        String sql = "insert into rent(customer_id, borrow_date, cost_per_day, model_id) VALUES(?,?,?,?);";
        boolean cond = false;
        try{
            PreparedStatement statement = Singleton.getInstance().database.getConnection().prepareStatement(sql);
            statement.setInt(1, rent.getCustomer_id());
            statement.setString(2, rent.getBorrow_date());
            statement.setDouble(3, rent.getCost_per_day());
            statement.setInt(4, rent.getModel_id());
            cond = !statement.execute();

            sql = "SELECT LAST_INSERT_ID();";

            ResultSet result = Singleton.getInstance().database.getConnection().createStatement().executeQuery(sql);
            int id = 0;
            if(result.next()){
                id = result.getInt("LAST_INSERT_ID()");
            }

            if(id != 0) {
                sql = "UPDATE car SET rental_id = " + id + " WHERE id = " + rent.getModel_id() + ";";
                cond = !Singleton.getInstance().database.getConnection().createStatement().execute(sql);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cond;
    }

    public boolean return_car(Car car){

        String current_date = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        String sql = "UPDATE rent SET return_date = "+current_date+" WHERE id = "+car.getRental_id();

        boolean cond = false;
        try{
            cond = !Singleton.getInstance().database.getConnection().createStatement().execute(sql);

            if(cond){
                sql = "UPDATE car SET rental_id = 0 WHERE id = "+car.getId()+";";
                cond = !Singleton.getInstance().database.getConnection().createStatement().execute(sql);
                if(cond)
                    car.setRental_id(0);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cond;
    }

    public ArrayList<Rent> carRent_history(int car_id){
        String sql = "select * from rent where model_id = "+car_id+";";
        ArrayList<Rent> rents = new ArrayList<>();
        try{
            ResultSet result = Singleton.getInstance().database.getConnection().createStatement().executeQuery(sql);
            while(result.next()){
                Rent rent = new Rent();
                rent.setCustomer_id(result.getInt("customer_id"));
                rent.setBorrow_date(result.getString("borrow_date"));
                rent.setReturn_date(result.getString("return_date"));
                rent.setCost_per_day(result.getDouble("cost_per_day"));
                rent.setModel_id(result.getInt("model_id"));
                rent.setId(result.getInt("id"));
                rents.add(rent);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rents;
    }
}
