package prac1Ej7;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String direccion;
	private int comision;
	private String email;
	
	
	public Estudiante(String nombre, String apellido, String direccion, int comision, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.comision = comision;
		this.email = email;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getComision() {
		return comision;
	}


	public void setComision(int comision) {
		this.comision = comision;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	public String tusDatos() {
		return "Estudiante:" + this.getNombre() + " " 
	          + this.getApellido() + ", direccion: " + this.getDireccion() + ", comision: "
				+ this.getComision() + ", email: " + this.getEmail();
	}
	
	
	
	

}
