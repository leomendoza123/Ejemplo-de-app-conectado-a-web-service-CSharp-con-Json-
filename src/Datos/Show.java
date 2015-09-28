package Datos;

import java.util.Date;

public class Show {
	String nombre; 
	Date inicia; 
	Date termina; 
	String categoria;
	
	public Show(String nombre, Date inicia, Date termina, String categoria) {
		super();
		this.nombre = nombre;
		this.inicia = inicia;
		this.termina = termina;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Show [nombre=" + nombre + ", inicia=" + inicia + ", termina=" + termina + ", categoria=" + categoria
				+ "]";
	} 
	
	
}
