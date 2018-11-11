/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etronicsadminsystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Brian
 */
public class ConnectionHandler {
    
    private Connection connect = null;
    
    public ConnectionHandler(){
    }
    
    public Connection makeConnection(){
        try {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://212.17.40.243:3030/etronics";
        String userName = "brian";
        String passWord = "test";
        // Setup the connection with the DB
        connect = DriverManager.getConnection(url, userName, passWord);
        
        } catch (Exception e) {
            throw new RuntimeException("Error connecting to the database server.", e);
        }
        return connect;
    }
}
