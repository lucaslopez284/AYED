package Practica3;
import java.util.*;

public class RecorridosAG {
   
	
	private static void numerosImparesMayoresQuePreOrdenRec (GeneralTree <Integer> a, Integer n, List<Integer> l) {
		if ((a.getData()% 2 == 1) && (a.getData() > n))
			l.add(a.getData());
		if (a.hasChildren()) {
	      for (GeneralTree <Integer> hijo: a.getChildren())
	      	numerosImparesMayoresQuePreOrdenRec(hijo,n,l);
		}
	}

	
	public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> result = new LinkedList<Integer>();
		if (a != null && !a.isEmpty()) numerosImparesMayoresQuePreOrdenRec(a,n,result);
		return result;
	}
	
	
	private static void numerosImparesMayoresQuePostOrdenRec (GeneralTree <Integer> a, Integer n, List<Integer> l) {
		if (a.hasChildren()) {
		  for (GeneralTree <Integer> hijo: a.getChildren())
	    	  numerosImparesMayoresQuePostOrdenRec(hijo,n,l);
		}
		if ((a.getData()%2 == 1) && (a.getData() > n))
			l.add(a.getData());
	}

	
	public static List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> result = new LinkedList<Integer>();
		if (a != null && !a.isEmpty()) numerosImparesMayoresQuePostOrdenRec(a,n,result);
		return result;
	}
	
	
	private static void numerosImparesMayoresQueInOrdenRec (GeneralTree <Integer> a, Integer n, List<Integer> l) {
		if (a.hasChildren())
			numerosImparesMayoresQueInOrdenRec(a.getChildren().get(0),n,l);
		if ((a.getData()% 2 == 1) && (a.getData() > n))
			l.add(a.getData());
		if (a.hasChildren()) {
	      for (int i = 1; i< a.getChildren().size()-1; i++)
	      	numerosImparesMayoresQuePreOrdenRec(a.getChildren().get(i),n,l);
		}
	}
	
	
	
	
	public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> result = new LinkedList<Integer>();
		if (a != null && !a.isEmpty()) numerosImparesMayoresQueInOrdenRec(a,n,result);
		return result;
	}
	
	
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a ,Integer n){
		List<Integer> result = new LinkedList<Integer>();
		Queue<GeneralTree<Integer>> cola = new Queue();
		cola.enqueue(a);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			GeneralTree<Integer> ab = cola.dequeue();
			if (ab!= null) {
				if (ab.getData() > n && (ab.getData()%2 == 1)) {
					result.add(ab.getData());
				}
				if (ab.hasChildren()) {
					List<GeneralTree<Integer>> children = ab.getChildren();
					for (GeneralTree<Integer> child: children) {
						cola.enqueue(child);
					}
				}
				
			}
			else if (!cola.isEmpty()) {
				cola.enqueue(null);
			}
		}
		return result;
	}
}
