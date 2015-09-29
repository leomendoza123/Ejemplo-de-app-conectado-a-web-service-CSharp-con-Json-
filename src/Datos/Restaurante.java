package Datos;

import java.util.ArrayList;

public class Restaurante {
	
	String nombre; 
	String horario; 
	ArrayList<Plato> platos;
	
	public Restaurante(String nombre, String horario, ArrayList<Plato> platos) {
		super();
		this.nombre = nombre;
		this.horario = horario;
		this.platos = platos;
	}

	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", horario=" + horario + ", platos=" + platos + "]";
	} 
	
	
	

}
