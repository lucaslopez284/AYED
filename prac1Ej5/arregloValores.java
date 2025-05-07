package prac1Ej5;

public class arregloValores {
	
	public static void main(String[] args) {
	
	  int [] elementos = new int [10];
	
	  for (int i= 0; i< 10; i++) {
	    elementos[i]= 2*(i+ 1);
	   }
	
	
	Valores arreglo = CalcularValores.calcular(elementos);
	System.out.println(arreglo.toString());
	
	Valores v = new Valores();
	
	CalcularValores.metodo2(elementos, v);
	System.out.println(v.toString());
		
	CalcularValores.metodo3(elementos);
	System.out.println(CalcularValores.res);
	
	}
}