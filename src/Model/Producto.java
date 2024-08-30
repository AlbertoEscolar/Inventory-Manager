package Model;

public class Producto {

	String nombre;
	float precio;
	int cantidad;
	
	
	public Producto(String _nombre, float _precio, int _cantidad) {
		this.nombre = _nombre;
		this.precio = _precio;
		this.cantidad = _cantidad;								
	}
	
	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
}
