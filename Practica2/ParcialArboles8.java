package Practica2;

public class ParcialArboles8 {
	
	
	private boolean sonIguales (BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean aux = true;
		if (arbol1.getData() != arbol2.getData());
		  aux = false;
		  
		return aux;
	}
	
	private boolean recorrido (BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean aux = true;
		if (!arbol1.getData().equals(arbol2.getData()))
		  aux = false;
		if (aux == true) {
			if (arbol1.hasLeftChild()) {
				if (!arbol2.hasLeftChild()) return false;
				aux = recorrido (arbol1.getLeftChild(),arbol2.getLeftChild());
			}
			if ((aux == true) && (arbol1.hasRightChild())) {
				if (!arbol2.hasRightChild()) return false;
				aux = recorrido(arbol1.getRightChild(), arbol2.getRightChild());
			}
		}		
		return aux;
	}
  
	
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		 boolean aux = true;
		 if (arbol1 == null) {
			 if (arbol2 == null)
				 aux = true;
			 else 
				 aux = false;
		 }
		 else aux = recorrido (arbol1,arbol2);
		 return aux;
	 }
	 
	 
}
