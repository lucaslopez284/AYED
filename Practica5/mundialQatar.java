package Practica5;

import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

public class mundialQatar {
	
	public List<String> estadios (Graph <Estadio> mapaEstadios, String estadioOrigen, int cantKm){
		List<String> camino = new LinkedList<String>();
		if (mapaEstadios != null && !mapaEstadios.isEmpty()) {
			Vertex <Estadio> origen = null;
			Iterator <Vertex<Estadio>> it = mapaEstadios.getVertices().iterator();
			while (origen == null && it.hasNext()) {
				Vertex <Estadio> v = it.next();
				if (v.getData().getNombre().equals(estadioOrigen)) {
					origen = v;
				}
			}
			if (origen != null) {
				System.out.println("entro");
				List<String> lista = new LinkedList<String>();
				boolean [] marcas = new boolean [mapaEstadios.getSize()];
				this.auxiliar(mapaEstadios, origen, camino, lista, marcas, cantKm);
			}
		}
		
		return camino;
	}
	
	private void auxiliar (Graph <Estadio> grafo, Vertex<Estadio> origen, List<String> camino, List<String> lista,
			               boolean [] marcas, int km) {
		
		marcas [origen.getPosition()] = true;
		lista.add(origen.getData().getNombre());
		
		if (lista.size() > camino.size()) {
			camino.clear();
			camino.addAll(lista);
		}
		
		for (Edge<Estadio> arista: grafo.getEdges(origen)) {
			Vertex<Estadio> vecino = arista.getTarget();
			int kmNue = km - arista.getWeight();
			if (!marcas[vecino.getPosition()] && kmNue >= 0) {
				this.auxiliar(grafo, vecino, camino, lista, marcas, kmNue);
			}
		}
		
		
			
	    lista.remove(lista.size() - 1);
		marcas [origen.getPosition()] = false;
	}
	
	
	
	public static void main(String args[]) {
        Graph<Estadio> grafo = new AdjListGraph<Estadio>();
        Vertex<Estadio> v1 = grafo.createVertex(new Estadio("Jor", "AI BAYT STADIUM"));
        Vertex<Estadio> v2 = grafo.createVertex(new Estadio("Lusail", "LUSAIL STADIUM"));
        Vertex<Estadio> v3 = grafo.createVertex(new Estadio("Rayán", "EDUCATION CITY STADIUM"));
        Vertex<Estadio> v4 = grafo.createVertex(new Estadio("Rayán", "AL RAYYAN STADIUM"));
        Vertex<Estadio> v5 = grafo.createVertex(new Estadio("Doha", "STADIUM 947"));
        Vertex<Estadio> v6 = grafo.createVertex(new Estadio("Doha", "KHALIFA INTERNATIONAL STADIUM"));
        Vertex<Estadio> v7 = grafo.createVertex(new Estadio("Doha", "AL THUMAMA STADIUM"));
        Vertex<Estadio> v8 = grafo.createVertex(new Estadio("Wakrah", "AL JANOUB STADIUM"));
        
        grafo.connect(v1, v2, 42);
        grafo.connect(v2, v1, 42);
        grafo.connect(v2, v3, 24);
        grafo.connect(v3, v2, 24);
        grafo.connect(v2, v5, 52);
        grafo.connect(v5, v2, 52);
        grafo.connect(v3, v4, 11);
        grafo.connect(v4, v3, 11);
        grafo.connect(v4, v6, 8);
        grafo.connect(v6, v4, 8);
        grafo.connect(v6, v7, 12);
        grafo.connect(v7, v6, 12);
        grafo.connect(v7, v8, 12);
        grafo.connect(v8, v7, 12);
        grafo.connect(v8, v5, 19);
        grafo.connect(v5, v8, 19);
        
        mundialQatar p = new mundialQatar();
        
        List<String> resultado = p.estadios(grafo, "AI BAYT STADIUM", 120);

        if (resultado.isEmpty()) {
            System.out.println("No se encontró un camino válido con el presupuesto de kilómetros.");
        } else {
            System.out.println("Camino con mayor cantidad de estadios dentro del presupuesto:");
            for (String nombre : resultado) {
                System.out.println(" - " + nombre);
            }
        }

    }

}
