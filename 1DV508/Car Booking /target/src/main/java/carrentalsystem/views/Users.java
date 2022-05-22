package org.code.carrentalsystem.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.controller.UserController;
import org.code.carrentalsystem.model.User;

public class Users {

    @FXML
    private TableView<User> tableview;

    @FXML
    private TableColumn<User, String> name;

    @FXML
    private TableColumn<User, String> phone_number;

    @FXML
    private TableColumn<User, String> email;

    @FXML
    private TableColumn<User, String> address;

    @FXML
    private TableColumn<User, Boolean> admin;

    UserController controller;

    @FXML
    void initialize(){
        controller = new UserController();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        admin.setCellValueFactory(new PropertyValueFactory<>("admin"));

        controller.load_users();

        tableview.getItems().addAll(controller.users);

        add_context_menu();
    }

    void add_context_menu(){
        ContextMenu contextMenu = new ContextMenu();

        contextMenu.getItems().add(Singleton.getInstance().getMenuItem("Add User", e->{
            if(!Singleton.getInstance().active_user.isAdmin()) {
                // do something..
                return;
            }
            Stage stage = new Stage();
            stage.setTitle("Add New User");
            FXMLLoader loader = Singleton.getInstance().fxmlLoader("views/add_user.fxml");
            Add_User add_user = loader.getController();
            stage.setScene(new Scene(loader.getRoot()));
            stage.showAndWait();

            if(add_user.success){
                tableview.getItems().add(add_user.user);
            }
        }));

        contextMenu.getItems().add(Singleton.getInstance().getMenuItem("Edit User", e->{
            if(!Singleton.getInstance().active_user.isAdmin()) {
                // do something..
                return;
            }
            User user = tableview.getSelectionModel().getSelectedItem();
            if(user == null) return;

            Stage stage = new Stage();
            stage.setTitle("Edit User");
            FXMLLoader loader = Singleton.getInstance().fxmlLoader("views/add_user.fxml");
            Add_User add_user = loader.getController();
            add_user.edit_user(user);
            stage.setScene(new Scene(loader.getRoot()));
            stage.showAndWait();

            if(add_user.success){
                tableview.getItems().add(add_user.user);
            }
        }));

        contextMenu.getItems().add(Singleton.getInstance().getMenuItem("Delete User", e->{
            if(!Singleton.getInstance().active_user.isAdmin()) {
                // do something..
                return;
            }
            User user = tableview.getSelectionModel().getSelectedItem();
            if(user == null) return;
            if(controller.delete_user(user))
                tableview.getItems().remove(user);

        }));

        tableview.setContextMenu(contextMenu);
    }



}
