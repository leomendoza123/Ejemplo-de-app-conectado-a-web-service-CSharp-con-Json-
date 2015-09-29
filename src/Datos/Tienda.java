package Datos;

import java.util.ArrayList;

public class Tienda {
	String nombre; 
	String horario; 
	ArrayList<Articulo> Articulos;
	public Tienda(String nombre, String horario, ArrayList<Articulo> articulos) {
		super();
		this.nombre = nombre;
		this.horario = horario;
		Articulos = articulos;
	}
	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", horario=" + horario + ", Articulos=" + Articulos + "]";
	} 
	
	
	
	
}
