package Practica5;
import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;


public class localidadesMendoza {
	
	public List<String> recorrido (Graph<String> grafo ,int cantLocalidades, int cantNafta, List<String> prohibidos){
		List<String> camino = new LinkedList<String>();
		if (grafo != null && !grafo.isEmpty()) {
			Vertex<String> origen = grafo.search("Mendoza");
			if (origen != null) {
				List<String> lista = new LinkedList<String>();
				boolean [] marcas = new boolean [grafo.getSize()];
				this.prohibir(grafo, prohibidos, marcas);
				//this.auxiliar(grafo, origen, cantLocalidades, cantNafta, camino, lista, marcas);
				this.auxiliarCorrecto(grafo, origen, cantLocalidades, cantNafta, camino, lista, marcas);
			}
		}
		
		return camino;
	}
	
	private void auxiliar (Graph<String> grafo, Vertex<String> origen ,int cantLocalidades, int cantNafta, List<String> camino, List<String> lista, boolean [] marcas) {
	  marcas [origen.getPosition()] = true;
	  boolean agregue = false;
	  
	  if ((cantNafta < 0) && (camino.isEmpty()) && (lista.size() >= cantLocalidades)) {
		  camino.addAll(lista);
	  }
	  else {
		  lista.add(origen.getData());
		  agregue = true;
		  if ((cantNafta == 0) && (camino.isEmpty()) && (lista.size() >= cantLocalidades)) {
			  camino.addAll(lista);
		  }
		  else {
			  Iterator <Edge<String>> it = grafo.getEdges(origen).iterator();
			  while (camino.isEmpty() && it.hasNext()) {
				  Edge<String> arista = it.next();
				  Vertex<String> vecino = arista.getTarget();
				  int aux = cantNafta - arista.getWeight();
				  if (!marcas[vecino.getPosition()]) {
					  this.auxiliar(grafo, vecino, cantLocalidades, aux, camino, lista, marcas);
				  }
			  }
		  }
	  }
	  
	  if (agregue) {
		  lista.remove(lista.size() - 1);
	  }
	  marcas [origen.getPosition()] = false;
	}
	
	
	private void auxiliarCorrecto (Graph<String> grafo, Vertex<String> origen ,int cantLocalidades, int cantNafta, List<String> camino, List<String> lista, boolean [] marcas){
		
		  marcas [origen.getPosition()] = true;
		  lista.add(origen.getData());
		  if (lista.size() >= cantLocalidades) {
			  camino.addAll(lista);
		  }
		  else {
			  Iterator <Edge<String>> it = grafo.getEdges(origen).iterator();
			  while (camino.isEmpty() && it.hasNext()) {
				  Edge<String> arista = it.next();
				  Vertex<String> vecino = arista.getTarget();
				  int aux = cantNafta - arista.getWeight();
				  if (!marcas[vecino.getPosition()] && aux >= 0) {
					  this.auxiliar(grafo, vecino, cantLocalidades, aux, camino, lista, marcas);
				  }
			  }
		  }
		
		  lista.remove(lista.size() - 1);
	      marcas [origen.getPosition()] = false;
		}
	
	private void prohibir (Graph<String> grafo, List<String> prohibidos, boolean [] marcas) {
		for (String lugar: prohibidos) {
			Vertex<String> act = grafo.search(lugar);
			if (act!= null) {
				marcas[act.getPosition()] = true;
			}
		}
	}

}
