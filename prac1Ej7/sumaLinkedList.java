package prac1Ej7;

import java.util.ArrayList;
import java.util.LinkedList;

public class sumaLinkedList {
	
	public static int sumarAux (LinkedList <Integer> l, int pos) {
		if (pos < l.size())
			return l.get(pos) + sumarAux (l, (pos + 1));
		else return 0;
	}
	
	public static int sumarLinkedList (LinkedList <Integer> l) {
		return sumarAux (l,0);
	}
	
	public static void main(String[] args) {
		LinkedList <Integer> l1 = new LinkedList <Integer> ();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		System.out.println("La suma de los elementos de la linked list es igual a " + sumarLinkedList (l1));
		
	}
}
