package Practica3;

import java.util.LinkedList;
import java.util.List;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> a) {
		if (a == null && a.isLeaf()) {
			return 0;
	    }
		else {
		  double max = 0;
		  double aux;
		  int cant = 0;
		  int total = 0;
		  Queue<GeneralTree<AreaEmpresa>> cola = new Queue();
		  cola.enqueue(a);
		  cola.enqueue(null);
		  GeneralTree<AreaEmpresa> ag;
		  while (!cola.isEmpty()) {
			  ag = cola.dequeue();
			  if (ag!= null) {
				   cant++;
				   total+= a.getData().getTardanza();
				   List<GeneralTree<AreaEmpresa>> children = a.getChildren();
				   for (GeneralTree<AreaEmpresa> child : children) {
					   cola.enqueue(child);
				   }
			  }
		     else {
		    	 if (!cola.isEmpty()) {
		    		 cola.enqueue(null); 
		         }
		    	 aux = (double) total/cant;
		    	 cant = 0;
				 total = 0;
		    	 if (aux > max)
		    		 max = aux;
		     }
		  }
		return max;
	  }
	}
	
	

}
