package business.logic;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import org.joda.time.*;

import business.entities.Elemento;
import business.entities.Persona;
import business.entities.Reserva;
import business.entities.TipoDeElemento;
import data.DataElemento;
import data.DataPersona;
import data.DataReserva;
import data.DataTipoDeElemento;
import tools.AppDataException;
import ui.Desktop.ListadoElementos;
import ui.Desktop.ListadoReservas;



public class CtrlReservaLogic {
	private DataReserva datRes;
	private DataPersona datPer;
	private DataElemento datElem;
	public ArrayList<Reserva> reservas; 

	
	public CtrlReservaLogic(){

		datRes = new DataReserva();
//		datPer = new DataPersona();
//		datElem = new DataElemento();
		reservas=new ArrayList<Reserva>();
	}
	
	public ArrayList<Reserva> getSome(ListadoReservas.TipoBusqueda tipob,Reserva res,int indice,int cantidad)throws Exception{
		return datRes.getSome(tipob, res, indice, cantidad);
	}
	
	public int getCantidad(ListadoReservas.TipoBusqueda tipob,Reserva reserva)throws Exception{
		return datRes.getCantidad(tipob, reserva);
	}
	
	public void add(Reserva r) throws SQLException, AppDataException{
		/*Reserva res = new Reserva();
		try {
			res=datRes.getOne(r);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		datRes.add(r);
	}

	public Boolean isFHastaMayorQFDesde(java.util.Date fechaHoraD,java.util.Date fechaHoraH)throws Exception,ParseException{
		
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//return (formatter.parse(fechaHoraD).compareTo(formatter.parse(fechaHoraH)))<0?true:false;
		return fechaHoraD.compareTo(fechaHoraH)<0?true:false;
	}
	
	public float getDaysBetween(Date fecha1,Date fecha2){
		long diff=fecha1.getTime()-fecha2.getTime();//te da la diferencia en milisegundos
		float dias = (float)diff / (1000*60*60*24);
		return dias;
	}
	
	public float getHoursBetween(Date fecha1,Date fecha2){
		long diff=fecha1.getTime()-fecha2.getTime();
		float horas=(float)diff/(1000*60*60);
		return horas;
	}
	
	public Boolean noEsFechaPasada(Date fecha){
		return fecha.compareTo(Calendar.getInstance().getTime())<0?false:true;
	}
	
	public int getReservasEnIntervalo(int idEle,Date fechaD,Date fechaH)throws Exception{
		return datRes.getReservasEnIntervalo(idEle, fechaD, fechaH);
	}
	
	public int getMaxId()throws Exception{
		return datRes.getMaxId();
	}
	
	/*
	public void update(Reserva r) throws SQLException, AppDataException{
		datRes.update(r);
	}*/
	
	public void updateParaCerrarRes(Reserva r) throws SQLException, AppDataException{
		datRes.updateParaCerrarRes(r);
	}

	public void delete(Reserva r) throws SQLException, AppDataException{
		datRes.delete(r);
	}
	
	public Reserva getOne(Reserva r)throws Exception{
		return datRes.getOne(r);
	}	
	
	
	
}

