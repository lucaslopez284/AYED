package Practica5;

public class Ciudad {
	
	String nombre;
	int dias;
	public Ciudad(String nombre, int dias) {
		super();
		this.nombre = nombre;
		this.dias = dias;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	@Override
	public String toString() {
		return "Ciudad: " + this.getNombre() + ", dias necesarios para visitarla: " + this.getDias();
	}
	
	

}
