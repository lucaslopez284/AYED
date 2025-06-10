package Practica5;

public class Tupla {
	
	int cant;
	boolean popular;
	
	
	public Tupla(int cant, boolean popular) {
		super();
		this.cant = cant;
		this.popular = popular;
	}
	
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public boolean isPopular() {
		return popular;
	}
	public void setPopular(boolean popular) {
		this.popular = popular;
	}

	@Override
	public String toString() {
		return "cant: " + cant + ", popular: " + popular;
	}
	
	
	
	

}
