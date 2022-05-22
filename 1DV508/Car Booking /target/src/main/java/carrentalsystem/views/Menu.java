package org.code.carrentalsystem.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.code.carrentalsystem.Singleton;

public class Menu {

    @FXML
    private BorderPane root;

    @FXML
    void cars(ActionEvent event) {
        root.setCenter(Singleton.getInstance().fxmlLoader("views/car_view.fxml").getRoot());
    }

    @FXML
    void customers(ActionEvent event) {
        root.setCenter(Singleton.getInstance().fxmlLoader("views/customer_view.fxml").getRoot());
    }

    @FXML
    void home_page(MouseEvent event) {
        root.setCenter(null);
    }

    @FXML
    void logout(ActionEvent event) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(Singleton.getInstance()
                .fxmlLoader("views/LoginPage.fxml").getRoot()));
        stage.centerOnScreen();
    }

    @FXML
    void settings(ActionEvent event) {
        root.setCenter(Singleton.getInstance().fxmlLoader("views/settings.fxml").getRoot());
    }

    @FXML
    void users(ActionEvent event) {
        root.setCenter(Singleton.getInstance().fxmlLoader("views/user_view.fxml").getRoot());
    }

}
