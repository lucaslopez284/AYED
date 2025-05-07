package Practica3;

import java.util.*;

/* Sea una red de agua potable, la cual comienza en un caño maestro y la misma se va dividiendo
sucesivamente hasta llegar a cada una de las casas.
Por el caño maestro ingresan “x” cantidad de litros y en la medida que el caño se divide, de acuerdo
con las bifurcaciones que pueda tener, el caudal se divide en partes iguales en cada una de ellas. Es
decir, si un caño maestro recibe 1000 litros y tiene por ejemplo 4 bifurcaciones se divide en 4 partes
iguales, donde cada división tendrá un caudal de 250 litros.
Luego, si una de esas divisiones se vuelve a dividir, por ej. en 5 partes, cada una tendrá un caudal de
50 litros y así sucesivamente hasta llegar a un lugar sin bifurcaciones.
Se debe implementar una clase RedDeAguaPotable que contenga el método con la siguiente firma:
public double minimoCaudal(double caudal)
que calcule el caudal de cada nodo y determine cuál es el caudal mínimo que recibe una casa. Asuma
que la estructura de caños de la red está representada por una variable de instancia de la clase
RedAguaPotable y que es un GeneralTree<Character>.
*/

public class RedDeAguaPotable {
	
	public GeneralTree<Character> ab;
	
	public RedDeAguaPotable(GeneralTree<Character> ab) {
		super();
		this.ab = ab;
	}
	public GeneralTree<Character> getAb() {
		return ab;
	}
	public void setAb(GeneralTree<Character> ab) {
		this.ab = ab;
	}
	
	private static double caudalRecursivo(GeneralTree<Character> ag, double caudal) {
		double min = 9999;
		if (ag.isLeaf()) {
			min = caudal;
		}
		else {
			List<GeneralTree<Character>> hijos = ag.getChildren();
			caudal = caudal / hijos.size();
			Iterator<GeneralTree<Character>> iterador = hijos.iterator(); 
			while (iterador.hasNext()) {
				min = Math.min(min, (caudalRecursivo(iterador.next(),caudal)));
			}     
		}
		return min;
	} 
	
	
	public double minimoCaudal(double caudal) {
		double minimo = caudal;
		if (this.getAb() != null && !this.getAb().isEmpty()) {
			minimo = this.caudalRecursivo(this.getAb(), caudal);
		}
		return minimo;
	}
	
	public static void main (String[] args) {
        GeneralTree<Character> ab1 = new GeneralTree<Character>('B');
        
        List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
        subChildren1.add(new GeneralTree<Character>('L'));
        GeneralTree<Character> subAb1 = new GeneralTree<Character>('G', subChildren1);
        List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
        subChildren2.add(new GeneralTree<Character>('F'));
        subChildren2.add(subAb1);
        GeneralTree<Character> ab2 = new GeneralTree<Character>('C', subChildren2);
        
        List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
        subChildren3.add(new GeneralTree<Character>('M'));
        subChildren3.add(new GeneralTree<Character>('N'));
        GeneralTree<Character> subAb2 = new GeneralTree<Character>('J', subChildren3);
        List<GeneralTree<Character>> subChildren4 = new LinkedList<GeneralTree<Character>>();
        subChildren4.add(new GeneralTree<Character>('H'));
        subChildren4.add(new GeneralTree<Character>('I'));
        subChildren4.add(subAb2);
        subChildren4.add(new GeneralTree<Character>('K'));
        subChildren4.add(new GeneralTree<Character>('P'));
        GeneralTree<Character> ab3 = new GeneralTree<Character>('D', subChildren4);
        
        GeneralTree<Character> ab4 = new GeneralTree<Character>('E');
        
        List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
        arbol.add(ab1);
        arbol.add(ab2);
        arbol.add(ab3);
        arbol.add(ab4);
        GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
        
        RedDeAguaPotable red = new RedDeAguaPotable(ab);
        System.out.println("Caudal minimo que recibe una casa: " + red.minimoCaudal(1000.0));
    }
	  
}
