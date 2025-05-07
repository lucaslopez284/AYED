package Practica2;

public class ProfundidadDeArbolBinario {
	BinaryTree <Integer> data;
	
	

	public ProfundidadDeArbolBinario(BinaryTree<Integer> data) {
		super();
		this.data = data;
	}

	public BinaryTree<Integer> getData() {
		return data;
	}

	public void setData(BinaryTree<Integer> data) {
		this.data = data;
	}
	
	private int suma(int n, BinaryTree<Integer> ab, int actual) {
		if (n == actual) {
			return ab.getData();
		}
		else {
			int aux = 0;
			if (ab.hasLeftChild()) aux += suma (n, ab.getLeftChild(),actual+1);
			if (ab.hasLeftChild()) aux += suma (n, ab.getRightChild(),actual+1);
			return aux;
		}
	}
	
	public int sumaElementosProfundidad (int n) {
		if (this.getData().isEmpty()) return 0;
		else return suma (n,this.getData(), 0);
				
	}
	
	/*public void imprimirEnNiveles (){
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
    } */
	
	public static void main (String[] args) {
        System.out.println("Test Profundidad");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(ab);
        System.out.println(prof.sumaElementosProfundidad(1));
        
    }
	
}
