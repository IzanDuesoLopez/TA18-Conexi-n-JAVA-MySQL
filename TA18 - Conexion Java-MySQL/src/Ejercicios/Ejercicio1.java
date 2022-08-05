package Ejercicios;

import database.BaseDeDatos;

public class Ejercicio1 {
	public static void main(String[] args) {
		funcionalidad();
	}

	public static void funcionalidad() {
		String nameDataBase = "tienda_de_informatica";

		// Query to create Fabricantes table
		String fabricantes = "create table Fabricantes(codigo int auto_increment primary key,nombre nvarchar(100) not null);";
		// Query to create Articulos table
		String articulos = "create table Articulos(codigo int auto_increment primary key,precio int not null"+
						"foreing key(fabricante) references Fabricantes(codigo));";
		
		int numAttributes = 3;
		
		// We define insert query variables for Fabricantes table
		String insertFabricantesUno = "insert into Fabricantes values ('Mercedes')";
		String insertFabricantesDos = "insert into Fabricantes values ('Red Bull')";
		String insertFabricantesTres = "insert into Fabricantes values ('Mc Claren')";
		String insertFabricantesCuatro = "insert into Fabricantes values ('Alpine')";
		String insertFabricantesCinco = "insert into Fabricantes values ('Williams')";
		
		// We define insert query variables for Articulos table
		String insertArticulosUno = "insert into Articulos values (Motor, 350, 1)";
		String insertArticulosDos = "insert into Articulos values (Alerón, 400, 2)";
		String insertArticulosTres = "insert into Articulos values (Suspensión, 260, 3)";
		String insertArticulosCuatro = "insert into Articulos values (Retrovisores, 325, 4)";
		String insertArticulosCinco = "insert into Articulos values (Neumáticos, 575, 5)";

		BaseDeDatos base_de_datos = new BaseDeDatos(); // New object with the method defined
		base_de_datos.connectMySql(); // Connect to MySql
		base_de_datos.deleteDataBase(nameDataBase); // First we delete the actual database
		base_de_datos.createDataBase(nameDataBase); // We create the database
		base_de_datos.createTable(nameDataBase, fabricantes); // We create the table Fabricantes
		base_de_datos.createTable(nameDataBase, articulos); // We create the table Articulos
		
		// We insert 5 registers into Fabricantes
		base_de_datos.insertData(nameDataBase, insertFabricantesUno);
		base_de_datos.insertData(nameDataBase, insertFabricantesDos);
		base_de_datos.insertData(nameDataBase, insertFabricantesTres);
		base_de_datos.insertData(nameDataBase, insertFabricantesCuatro);
		base_de_datos.insertData(nameDataBase, insertFabricantesCinco);
		
		// We insert 5 registers into Articulos
		base_de_datos.insertData(nameDataBase, insertArticulosUno);
		base_de_datos.insertData(nameDataBase, insertArticulosDos);
		base_de_datos.insertData(nameDataBase, insertArticulosTres);
		base_de_datos.insertData(nameDataBase, insertArticulosCuatro);
		base_de_datos.insertData(nameDataBase, insertArticulosCinco);
		
		// We print table registers
		base_de_datos.getValues(nameDataBase, "Fabricantes", numAttributes);
		base_de_datos.getValues(nameDataBase, "Articulos", numAttributes);
	}
}

