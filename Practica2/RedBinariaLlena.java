package Practica2;

public class RedBinariaLlena {
  BinaryTree <Integer> data;
  
  

public RedBinariaLlena(BinaryTree<Integer> data) {
	super();
	this.data = data;
}

public BinaryTree<Integer> getData() {
	return data;
}

public void setData(BinaryTree<Integer> data) {
	this.data = data;
}
  
  public int retardoEnvio(BinaryTree<Integer> ab) {
	  int result = 0;
	  if (ab.getData() == null){
		  result = 0;
	  }
	  else {
		  result = ab.getData();
		  if ((ab.hasRightChild()) && (ab.hasLeftChild())) {
			  if (ab.getRightChild().getData() >= ab.getLeftChild().getData()) {
				  result += this.retardoEnvio(ab.getRightChild());
			  }
			  else
				  result += this.retardoEnvio(ab.getLeftChild());
		  }
	  }
	  
	  
	  return result;
  }
  
  public static void main (String[] args) {
      System.out.println("Test retardo");
      BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
      ab.addLeftChild(new BinaryTree<Integer>(2));
      ab.addRightChild(new BinaryTree<Integer>(6));
      ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
      ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
      ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
      ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
      
      RedBinariaLlena red = new RedBinariaLlena(ab);
      System.out.println(red.retardoEnvio(ab));
      
  }
}
