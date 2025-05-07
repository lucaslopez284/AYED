package prac1Ej3;

import prac1Ej3.Estudiante;

public class Test {
	
	public static void main(String[] args) {
		Estudiante a1 [] = new Estudiante [2];
		Profesor a2 [] = new Profesor [3];
		a1 [0] = new Estudiante ("Lucas", "Lopez","28 y 4", 1,"lopez@gmail");
		a1 [1] = new Estudiante ("Catalina", "Petroni","quirno",3, "amor@gmail");
		for (int i = 0; i< 2; i++) {
			System.out.println(a1[i].tusDatos());
		}
		
		a2 [0] = new Profesor ("Laura", "Di Giusti","CADP","Informatica","cadp@gmail");
		a2 [1] = new Profesor ("Nacho", "Sabatini","AFC","Humanidades","gelp@gmail");
		a2 [2] = new Profesor ("Gonza", "Villarreal","Taller","Informatica","java@gmail");
		for (int i = 0; i< 3; i++) {
			System.out.println(a2[i].tusDatos());
		}
	}

}
