package com.senai.teacherdesktop.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection connectDB() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/saep_db","root","");
    }

    public static void main(String[] args) {
        try(Connection conn = ConnectDB.connectDB()){
            System.out.println("Connected to database");
        }catch (SQLException e){
            System.out.println("Error connecting to database"+e);}
    }
}
