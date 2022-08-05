package Ejercicios;

import database.BaseDeDatos;

public class Ejercicio9 {
	public static void main(String[] args) {
		funcionalidad();
	}

	public static void funcionalidad() {
		String nameDataBase = "peliculas_y_salas";

		// Query to create Facultad table
		String facultad = "create table Facultad ("
				+ "codigo int,"
				+ "nombre nvarchar(100) not null,"
				+ "primary key (codigo)"
				+ ");";
		
		// Query to create Investigadores table
		String investigadores = "create table Investigadores ("
				+ "DNI varchar(8),"
				+ "NomApels nvarchar(255)"
				+ "primary key (DNI),"
				+ "foreign key(facultad) references Facultad(codigo)"
				+ "on delete cascade on update cascade,"
				+ ")";
		
		// Query to create Reserva table
		String reserva = "create table Reserva ("
				+ "DNI varchar(8) primary key,"
				+ "NumSerie char(4),"
				+ "Comienzo datetime not null,"
				+ "Fin datetime not null,"
				+ "primary key(DNI, NumSerie),"
				+ "foreign key(DNI) references Investigadores(DNI)"
				+ "on delete cascade on update cascade,"
				+ "foreign key(NumSerie) references Equipos(NumSerie)"
				+ "on delete cascade on update cascade,"				
				+ ");";
		
		// Query to create Equipos table
		String equipos = "create table Equipos ("
				+ "NumSerie char(4),"
				+ "nombre nvarchar(100) not null,"
				+ "primary key(NumSerie),"
				+ "foreign key(facultad) references Facultad(codigo)"
				+ "on delete cascade on update cascade,"
				+ ");";
		
		int numAttributes = 3;
		
		// We define insert query variables for Reserva table
		String insertFacultadUno = "insert into Facultad values (1,'Quimica')";
		String insertFacultadDos = "insert into Facultad values (2,'Enologia')";
		String insertFacultadTres = "insert into Facultad values (3,'Matemáticas')";
		String insertFacultadCuatro = "insert into Facultad values (4,'Thor')";
		String insertFacultadCinco = "insert into Facultad values (5,'Spiderman')";
		
		// We define insert query variables for Investigadores table
		String insertInvestigadoresUno = "insert into Investigadores values ('23375678', 'Izan Dueso López', 1)";
		String insertInvestigadoresDos = "insert into Investigadores values ('01234568', 'Nicolás Copérnico', 2)";
		String insertInvestigadoresTres = "insert into Investigadores values ('01234569', 'Pablo González', 3)";
		String insertInvestigadoresCuatro = "insert into Investigadores values ('01234570', 'Javier Gutiérrez', 4)";
		String insertInvestigadoresCinco = "insert into Investigadores values ('01234571', 'Pablo Gutiérrez', 5)";

		// We define insert query variables for Reserva table
		String insertReservaUno = "insert into Reserva values ('23375678', '0001', 23/05/2023, 23/06/2023)";
		String insertReservaDos = "insert into Reserva values ('01234568', '0002', 23/05/2023, 23/06/2023)";
		String insertReservaTres = "insert into Reserva values ('01234569', '0003', 23/05/2023, 23/06/2023)";
		String insertReservaCuatro = "insert into Reserva values ('01234570', '0004', 23/05/2023, 23/06/2023)";
		String insertReservaCinco = "insert into Reserva values ('01234571', '0005', 23/05/2023, 23/06/2023)";
				
		// We define insert query variables for Equipos table
		String insertEquiposUno = "insert into Equipos values ('0001', 'Equipo A', 1)";
		String insertEquiposDos = "insert into Equipos values ('0002', 'Equipo B', 2)";
		String insertEquiposTres = "insert into Equipos values ('0003', 'Equipo C', 3)";
		String insertEquiposCuatro = "insert into Equipos values ('0004', 'Equipo D', 4)";
		String insertEquiposCinco = "insert into Equipos values ('0005', 'Equipo E', 5)";
				
		
		BaseDeDatos base_de_datos = new BaseDeDatos(); // New object with the method defined
		base_de_datos.connectMySql(); // Connect to MySql
		base_de_datos.deleteDataBase(nameDataBase); // First we delete the actual database
		base_de_datos.createDataBase(nameDataBase); // We create the database
		base_de_datos.createTable(nameDataBase, facultad); // We create the table Reserva
		base_de_datos.createTable(nameDataBase, investigadores); // We create the table Investigadores
		base_de_datos.createTable(nameDataBase, reserva); // We create the table Reserva
		base_de_datos.createTable(nameDataBase, equipos); // We create the table Equipos
		
		// We insert 5 registers into Facultad
		base_de_datos.insertData(nameDataBase, insertFacultadUno);
		base_de_datos.insertData(nameDataBase, insertFacultadDos);
		base_de_datos.insertData(nameDataBase, insertFacultadTres);
		base_de_datos.insertData(nameDataBase, insertFacultadCuatro);
		base_de_datos.insertData(nameDataBase, insertFacultadCinco);
		
		// We insert 5 registers into Salas
		base_de_datos.insertData(nameDataBase, insertInvestigadoresUno);
		base_de_datos.insertData(nameDataBase, insertInvestigadoresDos);
		base_de_datos.insertData(nameDataBase, insertInvestigadoresTres);
		base_de_datos.insertData(nameDataBase, insertInvestigadoresCuatro);
		base_de_datos.insertData(nameDataBase, insertInvestigadoresCinco);
		
		// We insert 5 registers into Facultad
		base_de_datos.insertData(nameDataBase, insertReservaUno);
		base_de_datos.insertData(nameDataBase, insertReservaDos);
		base_de_datos.insertData(nameDataBase, insertReservaTres);
		base_de_datos.insertData(nameDataBase, insertReservaCuatro);
		base_de_datos.insertData(nameDataBase, insertReservaCinco);
		
		// We insert 5 registers into Facultad
		base_de_datos.insertData(nameDataBase, insertEquiposUno);
		base_de_datos.insertData(nameDataBase, insertEquiposDos);
		base_de_datos.insertData(nameDataBase, insertEquiposTres);
		base_de_datos.insertData(nameDataBase, insertEquiposCuatro);
		base_de_datos.insertData(nameDataBase, insertEquiposCinco);
		
		// We print table registers
		base_de_datos.getValues(nameDataBase, "Facultad", numAttributes);
		base_de_datos.getValues(nameDataBase, "Investigadores", numAttributes);
		base_de_datos.getValues(nameDataBase, "Reserva", numAttributes);
		base_de_datos.getValues(nameDataBase, "Equipos", numAttributes);
	}
	
}

