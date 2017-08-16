package business.entities;

import java.util.Date;

public class Reserva {

	private int id_persona;
	private int id_elemento;
	private Date fecha_hora_desde;
	private Date fecha_hora_hasta;
	private String detalle;
	
	
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public int getId_elemento() {
		return id_elemento;
	}
	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}
	public Date getFecha_hora_desde() {
		return fecha_hora_desde;
	}
	public void setFecha_hora_desde(Date fecha_hora_desde) {
		this.fecha_hora_desde = fecha_hora_desde;
	}
	public Date getFecha_hora_hasta() {
		return fecha_hora_hasta;
	}
	public void setFecha_hora_hasta(Date fecha_hora_hasta) {
		this.fecha_hora_hasta = fecha_hora_hasta;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
	public Reserva(int id_persona, int id_elemento, Date fecha_hora, String detalle) {
		this.id_persona = id_persona;
		this.id_elemento = id_elemento;
		this.fecha_hora_desde = fecha_hora;
		this.detalle = detalle;
	}
	
	public Reserva(){
		
	}
		
}
