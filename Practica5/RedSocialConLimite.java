package Practica5;

import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

public class RedSocialConLimite {
	
	public List<String> invitacionMasterClass (Graph<String> red, String usuario, int distancia, int limite){
		List<String> invitados = new LinkedList<String>();
		if (red!= null && !red.isEmpty()) {
			Vertex <String> usuarioOri = red.search(usuario);
			if (usuarioOri!= null) {
				this.bfs(red, usuarioOri, distancia, limite, invitados);
				
			}
		}
		
		return invitados;
	}
	
	private void bfs (Graph<String> red, Vertex<String> usuario, int distancia, int limite, List<String> invitados) {
		Queue <Vertex<String>> cola = new Queue <Vertex<String>>();
		boolean [] marcas = new boolean [red.getSize()];
		marcas[usuario.getPosition()] = true;
		cola.enqueue(usuario);
		cola.enqueue(null);
		int disAct = 0;
		while (invitados.size() < limite && disAct <= 0 && !cola.isEmpty()) {
			Vertex<String> vertice = cola.dequeue();
			
			if (vertice != null) {
				if (disAct > 0 && disAct <= distancia) {
					invitados.add(vertice.getData());
				}
				List<Edge<String>> aristas = red.getEdges(vertice);
				for (Edge<String> a: aristas) {
					Vertex<String> vecino = a.getTarget();
					if (!marcas[vecino.getPosition()]) {
						marcas [vecino.getPosition()] = true;
						cola.enqueue(vecino);
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
		
	}

}
