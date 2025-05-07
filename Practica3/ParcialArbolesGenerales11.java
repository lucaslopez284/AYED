package Practica3;
import java.util.*;

public class ParcialArbolesGenerales11 {
	
	 
	
	public static boolean resolver(GeneralTree<Integer> a) {
	 boolean result = false;
	 if (a!=null && !a.isEmpty()) {
		 result = true;
		 Queue <GeneralTree<Integer>> cola = new Queue();
		 cola.enqueue(a);
		 cola.enqueue(null);
		 int cantAct = 0;
		 int cantAnt = 0;
		 while ((!cola.isEmpty()) && (result == true)) {
			 GeneralTree<Integer> nodo = cola.dequeue();
			 if (nodo!= null) {
				 cantAct++;
				 for (GeneralTree<Integer> hijo: nodo.getChildren()) {
					 cola.enqueue(hijo);
				 }
			 }
			 else { 
				 if (!cola.isEmpty()) {
					 cola.enqueue(null);
				 }
				 if ((cantAct - cantAnt) != 1) {
					 result = false;
				 }
				 cantAct = 0;
				 cantAnt++;
			 }
		 }
	 }
	 return result;
	}
	
	public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(83));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(18, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(5, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(33));
        subChildren3.add(new GeneralTree<Integer>(12));
        subChildren3.add(new GeneralTree<Integer>(17));
        subChildren3.add(new GeneralTree<Integer>(9));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(3, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(7));
        subChildren4.add(new GeneralTree<Integer>(11));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(4, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(1, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(13));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(2, arbol);
        
        System.out.println("Es creciente el arbol 1: " + resolver(a));
        
        
        List<GeneralTree<Integer>> subChildren5 = new LinkedList <GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(7));
        subChildren5.add(subAb3);
        GeneralTree<Integer> subAb5 = new GeneralTree<Integer>(4, subChildren5);
        
        List<GeneralTree<Integer>> subArbIzq2 = new LinkedList<GeneralTree<Integer>>();
        subArbIzq2.add(subAb2);
        subArbIzq2.add(subAb5);
        GeneralTree<Integer> arbIzq2 = new GeneralTree<Integer>(1, subArbIzq2);
        
        List <GeneralTree<Integer>> arbol2 = new LinkedList <GeneralTree<Integer>>();
        arbol2.add(arbIzq2);
        arbol2.add(arbDer);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, arbol2);
        
        System.out.println("Es creciente el arbol 2: " + resolver(a2));
        
        
	}    
	
	
	
}
