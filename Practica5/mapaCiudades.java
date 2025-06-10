package Practica5;
import java.util.*;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;
public class mapaCiudades {
	Graph <String> grafo;

	public mapaCiudades(Graph<String> grafo) {
		super();
		this.grafo = grafo;
	}
	
	
	
	public Graph<String> getGrafo() {
		return grafo;
	}



	public void setGrafo(Graph<String> grafo) {
		this.grafo = grafo;
	}


	// --------------------------------- EJERCICIO 1 ----------------------------------------------------------
	
	public List<String> devolverCamino (String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
		if (!this.grafo.isEmpty()) {
			Vertex<String> origen = this.grafo.search(ciudad1);
			Vertex <String> destino = this.grafo.search(ciudad2);
			boolean[] marca = new boolean[grafo.getSize()];
			List<String> lista = new LinkedList<String>();
			if (origen != null && destino != null)
				 
			   this.devolverCaminoAux(grafo, origen, ciudad1, ciudad2, marca, camino, lista);
		}
		return camino;
		
	}
	
	private void devolverCaminoAux (Graph<String> mapa,Vertex<String> entrada,String ciudad1, String ciudad2, boolean[] marcas, 
			List<String> camino, List<String> lista) {
		
		marcas[entrada.getPosition()] = true;
		
		lista.add(entrada.getData());
		if (entrada.getData().equals(ciudad2) && camino.isEmpty()) {
			camino.addAll(lista);
		}
	    for (Edge<String> e: mapa.getEdges(entrada)) {
	    	    Vertex<String> vecino = e.getTarget();
				if (camino.isEmpty() && !marcas[vecino.getPosition()])
					this.devolverCaminoAux(mapa, vecino, ciudad1, ciudad2, marcas, camino, lista);
			}
		
		lista.remove(lista.size() - 1);
		
	}
	
	// ej 1 x Guaymas, generalmente tiene de las mejores practicas
	
