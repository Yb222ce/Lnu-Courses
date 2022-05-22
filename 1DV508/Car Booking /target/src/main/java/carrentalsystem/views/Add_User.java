package org.code.carrentalsystem.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.controller.UserController;
import org.code.carrentalsystem.model.User;

public class Add_User {

    @FXML
    private TextField username_input;

    @FXML
    private TextField name_input;

    @FXML
    private TextField pass_input;

    @FXML
    private TextField email_input;

    @FXML
    private TextField pNumber_Input;

    @FXML
    private CheckBox is_admin;

    @FXML
    private TextArea address_input;

    public User user;
    public boolean success;

    boolean edit_mode;
    UserController controller;


    @FXML
    void initialize(){
        controller = new UserController();
        controller.load_users();
    }

    @FXML
    void add_user(ActionEvent event) {
        if(!validate_username()) {
            username_input.setStyle("-fx-border-color: red;");
            return;
        }else username_input.setStyle("");
        if(Singleton.getInstance().validate_textField(name_input, pNumber_Input, email_input, pass_input) ||
                Singleton.getInstance().validate_areaField(address_input)){
            // popup window for an error
            return;
        }

        if(!edit_mode) {
            user = new User();
            user.setName(name_input.getText());
            user.setUsername(username_input.getText());
            user.setPassword(pass_input.getText());
            user.setEmail(email_input.getText());
            user.setPhone_number(pNumber_Input.getText());
            user.setAddress(address_input.getText());
            user.setAdmin(is_admin.isSelected());

            success = controller.add_user(user);
        }else{
            user.setName(name_input.getText());
            user.setUsername(username_input.getText());
            user.setPassword(pass_input.getText());
            user.setEmail(email_input.getText());
            user.setPhone_number(pNumber_Input.getText());
            user.setAddress(address_input.getText());
            user.setAdmin(is_admin.isSelected());

            success = controller.update_user(user);
        }
        close();
    }

    boolean validate_username(){
        if(username_input.getText().isEmpty()) return false;

        for (User user1 : controller.users) {
            if(user1.getUsername().equals(username_input.getText())){
                return false;
            }
        }
        return true;
    }

    public void edit_user(User user){
        name_input.setText(user.getName());
        username_input.setText(user.getUsername());
        username_input.setDisable(true);
        pass_input.setText(user.getPassword());
        email_input.setText(user.getEmail());
        pNumber_Input.setText(user.getPhone_number());
        address_input.setText(user.getAddress());
        is_admin.setSelected(user.isAdmin());
    }

    @FXML
    void cancel(ActionEvent event) {
        close();
    }

    void close(){
        Stage stage = (Stage) name_input.getScene().getWindow();
        stage.close();
    }

}
