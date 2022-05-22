package org.code.carrentalsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    //This class will hold all functions to do with item detail, such as calling all of an item's attributes from the
    //database.

    private Connection connection;

    public Connection getConnection(){
        if(this.connection == null){
            authorize();
        }
        return connection;
    }

    private void authorize(){
        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/carrental", "root", "12345");
            //Prints Message to Console if successful connection to database is made.
            System.out.println("Connected to MySQL");

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
