package Practica5;

import java.util.*;

import prac1Ej8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;

/*El Banco Itaú se suma a las campañas "QUEDATE EN CASA" lanzando un programa para acercar el sueldo a los
jubilados hasta sus domicilios. Para ello el banco cuenta con información que permite definir un grafo de
personas donde la persona puede ser un jubilado o un empleado del banco que llevará el dinero.
Se necesita armar la cartera de jubilados para cada empleado repartidor del banco, incluyendo en cada lista, los
jubilados que vivan un radio cercano a su casa y no hayan percibido la jubilación del mes.
Para ello, implemente un algoritmo que dado un Grafo<Persona> retorne una lista de jubilados que se
encuentren a una distancia menor a un valor dado del empleado Itaú (grado de separación del empleado Itaú).
El método recibirá un Grafo<Persona>, un empleado y un grado de separación/distancia y debe retornar una
lista de hasta 40 jubilados que no hayan percibido la jubilación del mes y se encuentre a una distancia menor a
recibido como parámetro. */

public class QuedateEnCasa {
	
	public List<Persona> ayudaJubilados(Graph<Persona> grafo, Persona empleado, int distancia ){
		int max = 40;
		List<Persona> jubilados = new LinkedList<Persona>();
		if (!grafo.isEmpty()) {
		  boolean [] marcas = new boolean [grafo.getSize()];
		  Vertex <Persona> origen = this.buscarEmpleado(grafo, empleado);
		  if (origen!= null) {
			  int disAct = 0;
			  Queue <Vertex<Persona>> cola = new Queue <Vertex<Persona>>();
			  marcas[origen.getPosition()] = true;
			  cola.enqueue(origen);
			  cola.enqueue(null);
			  while ((jubilados.size() < max) && (disAct <= distancia) && (!cola.isEmpty())){
				  Vertex<Persona> actual = cola.dequeue();
				  if (actual != null) {
					  if (!marcas[actual.getPosition()]) {
					    if ((jubilados.size()<40) && (actual.getData().cumple())) {
						  jubilados.add(actual.getData());
					    }
					    marcas[actual.getPosition()] = true;
					  }
					  for (Edge<Persona> arista : grafo.getEdges(actual)) {
						  cola.enqueue(arista.getTarget());
					  }
						
			    	}
				  else {
					  disAct++;
					  if (!cola.isEmpty()) {
						  cola.enqueue(null);
					}
				}
			 } // cierro while
		  } // cierro if del origen
		} // cierro if del grafo
		
		return jubilados;
	}
	
	private Vertex <Persona>buscarEmpleado(Graph<Persona> grafo, Persona empleado){
		Vertex <Persona> v = null;
		boolean encontre = false;
		Iterator<Vertex<Persona>> it = grafo.getVertices().iterator();
		while (!encontre && it.hasNext()) {
			Vertex<Persona> act = it.next();
			if (act.getData().getNombre().equals(empleado.getNombre()) 
					&& act.getData().getDomicilio().equals(empleado.getDomicilio()) 
					&& act.getData().getTipo().equals(empleado.getTipo())){
				encontre = true;
				v = act;
			}

		}
		return v;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Vertex v1 = grafo.createVertex(new Persona("Empleado", "Matias", "AAA", true));
        Vertex v2 = grafo.createVertex(new Persona("Jubilado", "Julian", "BBB", false));
        Vertex v3 = grafo.createVertex(new Persona("Jubilado", "Francisco", "CCC", false));
        Vertex v4 = grafo.createVertex(new Persona("Empleado", "Valentin", "DDD", true));
        Vertex v5 = grafo.createVertex(new Persona("Jubilado", "Omar", "EEE", true));
        Vertex v6 = grafo.createVertex(new Persona("Empleado", "Rosana", "FFF", true));
        Vertex v7 = grafo.createVertex(new Persona("Jubilado", "Maria", "GGG", false));
        Vertex v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", "HHH", true));
        Vertex v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", "III", false));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        
        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);
        
        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
        
        QuedateEnCasa banco = new QuedateEnCasa();
        
        
        System.out.println(banco.ayudaJubilados(grafo, new Persona("Empleado", "Matias", "AAA", true), 5));
     
        
        
    }

}
