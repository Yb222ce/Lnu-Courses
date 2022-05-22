package org.code.carrentalsystem.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.controller.UserController;
import org.code.carrentalsystem.model.User;

public class Settings {

    @FXML
    private TextField name_input;

    @FXML
    private TextField email_input;

    @FXML
    private TextField phone_number_input;

    @FXML
    private PasswordField password_input;

    @FXML
    private TextArea address_input;


    @FXML
    void initialize(){
        setUser(Singleton.getInstance().active_user);
    }

    @FXML
    void update(ActionEvent event) {
        if(Singleton.getInstance().validate_textField(name_input, email_input, phone_number_input) ||
                Singleton.getInstance().validate_passField(password_input) ||
                Singleton.getInstance().validate_areaField(address_input)){
            return;
        }

        Singleton.getInstance().active_user.setName(name_input.getText());
        Singleton.getInstance().active_user.setEmail(email_input.getText());
        Singleton.getInstance().active_user.setPhone_number(phone_number_input.getText());
        Singleton.getInstance().active_user.setPassword(password_input.getText());
        Singleton.getInstance().active_user.setAddress(address_input.getText());

        new UserController().update_user(Singleton.getInstance().active_user);
    }

    public void setUser(User user){
        name_input.setText(user.getName());
        email_input.setText(user.getEmail());
        phone_number_input.setText(user.getPhone_number());
        password_input.setText(user.getPassword());
        address_input.setText(user.getAddress());
    }




}
