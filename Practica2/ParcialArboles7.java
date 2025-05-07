package Practica2;

public class ParcialArboles7 {
	BinaryTree<Integer> arbol;

	public ParcialArboles7(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
    
	private static int unicoHijo(BinaryTree<Integer> ab) {
		int aux = 0;
		if (ab == null)
			aux = 0;
		else {
         if ((ab.hasLeftChild() && !ab.hasRightChild()) | (!ab.hasLeftChild() && ab.hasRightChild())) {
			aux = 1 + unicoHijo(ab.getLeftChild()) + unicoHijo(ab.getRightChild());
		}
	   }
	 return aux;
	}
	
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> ab, int num) {
		if (ab == null)
			return null;
		else {
			if (ab.getData() == num)
				return ab;
			else {
				BinaryTree<Integer> res = null;
				if (ab.hasLeftChild())
					res= buscar(ab.getLeftChild(),num);
				if (res == null)
					if (ab.hasRightChild())
						res= buscar(ab.getRightChild(),num);
				return res;
			}
		}
	}	
			
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> nodo = buscar(this.getArbol(),num);
		boolean aux = false;
		if (nodo == null)
			aux = false;
	    else {
		   int hi = unicoHijo(nodo.getLeftChild());
		   int hd = unicoHijo(nodo.getRightChild());
		   if (hi < hd)
			   aux = true;
	    }
		return aux;
	}
	
}
