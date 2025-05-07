package Practica2;

import java.util.*;



public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		BinaryTree<T> aux = null;
		if (this.hasLeftChild())
		  aux =  this.leftChild;
		return aux;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		BinaryTree<T> aux = null;
		if (this.hasRightChild())
		  aux =  this.rightChild;
		return aux;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}
	

			

	public  int contarHojas() {
	   int hd = 0;
	   int hi = 0;
	   if (this.getData()== null) {
	     return 0;
	   }
	   else if (this.isLeaf())   {
			   return 1;
		   }
	        else {
	        	if (this.hasLeftChild())
	        	     hi = this.getLeftChild().contarHojas();
	             if (this.hasRightChild())
	            	 hd = this.getRightChild().contarHojas();
	             return (hi + hd);
	        }
	}
		
		
	public BinaryTree<T> espejo() {
		   BinaryTree<T> esp = new BinaryTree<T>(this.getData()); // 1. Crea una nueva raíz con el mismo dato del nodo actual
		   if (this.isEmpty()) // 2. Si el árbol está vacío, devuelve el árbol nuevo vacío
		       return esp;
		   else {
		       if (this.hasLeftChild()) {
		           // 3. Si tiene hijo izquierdo, se invierte y se agrega como hijo derecho del espejo
		           esp.addRightChild(this.getLeftChild().espejo());
		       }
		       if (this.hasRightChild()) {
		           // 4. Si tiene hijo derecho, se invierte y se agrega como hijo izquierdo del espejo
		           esp.addLeftChild(this.getRightChild().espejo());
		       }

		       return esp; // 5. Devuelve el árbol reflejado
		   }
		}

    public void entreNiveles(int n, int m) {
        // Si el árbol está vacío o los niveles son inválidos, no hacemos nada
        if (this.isEmpty() || n < 0 || m < n) return;

        // Creamos una cola para recorrer el árbol por niveles
        Queue<BinaryTree<T>> cola = new LinkedList<>();
        cola.add(this); // arrancamos desde la raíz

        int nivelActual = 0; // llevamos cuenta del nivel actual

        // Mientras haya nodos por procesar
        while (!cola.isEmpty()) {
            int nodoNivel = cola.size(); // cantidad de nodos en este nivel

            // Si estamos dentro del rango de niveles pedido
            if (nivelActual >= n && nivelActual <= m) {
                // Procesamos todos los nodos del nivel actual
                for (int i = 0; i < nodoNivel; i++) {
                    BinaryTree<T> nodo = cola.remove();
                    System.out.print(nodo.getData() + " | "); // imprimimos el dato

                    // Agregamos los hijos a la cola para el próximo nivel
                    if (nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                    if (nodo.hasRightChild()) cola.add(nodo.getRightChild());
                }
                // Después de imprimir todos los nodos del nivel, hacemos un salto de línea
                System.out.println();
            } else {
                // Si no estamos en un nivel que nos interesa, solo agregamos los hijos
                for (int i = 0; i < nodoNivel; i++) {
                    BinaryTree<T> nodo = cola.remove();
                    if (nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                    if (nodo.hasRightChild()) cola.add(nodo.getRightChild());
                }
            }

            // Pasamos al siguiente nivel
            nivelActual++;
        }
    }
    
    
    public void imprimirEnNiveles (){
    	Queue <BinaryTree<T>> cola = new LinkedList <>();
    	cola.offer(this);
    	cola.offer(null); // marca de nivel
    	
    	while (!cola.isEmpty()) {
    		BinaryTree<T> ab = cola.poll();
    		if (ab != null) {
    			System.out.print(ab.getData() + " ");
    			if (ab.hasLeftChild()) {
    				cola.offer(ab.getLeftChild());
    			}
    			if (ab.hasRightChild()) {
    				cola.offer(ab.getRightChild());
    			}
    		}
    		else if (!cola.isEmpty()) {
    			System.out.println();
    			cola.offer(null);
    		}
    	}
    }
    
   
	
	public void enOrden() {
        if (this != null) {
            if (this.hasLeftChild()) {
                this.getLeftChild().enOrden();
            }
            System.out.print(this.data + " ");
            if (this.hasRightChild()) {
                this.getRightChild().enOrden();
            }
        }
    }
	
	public void preOrden() {
        if (this != null) {
        	System.out.print(this.data + " ");
            if (this.hasLeftChild()) {
                this.getLeftChild().preOrden();
            }
            if (this.hasRightChild()) {
                this.getRightChild().preOrden();
            }
        }
    }
	
	public void postOrden() {
        if (this != null) {
            if (this.hasLeftChild()) {
                this.getLeftChild().postOrden();
            }
            if (this.hasRightChild()) {
                this.getRightChild().postOrden();
            }
            System.out.print(this.data + " ");
        }
    }
	
	public static void main(String[] args){
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hi = new BinaryTree<Integer> (25);
		hi.addLeftChild(new BinaryTree<Integer> (10));
		hi.addRightChild(new BinaryTree<Integer> (35));
		BinaryTree<Integer> hd = new BinaryTree<Integer> (60);
		hd.addLeftChild(new BinaryTree<Integer> (50));
		hd.addRightChild(new BinaryTree<Integer> (80));
		ab.addLeftChild(hi);
		ab.addRightChild(hd);
		/*ab.enOrden();
		System.out.println();
		ab.preOrden();
		System.out.println(); 
		ab.postOrden();
		System.out.println();
		ab.imprimirEnNiveles(); */
		ContadorArbol con = new ContadorArbol (ab);
		ArrayList <Integer> l = con.numerosParesPostOrden();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
}

