package prac1Ej1;
import java.util.Scanner;

public class pasajedeparametros {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a Scanner object
		 System.out.println("Ingrese el primer numero");
		 int num1 = input.nextInt();
		 System.out.println("Ingrese el segundo numero");
		 int num2 = input.nextInt();
		 pasajedeparametros.imprimirFor(num1, num2);
		 pasajedeparametros.imprimirWhile(num1, num2);
		 pasajedeparametros.imprimirC(num1, num2);
	}
	
	public static void imprimirFor(int n, int n2) {
		System.out.println("Impresion con for");
		for (int i = n; i<= n2; i++)
			System.out.println(i);
	}
	
	public static void imprimirWhile(int n, int n2) {
		System.out.println("Impresion con While");
		int i = n;
		while(i<= n2) {
			System.out.println(i);
			i++;
		}
	}
	
	
	
	public static void imprimirC(int n, int n2) {
	  if (n <= n2) {
		  System.out.println(n);
		  imprimirC(n+1,n2);
	  }
		  
	}

}
