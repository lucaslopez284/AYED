package prac1Ej7;

import java.util.ArrayList;

public class combinarListas {
	public static void main(String[] args) {
		ArrayList <Integer> l1 = new ArrayList <Integer> ();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		
		ArrayList <Integer> l2  = new ArrayList <Integer> ();
		l2.add(1);
		l2.add(3);
		l2.add(3);
		l2.add(6);
		l2.add(7);
		
		ArrayList<Integer> l3 = combinarOrdenado(l1,l2);
		for (int i = 0; i< l3.size();i++) {
			System.out.println(l3.get(i));
		}
		  
	}
	
	public static ArrayList <Integer> combinarOrdenado (ArrayList <Integer> l1, ArrayList <Integer> l2){
		ArrayList <Integer> l = new ArrayList <Integer> ();
		while (!l1.isEmpty() && !l2.isEmpty()) {
		  if (l1.getFirst() < l2.getFirst()) {
			  l.add(l1.getFirst());
			  l1.removeFirst();
		  }
		  else {
			  l.add(l2.getFirst());
			  l2.removeFirst();
		  }
		}
		return l;
	}

}
