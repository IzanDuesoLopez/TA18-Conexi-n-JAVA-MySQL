package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import com.mysql.cj.MysqlConnection;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import com.mysql.cj.xdevapi.Statement;

public class BaseDeDatos {
	
	private static Connection connect;
	
	// Default builder
	public BaseDeDatos() {
		
	}
	
	// Method that recives a string and creates a database
	public void createDataBase(String dbName) {
		try {
			connectMySql(); // Connecting to database
			String query = "create database " + dbName; // Query to create the database
			java.sql.Statement jst = connect.createStatement(); // We create the statement
			jst.executeUpdate(query); // We execute the query
			System.out.println("The database has been created: " + dbName); // Print that the database has been created
			closeConnection(); // Close connection
		} catch (SQLException e) {
			Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	// Method that deletes a database
	public void deleteDataBase(String dbName) {
		try {
			String query = "drop database " + dbName; // Query to create the database
			java.sql.Statement jst = connect.createStatement(); // We create the statement
			jst.executeUpdate(query); // We execute the query
			System.out.println("The database has been deleted: " + dbName); // Print that the database has been created
			closeConnection(); // Close connection
		} catch (SQLException e) {
			Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	// Method for connecting to the database
	public static void connectMySql() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // We use the driver
			connect = DriverManager.getConnection("jdbc:mysql://192.168.1.138:3306?useTimezone=true&serverTimezone=UTC", "local", "Local123@"); // We connect to our fedora server
			System.out.println("> You've been connected to the server <"); // We print that we've been connected
		} catch (SQLException | ClassNotFoundException ex) { // If some code returns error
			System.out.println("> Can't connect to database <");
			System.out.println(ex);
		}
	}
	
	// Method for closing the connection
	public static void closeConnection() {
		try {
			connect.close(); // We close the connection
			System.out.println("> Connection ended <");
		} catch (SQLException e) {
			Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	// Method to create a table
	public static void createTable(String database, String queryCreateTable) {
		// We use a try to proceed with connection, use the database, and create the table
		try {
			connectMySql(); // We connect to MySQL
			// We use the table
			String querydatabase = "use " + database + ";";
			java.sql.Statement stdatabase = connect.createStatement();
			stdatabase.executeUpdate(querydatabase);
			
			// Creating the table
			java.sql.Statement st = connect.createStatement();
			st.executeUpdate(queryCreateTable);
			System.out.println("The table has been created correctly");
			
			closeConnection();
			// We do a catch in case an error exists
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Method to insert data on table
	public static void insertData(String database, String queryCreateTable) {
		// We use a try to proceed with connection, use the database, and insert the data
		try {
			connectMySql(); // We connect to MySQL
			// We use the table
			String querydatabase = "use " + database + ";";
			java.sql.Statement stdatabase = connect.createStatement();
			stdatabase.executeUpdate(querydatabase);

			// Insert the data
			java.sql.Statement st = connect.createStatement();
			st.executeUpdate(queryCreateTable);
			System.out.println("The data has been inserted");

			closeConnection();
			// We do a catch in case an error exists
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
	// Method that get mysql values
	public void getValues(String database_name, String table, int attributes) {
		try {
			connectMySql();
			String query_use = "use " + database_name + ";";
			java.sql.Statement st_use_database = connect.createStatement();
			st_use_database.executeUpdate(query_use);
			
			String result = "select * from " + table;
			java.sql.Statement st_select = connect.createStatement();
			java.sql.ResultSet registers = st_select.executeQuery(result);
			
			System.out.println("\n"+table);
			// We print table registers, controlling the number of attributes that every register has
			while(registers.next()) {
				if(attributes == 2) {
					System.out.println(registers.getString(1) + " " + registers.getString(2));
				}else if(attributes == 3) {
					System.out.println(registers.getString(1) + " " + registers.getString(2) + " " + registers.getString(3));
				} else if(attributes == 4) {
					System.out.println(registers.getString(1) + " " + registers.getString(2) + " " + registers.getString(3) + " " + registers.getString(4));
				}
			}
			System.out.println("\n");
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("The data retrieve failed");
		}
	}
	
	
}
