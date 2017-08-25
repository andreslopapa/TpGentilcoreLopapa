package business.entities;

import java.util.Date;

public class Reserva {

	private int id_reserva;
	private Persona id_persona;
	private Elemento id_elemento;
	private Date fecha_hora_reserva_hecha;
	private Date fecha_hora_desde_solicitada;
	private Date fecha_hora_hasta_solicitada;   
	private Date fecha_hora_entregado;
	private String detalle;
	/*campos en base de datos: id_reserva, id_persona, id_elemento, fecha_hora_reserva_hecha, fecha_hora_desde_solicitada, fecha_hora_hasta_solicitada, fecha_hora_entregado, detalle
*/
	
	public Reserva(){
	}
		
	public Reserva(int id_reserva, Persona id_persona, Elemento id_elemento, Date fecha_hora_reserva_hecha,
			Date fecha_hora_desde_solicitada, Date fecha_hora_hasta_solicitada, Date fecha_hora_entregado,
			String detalle) {
		super();
		this.id_reserva = id_reserva;
		this.id_persona = id_persona;
		this.id_elemento = id_elemento;
		this.fecha_hora_reserva_hecha = fecha_hora_reserva_hecha;
		this.fecha_hora_desde_solicitada = fecha_hora_desde_solicitada;
		this.fecha_hora_hasta_solicitada = fecha_hora_hasta_solicitada;
		this.fecha_hora_entregado = fecha_hora_entregado;
		this.detalle = detalle;
	}

	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}


	public Persona getId_persona() {
		return id_persona;
	}
	public void setId_persona(Persona id_persona) {
		this.id_persona = id_persona;
	}

	public Elemento getId_elemento() {
		return id_elemento;
	}
	public void setId_elemento(Elemento id_elemento) {
		this.id_elemento = id_elemento;
	}

	public Date getFecha_hora_reserva_hecha() {
		return fecha_hora_reserva_hecha;
	}
	public void setFecha_hora_reserva_hecha(Date fecha_hora_reserva_hecha) {
		this.fecha_hora_reserva_hecha = fecha_hora_reserva_hecha;
	}

	public Date getFecha_hora_desde_solicitada() {
		return fecha_hora_desde_solicitada;
	}
	public void setFecha_hora_desde_solicitada(Date fecha_hora_desde_solicitada) {
		this.fecha_hora_desde_solicitada = fecha_hora_desde_solicitada;
	}

	public Date getFecha_hora_hasta_solicitada() {
		return fecha_hora_hasta_solicitada;
	}
	public void setFecha_hora_hasta_solicitada(Date fecha_hora_hasta_solicitada) {
		this.fecha_hora_hasta_solicitada = fecha_hora_hasta_solicitada;
	}

	public Date getFecha_hora_entregado() {
		return fecha_hora_entregado;
	}
	public void setFecha_hora_entregado(Date fecha_hora_entregado) {
		this.fecha_hora_entregado = fecha_hora_entregado;
	}

	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
		
}