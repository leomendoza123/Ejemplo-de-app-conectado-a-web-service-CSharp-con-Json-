package Datos;

import java.util.Date;

public class Show {
	String nombre; 
	String horario; 
	String lugar; 
	String descripcion;
	public Show(String nombre, String horario, String lugar, String descripcion) {
		super();
		this.nombre = nombre;
		this.horario = horario;
		this.lugar = lugar;
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Show [nombre=" + nombre + ", horario=" + horario + ", lugar=" + lugar + ", descripcion=" + descripcion
				+ "]";
	} 
	
	

	
}
