package org.code.carrentalsystem.views;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.code.carrentalsystem.controller.CarsController;
import org.code.carrentalsystem.controller.CustomerController;
import org.code.carrentalsystem.model.Car;
import org.code.carrentalsystem.model.Rent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RentHistory {

    @FXML
    private TableView<HistoryModel> tableView;

    @FXML
    private TableColumn<HistoryModel, String> model_name;

    @FXML
    private TableColumn<HistoryModel, String> customer_name;

    @FXML
    private TableColumn<HistoryModel, String> borrowed_date;

    @FXML
    private TableColumn<HistoryModel, String> return_date;

    @FXML
    private TableColumn<HistoryModel, Double> earned;

    public static class HistoryModel{
        String model_name;
        String customer_name;
        String borrowed_date;
        String return_date;
        double earned;

        HistoryModel(String m_name, String c_name, String b_date, String r_date, double earned){
            model_name = m_name;
            customer_name = c_name;
            borrowed_date = b_date;
            return_date = r_date;
            this.earned = earned;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public String getModel_name() {
            return model_name;
        }

        public String getBorrowed_date() {
            return borrowed_date;
        }

        public String getReturn_date() {
            return return_date;
        }

        public double getEarned() {
            return earned;
        }
    }

    ArrayList<HistoryModel> historyModels = new ArrayList<>();

    @FXML
    void initialize(){
        model_name.setCellValueFactory(new PropertyValueFactory<>("model_name"));
        customer_name.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        borrowed_date.setCellValueFactory(new PropertyValueFactory<>("borrowed_date"));
        return_date.setCellValueFactory(new PropertyValueFactory<>("return_date"));
        earned.setCellValueFactory(new PropertyValueFactory<>("earned"));
    }

    public void car_rent_history(Car car){
        for (Rent rent : new CarsController().carRent_history(car.getId())) {
            try {
                historyModels.add(
                        new HistoryModel(car.getModel_name(),
                                new CustomerController().getCustomerName(rent.getCustomer_id()),
                                rent.getBorrow_date(), rent.getReturn_date(),
                                total_earned(rent.getBorrow_date(), rent.getReturn_date(), rent.getCost_per_day()))
                );
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        tableView.getItems().addAll(historyModels);
    }

    double total_earned(String borrow_date, String return_date, double cost_per_day) throws ParseException {
        if(return_date == null) return cost_per_day;
        if (borrow_date.equals (return_date) || return_date.isEmpty ( )) return cost_per_day;
        SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy");
        Date d1 = sdf.parse (borrow_date);
        Date d2 = sdf.parse (return_date);
        long time_difference = d2.getTime ( ) - d1.getTime ( );
        long day_difference = TimeUnit.MICROSECONDS.toDays (time_difference);


            return day_difference * cost_per_day;
    }

}
