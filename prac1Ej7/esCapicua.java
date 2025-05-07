package prac1Ej7;

import java.util.ArrayList;

public class esCapicua {
	public static void main(String[] args) {
		ArrayList <Integer> l1 = new ArrayList <Integer> ();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(2);
		l1.add(1);
		if (esONo (l1) == true)
			System.out.println("la secuencia es capicua");
		else 
			System.out.println("la secuencia no es capicua");
		
		
		
	}	
		public static boolean esONo(ArrayList <Integer> l) {
	       boolean aux = true;
	       int i = 0;
	       while ((i < (l.size() / 2)) && (aux = true)){
	    	  if  (l.get(i) != l.reversed().get(i))
	    		  aux = false;
	    	  i++;
	       }
	       return aux;
		}
		
		
  
}
