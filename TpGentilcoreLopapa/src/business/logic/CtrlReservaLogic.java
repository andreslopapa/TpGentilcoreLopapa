package business.logic;

import java.sql.SQLException;
import java.util.ArrayList;

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

