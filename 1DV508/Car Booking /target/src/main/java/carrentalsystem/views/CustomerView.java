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
import org.code.carrentalsystem.controller.CustomerController;
import org.code.carrentalsystem.model.Customer;

public class CustomerView {

    @FXML
    private TableView<Customer> tableview;

    @FXML
    private TableColumn<Customer, String> name;

    @FXML
    private TableColumn<Customer, String> email;

    @FXML
    private TableColumn<Customer, String> phone_number;

    @FXML
    private TableColumn<Customer, String> address;

    @FXML
    private TableColumn<Customer, Boolean> licensed;

    CustomerController controller;

    @FXML
    void initialize(){
        controller = new CustomerController();

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        licensed.setCellValueFactory(new PropertyValueFactory<>("license"));

        controller.load_customers();

        tableview.getItems().addAll(controller.customers);

        ContextMenu contextMenu = new ContextMenu();

        contextMenu.getItems().add(Singleton.getInstance().getMenuItem("Add New", e->{
            Stage stage = new Stage();
            stage.setTitle("Add Customer");
            FXMLLoader loader = Singleton.getInstance().fxmlLoader("views/add_customer.fxml");
            Add_Customer con = loader.getController();
            stage.setScene(new Scene(loader.getRoot()));
            stage.showAndWait();
            if(con.success)
                tableview.getItems().add(con.customer);
        }));

        contextMenu.getItems().add(Singleton.getInstance().getMenuItem("Edit Customer", e->{

            Customer customer = tableview.getSelectionModel().getSelectedItem();
            if(customer == null) return;

            Stage stage = new Stage();
            stage.setTitle("Edit Customer");
            FXMLLoader loader = Singleton.getInstance().fxmlLoader("views/add_customer.fxml");
            Add_Customer con = loader.getController();
            con.edit_customer(customer);
            stage.setScene(new Scene(loader.getRoot()));
            stage.showAndWait();
            if(con.success)
                tableview.refresh();
        }));
        contextMenu.getItems().add(Singleton.getInstance().getMenuItem("Delete", e->{
            Customer customer = tableview.getSelectionModel().getSelectedItem();
            if(customer == null) return;
            if(controller.delete_customer(customer)){
                tableview.getItems().remove(customer);
            }

        }));

        tableview.setContextMenu(contextMenu);
    }
}
