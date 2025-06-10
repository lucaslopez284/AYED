package Practica5;
import java.util.*;

public class Objeto {
	List<String> lugares;
	int cuadras;
	public Objeto(List<String> lugares, int cuadras) {
		super();
		this.lugares = lugares;
		this.cuadras = cuadras;
	}
	
	
	public List<String> getLugares() {
		return lugares;
	}


	public void setLugares(List<String> lugares) {
		this.lugares = lugares;
	}


	public int getCuadras() {
		return cuadras;
	}


	public void setCuadras(int cuadras) {
		this.cuadras = cuadras;
	}

	
	
	@Override
	public String toString() {
		return "lista de lugares: " + lugares.toString() + "\n" + "Cantidad de cuadras: " + this.getCuadras() +  "\n";
	}
	
	
	

}
