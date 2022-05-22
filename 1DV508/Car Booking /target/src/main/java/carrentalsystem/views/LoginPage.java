package org.code.carrentalsystem.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.controller.LoginController;

public class LoginPage {

    @FXML
    private TextField user_input;

    @FXML
    private PasswordField pass_input;

    LoginController controller;

    @FXML
    void initialize(){
        controller = new LoginController();
    }

    @FXML
    void login(ActionEvent event) {

        if(user_input.getText().isEmpty() || pass_input.getText().isEmpty()){
            // show the error dialog.
            return;
        }

        String username = user_input.getText();
        String password = pass_input.getText();

        if(controller.login(username, password)){
            Stage stage = (Stage) user_input.getScene().getWindow();
            stage.setScene(new Scene(Singleton.getInstance()
                    .fxmlLoader("views/menu.fxml").getRoot()));
            stage.centerOnScreen();
        }else{
            // login failed.
        }
    }

}
