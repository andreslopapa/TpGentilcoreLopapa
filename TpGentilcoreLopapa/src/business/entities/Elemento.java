package business.entities;

public class Elemento {
	
	public Elemento(int id, String nombre, int id_elemento) {
		this.id = id;
		this.nombre = nombre;
		this.id_elemento = id_elemento;
	}
	
	
	public Elemento(){}
	
	
	
	private int id;
	private String nombre; //este es opcional
	private int id_elemento;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId_elemento() {
		return id_elemento;
	}
	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}
	
	
}