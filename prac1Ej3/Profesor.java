package prac1Ej3;

public class Profesor {
	private String nombre;
	private String apellido;
	private String catedra;
	private String facultad;
	private String email;
	public Profesor(String nombre, String apellido, String catedra, String facultad, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.catedra = catedra;
		this.facultad = facultad;
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
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String tusDatos() {
		return "Profesor " +  this.getNombre() + " " + this.getApellido() + 
				", catedra: " + this.getCatedra() + ", facultad: "
				+ this.getFacultad() + ", email: " + this.getEmail();
	}
	
	
	
}
