package business.entities;

public class Persona {
	private int id;
	private String dni;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contrasenia;
	private String email;
	private boolean habilitado; //true or false
	private int id_categoria; //prom. direct     1-encargado 2-admin 3-usuario
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public String getContrasenia() {
		return contrasenia;	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCategoria() {
		return id_categoria; 	}
	public void setCategoria(int categoria) {
		this.id_categoria = categoria;  }	
	
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Persona(){
		
	}
	
	public Persona(int id,String apellido, String nombre, String dni, String usuario, String contrasenia,String email, int categoria,boolean habilitado){
		this(apellido,nombre,dni,usuario,contrasenia,email,categoria,habilitado);
		this.setApellido(apellido);	
	}
	
	public Persona(String apellido, String nombre, String dni, String usuario, String contrasenia,String email, int categoria,boolean habilitado){
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setDni(dni);
		this.setUsuario(usuario);
		this.setContrasenia(contrasenia);
		this.setEmail(email);
		this.setCategoria(categoria);
		this.setHabilitado(habilitado);}
	
	@Override
	public boolean equals(Object p){
		return(p instanceof Persona) && (((Persona)p).getDni().equals(this.getDni()));
				}
}