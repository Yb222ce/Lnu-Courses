package org.code.carrentalsystem.controller;

import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {

    public ArrayList<User> users = new ArrayList<>();

    public void  load_users(){
        String sql = "select * from user;";
        try{
            ResultSet result = Singleton.getInstance()
                    .database.getConnection().createStatement().executeQuery(sql);
            while(result.next()){
                User user = new User();
                user.setName(result.getString("name"));
                user.setAddress(result.getString("address"));
                user.setPhone_number(result.getString("phone_number"));
                user.setEmail(result.getString("email"));
                user.setAdmin(result.getBoolean("admin"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean add_user(User user){
        String sql = "insert into user(username, name, email, address, phone_number, admin, password) VALUES(?,?,?,?,?,?,?);";
        try{
            PreparedStatement statement = Singleton.getInstance().database.getConnection().prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPhone_number());
            statement.setBoolean(6, user.isAdmin());
            statement.setString(7, user.getPassword());
            if(!statement.execute()){
                users.add(user);
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean update_user(User user){
        String sql = "UPDATE user SET name = ?, email = ?, address = ?, phone_number = ?, admin = ?, password = ? where username = '"+user.getUsername()+"';";

        try{
            PreparedStatement statement = Singleton.getInstance().database.getConnection().prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getPhone_number());
            statement.setBoolean(5, user.isAdmin());
            statement.setString(6, user.getPassword());
            if(!statement.execute())
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean delete_user(User user){
        String sql = "DELETE user WHERE username = "+user.getUsername()+";";
        try{
            return !Singleton.getInstance().database.getConnection().createStatement().execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
