package Ejercicios;

import database.BaseDeDatos;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		funcionalidad();
	}

	public static void funcionalidad() {
		String nameDataBase = "los_almacenes";

		// Query to create Cajas table
		String almacenes = "create table Almacenes(id int auto_increment primary key, lugar nvarchar(100), capacidad int);";
		// Query to create Cajas table
		String cajas = "create table Cajas (numReferencia char(5) primary key,contenido nvarchar(100),valor int,"+
						"codigo int auto_increment,foreign key (codigo) references Almacenes (id));";
		
		int numAttributesAlmacenes = 3, numAttributesCajas = 4;
		
		// We define insert query variables for Almacenes table
		String insertAlmacenesUno = "insert into Almacenes(lugar, capacidad) values ('Salou', 30)";
		String insertAlmacenesDos = "insert into Almacenes(lugar, capacidad) values ('Reus', 40)";
		String insertAlmacenesTres = "insert into Almacenes(lugar, capacidad) values ('Tarragona', 21)";
		String insertAlmacenesCuatro = "insert into Almacenes(lugar, capacidad) values ('Valls', 55)";
		String insertAlmacenesCinco = "insert into Almacenes(lugar, capacidad) values ('Cambrils', 60)";
		
		// We define insert query variables for Cajas table
		String insertCajasUno = "insert into Cajas(numReferencia, contenido, valor) values ('aaaa', 'Manzanas', 335)";
		String insertCajasDos = "insert into Cajas(numReferencia, contenido, valor) values ('aaab', 'Peras', 221)";
		String insertCajasTres = "insert into Cajas(numReferencia, contenido, valor) values ('aabc', 'Melocotones', 111)";
		String insertCajasCuatro = "insert into Cajas(numReferencia, contenido, valor) values ('abcd', 'Sandias', 666)";
		String insertCajasCinco = "insert into Cajas(numReferencia, contenido, valor) values ('bcde', 'Melones', 777)";

		BaseDeDatos base_de_datos = new BaseDeDatos(); // New object with the methos defined
		base_de_datos.connectMySql(); // Connect to MySql
		base_de_datos.deleteDataBase(nameDataBase); // First we delete the actual database
		base_de_datos.createDataBase(nameDataBase); // We create the database
		base_de_datos.createTable(nameDataBase, almacenes); // We create the table almacenes
		base_de_datos.createTable(nameDataBase, cajas); // We create the table cajas
		
		// We insert 5 registers into Almacenes
		base_de_datos.insertData(nameDataBase, insertAlmacenesUno);
		base_de_datos.insertData(nameDataBase, insertAlmacenesDos);
		base_de_datos.insertData(nameDataBase, insertAlmacenesTres);
		base_de_datos.insertData(nameDataBase, insertAlmacenesCuatro);
		base_de_datos.insertData(nameDataBase, insertAlmacenesCinco);
		
		// We insert 5 registers into Cajas
		base_de_datos.insertData(nameDataBase, insertCajasUno);
		base_de_datos.insertData(nameDataBase, insertCajasDos);
		base_de_datos.insertData(nameDataBase, insertCajasTres);
		base_de_datos.insertData(nameDataBase, insertCajasCuatro);
		base_de_datos.insertData(nameDataBase, insertCajasCinco);
		
		// We print table registers
		base_de_datos.getValues(nameDataBase, "Almacenes", numAttributesAlmacenes);
		base_de_datos.getValues(nameDataBase, "Cajas", numAttributesCajas);
	}
	
}
