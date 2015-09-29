package Datos;

public class Articulo {
	String nombre; 
	String precio; 
	int cantidad;
	public Articulo(String nombre, String precio, int cantidad) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Articulo [nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + "]";
	} 

}
