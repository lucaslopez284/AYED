package Practica2;

public class dobleInfo {
  private Integer suma;
  private Integer dif;
  
  
  
public dobleInfo(Integer suma, Integer dif) {
	super();
	this.suma = suma;
	this.dif = dif;
}

public Integer getSuma() {
	return suma;
}

public void setSuma(int suma) {
	this.suma = suma;
}

public Integer getDif() {
	return dif;
}

public void setDif(int dif) {
	this.dif = dif;
}

@Override
public String toString() {
	return "[Suma: " + this.getSuma() + ", dif: " + this.getDif() + "]";
}
 

  
}
