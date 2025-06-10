package Practica5;

import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

public class CaminoMasCiudades {
	
	public List<String> resolver (Graph <Ciudad> mapa, String arranque, int cant){
		List<String> camino = new LinkedList<String>();
		if (mapa!= null && !mapa.isEmpty()) {
			Vertex <Ciudad> origen = null;
			Iterator <Vertex<Ciudad>> it = mapa.getVertices().iterator();
			while (origen == null && it.hasNext()) {
				Vertex <Ciudad> v = it.next();
				if (v.getData().getNombre().equals(arranque)) {
					origen = v;
				}
			}
			
			if (origen != null) {
				boolean [] marcas = new boolean [mapa.getSize()];
				List<String> lista = new LinkedList<String>();
				this.auxiliar(mapa, origen, cant, lista, camino, marcas);
				
			}
			
		}
		
		
		return camino;
	}
	
	
	private void auxiliar (Graph <Ciudad> mapa, Vertex<Ciudad> origen, int dias, List<String> lista, List<String> camino, boolean [] marcas) {
		marcas [origen.getPosition()] = true;
		boolean sume = false;
		if (dias <= origen.getData().getDias()) {
			if (dias == origen.getData().getDias()) {
				lista.add(origen.getData().getNombre());
				sume = true;
			}
			if (lista.size() > camino.size()) {
				camino.clear();
				camino.addAll(lista);
			} 
		}
		else {
			lista.add(origen.getData().getNombre());
		    sume = true;
		    int nueDias = dias - origen.getData().getDias();
		    List<Edge<Ciudad>> aristas = mapa.getEdges(origen);
		    for (Edge<Ciudad> aristaAct: aristas) {
		    	Vertex<Ciudad> vecino = aristaAct.getTarget();
		    	if (!marcas[vecino.getPosition()]) 
		    	  this.auxiliar(mapa, vecino, nueDias, lista, camino, marcas);
		    }
		}
		     
		
		marcas [origen.getPosition()] = false;
		if (sume) {
			lista.remove(lista.size() - 1);
		}
	}
	
}
