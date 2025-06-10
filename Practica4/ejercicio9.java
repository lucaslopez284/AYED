package Practica4;

public class ejercicio9 {
	
	public static int rec2(int n){
		System.out.println(n);
		if (n <= 1)
			return 1;
		else
		    return (2 * rec2(n-1));
	}
	
    public static int rec1(int n){
    	System.out.println(n);
		if (n <= 1)
			return 1;
		else
		    return (rec1(n-1) + rec1(n-1));
	}
    
    public static int rec3(int n){
		if ( n == 0 )
			return 0;
		else {
		  if ( n == 1 )
			  return 1;
		  else
			  return (rec3(n-2) * rec3(n-2));
		}
	}
     
	public static int potencia_iter(int x, int n){
		int potencia;
		if (n == 0)
			potencia = 1;
		else {
		  if (n == 1)
			  potencia = x;
		  else{
			  potencia = x;
		      for (int i = 2 ; i <= n ; i++) {
		         potencia *= x ;
		    }
		  }
		}
		return potencia;
	}
	
	
	public static int potencia_rec( int x, int n){
		System.out.println(n);
		if( n == 0 )
			return 1;
		else{
			if( n == 1)
				return x;
		    else{
		    	if ( (n % 2 ) == 0)
		    		return potencia_rec (x * x, n / 2 );
		        else 
		        	return potencia_rec (x * x, n / 2) * x;
		    }
		 }
	}
	
	public static void main(String[] args) {
		System.out.println("Rec1");
		int x = rec1(5);
		System.out.println("Rec2");
		int y = rec2(5);
		
		System.out.println("Potencia Rec");
		int j = potencia_rec(5, 8);
	}

}
