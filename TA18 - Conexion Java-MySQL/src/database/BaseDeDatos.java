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
	private String localServer= "jdbc:mysql://192.168.1.138:9090?useTimezone=true&serverTimeZona=UTC";
	private String localUser= "root";
	private String localPass= "Cibtraseña123";
	
	// Default builder
	public BaseDeDatos() {
		
	}
	
	// Method that recives a string and creates a database
	public void createDataBase(String dbName) {
		try {
			String query = "create database " + dbName; // Query to create the database
			java.sql.Statement jst = connect.createStatement(); // We create the statement
			jst.executeUpdate(query); // We execute the query
			closeConnection(); // Close connection
			connectDataBase(localServer, localUser, localPass); // Connecting to database
			System.out.println("The database has been created: " + dbName); // Print that the database has been created
		} catch (SQLException e) {
			Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	// Method for connecting to the database
	public void connectDataBase(String localServer, String localUser, String localPass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // We use the driver
			connect = DriverManager.getConnection(localServer, localUser, localPass); // We connect to our fedora server
			System.out.println("You've been connected to the server"); // We print that we've been connected
		} catch (SQLException | ClassNotFoundException ex) { // If some code returns error
			System.out.println("Can't connect to database");
			System.out.println(ex);
		}
	}
	
	// Method for closing the connection
	public void closeConnection() {
		try {
			connect.close(); // We close the connection
			System.out.println("Connection ended");
		} catch (SQLException e) {
			Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	// Method to create a table
	public static void createTable(String database, String name, String query) {
		// We use a try to proceed with connection, use the database, and create the table
		try {
			
			// We use the table
			String querydatabase = "use" + database + ";";
			java.sql.Statement stdatabase = connect.createStatement();
			stdatabase.executeUpdate(querydatabase);
			
			// Creating the table
			java.sql.Statement st = connect.createStatement();
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito");
			
			// We do a catch in case an error exists
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
}
