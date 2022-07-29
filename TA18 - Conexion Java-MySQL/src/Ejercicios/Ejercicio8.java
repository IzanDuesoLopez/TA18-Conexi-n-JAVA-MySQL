package Ejercicios;

import database.BaseDeDatos;

public class Ejercicio8 {

	public static void main(String[] args) {
		funcionalidad();
	}

	public static void funcionalidad() {
		String nameDataBase = "grandesAlmacenes";

		// Query to create Productos table
		String productos = "create table Productos (codigo int auto_increment primary key,nombre nvarchar(100),precio int);";
		// Query to create Cajeros table
		String cajeros = "create table Cajeros (codigo char(5) primary key,nomApels nvarchar(100));";
		// Query to create Maquinas table
		String maquinas_registradoras = "create table Maquinas_Registradoras (codigo int auto_increment primary key,piso int);";
		// Query to create Ventas table
		String ventas = " create table Ventas (codigo_cajero char(5),codigo_maquina int,codigo_producto int,"+
						"primary key (codigo_cajero, codigo_maquina, codigo_producto),foreign key (codigo_cajero) references Cajeros (codigo),"+
						"foreign key (codigo_maquina) references Maquinas_Registradoras (codigo),"+
						"foreign key (codigo_producto) references Productos (codigo));";
		
		int numAttributesProductos = 3, numAttributesCajeros = 2, numAttributesMaquinas = 2, numAttributesVenta = 3;
		
		// We define insert query variables for Productos table
		String insertProductosUno = "insert into Productos(nombre, precio) values ('Cacahuetes', 3)";
		String insertProductosDos = "insert into Productos(nombre, precio) values ('Lechuga', 2)";
		String insertProductosTres = "insert into Productos(nombre, precio) values ('Agua', 1)";
		String insertProductosCuatro = "insert into Productos(nombre, precio) values ('Leche', 2)";
		String insertProductosCinco = "insert into Productos(nombre, precio) values ('Pan', 10)";
		
		// We define insert query variables for Cajeros table
		String insertCajerosUno = "insert into Cajeros(codigo, nomApels) values ('aaaa', 'Oscar Alvadueso')";
		String insertCajerosDos = "insert into Cajeros(codigo, nomApels) values ('aaab','David Rac')";
		String insertCajerosTres = "insert into Cajeros(codigo, nomApels) values ('aabc','Ludex Gundyr')";
		String insertCajerosCuatro = "insert into Cajeros(codigo, nomApels) values ('abcd','Hora Loux')";
		String insertCajerosCinco = "insert into Cajeros(codigo, nomApels) values ('bcde','Cinder Lord')";
		
		// We define insert query variables for Maquinas_registradoras table
		String insertMaquinaUno = "insert into Maquinas_Registradoras(piso) values (5);";
		String insertMaquinaDos = "insert into Maquinas_Registradoras(piso) values (51);";
		String insertMaquinaTres = "insert into Maquinas_Registradoras(piso) values (33);";
		String insertMaquinaCuatro = "insert into Maquinas_Registradoras(piso) values (21);";
		String insertMaquinaCinco = "insert into Maquinas_Registradoras(piso) values (7);";

		BaseDeDatos base_de_datos = new BaseDeDatos(); // New object with the methos defined
		base_de_datos.connectMySql(); // Connect to MySql
		base_de_datos.deleteDataBase(nameDataBase); // First we delete the actual database
		base_de_datos.createDataBase(nameDataBase); // We create the database
		base_de_datos.createTable(nameDataBase, productos); // We create the table Productos
		base_de_datos.createTable(nameDataBase, cajeros); // We create the table Cajeros
		base_de_datos.createTable(nameDataBase, maquinas_registradoras); // We create the maquinas table
		base_de_datos.createTable(nameDataBase, ventas);
		
		// We insert 5 registers into Productos
		base_de_datos.insertData(nameDataBase, insertProductosUno);
		base_de_datos.insertData(nameDataBase, insertProductosDos);
		base_de_datos.insertData(nameDataBase, insertProductosTres);
		base_de_datos.insertData(nameDataBase, insertProductosCuatro);
		base_de_datos.insertData(nameDataBase, insertProductosCinco);
		
		// We insert 5 registers into Cajeros
		base_de_datos.insertData(nameDataBase, insertCajerosUno);
		base_de_datos.insertData(nameDataBase, insertCajerosDos);
		base_de_datos.insertData(nameDataBase, insertCajerosTres);
		base_de_datos.insertData(nameDataBase, insertCajerosCuatro);
		base_de_datos.insertData(nameDataBase, insertCajerosCinco);
		
		// We insert 5 registers into maquinas_registradoras
		base_de_datos.insertData(nameDataBase, insertMaquinaUno);
		base_de_datos.insertData(nameDataBase, insertMaquinaDos);
		base_de_datos.insertData(nameDataBase, insertMaquinaTres);
		base_de_datos.insertData(nameDataBase, insertMaquinaCuatro);
		base_de_datos.insertData(nameDataBase, insertMaquinaCinco);
		
		// We print table registers
		base_de_datos.getValues(nameDataBase, "Productos", numAttributesProductos);
		base_de_datos.getValues(nameDataBase, "Cajeros", numAttributesCajeros);
		base_de_datos.getValues(nameDataBase, "Maquinas_Registradoras", numAttributesMaquinas);
	}
}
