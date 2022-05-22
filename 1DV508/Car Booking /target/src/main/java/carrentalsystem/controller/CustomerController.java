package org.code.carrentalsystem.controller;

import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerController {

    public ArrayList<Customer> customers = new ArrayList<>();

    public boolean add_customer(Customer customer){
        String sql = "insert into customer(name, address, phone_number, email, license) VALUES(?,?,?,?,?);";

        try{
            PreparedStatement statement = Singleton.getInstance().database.getConnection().prepareStatement(sql);

            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAddress());
            statement.setString(3, customer.getPhone_number());
            statement.setString(4, customer.getEmail());
            statement.setBoolean(5, customer.getLicense());
            System.out.println(statement.execute() ? "FAILED": "ADDED");

            sql = "SELECT LAST_INSERT_ID();";

            ResultSet result = Singleton.getInstance().database.getConnection().createStatement().executeQuery(sql);

            if(result.next()){
                customer.setId(result.getInt("LAST_INSERT_ID()"));
                System.out.println("Customer ID: "+customer.getId());
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean update_customer(Customer customer){
        String sql = "UPDATE customer SET name=?, address=?, email=?, phone_number=?, license=? WHERE id = "+customer.getId()+";";

        try{
            PreparedStatement statement = Singleton.getInstance().database.getConnection().prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAddress());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone_number());
            statement.setBoolean(5, customer.getLicense());
            return !statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public void load_customers(){
        String sql = "select * from customer;";
        try{
            ResultSet result = Singleton.getInstance().database.getConnection()
                    .createStatement().executeQuery(sql);

            while(result.next()){
                Customer customer = new Customer();
                customer.setName(result.getString("name"));
                customer.setEmail(result.getString("email"));
                customer.setAddress(result.getString("address"));
                customer.setId(result.getInt("id"));
                customer.setPhone_number(result.getString("phone_number"));
                customer.setLicense(result.getBoolean("license"));
                customers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getCustomerName(int id){
        String sql = "select name from customer where id = "+id+";";
        try{
            ResultSet result = Singleton.getInstance().database.getConnection().createStatement().executeQuery(sql);
            if(result.next())
                return result.getString("name");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "";
    }

    public boolean delete_customer(Customer selectedItem) {
        String sql = "delete from customer where id = "+selectedItem.getId();
        try{
            return !Singleton.getInstance().database.getConnection().createStatement().execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
