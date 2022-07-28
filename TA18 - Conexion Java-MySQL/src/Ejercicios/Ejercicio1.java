package Ejercicios;

import database.BaseDeDatos;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		funcionalidad();
		
	}
	
	public static void funcionalidad() {
		String nameDataBase = "los_almacenes";
		
		BaseDeDatos base_de_datos = new BaseDeDatos();
		base_de_datos.deleteDataBase(nameDataBase);
		base_de_datos.createDataBase(nameDataBase);
		
	}
	
}
