package Practica3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ParcialArbolesGenerales9 {
	
	
	private static int minimo( List <GeneralTree<Integer>> l) {
		int min = 9999;
		for (GeneralTree<Integer> info : l) {
			if (info.getData() < min)
				min = info.getData();
		}
		return min; 
	}
	
	
	private static boolean metodoAuxiliar(GeneralTree<Integer> a) {
		boolean aux = false;
		if (a.isLeaf()) {
			aux = true;
		}
		else {
		  if (a.getData() == minimo (a.getChildren())) {
			  aux = true;
		  }
		  Iterator <GeneralTree<Integer>> iterador = a.getChildren().iterator();
		  while (aux == true && iterador.hasNext()) {
				aux = metodoAuxiliar(iterador.next());
	      }
		}
		return aux;
	}
	
	public static boolean iterativo (GeneralTree<Integer> a) {
		boolean aux = true;
		Queue <GeneralTree<Integer>> cola = new Queue <GeneralTree<Integer>> ();
		cola.enqueue(a);
		while ((aux == true) && (!cola.isEmpty())) {
			GeneralTree<Integer> ag = cola.dequeue();
			int min = Integer.MAX_VALUE;
			if (ag.isLeaf()) 
			  min = ag.getData();
		    else {
			  List <GeneralTree<Integer>> hijos = ag.getChildren();
			  for (GeneralTree<Integer> h : hijos) {
				 if (h.getData() < min) {
					  min = h.getData();
				 }
			      cola.enqueue(h);
			   }
			}
		}
		return aux;
	}
	
	public static boolean esDeSeleccion (GeneralTree<Integer> a) {
         boolean aux = false;
         if (a!= null && !a.isEmpty()) {
        	 aux = iterativo(a);
		}
        return aux;
	}
	
	public static void main(String[] args) {
        
        
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        subChildren1.add(new GeneralTree<Integer>(83));
        subChildren1.add(new GeneralTree<Integer>(12));
        subChildren1.add(new GeneralTree<Integer>(33));
        
     
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, subChildren1); 
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));
        
	}
}
