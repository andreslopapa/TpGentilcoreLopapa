package business.entities;

import java.util.Date;

public class TipoElemento {
	
	
	public TipoElemento(int id, String nombre, int cant_max_res_pen, int limite_horas_res,
			int dias_max_anticipacion) {
		this.id = id;
		this.nombre = nombre;
		this.cant_max_res_pen = cant_max_res_pen;
		this.limite_horas_res = limite_horas_res;
		this.dias_max_anticipacion = dias_max_anticipacion;
	}

	public TipoElemento(){
		
	}

	private int id;
	private String nombre;
	private int cant_max_res_pen; 
	private int limite_horas_res; //es el limite de tiempo de la reseva en horas
	private int dias_max_anticipacion;//cantidad maxima de dias de anticipacion			
	
	
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
	public int getCant_max_res_pen() {
		return cant_max_res_pen;
	}
	public void setCant_max_res_pen(int cant_max_res_pen) {
		this.cant_max_res_pen = cant_max_res_pen;
	}
	public int getLimite_horas_res() {
		return limite_horas_res;
	}
	public void setLimite_horas_res(int limite_horas_res) {
		this.limite_horas_res = limite_horas_res;
	}
	public int getDias_max_anticipacion() {
		return dias_max_anticipacion;
	}
	public void setDias_max_anticipacion(int dias_max_anticipacion) {
		this.dias_max_anticipacion = dias_max_anticipacion;
	}

	

	
}
