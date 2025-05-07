package prac1Ej7;

import java.util.ArrayList;

public class invertirConRecursion {
	public static void main(String[] args) {
		ArrayList <Integer> l1 = new ArrayList <Integer> ();
		l1.add(1);
		l1.add(3);
		l1.add(5);
		l1.add(7);
		l1.add(9);
		l1.add(11);
		imprimir(l1);
		darVuelta(l1);
		imprimir(l1);
		
	}
	
	public static ArrayList <Integer> darVuelta2 (ArrayList <Integer> l) {
		ArrayList <Integer> aux = (ArrayList <Integer>) l.reversed();
		return aux;
	}
	public static void darVuelta (ArrayList <Integer> l) {
		invertir(l,0,(l.size() - 1));
	}
	public static void invertir (ArrayList <Integer> l, int i, int j) {
		if (i< j) {
			Integer aux = l.get(i);
			l.set(i,l.get(j));
			l.set(j, aux);
			invertir(l,(i+1), (j-1));
		}
	}
	
	public static void imprimir (ArrayList <Integer> l) {
		for (int i = 0; i< l.size(); i++)
			System.out.println(l.get(i));
	}
}
