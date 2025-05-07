package Practica2;

public class ParcialArboles9 {
	
	private BinaryTree<dobleInfo> recorrido (BinaryTree<Integer> arbol, Integer s, Integer p){
		if (arbol == null)
			return null;
		else {
			Integer suma = arbol.getData() + s;
			Integer dif = arbol.getData() - p;
			dobleInfo data = new dobleInfo(suma,dif);
			BinaryTree<dobleInfo> aux = new BinaryTree<dobleInfo>(data);
			if (arbol.hasLeftChild()) {
				aux.addLeftChild(recorrido(arbol.getLeftChild(), suma, arbol.getData()));
			}
			
			if (arbol.hasRightChild()) {
				aux.addRightChild(recorrido(arbol.getRightChild(),suma,arbol.getData()));
			}
			
			return aux;
		}
		
	}
	
	
	public BinaryTree<dobleInfo> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<dobleInfo> a = recorrido (arbol,0,0);
		return a;
	}
	
	public static void main(String[] args) {
        System.out.println("Test Ejercicio9");
        ParcialArboles9 parcialArb = new ParcialArboles9();
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(20);
        ab.addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(10));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.addRightChild(new BinaryTree<Integer>(30));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(50));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(-9));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
        
        ab.imprimirEnNiveles();;
        System.out.println();
        System.out.println("Nuevo arbol:");
        parcialArb.sumAndDif(ab).imprimirEnNiveles();
    }

}
