package Practica2;

public class Transformacion {
	private BinaryTree <Integer> data;
	
	

	public Transformacion(BinaryTree<Integer> data) {
		super();
		this.data = data;
	}

	public BinaryTree<Integer> getData() {
		return data;
	}

	public void setData(BinaryTree<Integer> data) {
		this.data = data;
	}
	
	
	private BinaryTree<Integer> recorrer(BinaryTree<Integer> ab) {
		BinaryTree<Integer> nodo = new BinaryTree<Integer>();
		int aux = 0;
		if (ab.hasLeftChild()) {
			aux += ab.getLeftChild().getData();
			Transformacion t = new Transformacion (ab.getLeftChild());
			nodo.addLeftChild(t.suma());
		}
		if (ab.hasRightChild()) {
			aux += ab.getRightChild().getData();
			Transformacion t = new Transformacion (ab.getRightChild());
			nodo.addRightChild(t.suma());
		}
		nodo.setData(aux);
		return nodo; 
	}
	
	public BinaryTree<Integer> suma(){
		return recorrer(this.getData());
	}
	
	public static void main (String[] args) {
        System.out.println("Test Transformacion");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ab.imprimirEnNiveles();;
        BinaryTree<Integer> nuevo = new Transformacion(ab).suma();
        System.out.println();
        System.out.println("Arbol transformado");
        nuevo.imprimirEnNiveles();
    }

}
