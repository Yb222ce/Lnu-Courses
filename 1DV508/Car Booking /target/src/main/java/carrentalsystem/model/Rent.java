package org.code.carrentalsystem.model;

public class Rent {

    private int id;
    private int customer_id;
    private int model_id;
    private String borrow_date;
    private String return_date;
    private double cost_per_day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public double getCost_per_day() {
        return cost_per_day;
    }

    public void setCost_per_day(double cost_per_day) {
        this.cost_per_day = cost_per_day;
    }
}
