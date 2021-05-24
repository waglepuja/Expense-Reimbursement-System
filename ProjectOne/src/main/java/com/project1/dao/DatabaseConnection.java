package com.project1.dao;

import java.sql.Connection;
//import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:postgresql://rev-can-training.csnhlwu8boxj.us-east-2.rds.amazonaws.com:5432/ersdb";
	private static final String username = "ersuser";
	private static final String password = "password";	
	
	
	public static Connection getDbConnection() throws SQLException{
		
		try {
			//System.out.println("Print this");

			//DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, username, password);
		}catch(Exception exception){
			throw new RuntimeException("Error Connecting to the Database", exception);
		}
	}
	
	// To test the connection 
	public static void main(String[] args) {
		try {
			Connection connection = getDbConnection();
			System.out.println("connected");
		}
		catch(Exception exception){
			throw new RuntimeException("Error Connecting to the Database", exception);
		}
	}

}
