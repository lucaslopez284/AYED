package Practica5;

import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

public class ParcialTemaiken {
	public int Resolver (Graph<Recinto> grafo, int tiempo) {
		int resultado = 0;
		if (grafo != null && !grafo.isEmpty()) {
			Vertex<Recinto> origen = null;
			Iterator <Vertex<Recinto>> it = grafo.getVertices().iterator();
			while (origen == null && it.hasNext()) {
				Vertex<Recinto> vertice = it.next();
				if (vertice.getData().getNombre().equals("Entrada")) {
					origen = vertice;
				}
				
			}
			if (origen != null) {
				boolean [] marcas = new boolean [grafo.getSize()];
				resultado = this.auxiliar(grafo, origen, tiempo, marcas);
			}
		}
		
		return resultado;
	}
	
	private int auxiliar (Graph<Recinto> grafo, Vertex<Recinto> origen, int tiempo, boolean [] marcas ) {
		marcas [origen.getPosition()] = true;
		int ret;
		if (tiempo < origen.getData().tiempo) {
			ret = 0;
		}
		else {
			tiempo = tiempo - origen.getData().getTiempo();
			int lugares = 0; int maxLugares = 0;
			for (Edge<Recinto> arista:grafo.getEdges(origen)) {
				Vertex<Recinto> vecino = arista.getTarget();
				
				if (!marcas[vecino.getPosition()] && (tiempo >= arista.getWeight() + vecino.getData().getTiempo())) {
					lugares = this.auxiliar(grafo, vecino, tiempo, marcas);
				}
				if (lugares > maxLugares) {
					maxLugares = lugares;
				}
			}
			ret = maxLugares + 1;
			
		}
			
		
		
		marcas [origen.getPosition()] = false;
		return ret;
	}
      
}
