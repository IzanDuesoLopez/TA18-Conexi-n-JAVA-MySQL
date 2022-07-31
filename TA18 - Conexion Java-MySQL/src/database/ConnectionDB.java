package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
	private static Connection connection;
	private String local_server= "jdbc:mysql://192.168.1.111:3306?useTimeZone=true&serverTimeZone=UTC";
	private String local_user= "root";
	private String local_password= "xxxx";
	
	// Default builder
	public ConnectionDB() {
	
	}
	
	// Method for connecting to the database
	public void openDatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // We use the driver
			connection = DriverManager.getConnection(local_server, local_user, local_password); // We connect to our fedora server
			System.out.println("You have connected to the server"); // We print that we have connected
			
		} catch (SQLException | ClassNotFoundException e) { // If some code returns error
			System.out.println("Can not connect to database");
			System.out.println(e);
		}
	}
	
	// Method for closing the connection
	public void closeDatabaseConnection() {
		try {
			connection.close(); // We close the connection
			System.out.println("\nConnection closed");
			
		} catch (SQLException e) {
			Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
		}
	}
		
	// Method that receives a string and creates a database
	public void createDataBase(String database_name) {
		try {
			String query_drop = "drop database if exists " + database_name + ";"; // Query to drop the database if exists
			Statement st_drop = connection.createStatement(); // We create the statement
			st_drop.executeUpdate(query_drop); // We execute the query
			
			String query_create = "create database " + database_name + ";"; // Query to create the database
			Statement st_create = connection.createStatement(); // We create the statement
			st_create.executeUpdate(query_create); // We execute the query
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
	
	// Method that gets a insert query
	public void insertRow(String database_name, String query_insert) {
		
		try {
			// We use the database
			String query_use = "use " + database_name + ";";
			Statement st_use_database = connection.createStatement();
			st_use_database.executeUpdate(query_use);
			
			// We insert the values into a table
			Statement st_insert = connection.createStatement();
			st_insert.executeUpdate(query_insert);
			System.out.println("Row inserted successfully");
			
			// We do a catch in case an error exists
		} catch (SQLException e) {
			System.out.println("Error ocurred when inserting values");
			System.out.println(e.getMessage());
		}
	}
	// Method that get mysql values
		public void getValues(String database_name, String table) {
			try {
				// We use the database
				String query_use = "use " + database_name + ";";
				Statement st_use_database = connection.createStatement();
				st_use_database.executeUpdate(query_use);
				
				// Assign the result of a select query to a resultset data structure and get its metadata
				String result = "select * from " + table;
				Statement st_select = connection.createStatement();
				ResultSet rs_registers = st_select.executeQuery(result);
				ResultSetMetaData rs_metadata = rs_registers.getMetaData();
				int columns = rs_metadata.getColumnCount();
				
				// Print the results in a readable way
				System.out.println("\n" + table);
				
				while(rs_registers.next()) {
					for(int i = 1; i <= columns; i++) {
						if(i > 1) 
							System.out.print(", ");
						String value = rs_registers.getString(i);
						System.out.print(rs_metadata.getColumnName(i) + ": " + value);
					}
					System.out.println("");
				}
			// We manage any sql-related exception that occurs
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("The data retrieve failed");
			}
		}
}