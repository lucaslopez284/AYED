package Practica3;

import java.util.*;

/* Dada una clase Caminos que contiene una variable de instancia de tipo GeneralTree de números
enteros, implemente un método que retorne el camino a la hoja más lejana. En el caso de haber
más de un camino máximo retorne el primero que encuentre.
El método debe tener la siguiente firma: public List<Integer> caminoAHojaMasLejana ()
Por ejemplo, para el siguiente árbol, la lista a retornar seria: 12, 17, 6, 1 de longitud 3
(Los caminos 12, 15, 14, 16 y 12, 15, 14, 7 son también máximos, pero se pide el primero)*/

public class Caminos {
	public GeneralTree<Integer> ag;

	public Caminos(GeneralTree<Integer> ag) {
		super();
		this.ag = ag;
	}

	public GeneralTree<Integer> getAg() {
		return ag;
	}

	public void setAg(GeneralTree<Integer> ag) {
		this.ag = ag;
	}
	
	
	private static void caminoLargo(GeneralTree<Integer> ag, List<Integer> camino,  List<Integer> aux) {
		aux.add(ag.getData());
		if (ag.isLeaf()) {
			if (aux.size() > camino.size()){
				camino.removeAll(camino);
				camino.addAll(aux);
			}
		} 
		else {
		    for (GeneralTree<Integer> hijo : ag.getChildren()) {
				caminoLargo(hijo,camino, aux);
			}
		}
		aux.remove(aux.size()-1);
	}
	
	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> camino = new LinkedList<Integer>();
		if (this.getAg() != null && !this.getAg().isEmpty()) {
			List<Integer> aux = new LinkedList<Integer>();
			caminoLargo(this.getAg(), camino, aux);
		}
		return camino;
	}
	
	
	
	 public static void main(String[] args) {
	        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
	        subChildren1.add(new GeneralTree<Integer>(1));
	        GeneralTree<Integer> subA = new GeneralTree<Integer>(6, subChildren1);
	        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
	        subChildren2.add(new GeneralTree<Integer>(10));
	        subChildren2.add(subA);
	        GeneralTree<Integer> a1 = new GeneralTree<Integer>(17, subChildren2);
	        
	        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
	        subChildren3.add(new GeneralTree<Integer>(8));
	        GeneralTree<Integer> a2 = new GeneralTree<Integer>(9, subChildren3);
	        
	        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
	        subChildren4.add(new GeneralTree<Integer>(16));
	        subChildren4.add(new GeneralTree<Integer>(7));
	        GeneralTree<Integer> subB = new GeneralTree<Integer>(14, subChildren4);
	        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
	        subChildren5.add(subB);
	        subChildren5.add(new GeneralTree<Integer>(18));
	        GeneralTree<Integer> a3 = new GeneralTree<Integer>(15, subChildren5);
	        
	        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
	        arbol.add(a1);
	        arbol.add(a2);
	        arbol.add(a3);
	        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);
	        
	        Caminos cam = new Caminos(a);
	        
	        System.out.println("Camino a hoja mas lejana: " + cam.caminoAHojaMasLejana());
	 }

	
	
}
