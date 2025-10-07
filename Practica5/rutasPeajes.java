package Practica5;

import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

public class rutasPeajes {
	
	public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int monto){
		List<String> camino = new LinkedList<String>();
		if (ciudades != null && !ciudades.isEmpty()) {
			Vertex<String> ori = ciudades.search(origen);
			Vertex<String> des = ciudades.search(destino);
			if (ori != null && des != null) {
				List<String> lista = new LinkedList<String>();
				boolean [] marcas = new boolean [ciudades.getSize()];
				this.auxiliar(ciudades, ori, des, monto, marcas, camino, lista);
			}
		}
		return camino;
	}
	
	private void auxiliar (Graph<String> ciudades, Vertex<String> origen, Vertex <String> destino, int monto, boolean [] marcas,
			              List<String> camino, List<String> lista) {
		marcas [origen.getPosition()] = true;
		lista.add(origen.getData());
		if ((origen.equals(destino)) && (monto >= 0)) {
			camino.addAll(lista);
		}
		else {
			Iterator <Edge<String>> it = ciudades.getEdges(origen).iterator();
			while (camino.isEmpty() && it.hasNext()) {
				Edge<String> arista = it.next();
				Vertex<String> vecino = arista.getTarget();
				int nueMonto = monto - arista.getWeight();
				if (!marcas[vecino.getPosition()] && nueMonto >= 0) {
					this.auxiliar(ciudades, vecino, destino, nueMonto, marcas, camino, lista);
				}
			}
		}
		
		
		marcas [origen.getPosition()] = false;
		lista.remove(lista.size() - 1);
	}

}
