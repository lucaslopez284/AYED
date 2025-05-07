package Practica3;
import java.util.*;

public class parcialArboles10 {
	
	private static void metodoAuxiliar(GeneralTree<Integer> a, List<Integer> l , List<Integer> aux , Maximo max, int nivel , int result) {
		boolean agregue = false;
		if (a.getData() == 1) {
			aux.add(a.getData());
			agregue = true;
			result += nivel;
		}
		if (a.isLeaf()) {
			if (result > max.getMax()) {
				max.setMax(result);
				l.clear();
				l.addAll(aux);
			}
		}
		else {
			nivel++;
			for (GeneralTree<Integer> hijo: a.getChildren()) {
				metodoAuxiliar(hijo,l,aux,max,nivel,result);
			}
		}
		if (agregue) {
			aux.remove(aux.size()-1);
		}
	}
	
	public static List<Integer> resolver(GeneralTree<Integer> a){
		List<Integer> l = new LinkedList<Integer>();
		if (a != null && !a.isEmpty()) {
			Maximo max = new Maximo(-1);
			List<Integer> aux = new LinkedList<Integer>();
			metodoAuxiliar(a,l,aux, max,0,0);
			System.out.println("La suma total del camino de la lista es " + max.getMax());
		}
		return l;
	}
	
	
	public static void main(String[] args){
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(1, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(subA);
        subChildren2.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(0, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(0, subChildren3);
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(subB);
        GeneralTree<Integer> subC = new GeneralTree<Integer>(0, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(1));
        subChildren5.add(subC);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subChildren5);
        
        List<GeneralTree<Integer>> subChildren6 = new LinkedList<GeneralTree<Integer>>();
        subChildren6.add(new GeneralTree<Integer>(0));
        subChildren6.add(new GeneralTree<Integer>(0));
        GeneralTree<Integer> subD = new GeneralTree<Integer>(0, subChildren6);
        List<GeneralTree<Integer>> subChildren7 = new LinkedList<GeneralTree<Integer>>();
        subChildren7.add(subD);
        GeneralTree<Integer> subE = new GeneralTree<Integer>(0, subChildren7);
        List<GeneralTree<Integer>> subChildren8 = new LinkedList<GeneralTree<Integer>>();
        subChildren8.add(subE);
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subChildren8);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(1, arbol);
        
        System.out.println(resolver(a));
        
    }
}
