package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import com.mysql.cj.xdevapi.Statement;

public class BaseDeDatos {
	
	private Connection connect;
	
	// Default builder
	public BaseDeDatos() {
		
	}
	
	// Method that recives a string and creates a database
	public void createDataBase(String dbName) {
		try {
			String query = "create database " + dbName; // Query to create the database
		} catch (Exception e) {
			
		}
	}
	
	// Method for connecting to the database
	public void connectDataBase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // We use the driver
			connect = DriverManager.getConnection("jdbc:mysql://192.168.1.138:9090?useTimezone=true&serverTimeZona=UTC", "root", "Contraseña123"); // We connect to our fedora server
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
	public static void createTable(String database, String name, String Query) {
		// Hacemos un try para conectarnos, usar la database, y crear la tabla
		try {
			
			// Usamos la tabla
			String Querydatabase = "use" + database + ";";
			Statement stdatabase = connect.createStatement();
			stdatabase.executeUpdate(Querydatabase);
			
			// Creamos la tabla
			
			Statement st = connect.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito");
			
			// Hacemos un catch en caso de que haya error en crear la tabla
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage(ex));
			System.out.println("Error creando tabla");
		}
	}
	
}
