package org.code.carrentalsystem.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.controller.CustomerController;
import org.code.carrentalsystem.model.Customer;

public class Add_Customer {

    @FXML
    private TextField name_input;

    @FXML
    private TextField email_input;

    @FXML
    private TextField phone_number;

    @FXML
    private TextArea address_input;

    @FXML
    private CheckBox is_licensed;

    CustomerController controller = new CustomerController();

    boolean edit_mode;

    public boolean success = false;
    public Customer customer = new Customer();

    @FXML
    void add(ActionEvent event) {
        if(Singleton.getInstance().validate_textField(name_input, phone_number, email_input) ||
        Singleton.getInstance().validate_areaField(address_input)) return;

        if(!edit_mode) {
            Customer customer = new Customer(name_input.getText(), address_input.getText(), phone_number.getText(), email_input.getText());
            customer.setLicense(is_licensed.isSelected());
            if (controller.add_customer(customer)) {
                // do something.
                Singleton.getInstance().dialog_box("Pass", "Successfully added customer", customer.getName()+ "Customer details has been stored into database.");

                success = true;
                this.customer = customer;
            }
        }else {
            this.customer.setName(name_input.getText());
            this.customer.setEmail(email_input.getText());
            this.customer.setPhone_number(phone_number.getText());
            this.customer.setAddress(address_input.getText());
            this.customer.setLicense(is_licensed.isSelected());
            if (controller.update_customer(customer)) {
                success = true;
            }else{
                Singleton.getInstance().dialog_box("Update Fail", "Failed to update the customer", "please check the inputs and retry or it's possible database is not connected.");

            }
        }
        close();
    }

    @FXML
    void cancel(ActionEvent event) {
        close();
    }

    private void close() {
        Stage stage = (Stage) name_input.getScene().getWindow();
        stage.close();
    }

    public void edit_customer(Customer customer){
        this.customer = customer;
        edit_mode = true;
        name_input.setText(customer.getName());
        address_input.setText(customer.getAddress());
        email_input.setText(customer.getEmail());
        is_licensed.setSelected(customer.getLicense());
        phone_number.setText(customer.getPhone_number());
    }
}
