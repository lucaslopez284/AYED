package prac1Ej5;

public class CalcularValores {
	
	static String res;
	
	public static Valores calcular (int [] arreglo) {
		int max = 0; int min = 999;
		int suma = 0; int cant = 0;
		
		for (int i = 0; i < arreglo.length;i++) {
			suma= suma + arreglo[i];
			cant++;
			if (arreglo [i] < min) {
				min= arreglo [i];
			}
			if (arreglo[i]> max) {
				max= arreglo[i];
			}
			
		}
		
		double prom = (double) suma/cant;
		
		Valores obj = new Valores();
		obj.setMax(max);
		obj.setMin(min);
		obj.setProm(prom);
		
		return obj;
		
		
	}
	
	public static void metodo2 (int [] arreglo, Valores v) {
		int max = 0; int min = 999;
		int suma = 0; int cant = 0;
		
		for (int i = 0; i < arreglo.length;i++) {
			suma= suma + arreglo[i];
			cant++;
			if (arreglo [i] < min) {
				min= arreglo [i];
			}
			if (arreglo[i]> max) {
				max= arreglo[i];
			}
			
		}
		
		double prom = (double) suma/cant;
		
		
		v.setMax(max);
		v.setMin(min);
		v.setProm(prom);
		
	}
	
	public static void metodo3 (int [] arreglo) {
		int max = 0; int min = 999;
		int suma = 0; int cant = 0;
		
		for (int i = 0; i < arreglo.length;i++) {
			suma= suma + arreglo[i];
			cant++;
			if (arreglo [i] < min) {
				min= arreglo [i];
			}
			if (arreglo[i]> max) {
				max= arreglo[i];
			}
			
		}
		
		double prom = (double) suma/cant;
		setRes("Promedio " + prom + ", maximo " + max + ", minimo " + min);
		
		
		
		
	}


	public static void setRes(String res) {
		CalcularValores.res = res;
	}

	
	

}
