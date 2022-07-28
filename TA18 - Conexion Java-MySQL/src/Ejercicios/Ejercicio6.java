package Ejercicios;

import database.ConnectionDB;

public class Ejercicio6 {
	public static void main(String[] args) {
		executeQueries();
	}
	public static void executeQueries() {
		ConnectionDB connection = new ConnectionDB();
		
		String database_name = "piezas_y_proveedores";
		
		String create_piezas = "create table piezas("
				+ "codigo int primary key,"
				+ "nombre nvarchar(100)"
				+ ");";

		String create_proveedores = "create table proveedores ("
				+ "id char(4) primary key,"
				+ "nombre nvarchar(100)"
				+ ");";
		
		String create_suministra = "create table suministra ("
				+ "codigo_pieza int,"
				+ "id_proveedor char(4),"
				+ "precio int,"
				+ "primary key(codigo_pieza, id_proveedor),"
				+ "foreign key(codigo_pieza) references piezas(codigo),"
				+ "foreign key(id_proveedor) references proveedores(id)"
				+ ");";
		
		String insert_piezas_1 = "insert into piezas values (1, 'freno');";
		String insert_piezas_2 = "insert into piezas values (2, 'rueda');";
		String insert_piezas_3 = "insert into piezas values (3, 'sensor');";
		String insert_piezas_4 = "insert into piezas values (4, 'llanta');";
		String insert_piezas_5 = "insert into piezas values (5, 'motor');";
		
		String insert_proveedores_1 = "insert into proveedores values ('0123', 'Audi');";
		String insert_proveedores_2 = "insert into proveedores values ('5678', 'Dacia');";
		String insert_proveedores_3 = "insert into proveedores values ('2345', 'Kia');";
		String insert_proveedores_4 = "insert into proveedores values ('7890', 'Fiat');";
		String insert_proveedores_5 = "insert into proveedores values ('3456', 'Jeep');";
		
		String insert_suministra_1 = "insert into suministra values (5, '0123', 5000);";
		String insert_suministra_2 = "insert into suministra values (3, '5678', 300);";
		String insert_suministra_3 = "insert into suministra values (1, '2345', 1000);";
		String insert_suministra_4 = "insert into suministra values (2, '7890', 500);";
		String insert_suministra_5 = "insert into suministra values (4, '3456', 3000);";
		
		// Open the database connection
		connection.openDatabaseConnection();
		
		// Create the database
		connection.createDataBase(database_name);
		
		// Create the tables
		connection.createTable(database_name, create_piezas);
		connection.createTable(database_name, create_proveedores);
		connection.createTable(database_name, create_suministra);
		
		// Insert values to the tables
		connection.insertRow(database_name, insert_piezas_1);
		connection.insertRow(database_name, insert_piezas_2);	
		connection.insertRow(database_name, insert_piezas_3);
		connection.insertRow(database_name, insert_piezas_4);
		connection.insertRow(database_name, insert_piezas_5);
		
		connection.insertRow(database_name, insert_proveedores_1);
		connection.insertRow(database_name, insert_proveedores_2);
		connection.insertRow(database_name, insert_proveedores_3);
		connection.insertRow(database_name, insert_proveedores_4);
		connection.insertRow(database_name, insert_proveedores_5);
		
		connection.insertRow(database_name, insert_suministra_1);
		connection.insertRow(database_name, insert_suministra_2);
		connection.insertRow(database_name, insert_suministra_3);
		connection.insertRow(database_name, insert_suministra_4);
		connection.insertRow(database_name, insert_suministra_5);
		
		// Close the database connection
		connection.closeDatabaseConnection();
		
	}
}
