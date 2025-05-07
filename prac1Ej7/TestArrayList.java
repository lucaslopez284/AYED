package prac1Ej7;

import java.util.ArrayList;


public class TestArrayList {
	public static void main(String[] args) {
		metodoD();
	/*	ArrayList lista = new ArrayList();
		Scanner input = new Scanner(System.in); // Create a Scanner object
	    System.out.println("Ingrese el primer numero");
	    int num1 = input.nextInt();
	    System.out.println("Ingrese el segundo numero");
	    int num2 = input.nextInt();
	    System.out.println("Ingrese el tercer numero");
	    int num3 = input.nextInt();
	    lista.add(num1);
	    lista.add(num2);
	    lista.add(num3);
	    for (int i = 0; i < 3; i++)
	    	System.out.println(lista.get(i)); */
	}
	
	public static void metodoD () {
	   ArrayList <Estudiante>l2 = new ArrayList<Estudiante>();
	   Estudiante e1 = new Estudiante ("Lucas", "Lopez","28 y 4", 1,"lopez@gmail");
	   Estudiante e2 = new Estudiante ("Catalina", "Petroni","quirno",3, "amor@gmail");
	   Estudiante e3 = new Estudiante ("Malena", "Bello","La Plata", 2,"bahia@gmail");
	   l2.add(e1);
	   l2.add(e2);
	   l2.add(e3);
	   ArrayList <Estudiante>l3 = new ArrayList<Estudiante>();
	   l3 = l2;
	   System.out.println("Lista de estudiantes: ");
	   for (int i = 0; i < 3; i++)
	    	System.out.println(l2.get(i).tusDatos());
	   Estudiante es = null;
	   System.out.println("Copia de lista de estudiantes: ");
	   for (int i = 0; i < 3; i++) {
		    es = l3.get(i);
	    	System.out.println(es.tusDatos());
	   }
	   
	   l3.get(1).setComision(28);
	   
	   System.out.println("----------------Ahora de nuevo ---------------- ");
	   
	   System.out.println("Lista de estudiantes: ");
	   for (int i = 0; i < 3; i++)
	    	System.out.println(l2.get(i).tusDatos()); 
	   System.out.println("Copia de lista de estudiantes: ");
	   for (int j = 0; j < 3; j++) {
		   System.out.println(l3.get(j).tusDatos());
	   }
	   
	   Estudiante e4 = new Estudiante ("Lautaro", "Guzman","Ranelagh", 3,"Arse@gmail");
	   agregarEstudiante(l2,e4);
	   
	   
	}
	
	public static void agregarEstudiante (ArrayList <Estudiante> lis, Estudiante e ) {
		boolean esta = false; int i = 0;
		while ( (i < lis.size()) && (esta = false)){
			if ((lis.get(i).getNombre() == e.getNombre()) &&(lis.get(i).getApellido() == e.getApellido()))
				esta = true;
			i++;
		}
	   if (esta != true)
		   lis.add(e);
	   
	   System.out.println("Lista de estudiantes: ");
	   for (int j = 0; j < lis.size(); j++)
	    	System.out.println(lis.get(j).tusDatos()); 
	
	}
}
