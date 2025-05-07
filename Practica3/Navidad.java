package Practica3;
import java.util.*;

/* Retomando el ejercicio abeto navideño visto en teoría, cree una clase Navidad que cuenta con una
variable de instancia GeneralTree que representa al abeto (ya creado) e implemente el método con la
firma: public String esAbetoNavidenio() */

public class Navidad {
	GeneralTree<Integer> ag;

	 public Navidad(GeneralTree<Integer> ag) {
		super();
		this.ag = ag;
	}


	public GeneralTree<Integer> getAg() {
		return ag;
	}


	public void setAg(GeneralTree<Integer> ag) {
		this.ag = ag;
	}

	
	
	private static boolean esAbetoRec(GeneralTree<Integer> ag) {
		boolean aux = false;
		if (ag.isLeaf()) {
			aux = true;
		}
		else {
			if (ag.getChildren().size()> 2){
			  aux = true;
			}
			System.out.println("Hijos: " + ag.getChildren().size());
			Iterator <GeneralTree<Integer>> iterador = ag.getChildren().iterator();
			while (aux == true && iterador.hasNext()) {
				aux = esAbetoRec(iterador.next());
			}
		}
		return aux;
	} 
	
	public String esAbetoNavidenio() {
		 String respuesta ="no";
		 if (this.getAg()!= null && !this.getAg().isEmpty()) {
			 boolean aux = esAbetoRec(this.getAg());
			 if (aux) {
				 respuesta = "si";
			 }
		 }
		 return respuesta;
	 }
	
	
    public static void main(String[] args) {
        
        
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        subChildren1.add(new GeneralTree<Integer>(83));
        subChildren1.add(new GeneralTree<Integer>(12));
        subChildren1.add(new GeneralTree<Integer>(33));
        
     
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, subChildren1); 
        Navidad n = new Navidad(a);
        
        System.out.println("Es abeto: " + n.esAbetoNavidenio());
        
	}

}
