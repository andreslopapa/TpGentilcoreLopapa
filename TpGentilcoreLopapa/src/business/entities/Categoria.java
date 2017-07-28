package business.entities;

public class Categoria {
	private int id_categoria;
	private String descripcion;

	
	public int getId() {
		return id_categoria;
	}
	public void setId(int id) {
		this.id_categoria = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Categoria(){			
	}
	
	public Categoria(int id, String descripcion) {
		this.id_categoria = id;
		this.descripcion = descripcion;   
		}
}