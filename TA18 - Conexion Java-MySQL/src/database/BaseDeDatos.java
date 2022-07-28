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
			closeConnection(); // Close connection
			
			System.out.println("The database has been created: " + dbName); // Print that the database has been created
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
			closeConnection(); // Close connection
			System.out.println("The database has been deleted: " + dbName); // Print that the database has been created
		} catch (SQLException e) {
			Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	// Method for connecting to the database
	public void connectMySql() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // We use the driver
			connect = DriverManager.getConnection("jdbc:mysql://192.168.1.138:3306?useTimezone=true&serverTimezone=UTC", "local", "Local123@"); // We connect to our fedora server
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
	
	// Método para crear tabla
	public static void createTable(String database, String name, String query) {
		// Hacemos un try para conectarnos, usar la database, y crear la tabla
		try {
			
			// Usamos la tabla
			String querydatabase = "use" + database + ";";
			java.sql.Statement stdatabase = connect.createStatement();
			stdatabase.executeUpdate(querydatabase);
			
			// Creamos la tabla
			java.sql.Statement st = connect.createStatement();
			st.executeUpdate(query);
			System.out.println("Tabla creada con éxito");
			
			// Hacemos un catch en caso de que haya error en crear la tabla
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	
}
