package business.entities;

import java.util.Date;

public class Reserva {

	private int id_persona;
	private int id_elemento;
	private Date fecha_hora;
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
	public Date getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
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
		this.fecha_hora = fecha_hora;
		this.detalle = detalle;
	}
	
	public Reserva(){
		
	}
	
	
	
	
}
