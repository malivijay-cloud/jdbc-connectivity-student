package org.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService
{
   public Connection getConnection(){
       Connection Connection = null;
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
                   String url ="jdbc:mysql://localhost:3306/student";
                   String username ="root";
                   String password ="system";
                   Connection = DriverManager.getConnection(url, username, password);
                   System.out.println("connected to the database");
       }
       catch (SQLException e)
       {
           System.out.println("Connetion error: "+e.getMessage());
       }catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       return Connection;
   }
}
