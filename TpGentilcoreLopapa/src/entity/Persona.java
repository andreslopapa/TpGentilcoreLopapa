package entity;

public class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contrase�a;
	private int categoria; //prom. direct     1-encargado 2-admin 3-usuario
	
	public String getDni() {
		return dni; 	}
	public void setDni(String dni) {
		this.dni = dni;  }
	
	public String getNombre() {
		return nombre; 	}
	public void setNombre(String nombre) {
		this.nombre = nombre; }
	
	public String getApellido() {
		return apellido; }
	public void setApellido(String apellido) {
		this.apellido = apellido;	}
	
	public String getUsuario() {
		return usuario;  }
	public void setUsuario(String usuario) {
		this.usuario = usuario; }
	
	public String getContrase�a() {
		return contrase�a;	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;	}
	
	public int getCategoria() {
		return categoria; 	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;  }
	
	
	Persona(String apellido, String nombre, String dni, String usuario, String contrase�a, int categoria){
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setDni(dni);
		this.setUsuario(usuario);
		this.setContrase�a(contrase�a);
		this.setCategoria(categoria);}
	
	@Override
	public boolean equals(Object p){
		return(p instanceof Persona) && (((Persona)p).getDni().equals(this.getDni()));
				}
}
