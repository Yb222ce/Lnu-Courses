package org.code.carrentalsystem.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.controller.CarsController;
import org.code.carrentalsystem.model.Car;

public class CarView {

    @FXML
    private Label cars_in_database;

    @FXML
    private FlowPane flowPane;

    CarsController controller = new CarsController();

    @FXML
    void initialize(){
        updateListView();
    }

    @FXML
    void add_car(ActionEvent event) {

        FXMLLoader loader = Singleton.getInstance().fxmlLoader("views/AddCar.fxml");
        AddCar addCar = loader.getController();

        Stage stage = new Stage();
        stage.setTitle("Add Car");
        stage.setScene(new Scene(loader.getRoot()));
        stage.showAndWait();

        if(addCar.car != null){
            if(controller.addCar(addCar.car)) {
                controller.cars.add(addCar.car);
            }
        }
    }

    void addContextMenu(Car car, AnchorPane root){
        ContextMenu contextMenu = new ContextMenu();

        contextMenu.getItems().add(Singleton.getInstance().getMenuItem(
                "Edit", e->{
                    FXMLLoader loader = Singleton.getInstance().fxmlLoader("views/AddCar.fxml");
                    AddCar con = loader.getController();
                    Stage stage = new Stage();
                    stage.setTitle("Edit Car");
                    con.edit_car(car);
                    stage.setScene(new Scene(loader.getRoot()));
                    stage.showAndWait();
                }));

        contextMenu.getItems().add(Singleton.getInstance().getMenuItem("Rent History", e->{
                    FXMLLoader loader = Singleton.getInstance().fxmlLoader("views/rent_history.fxml");
                    RentHistory controller = loader.getController();
                    controller.car_rent_history(car);
                    Stage stage = new Stage();
                    stage.setTitle("Rent History");
                    stage.setScene(new Scene(loader.getRoot()));
                    stage.showAndWait();
                }
        ));

        contextMenu.getItems().add(Singleton.getInstance().getMenuItem("Remove", e->{
            if(controller.remove(car)) {
                controller.cars.remove(car);
                updateListView();
            }
        }));

        root.setOnContextMenuRequested(e->{
            contextMenu.show(root, Side.RIGHT, -50,10);
        });
    }

    void updateListView(){
        flowPane.getChildren().clear();
        try {
            for (Car car : controller.cars) {
                FXMLLoader loader = Singleton.getInstance().fxmlLoader("views/CarModel.fxml");
                CarModel controller = loader.getController();
                controller.setCar(car);
                flowPane.getChildren().add(loader.getRoot());
                addContextMenu(car, loader.getRoot());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        cars_in_database.setText(cars_in_database.getText().replace("X", controller.cars.size()+""));
    }

}
