package Practica3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	
	// EJERCICIOS 2 B
	
	private void numerosImparesMayoresQuePreOrdenRec (GeneralTree <T> a, Integer n, List<T> l) {
		if ((a.getData()% 2 == 1) && (a.getData() > n))
			l.add(a.getData());
		if (a.hasChildren()) {
	      for (GeneralTree <T> hijo: a.getChildren())
	      	numerosImparesMayoresQuePreOrdenRec(hijo,n,l);
		}
	}
	
	
	
	public List<Integer> numerosImparesMayoresQuePreOrden (Integer n){
		
		List<T> l = new LinkedList<T>();
		if (this!= null && !this.isEmpty()) numerosImparesMayoresQuePreOrdenRec(this,n,l);
	    return l;
	}
	
	
	private void numerosImparesMayoresQuePostOrdenRec (GeneralTree <T> a, Integer n, List<T> l) {
		if (a.hasChildren()) {
		  for (GeneralTree <T> hijo: a.getChildren())
	    	  numerosImparesMayoresQuePostOrdenRec(hijo,n,l);
		}
		if ((a.getData()%2 == 1) && (a.getData() > n))
			l.add(a.getData());
	}

	
	public List<Integer> numerosImparesMayoresQuePostOrden ( Integer n){
		List<T> result = new LinkedList<T>();
		if (this!= null && !this.isEmpty()) numerosImparesMayoresQuePostOrdenRec(this,n,result);
		return result;
	}
	
	
	private void numerosImparesMayoresQueInOrdenRec (GeneralTree <T> a, Integer n, List<T> l) {
		if (a.hasChildren())
			numerosImparesMayoresQueInOrdenRec(a.getChildren().get(0),n,l);
		if ((a.getData()% 2 == 1) && (a.getData() > n))
			l.add(a.getData());
		if (a.hasChildren() && a.getChildren().size()>1) {
	      for (int i = 1; i< a.getChildren().size()-1; i++)
	      	numerosImparesMayoresQuePreOrdenRec(a.getChildren().get(i),n,l);
		}
	}
	
	
	
	
	public List<Integer> numerosImparesMayoresQueInOrden (Integer n){
		List<Integer> result = new LinkedList<Integer>();
		if (this!= null && !this.isEmpty()) numerosImparesMayoresQueInOrdenRec(this,n,result);
		return result;
	}
	
	
	
	
	public List<T> numerosImparesMayoresQuePorNiveles(Integer n){
		List<T> result = new LinkedList<T>();
		Queue<GeneralTree<T>> cola = new Queue();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			GeneralTree<T> ab = cola.dequeue();
			if (ab!= null) {
				if (ab.getData() > n && (ab.getData()%2 == 1)) {
					result.add(ab.getData());
				}
				if (ab.hasChildren()) {
					List<GeneralTree<T>> children = ab.getChildren();
					for (GeneralTree<T> child: children) {
						cola.enqueue(child);
					}
				}
				
			}
			else if (!cola.isEmpty()) {
				cola.enqueue(null);
			}
		}
		return result;
	}


	// EJERCICIOS 3
   public int altura() {
	   Queue<GeneralTree<T>> cola = new Queue();
	   int act = 0;
	   cola.enqueue(this);
	   cola.enqueue(null);
	   GeneralTree<T> ab;
	   while (!cola.isEmpty()) {
		   ab = cola.dequeue();
		   if (ab != null) {
			   if (ab.hasChildren()) {
				   List <GeneralTree<T>> children = ab.getChildren();
				   for (GeneralTree<T> child : children ) {
					   cola.enqueue(child);
				   }
			   }
		   }    
		   else { 
			   if (!cola.isEmpty()) {
				   cola.enqueue(null);
				   act++;
			   }
		   }
	   }	   
	   return act;
   }
	

	public int nivel(T dato){
		int n = 999;
		Queue<GeneralTree<T>> cola = new Queue();
		cola.enqueue(this);
		cola.enqueue(null);
		GeneralTree<T> ab;
		int actual = 0;
		while (n == 999 && !cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab!= null) {
				if (ab.getData().equals(dato))
					n = actual;
				if (n == 999) {
					List<GeneralTree<T>> children = ab.getChildren();
				    for (GeneralTree<T> child: children) {
					cola.enqueue(child);
				  }
				}
			}
			else if (!cola.isEmpty() && n == 999) {
				  actual++;
				  cola.enqueue(null);	
			   } 
			}  
		return n;
	  }


	public int ancho(){
		int max = 0;
		int cant = 0;
		List<T> result = new LinkedList<T>();
		Queue<GeneralTree<T>> cola = new Queue();
		GeneralTree<T> ab;
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab != null) {
				cant++;
		        if (ab.hasChildren()) {
				  List<GeneralTree<T>> children = ab.getChildren();
				  for (GeneralTree<T> child: children) {
					cola.enqueue(child);
				}
			  }
			}
			else  {
				if (cant > max)
					max = cant;
				cant = 0;
				if (!cola.isEmpty())
					cola.enqueue(null);
			}
		}
		return cant;	
	}
	
	///// EJERCICIO 5 ///////
    
	/*Se dice que un nodo n es ancestro de un nodo m si existe un camino desde n a m. Implemente un
	método en la clase GeneralTree con la siguiente firma: */
	
	// public boolean esAncestro(T a, T b): devuelve true si el valor “a” es ancestro del valor “b”.
	
	private GeneralTree<Integer> buscoNodo(GeneralTree<Integer> ag, Integer a) {
		GeneralTree<Integer> arbol = null;
		if (ag.getData().equals(a)) {
			arbol = ag;
		}
		else {
			if (ag.hasChildren()) {
				List <GeneralTree<Integer>> hijos = ag.getChildren();
				Iterator<GeneralTree<Integer>> iterador = hijos.iterator(); 
				while (arbol == null && iterador.hasNext()) {
					arbol = buscoNodo (iterador.next(),a);
				}
			}
		}
		return arbol;
	}
	
	
	private boolean estaHijo(GeneralTree<Integer> ag, Integer b){
		boolean esta = false;
		GeneralTree<Integer> arbol = null;
		if (ag.hasChildren()) {
			List <GeneralTree<Integer>> hijos = ag.getChildren();
			Iterator<GeneralTree<Integer>> iterador = hijos.iterator(); 
			while (esta == false && iterador.hasNext()) {
				arbol = buscoNodo (iterador.next(),b);
				if (arbol!= null) {
					esta = true;
				}
			}
		} 
		return esta;
	}

	
	public boolean esAncestro(Integer a, Integer b) {
		boolean encontre = false;
		GeneralTree<Integer> arbolA = null;
		if (this!= null && !this.isEmpty()) {
			arbolA = buscoNodo(this,a);
		}
		if (arbolA!= null && !arbolA.isEmpty()) {
			encontre = estaHijo(arbolA,b);
		}
		return encontre;
	}
	
} 