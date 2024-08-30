package Controller;

import java.util.List;
import java.util.Scanner;

import Model.Producto;
import Model.Vendible;


public class InventoryController  implements Vendible {

	
	public InventoryController() {
		
	}
	
	public void agregarProducto(Scanner scanIn, List<Producto> lstProductos) throws Exception {
		
		String productName = "";
		float productPrice;
		int intCantidad;
					
		System.out.println("Introduzca NOMBRE del producto: ");
		productName = scanIn.next();
		System.out.println();					
		
		if (lstProductos.contains(productName)) {
			System.out.println("El producto YA EXISTE!");
			return;
		}
				
		try {
			System.out.println("Introduzca PRECIO del producto: ");
			productPrice = scanIn.nextFloat();
			System.out.println();		
		} catch (Exception ex) {
			throw new Exception("Valor introducido para precio INCORRECTO");
		}
		
		try {
			System.out.println("Introduzca CANTIDAD disponible del producto: ");
			intCantidad = scanIn.nextInt();
			System.out.println();
		} catch (Exception ex) {
			throw new Exception("Valor introducido para cantidad INCORRECTO");
		}
		
		Producto oProducto = new Producto(productName, productPrice, intCantidad);			
		lstProductos.add(oProducto);		
	}		
	
	
	public void mostrarProductos(List<Producto> lstProductos) {		
		for (int i = 0; i <= lstProductos.size() - 1; i++) {
			System.out.print((i + 1) + ". Producto: " + lstProductos.get(i).toString());									
		}
		System.out.println();
		
	}
	
	public void buscarProducto(Scanner scanIn, List<Producto> lstProductos) {
		
		String productName = "";
		
		System.out.println("Escribe el nombre del producto a buscar: ");
		productName = scanIn.next();
		
		for (Producto producto : lstProductos) {
			
			if (producto.getNombre().trim().equals(productName)) {
				System.out.println();
				System.out.print(producto.toString());
				return;
			}
			
		}
		
		System.out.println("NO SE HA ENCONTRADO EL PRODUCTO: " + productName);		
	}	

	@Override
	public void venderProducto(List<Producto> lstProductos) {
		
		
	}
	
}
