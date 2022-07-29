package Ejercicios;

import database.BaseDeDatos;

public class Ejercicio4 {

	public static void main(String[] args) {
		funcionalidad();
	}

	public static void funcionalidad() {
		String nameDataBase = "peliculas_y_salas";

		// Query to create Peliculas table
		String peliculas = "create table Peliculas(codigo int auto_increment primary key,nombre nvarchar(100) not null,calificacion_edad int not null);";
		// Query to create Salas table
		String salas = "create table Salas(codigo int auto_increment primary key,pelicula int not null,nombre nvarchar(100) not null,"+
						"foreign key(pelicula) references Peliculas(codigo));";
		
		int numAttributes = 3;
		
		// We define insert query variables for Peliculas table
		String insertPeliculasUno = "insert into Peliculas(nombre, calificacion_edad) values ('Hitman', 18)";
		String insertPeliculasDos = "insert into Peliculas(nombre, calificacion_edad) values ('Dragon ball', 16)";
		String insertPeliculasTres = "insert into Peliculas(nombre, calificacion_edad) values ('Spongebob', 7)";
		String insertPeliculasCuatro = "insert into Peliculas(nombre, calificacion_edad) values ('Thor', 12)";
		String insertPeliculasCinco = "insert into Peliculas(nombre, calificacion_edad) values ('Spiderman', 12)";
		
		// We define insert query variables for Salas table
		String insertSalasUno = "insert into Salas(pelicula, nombre) values (1, 'Hitman')";
		String insertSalasDos = "insert into Salas(pelicula, nombre) values (2, 'Dragon ball')";
		String insertSalasTres = "insert into Salas(pelicula, nombre) values (3, 'Spongebob')";
		String insertSalasCuatro = "insert into Salas(pelicula, nombre) values (4, 'Thor')";
		String insertSalasCinco = "insert into Salas(pelicula, nombre) values (5, 'Spiderman')";

		BaseDeDatos base_de_datos = new BaseDeDatos(); // New object with the methos defined
		base_de_datos.connectMySql(); // Connect to MySql
		base_de_datos.deleteDataBase(nameDataBase); // First we delete the actual database
		base_de_datos.createDataBase(nameDataBase); // We create the database
		base_de_datos.createTable(nameDataBase, peliculas); // We create the table Peliculas
		base_de_datos.createTable(nameDataBase, salas); // We create the table Salas
		
		// We insert 5 registers into Peliculas
		base_de_datos.insertData(nameDataBase, insertPeliculasUno);
		base_de_datos.insertData(nameDataBase, insertPeliculasDos);
		base_de_datos.insertData(nameDataBase, insertPeliculasTres);
		base_de_datos.insertData(nameDataBase, insertPeliculasCuatro);
		base_de_datos.insertData(nameDataBase, insertPeliculasCinco);
		
		// We insert 5 registers into Salas
		base_de_datos.insertData(nameDataBase, insertSalasUno);
		base_de_datos.insertData(nameDataBase, insertSalasDos);
		base_de_datos.insertData(nameDataBase, insertSalasTres);
		base_de_datos.insertData(nameDataBase, insertSalasCuatro);
		base_de_datos.insertData(nameDataBase, insertSalasCinco);
		
		// We print table registers
		base_de_datos.getValues(nameDataBase, "Peliculas", numAttributes);
		base_de_datos.getValues(nameDataBase, "Salas", numAttributes);
	}
	
}
