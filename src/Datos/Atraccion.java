package Datos;

public class Atraccion {
	
	String Categoría; 
	String Nombre; 
	String Horario; 
	String Estado; 
	int Espera;
	public Atraccion(String categoría, String nombre, String horario, String estado, int espera) {
		super();
		Categoría = categoría;
		Nombre = nombre;
		Horario = horario;
		Estado = estado;
		Espera = espera;
	}
	@Override
	public String toString() {
		return "Atraccion [Categoría=" + Categoría + ", Nombre=" + Nombre + ", Horario=" + Horario + ", Estado="
				+ Estado + ", Espera=" + Espera + "]";
	} 
	
	
	
	
	

}
