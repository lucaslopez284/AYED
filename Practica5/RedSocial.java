package Practica5;

import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

public class RedSocial {
	
	public Tupla nivelPopularidad (Graph <String> red, String usuario, int distancia, int umbral) {
		Tupla result = null;
		if (red!= null && !red.isEmpty()) {
			Vertex <String> origen = red.search(usuario);
			if (origen!= null) {
				int cant = this.bfs(red, origen, distancia);
				boolean cumple = false;
				if (cant >= umbral) {
					cumple = true;
				}
				result = new Tupla(cant,cumple);
			}
			else result = new Tupla(0, false);
		}
		
		return result;
	}
	
	private int bfs (Graph <String> red, Vertex<String> usuario, int distancia) {
		int cant = 0; int disAct = 0;
		Queue <Vertex<String>> cola = new Queue <Vertex<String>>();
		boolean [] marcas  = new boolean [red.getSize()];
		marcas[usuario.getPosition()] = true;
		cola.enqueue(usuario);
		cola.enqueue(null);
		while (disAct <= distancia && !cola.isEmpty()) {
			Vertex<String> vertice = cola.dequeue();
			if (vertice != null) {
				if (disAct == distancia) {
					cant++;
				}
				for (Edge<String> arista: red.getEdges(vertice)) { 
					Vertex<String> vecino = arista.getTarget();
					if (!marcas[vecino.getPosition()]) {
						cola.enqueue(vecino);
						marcas [vecino.getPosition()] = true;
					}
				}
			}
			else {
				disAct++;
				if (!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		
		
		return cant;
	}

}

