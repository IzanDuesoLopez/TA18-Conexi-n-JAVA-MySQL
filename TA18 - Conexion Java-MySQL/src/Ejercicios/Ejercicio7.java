package Ejercicios;

import database.ConnectionDB;

public class Ejercicio7 {
	public static void main(String[] args) {
		executeQueries();
	}
	public static void executeQueries() {		
		ConnectionDB connection = new ConnectionDB();
		
		String database_name = "cientificos";
		
		String create_cientificos = "create table cientificos ("
				+ "dni varchar(8),"
				+ "nom_apels nvarchar(255),"
				+ "primary key (dni)"
				+ ");";

		String create_proyectos = "create table proyectos ("
				+ "id char(4),"
				+ "nombre nvarchar(255),"
				+ "horas int,"
				+ "primary key (id)"
				+ ");";
		
		String create_asignado_a = "create table asignado_a ("
				+ "cientifico varchar(8),"
				+ "proyecto char(4),"
				+ "primary key (cientifico, proyecto),"
				+ "foreign key (cientifico) references cientificos (dni)"
				+ "on delete cascade on update cascade,"
				+ "foreign key (proyecto) references proyectos (id)"
				+ "on delete cascade on update cascade"
				+ ");";
		
		String insert_cientificos_1 = "insert into cientificos values ('99775645', 'Albert Einstein');";
		String insert_cientificos_2 = "insert into cientificos values ('09787766', 'Isaac Newton');";
		String insert_cientificos_3 = "insert into cientificos values ('65477457', 'Galileo Galilei');";
		String insert_cientificos_4 = "insert into cientificos values ('82455533', 'Leonardo da Vinci');";
		String insert_cientificos_5 = "insert into cientificos values ('08765787', 'Max Planck');";
		
		String insert_proyectos_1 = "insert into proyectos values ('0123', 'Parachute', 900);";
		String insert_proyectos_2 = "insert into proyectos values ('5678', 'Telescope', 290);";
		String insert_proyectos_3 = "insert into proyectos values ('2345', 'Spectroscopy', 795);";
		String insert_proyectos_4 = "insert into proyectos values ('7890', 'Quantum Theory', 600);";
		String insert_proyectos_5 = "insert into proyectos values ('3456', 'Theory of General Relativity', 775);";
		
		String insert_asignado_a_1 = "insert into asignado_a values ('99775645', '3456');";
		String insert_asignado_a_2 = "insert into asignado_a values ('09787766', '2345');";
		String insert_asignado_a_3 = "insert into asignado_a values ('65477457', '5678');";
		String insert_asignado_a_4 = "insert into asignado_a values ('82455533', '0123');";
		String insert_asignado_a_5 = "insert into asignado_a values ('08765787', '7890');";
		
		// Open the database connection
		connection.openDatabaseConnection();
		
		// Create the database
		connection.createDataBase(database_name);
		
		// Create the tables
		connection.createTable(database_name, create_cientificos);
		connection.createTable(database_name, create_proyectos);
		connection.createTable(database_name, create_asignado_a);
		
		// Insert values to the tables
		connection.insertRow(database_name, insert_cientificos_1);
		connection.insertRow(database_name, insert_cientificos_2);	
		connection.insertRow(database_name, insert_cientificos_3);
		connection.insertRow(database_name, insert_cientificos_4);
		connection.insertRow(database_name, insert_cientificos_5);
		
		connection.insertRow(database_name, insert_proyectos_1);
		connection.insertRow(database_name, insert_proyectos_2);
		connection.insertRow(database_name, insert_proyectos_3);
		connection.insertRow(database_name, insert_proyectos_4);
		connection.insertRow(database_name, insert_proyectos_5);
		
		connection.insertRow(database_name, insert_asignado_a_1);
		connection.insertRow(database_name, insert_asignado_a_2);
		connection.insertRow(database_name, insert_asignado_a_3);
		connection.insertRow(database_name, insert_asignado_a_4);
		connection.insertRow(database_name, insert_asignado_a_5);
		
		connection.getValues(database_name, "cientificos");
		connection.getValues(database_name, "proyectos");
		connection.getValues(database_name, "asignado_a");
		
		// Close the database connection
		connection.closeDatabaseConnection();
		
	}
}
