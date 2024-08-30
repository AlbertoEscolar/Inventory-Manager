package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Producto;

public class InventoryController {

	List<Producto> lstProductos = new ArrayList<Producto>();
	
	public InventoryController() {
		
	}
	
	public static void agregarProducto(Scanner scanIn) throws Exception {
		
		System.out.println("Introduzca NOMBRE del producto: ");
		String productName = scanIn.nextLine();
		System.out.println();
		
		try {
			System.out.println("Introduzca PRECIO del producto: ");
			float productPrice = scanIn.nextFloat();
			System.out.println();		
		} catch (Exception ex) {
			throw new Exception("Valor introducido para precio INCORRECTO");
		}
		
		try {
			System.out.println("Introduzca CANTIDAD disponible del producto: ");
			int intCantidad = scanIn.nextInt();
			System.out.println();
		} catch (Exception ex) {
			throw new Exception("Valor introducido para cantidad INCORRECTO");
		}
		
	}		
	
}
