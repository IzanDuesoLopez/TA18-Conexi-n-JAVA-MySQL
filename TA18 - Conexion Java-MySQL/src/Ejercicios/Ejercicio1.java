package Ejercicios;

import database.BaseDeDatos;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		funcionalidad();
	}
	
	public static void funcionalidad() {
		String nameDataBase = "los_almacenes";
		
		// Query to create Cajas table
		String almacenes = "create table Almacenes(" + 
							"id int auto_increment primary key," + 
							"lugar nvarchar(100)," + 
							"capacidad int);";
		// Query to create Cajas table
		String cajas = "create table Cajas ("+
						"numReferencia char(5) primary key,"+
					    "contenido nvarchar(100)," +
					    "valor int,"+
					    "codigo int auto_increment,"+
						"foreign key (codigo) references Almacenes (codigo));";
		
		
		BaseDeDatos base_de_datos = new BaseDeDatos(); // New object with the methos defined
		base_de_datos.connectMySql(); // Connect to MySql
		base_de_datos.deleteDataBase(nameDataBase); // First we delete the actual database
		base_de_datos.createDataBase(nameDataBase); // We create the database
		base_de_datos.createTable(nameDataBase, almacenes); // We create the table almacenes
		base_de_datos.createTable(nameDataBase, cajas); // We create the table cajas
	}
}
