package Datos;

public class Atraccion {
	
	String Categor�a; 
	String Nombre; 
	String Horario; 
	String Estado; 
	int Espera;
	public Atraccion(String categor�a, String nombre, String horario, String estado, int espera) {
		super();
		Categor�a = categor�a;
		Nombre = nombre;
		Horario = horario;
		Estado = estado;
		Espera = espera;
	}
	@Override
	public String toString() {
		return "Atraccion [Categor�a=" + Categor�a + ", Nombre=" + Nombre + ", Horario=" + Horario + ", Estado="
				+ Estado + ", Espera=" + Espera + "]";
	} 
	
	
	
	
	

}
