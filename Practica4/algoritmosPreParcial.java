package Practica4;

public class algoritmosPreParcial {
	
	
	
	public static void metodo (int n) {
		int i= n;
		int j = 1;
		while (i>= 1) {
			while (j < n) {
				for (int k = i; k < 20; k++) {
					System.out.println(k*i*j);
				}
				j = j * 2;
			}
			i = i - 5;
		}
	}
	
	
	public static void suma (int n, int sum) {
    
	for (int i = 1; i < n + 100; ++i) {
		for (int j = 0; j < i * n ; j+= 10) {
			sum = sum + j;
		}
	 }
	}
	
	
	public static void fun (int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n ; j+= i) {
				// some 0(1) task
			}
		}
	}
	
	

}
