package Practica2;

import java.util.LinkedList;
import java.util.List;

public class ParcialPrevioAB {
	
	public static void auxiliar (BinaryTree <Integer> ab,List <Integer> lista , List <Integer> camino, int cant, int min) {
		camino.add(ab.getData());
		if (ab.getData() % 2 == 0) {
			cant++;
		}
		if (ab.isLeaf()) {
			if (cant >= min) {
				lista.addAll(camino);
			}
		}
		else {
			if (lista.isEmpty() && ab.hasLeftChild()) {
				auxiliar(ab.getLeftChild(),lista,camino,cant,min);
			}
			if (lista.isEmpty() && ab.hasRightChild()) {
				auxiliar(ab.getRightChild(),lista,camino,cant,min);
			}				
		}
	}
		
	
	
	public List <Integer> resolver (BinaryTree <Integer> ab, int min){
		List <Integer> lista = new LinkedList<Integer>();
		if (ab!= null && !ab.isEmpty()) {
			List <Integer> camino = new LinkedList<Integer>();
			auxiliar(ab, lista,camino, 0,min);
		}
		return lista;
	}

}
