package org.code.carrentalsystem.controller;

import org.code.carrentalsystem.Singleton;
import org.code.carrentalsystem.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    public boolean login(String username, String password){
        String query = "select * from user where username = '"+username+"' and password = '"+password+"';";
        boolean cond = false;
        try {
            ResultSet result = Singleton.getInstance().database.getConnection().createStatement().executeQuery(query);
            if(result.next()){
                cond = true;
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setName(result.getString("name"));
                user.setAddress(result.getString("address"));
                user.setEmail(result.getString("email"));
                user.setAdmin(result.getBoolean("admin"));
                user.setPhone_number(result.getString("phone_number"));
                Singleton.getInstance().active_user = user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cond;
    }
}
