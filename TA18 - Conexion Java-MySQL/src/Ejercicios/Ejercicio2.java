package Ejercicios;

import database.ConnectionDB;

public class Ejercicio2 {
	public static void main(String[] args) {
		executeQueries();
	}
	public static void executeQueries() {
		ConnectionDB connection = new ConnectionDB();
		
		String database_name = "almacenes";
		
		String create_almacenes = "create table almacenes ("
				+ "codigo int primary key,"
				+ "lugar nvarchar(100),"
				+ "capacidad int"
				+ ");";

		String create_cajas = "create table cajas ("
				+ "num_referencia char(5) primary key,"
				+ "contenido nvarchar(100),"
				+ "valor int,"
				+ "codigo int auto_increment,"
				+ "foreign key (codigo) references almacenes (codigo)"
				+ ");";
		
		String insert_almacenes_1 = "insert into almacenes values (1, 'Tarragona', 900);";
		String insert_almacenes_2 = "insert into almacenes values (2, 'Reus', 300);";
		String insert_almacenes_3 = "insert into almacenes values (3, 'Salou', 200);";
		String insert_almacenes_4 = "insert into almacenes values (4, 'Constantí', 100);";
		String insert_almacenes_5 = "insert into almacenes values (5, 'Hospitalet', 20000);";
		String insert_cajas_1 = "insert into cajas values ('01234', 'ordenadores', 5000, 1);";
		String insert_cajas_2 = "insert into cajas values ('56789', 'pantallas', 3000, 2);";
		String insert_cajas_3 = "insert into cajas values ('23456', 'ventiladores', 1000, 3);";
		String insert_cajas_4 = "insert into cajas values ('78901', 'sillas', 500, 4);";
		String insert_cajas_5 = "insert into cajas values ('34567', 'cables', 300, 5);";
		
		// Open the database connection
		connection.openDatabaseConnection();
		
		// Create the database
		connection.createDataBase(database_name);
		
		// Create the tables
		connection.createTable(database_name, create_almacenes);
		connection.createTable(database_name, create_cajas);
		
		// Insert values to the tables
		connection.insertRow(database_name, insert_almacenes_1);
		connection.insertRow(database_name, insert_almacenes_2);	
		connection.insertRow(database_name, insert_almacenes_3);
		connection.insertRow(database_name, insert_almacenes_4);
		connection.insertRow(database_name, insert_almacenes_5);
		
		connection.insertRow(database_name, insert_cajas_1);
		connection.insertRow(database_name, insert_cajas_2);
		connection.insertRow(database_name, insert_cajas_3);
		connection.insertRow(database_name, insert_cajas_4);
		connection.insertRow(database_name, insert_cajas_5);
		
		connection.getValues(database_name, "almacenes");
		connection.getValues(database_name, "cajas");
		
		// Close the database connection
		connection.closeDatabaseConnection();
		
	}
}
