package business.entities;

import java.util.Date;

public class Reserva {

	private int id_reserva;
	private int id_persona;
	private int id_elemento;
	private Date fecha_hora_reserva_hecha;
	private Date fecha_hora_desde_solicitada;
	private Date fecha_hora_hasta_solicitada;   
	private Date fecha_hora_entregado;
	private String detalle;
	/*campos en base de datos: id_reserva, id_persona, id_elemento, fecha_hora_reserva_hecha, fecha_hora_desde_solicitada, fecha_hora_hasta_solicitada, fecha_hora_entregado, detalle
*/
	
	public int getId_persona() {
		return id_persona;
	}
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Date getFecha_hora_reserva_hecha() {
		return fecha_hora_reserva_hecha;
	}
	public void setFecha_hora_reserva_hecha(Date fecha_hora_reserva_hecha) {
		this.fecha_hora_reserva_hecha = fecha_hora_reserva_hecha;
	}
	public Date getFecha_hora_entregado() {
		return fecha_hora_entregado;
	}
	public void setFecha_hora_entregado(Date fecha_hora_entregado) {
		this.fecha_hora_entregado = fecha_hora_entregado;
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
		return fecha_hora_desde_solicitada;
	}
	public void setFecha_hora_desde(Date fecha_hora_desde) {
		this.fecha_hora_desde_solicitada = fecha_hora_desde;
	}
	public Date getFecha_hora_hasta() {
		return fecha_hora_hasta_solicitada;
	}
	public void setFecha_hora_hasta(Date fecha_hora_hasta) {
		this.fecha_hora_hasta_solicitada = fecha_hora_hasta;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
	
	
	public Reserva(int id_reserva, int id_persona, int id_elemento, Date fecha_hora_reserva_hecha,
			Date fecha_hora_desde_solicitada, Date fecha_hora_hasta_solicitada, Date fecha_hora_entregado,
			String detalle) {
		//this.id_reserva = id_reserva;
		this.id_persona = id_persona;
		this.id_elemento = id_elemento;
		this.fecha_hora_reserva_hecha = fecha_hora_reserva_hecha;
		this.fecha_hora_desde_solicitada = fecha_hora_desde_solicitada;
		this.fecha_hora_hasta_solicitada = fecha_hora_hasta_solicitada;
		this.fecha_hora_entregado = fecha_hora_entregado;
		this.detalle = detalle;
	}
	
	public Reserva(){
	}
		
}
