package Practica5;
import prac1Ej8.*;
import prac1Ej8.Queue;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.adjMatrix.*;
import java.util.*;

public class Recorridos {
	
	private void dfsAux(int i, Graph <Integer> grafo, boolean [] marca) {
		marca [i] = true;
		Vertex <Integer> v = grafo.getVertex(i);
		System.out.println(v);
		for (Edge<Integer> e: grafo.getEdges(v)) {
			int j = e.getTarget().getPosition();
			if (!marca[j]) {
				dfsAux(j,grafo,marca);
			}
		}
	}
	
	public void dfs (Graph <Integer> grafo) {
		boolean [] marca = new boolean [grafo.getSize()];
		for (int i = 0; i < grafo.getSize(); i++) {
			if (!marca[i]) {
				System.out.println("Largo con: " + grafo.getVertex(i).getData());
				dfsAux(i,grafo,marca);
			}
		}
	}
	
	
	private void bfsAux(int i, Graph <Integer> grafo, boolean [] marca) {
		Queue <Vertex<Integer>> cola = new Queue <Vertex<Integer>>() ;
		cola.enqueue(grafo.getVertex(i));
		marca [i] = true;
		
		while (!cola.isEmpty()) {
			Vertex<Integer> v = cola.dequeue();
			for (Edge<Integer> e: grafo.getEdges(v)) {
				int j = e.getTarget().getPosition();
				if (!marca[j]) {
					marca[j] = true;
					cola.enqueue(e.getTarget());
				}
			}
		}
	}
	
	public void bfs (Graph <Integer> grafo) {
		boolean [] marca = new boolean [grafo.getSize()];
		for (int i = 0; i < grafo.getSize(); i++) {
			if (!marca[i]) {
				System.out.println("Largo con: " + grafo.getVertex(i).getData());
				bfsAux(i,grafo,marca);
			}
		}
	}

}
