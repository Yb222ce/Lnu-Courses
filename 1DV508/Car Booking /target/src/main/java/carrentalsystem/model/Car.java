package org.code.carrentalsystem.model;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class Car {
    private int id;
    private Blob car_image;
    private String model_name;
    private int total_seats;
    private String registration_number;
    private int rental_id;

    public FileInputStream fileInputStream;
    public int image_length;

    public Car(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCar_image(Blob car_image) {
        this.car_image = car_image;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public Image getCar_image() throws SQLException {
        if(car_image != null)
            return new Image(car_image.getBinaryStream());
        else if(fileInputStream != null)
            return new Image(fileInputStream);
        return null;
    }
}
