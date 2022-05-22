package org.code.carrentalsystem.views;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.controller.CarsController;
import org.code.carrentalsystem.model.Car;

import java.sql.SQLException;

public class CarModel {

    @FXML
    private AnchorPane car_model_root;

    @FXML
    private Rectangle car_image;

    @FXML
    private Label car_name;

    public Car car;

    @FXML
    private JFXButton book_btn;

    CarsController controller;

    @FXML
    void initialize(){
        controller = new CarsController();
    }


    public void setCar(Car car){
        this.car = car;
        car_name.setText(car.getModel_name());
        if(car.getRental_id() != 0){
            book_btn.setText("return");
            book_btn.setOnAction(e->{
                // return the vehicle functionality.
                if(new CarsController().return_car(car)){
                    Singleton.getInstance().dialog_box("Success", "Return the Vehicle", car.getModel_name()+" has returned from the customer.\n updated record into database successfully.");
                    book_btn.setText("book");
                    book_btn.setOnAction(this::book);
                }
            });
        }
        try {
            car_image.setFill(new ImagePattern(car.getCar_image()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void book(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader loader = Singleton.getInstance().fxmlLoader("views/booking.fxml");
        Booking controller = loader.getController();
        controller.book_model(car.getId());
        stage.setTitle("Car Booking.");
        stage.setScene(new Scene(loader.getRoot()));
        stage.showAndWait();
    }

}
