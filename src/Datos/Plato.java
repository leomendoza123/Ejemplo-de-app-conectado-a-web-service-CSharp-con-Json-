package Datos;

public class Plato {
	String nombre; 
	String descripcion;
	public Plato(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Plato [nombre=" + nombre + ", descripcion=" + descripcion + "]";
	} 
	
	
	
}
