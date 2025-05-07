package Practica3;
import java.util.*;

public class ParcialPrevioAG {
	GeneralTree <Integer> Arbol;
	
	
	public static void BuscarCamino (GeneralTree <Integer> ag , List <Integer> lista, List <Integer> camino, int num) {
		camino.add(ag.getData());
		if (ag.isLeaf()) {
			lista.addAll(camino);
		}
		else {
			if (lista.isEmpty()) {
				if (ag.getChildren().size() >= num) {
					Iterator <GeneralTree<Integer>> iterador = ag.getChildren().iterator();
					while (lista.isEmpty() && iterador.hasNext()) {
						BuscarCamino(iterador.next(),lista,camino,num);
					}
				}
			}
		}
		camino.remove(camino.size() - 1);
	}
	
	public List <Integer> Camino (int num){
		List <Integer> lista = new LinkedList<Integer>();
		if (this.Arbol!= null && !this.Arbol.isEmpty()) {
			List <Integer> caminoAux = new LinkedList<Integer>();
			BuscarCamino(this.Arbol, lista,caminoAux,num);
		}
		return lista;
	}

}
