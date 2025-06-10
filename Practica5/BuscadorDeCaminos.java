package Practica5;

import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

public class BuscadorDeCaminos {
	
	Graph <String> bosque;
	
	
	
	
	public BuscadorDeCaminos(Graph<String> bosque) {
		super();
		this.bosque = bosque;
	}




	public List <List <String>> recorridosMasSeguro(){
		List <List<String>> caminos = new LinkedList<List<String>>();
		if (!this.bosque.isEmpty()) {
			Vertex<String> origen = this.bosque.search("Casa Caperucita");
			Vertex<String> destino = this.bosque.search("Casa Abuelita");
			if (origen != null && destino!= null) {
				boolean [] marcas = new boolean [bosque.getSize()];
				List<String> lista = new LinkedList<String>();
				this.auxiliar(origen, destino, caminos, lista, marcas);
			}
		}
		return caminos;
	}
	
	private void auxiliar(Vertex<String> origen, Vertex<String> destino, List<List<String>> caminos, List<String> lista, boolean [] marcas) {
		lista.add(origen.getData());
		marcas[origen.getPosition()] = true;
		
		if (origen.equals(destino)) {
			caminos.add(new LinkedList<String>(lista));
		}
		else {
			for (Edge<String> arista: bosque.getEdges(origen)) {
				Vertex<String> vecino = arista.getTarget();
				if (!marcas[vecino.getPosition()] && arista.getWeight()<= 5) {
					this.auxiliar(vecino, destino, caminos, lista, marcas);
				}
			}
		}
		
		lista.remove(lista.size() - 1);
		marcas[origen.getPosition()] = false;
		
	}
	
	
	
	public static void main (String[] args) {
        Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        BuscadorDeCaminos bos = new BuscadorDeCaminos(bosque);
        List<List<String>> lis = bos.recorridosMasSeguro();
        for(List<String> l: lis) {
            System.out.println(l);
        }
	
	}

}
