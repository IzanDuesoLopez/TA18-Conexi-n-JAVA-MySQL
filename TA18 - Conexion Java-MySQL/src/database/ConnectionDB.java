package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
	
	private static Connection connection;
	private String localServer= "jdbc:mysql://192.168.0.111:3306?useTimezone=true&serverTimeZona=UTC";
	private String localUser= "remote";
	private String localPass= "Admin1234";
	
	// Default builder
	public ConnectionDB() {
		
	}
	
	// Method for connecting to the database
	public void openDatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // We use the driver
			connection = DriverManager.getConnection(localServer, localUser, localPass); // We connect to our fedora server
			System.out.println("You have been connected to the server"); // We print that we've been connected
			
		} catch (SQLException | ClassNotFoundException e) { // If some code returns error
			System.out.println("Can not connect to database");
			System.out.println(e);
		}
	}
	
	// Method for closing the connection
	public void closeDatabaseConnection() {
		try {
			connection.close(); // We close the connection
			System.out.println("Connection closed");
			
		} catch (SQLException e) {
			Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
		}
	}
		
	// Method that receives a string and creates a database
	public void createDataBase(String database_name) {
		try {
			String query = "create database " + database_name + ";"; // Query to create the database
			Statement st = connection.createStatement(); // We create the statement
			st.executeUpdate(query); // We execute the query
			System.out.println("The database has been created: " + database_name); // Print that the database has been created
			
		} catch (SQLException e) {
			Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	// Method to create a table
	public void createTable(String database_name, String query_create) {
		// We use a try to proceed with connection, use the database, and create the table
		try {
			// We use the table
			String query_use = "use " + database_name + ";";
			Statement st_use_database = connection.createStatement();
			st_use_database.executeUpdate(query_use);
			
			// Creating the table
			Statement st_create_database = connection.createStatement();
			st_create_database.executeUpdate(query_create);
			System.out.println("Table successfully created");
			
			// We do a catch in case an error exists
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error ocurred when creating table");
		}
	}
	
	public void insertRow(String database_name, String query_insert) {
		
		try {
			String query_use = "use " + database_name + ";";
			Statement st_use_database = connection.createStatement();
			st_use_database.executeUpdate(query_use);
			Statement st_insert = connection.createStatement();
			st_insert.executeUpdate(query_insert);
			System.out.println("Row inserted successfully");
			
		} catch (SQLException e) {
			System.out.println("Error ocurred when inserting values");
			System.out.println(e.getMessage());
		}
	}
}