package prac1Ej7;

import java.util.ArrayList;

public class EjercicioSucesion {
	
	public static void main(String[] args) {
		int i = 6;
		ArrayList<Integer> lista = listaSucesion(i);
		System.out.println("Lista: ");
		for (int x = 0; x< lista.size(); x++) {
			System.out.print(lista.get(x) + " ");
		}
	}
	
	public static ArrayList<Integer> hacerLista(ArrayList<Integer> l, int n){
		System.out.println(n);
		l.add(n);
		if ( n > 1) {
			if ((n % 2) == 0) {
				n = n/2;
				hacerLista(l,n);
			}
			else {
				n = 3*n + 1;
				hacerLista(l,n);
			}
		}
		return l;
	}
	
	public static ArrayList<Integer> listaSucesion (int n){
		ArrayList<Integer> l = new ArrayList<Integer>();
		l = hacerLista(l,n);
		return l;
	}
	

}
