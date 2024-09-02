package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.InventoryController;
import Model.Producto;

public class InventoryManager {

//	Ejercicio: Sistema de Gestión de Inventarios
//	Descripción:
//
//	Crea un programa en Java que actúe como un sistema básico de gestión de inventarios. 
//El programa debe permitir al usuario realizar las siguientes acciones:
//
//	    Agregar un producto: El usuario puede ingresar un nuevo producto al inventario.
//		Cada producto debe tener un nombre, un precio y una cantidad disponible.
//	    Mostrar todos los productos: El programa muestra todos los productos actuales en el inventario.
//	    Buscar un producto por nombre: El usuario puede buscar un producto específico en el inventario utilizando su nombre.
//	    Vender un producto: El usuario puede vender una cantidad de un producto específico,
//		lo que reducirá su cantidad disponible en el inventario.
//	    Salir: Terminar el programa.
//
//	Detalles del Ejercicio:
//	Interfaz de Usuario:
//
//	    Utiliza la consola para la interacción con el usuario.
//	    Muestra un menú de opciones cada vez que se completa una acción.
//
//	Estructura del Programa:
//
//	    Usa una clase Producto con atributos como nombre, precio, y cantidad.
//	    Usa una clase Inventario que contenga una lista de objetos Producto y métodos para agregar, mostrar, buscar y vender productos.
//	    Usa una interfaz Vendible que tenga un método vender(int cantidad).
//
//	Funciones Esperadas:
//
//	    void agregarProducto(String nombre, double precio, int cantidad): Añade un nuevo producto al inventario.
//	    void mostrarProductos(): Muestra todos los productos con sus detalles.
//	    Producto buscarProducto(String nombre): Devuelve un producto basado en su nombre.
//	    void venderProducto(String nombre, int cantidad): Reduce la cantidad disponible de un producto.
//	    boolean salir(): Permite al usuario salir del programa.
	//Test
	
	public static void main(String[] args) throws Exception {

						
			int intSelectedNum = -1;
			
			InventoryController invController = new InventoryController();
			
			List<Producto> lstProductos = new ArrayList<Producto>();
			
			//Infinite loop
			while (0 != 1) {
				
				Scanner scanIn = new Scanner(System.in);
				
				try {
				
				System.out.println();
				
				displayMenu();
				
				System.out.println();
				System.out.println("Introduzca número para seleccionar la tarea a realizar: ");
								
				intSelectedNum = scanIn.nextInt();								
				
					switch (intSelectedNum) {
					
						case 1: {
							invController.agregarProducto(scanIn, lstProductos);						
							break;
						}
						case 2: {
							invController.mostrarProductos(lstProductos);						
							break;
						}
						case 3: {
							invController.buscarProducto(scanIn, lstProductos);
							break;
						}
						case 4: {
							invController.venderProducto(scanIn, lstProductos);
							break;
						}
						case 5: {
							System.out.println();
							System.out.println("Hasta la próxima! :)");
							break;
						}
						
					}
				
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					scanIn.close();
				}
				
			}					

	}

	private static void displayMenu() {

		System.out.println("------- MENU -------");
		System.out.println("1. Agregar Producto");
		System.out.println("2. Mostrar Productos");
		System.out.println("3. Buscar Producto");
		System.out.println("4. Vender un Producto");
		System.out.println("5. Salir");
		System.out.println();
	}
			
	
}
