package org.code.carrentalsystem.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.controller.CarsController;
import org.code.carrentalsystem.model.Car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class AddCar {

    @FXML
    private Rectangle car_image;

    @FXML
    private TextField name_input;

    @FXML
    private TextField seats_input;

    @FXML
    private TextField reg_num_input;

    private File file;

    public Car car = null;

    boolean edit_mode = false;

    CarsController controller = new CarsController();

    @FXML
    void initialize(){
        Singleton.getInstance().numField(seats_input);
    }

    @FXML
    void cancel(ActionEvent event) {
        close();
    }

    private void close() {
        System.out.println("problem in stage?");
        Stage stage = (Stage) name_input.getScene().getWindow();
        stage.close();
        System.out.println("problem in stage?2");

    }

    @FXML
    void save(ActionEvent event) {
        // if the fields are empty.
        if(Singleton.getInstance().validate_textField(name_input, seats_input, reg_num_input)) return;

        String model_name = name_input.getText();
        int total_seats = Integer.parseInt(seats_input.getText());
        String registration_number = reg_num_input.getText();

        if(!edit_mode)
            car = new Car();
        car.setModel_name(model_name);
        car.setTotal_seats(total_seats);
        car.setRegistration_number(registration_number);

        if(file != null) {
            try {
                car.fileInputStream = new FileInputStream(file);
                car.image_length = (int) file.length();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(edit_mode)
            if(controller.update_car(this.car)){
                this.car = null;
            }

        close();
    }

    @FXML
    void upload_image(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        chooser.setTitle("Load Car Image");
        file = chooser.showOpenDialog(null);
        System.out.println(file.getAbsolutePath());
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(image == null) return;
        car_image.setFill(new ImagePattern(image));
    }

    public void edit_car(Car car){
        this.car = car;
        edit_mode = true;
        try {
            car_image.setFill(new ImagePattern(car.getCar_image()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        name_input.setText(car.getModel_name());
        seats_input.setText(car.getTotal_seats()+"");
        reg_num_input.setText(car.getRegistration_number());
    }

}