	public List<String> devolverCaminoGua (String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
		if (!this.grafo.isEmpty()) {
			Vertex<String> origen = this.grafo.search(ciudad1);
			Vertex <String> destino = this.grafo.search(ciudad2);
			boolean[] marca = new boolean[grafo.getSize()];
			List<String> lista = new LinkedList<String>();
			if (origen != null && destino != null)
				 devolverCaminoA(origen, destino, camino, marca);
			   //this.devolverCaminoAux(grafo, origen, ciudad1, ciudad2, marca, camino, lista);
		}
		return camino;
		
	}
	
	
	private boolean devolverCaminoA(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marcas) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if(origen == destino) {
            return true;
        } else {
            List<Edge<String>> ady = this.grafo.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !encontre) {
                Vertex<String> v = it.next().getTarget();
                int j = v.getPosition();
                if(!marcas[j]) {
                    encontre = devolverCaminoA(v, destino, camino, marcas);
                }
            }
        }
        if(!encontre) {
            camino.remove(camino.size()-1); //marcas[origen.getPosition()] = false; Cuando haya encontrado el camino hacia destino, deja marcadas las posiciones del vector de marcas
        }
        marcas[origen.getPosition()] = false; //Deja desmarcadas todas las posiciones del vector de marcas: no es necesario desmarcar en este ejemplo.
        return encontre;
    }
	
	// --------------------------------- EJERCICIO 2 ----------------------------------------------------------
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades ) {
        List<String> camino = new LinkedList<String>();
        if(!this.grafo.isEmpty()) {
            Vertex <String>origen = this.grafo.search(ciudad1);
            Vertex <String>destino = this.grafo.search(ciudad2);
            if(origen != null && destino != null) {
            	boolean[] marcas = new boolean[grafo.getSize()];
            	List<String> lista = new LinkedList<String>();
            	marcasRestringidos(ciudades,marcas);
                auxiliarEj2(origen, destino, camino, lista, marcas);
            }
        }
        return camino;
    }
	
	private boolean auxiliarEj2(Vertex<String> origen, Vertex<String> destino, List<String> camino, List<String> lista, boolean[] marcas) {
		boolean encontre = false;
		marcas[origen.getPosition()] = true;
		lista.add(origen.getData());
		if (origen == destino) {
			camino.addAll(lista);
			return true;
		}
		else {
			List<Edge<String>> aristas = this.grafo.getEdges(origen);
			Iterator <Edge<String>> iterador = aristas.iterator();
			while (!encontre && iterador.hasNext()) {
				Vertex <String> v = iterador.next().getTarget();
				if (!marcas[v.getPosition()])
					encontre = this.auxiliarEj2(v, destino, camino, lista, marcas);
			}
		}
		lista.remove(lista.size() - 1);
		marcas[origen.getPosition()] = false;
		return encontre;
	}
	
	private void marcasRestringidos(List<String> ciudades, boolean [] marcas) {
		for (String ciudad: ciudades) {
			Vertex <String>nodo = this.grafo.search(ciudad);
			if (nodo != null) {
				marcas[nodo.getPosition()] = true;
			}
		}
	}
	
	// --------------------------------- EJERCICIO 3 ----------------------------------------------------------
	
	 public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		 List<String> camino = new LinkedList<String>();
		 if (!grafo.isEmpty()) {
			 Vertex <String> origen = grafo.search(ciudad1);
			 Vertex <String> destino = grafo.search(ciudad2);
			 if (origen != null && destino != null) {
				 List<String> lista = new LinkedList<String>();
				 boolean [] marcas = new boolean [grafo.getSize()];
				 this.AuxiliarEj3(origen, destino, camino, lista, 0, Integer.MAX_VALUE, marcas);
				 
			 }
		 }
		 
		 return camino;
	 }
	 
	 private int AuxiliarEj3 (Vertex <String> origen, Vertex<String> destino, List<String> camino, 
			                  List <String> lista, int total, int min, boolean [] marcas) {
		 
		 lista.add(origen.getData());
		 
		 marcas[origen.getPosition()] = true;
		 
		 if (origen.equals(destino) && total < min) {
			 camino.clear();
			 camino.addAll(lista);
			 min = total;
		 }
		 else {
			 List <Edge<String>> aristas = grafo.getEdges(origen);
			 for (Edge<String> vecino : aristas) {
				 Vertex<String> v = vecino.getTarget();
				 if(!marcas[v.getPosition()]) {
					 int aux = total + vecino.getWeight();
					 min = this.AuxiliarEj3(v, destino, camino, lista, aux, min, marcas);
				 }
				 
			 }
		 }
		 
		 lista.remove(lista.size() - 1);
		 marcas[origen.getPosition()] = false;
		 return min;
		 
		 
	 }
	 
	 
	// --------------------------------- EJERCICIO 4 ----------------------------------------------------------
	 
	 public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		 List<String> camino = new LinkedList<String>();
		 if (!grafo.isEmpty()) {
			 Vertex <String> origen = grafo.search(ciudad1);
			 Vertex <String> destino = grafo.search(ciudad2);
			 if (origen != null && destino != null) {
				 boolean [] marcas = new boolean [grafo.getSize()];
				 List <String> lista = new LinkedList <String>();
				 this.AuxiliarEj4(origen, destino, tanqueAuto, marcas, camino, lista);
				 
			 }
		 }
		 
		 return camino;
	 }
	 
	 
	
	
    private void AuxiliarEj4 (Vertex <String> origen, Vertex <String> destino, int tanque, boolean [] marcas,
    		                    List <String> camino, List <String> lista) {
    	marcas [origen.getPosition()] = true;
    	lista.add(origen.getData());
    	
    	if (origen.equals(destino)) {
    			camino.addAll(lista);
    	} 
    	else {
    		Iterator <Edge<String>> it = grafo.getEdges(origen).iterator();
    		while(camino.isEmpty() && it.hasNext()) {
    			Edge<String> arista = it.next();
    			Vertex<String> vecino = arista.getTarget();
    			int aux = tanque - arista.getWeight();
    			if (aux > 0 && !marcas[vecino.getPosition()]) {
    				this.AuxiliarEj4(vecino, destino, aux, marcas, camino, lista);
    			}
    		}
    	}
    	
    	lista.remove(lista.size() - 1);
    	marcas [origen.getPosition()] = false;
    }
    
 // --------------------------------- EJERCICIO 5 ---------------------------------------------------------- 
    
    public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto) {
    	List <String> camino = new LinkedList<String>();
    	if (!this.grafo.isEmpty()) {
    		Vertex <String> origen = this.grafo.search(ciudad1);
    		Vertex <String> destino = this.grafo.search(ciudad2);
    		if (origen != null && destino != null) {
    			boolean [] marcas = new boolean [grafo.getSize()];
    			List <String> lista = new LinkedList<String>();
    			this.AuxiliarEj5(origen, destino, tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE, marcas, camino, lista);
    		}
    	}
    	return camino;
    }
    
    
	private int AuxiliarEj5(Vertex <String> origen, Vertex <String> destino, int tanque, int completo,
			                 int cargas, int minCargas  ,boolean [] marcas, List<String> camino, List<String> lista) {
		
		marcas[origen.getPosition()] = true;
		lista.add(origen.getData());
		
		if (origen.equals(destino)) {
			if (cargas < minCargas) {
				camino.clear();
				camino.addAll(lista);
				minCargas = cargas;
			}
		}
		else {
			for (Edge<String> arista: grafo.getEdges(origen)) {
				Vertex  <String> vecino = arista.getTarget();
				int aux = tanque - arista.getWeight();
				if (!marcas[vecino.getPosition()]) {
					if (aux >= 0) {
						minCargas = this.AuxiliarEj5(vecino, destino, aux, completo, cargas, minCargas, marcas, camino, lista);
					}
					else if (completo >= arista.getWeight()){
						minCargas = this.AuxiliarEj5(vecino, destino, completo, completo, (cargas + 1), minCargas, marcas, camino, lista);
					}
				}
			}
		}
		
		
		marcas[origen.getPosition()] = false;
		lista.remove(lista.size() - 1);
		return minCargas;
	}
	
	
	// --------------------------------- MAIN ----------------------------------------------------------
	
	public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        mapaCiudades mapa = new mapaCiudades(mapaCiudades);
        System.out.print("LISTA DEVOLVER CAMINO algoritmo Guaymas: ");
        System.out.println(mapa.devolverCamino("La Plata", "Berazategui"));
        System.out.print("LISTA DEVOLVER CAMINO algoritmo Lucas: ");
        System.out.println(mapa.devolverCaminoGua("La Plata", "Berazategui"));
        
        System.out.print("LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:");
        List<String> restringidos = new LinkedList<String>();
        restringidos.add("Berisso");
        System.out.println(mapa.devolverCaminoExceptuando("La Plata", "San Vicente", restringidos));
        
        System.out.print("LISTA CAMINO MAS CORTO (SEGUN DISTANCIA): ");
        System.out.println(mapa.caminoMasCorto("La Plata", "San Vicente"));
        
        
        System.out.print("LISTA CAMINO SIN CARGAR COMBUSTIBLE: ");
        System.out.print(mapa.caminoSinCargarCombustible("La Plata", "San Vicente", 30));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO CON MENOR CARGAS DE COMBUSTIBLE: ");
        System.out.print(mapa.caminoConMenorCargaDeCombustible("La Plata", "San Vicente", 10));
        
        System.out.println("");
        
	}
	
	
	
	
	

}
