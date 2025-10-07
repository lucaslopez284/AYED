package Practica5;

import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;


public class CiudadLaPlata {
	
	public List<Objeto> resolver(Graph<String> sitios, String origen, String destino, List<String> lugaresProhibidos){
		List<Objeto> resultado = new LinkedList<Objeto>();
		if (sitios != null && !sitios.isEmpty()) {
			Vertex <String> arranco = null;
			Vertex <String> termino = null;
			
			Iterator<Vertex<String>> it = sitios.getVertices().iterator();
			while ((arranco == null || termino == null ) && (it.hasNext())) {
				Vertex<String> v = it.next();
				if (v.equals(arranco)) {
					arranco = v;
				}
				else if (v.equals(termino)) {
					termino = v;
				}
				
			}
			
			if (arranco != null && termino != null) {
				boolean [] marcas = new boolean [sitios.getSize()];
				List<String> lista = new LinkedList<String>();
				this.prohibidos(sitios, lugaresProhibidos, marcas);
				int cuadras = 0;
				this.auxiliar(sitios, arranco, termino, resultado, lista, cuadras, marcas);
				
			}
		}
		return resultado;
	}
	
	
	
	private void auxiliar(Graph<String> sitios, Vertex <String> origen, Vertex <String>destino,
			              List<Objeto> resultado, List<String> lista, int cuadras, boolean [] marcas  ) {
		
		lista.add(origen.getData());
		marcas [origen.getPosition()] = true;
		
		if (origen.equals(destino)) {
			resultado.add(new Objeto (new LinkedList<String>(lista),cuadras));
		}
		else 
			for (Edge <String> arista : sitios.getEdges(origen)) {
				int aux = cuadras + arista.getWeight();
				Vertex <String> vecino = arista.getTarget();
				if (!marcas[vecino.getPosition()]) {
					this.auxiliar(sitios, vecino, destino, resultado, lista, aux, marcas);
				}
			}
		
		lista.remove(lista.size() - 1);
		marcas [origen.getPosition()] = false;
	 
	}
	
	private void prohibidos (Graph<String> sitios, List<String> lugaresProhibidos, boolean [] marcas) {
		for (String act :lugaresProhibidos) {
			Vertex<String> v = sitios.search(act);
			if (v != null) {
				marcas [v.getPosition()] = true;
			}
		}
	}
	
	
}
