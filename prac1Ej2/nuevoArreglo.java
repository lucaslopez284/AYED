package prac1Ej2;
import java.util.Scanner;


public class nuevoArreglo {
  public static int[] completar(int n, int n2) {
	  int arreglo [] = new int [n2];
	  int diml = 0;
	  int aux = n;
	  int  i = 1;
	  while (diml < n2) {
		  arreglo[diml]= aux * i;
		  i++; 
		  diml++;
	  }
	  return arreglo;
  }
	  
	  public static void informar (int[] arreglo) {
		  for (int x = 0; x < arreglo.length; x++) {
			  System.out.println(arreglo[x]);
	  }
	 
    	  
      
  }
	  
	  public static void main(String[] args) {
		  Scanner input = new Scanner(System.in); // Create a Scanner object
			 System.out.println("Ingrese el primer numero");
			 int num1 = input.nextInt();
			 System.out.println("Ingrese el segundo numero");
			 int num2 = input.nextInt();
			 nuevoArreglo.informar(nuevoArreglo.completar(num1, num2));
	  }
}
