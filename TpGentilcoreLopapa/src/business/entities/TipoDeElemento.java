package business.entities;

import java.util.Date;

public class TipoDeElemento {
	private int id_tipodeelemento;
	private String nombre;
	private int cant_max_res_pen; 
	private int limite_horas_res; //es el limite de tiempo de la reseva en horas
	private int dias_max_anticipacion;//es la cantidad maxima de dias de anticipacion			
	
	
	public int getId() {
		return id_tipodeelemento;
	}
	public void setId(int id) {
		this.id_tipodeelemento = id;
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

	public TipoDeElemento(int id, String nombre, int cant_max_res_pen, int limite_horas_res,
			int dias_max_anticipacion) {
		this.id_tipodeelemento = id;
		this.nombre = nombre;
		this.cant_max_res_pen = cant_max_res_pen;
		this.limite_horas_res = limite_horas_res;
		this.dias_max_anticipacion = dias_max_anticipacion;
	}

	public TipoDeElemento(){
	}
	
	@Override
	public String toString() {
		return id_tipodeelemento + "-" + nombre;
		//id_tipodeelemento + " - " + dias_max_anticipacion + " d�as " + limite_horas_res + "hs -" +
	}
	
	@Override
	public boolean equals(Object o){
		return (o instanceof TipoDeElemento && ((TipoDeElemento)o).getId()==this.getId());
	}
	
	@Override
	public int hashCode(){
		return ((Integer) this.getId()).hashCode();
	}
}