package org.code.carrentalsystem.model;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone_number;
    private String email;
    private boolean license;

    public Customer(){

    }

    public Customer(String name, String address, String phone_number, String email){
        setName(name);
        setAddress(address);
        setPhone_number(phone_number);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    public String insert_query(){
        String attributes = "name, address, phone_number, email, license", values = name+","+address+","+phone_number+","+email+","+license;

        return "insert into customer("+address+") values("+values+");";
    }
}
