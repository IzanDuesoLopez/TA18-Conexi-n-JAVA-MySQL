package Ejercicios;

import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio9 {

}

// Método para crear tabla
public static void createTable(String database, String name, String Query) {
	// Hacemos un try para conectarnos, usar la database, y crear la tabla
	try {
		
		// Usamos la tabla
		String Querydatabase = "use" + database + ";";
		Statement stdatabase = connection.createStatement();
		stdatabase.executeUpdate(Querydatabase);
		
		// Creamos la tabla
		
		Statement st = connection.createStatement();
		st.executeUpdate(Query);
		System.out.println("Tabla creada con éxito");
		
		// Hacemos un catch en caso de que haya error en crear la tabla
		
	} catch (SQLException ex) {
		System.out.println(ex.getMessage(ex));
		System.out.println("Error creando tabla");
	}
}