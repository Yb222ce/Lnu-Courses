package org.code.carrentalsystem.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.controller.CarsController;
import org.code.carrentalsystem.controller.CustomerController;
import org.code.carrentalsystem.model.Customer;
import org.code.carrentalsystem.model.Rent;

import java.time.format.DateTimeFormatter;

public class Booking {

    @FXML
    private ComboBox<String> customer;

    @FXML
    private TextField cost_per_day;

    @FXML
    private DatePicker borrowed_date;

    @FXML
    private DatePicker returned_date;
    CustomerController controller = new CustomerController();

    Rent rent;

    @FXML
    void initialize(){
        controller.load_customers();
        for (Customer c : controller.customers) {
            customer.getItems().add(c.getName());
        }
        rent = new Rent();
        Singleton.getInstance().numField(cost_per_day);
    }

    void book_model(int car_id){
        rent.setModel_id(car_id);
    }

    @FXML
    void book(ActionEvent event) {
        if(customer.getSelectionModel().isEmpty() || Singleton.getInstance().validate_textField(cost_per_day)) return;

        rent.setCost_per_day(Double.parseDouble(cost_per_day.getText()));
        rent.setBorrow_date(borrowed_date.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));
        if(returned_date.getValue() != null)
            rent.setReturn_date(returned_date.getValue().format(DateTimeFormatter.BASIC_ISO_DATE));
        int id = getCustomerId(customer.getSelectionModel().getSelectedItem());
        if(id != 0) {
            rent.setCustomer_id(id);
            CarsController controller = new CarsController();
            if(controller.rent_car(rent)){
                Singleton.getInstance().dialog_box("Success", "Rent the car successfully", "Your car is on rent successfully.\n stored information into database");
            }
            // save into database.
        }// failed reason.
        CLOSE();
    }

    @FXML
    void cancel(ActionEvent event) {
        CLOSE();
    }

    private void CLOSE() {
        Stage stage = (Stage) returned_date.getScene().getWindow();
        stage.close();
    }

    int getCustomerId(String name){
        for (Customer c : controller.customers) {
            if(c.getName().equals(name)){
                return c.getId();
            }
        }
        return 0;
    }

}
