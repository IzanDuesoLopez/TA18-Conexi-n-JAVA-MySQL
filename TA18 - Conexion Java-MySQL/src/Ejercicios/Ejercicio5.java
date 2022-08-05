package Ejercicios;

import database.BaseDeDatos;

public class Ejercicio5 {
	public static void main(String[] args) {
		funcionalidad();
	}

	public static void funcionalidad() {
		String nameDataBase = "directores";

		// Query to create Directores table
		String directores = "create table Directores(DNI varchar(8) primary key,NomApels nvarchar(100) not null,DNIJefe varchar (8) foreing key, Despacho int not null foreign key);";
		// Query to create Despachos table
		String despachos = "create table Despachos(numero int primary key,capacidad int not null,);";
		
		int numAttributes = 3;
		
		// We define insert query variables for Directores table
		String insertDirectoresUno = "insert into Directores values ('37430021', 'Pedro Valdivia', '326X')";
		String insertDirectoresDos = "insert into Directores values ('38960330', 'Enrique Bunbury', '968F')";
		String insertDirectoresTres = "insert into Directores values ('35322121', 'Rosa Garcia', '554E')";
		String insertDirectoresCuatro = "insert into Directores values ('99620021', 'Ramon Melendi', '225M')";
		String insertDirectoresCinco = "insert into Directores values ('7882561', 'Oscar Plana', '447C')";
		
		// We define insert query variables for Despachos table
		String insertDespachosUno = "insert into Despachosvalues (25000)";
		String insertDespachosDos = "insert into Despachos values (37880)";
		String insertDespachosTres = "insert into Despachos values (55220)";
		String insertDespachosCuatro = "insert into Despachos values (77852)";
		String insertDespachosCinco = "insert into Despachos values (33688)";

		BaseDeDatos base_de_datos = new BaseDeDatos(); // New object with the method defined
		base_de_datos.connectMySql(); // Connect to MySql
		base_de_datos.deleteDataBase(nameDataBase); // First we delete the actual database
		base_de_datos.createDataBase(nameDataBase); // We create the database
		base_de_datos.createTable(nameDataBase, directores); // We create the table Directores
		base_de_datos.createTable(nameDataBase, despachos); // We create the table Despachos
		
		// We insert 5 registers into Peliculas
		base_de_datos.insertData(nameDataBase, insertDirectoresUno);
		base_de_datos.insertData(nameDataBase, insertDirectoresDos);
		base_de_datos.insertData(nameDataBase, insertDirectoresTres);
		base_de_datos.insertData(nameDataBase, insertDirectoresCuatro);
		base_de_datos.insertData(nameDataBase, insertDirectoresCinco);
		
		// We insert 5 registers into Despachos
		base_de_datos.insertData(nameDataBase, insertDespachosUno);
		base_de_datos.insertData(nameDataBase, insertDespachosDos);
		base_de_datos.insertData(nameDataBase, insertDespachosTres);
		base_de_datos.insertData(nameDataBase, insertDespachosCuatro);
		base_de_datos.insertData(nameDataBase, insertDespachosCinco);
		
		// We print table registers
		base_de_datos.getValues(nameDataBase, "Directores", numAttributes);
		base_de_datos.getValues(nameDataBase, "Despachos", numAttributes);
	}
	
}
