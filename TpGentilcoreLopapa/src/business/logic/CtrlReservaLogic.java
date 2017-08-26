package business.logic;

import java.sql.SQLException;

import business.entities.Persona;
import business.entities.Reserva;
import data.DataElemento;
import data.DataPersona;
import data.DataReserva;
import tools.AppDataException;

public class CtrlReservaLogic {
	private DataReserva datRes;
	private DataPersona datPer;
	private DataElemento datElem;
	
	
	public CtrlReservaLogic(){
		
		datRes = new DataReserva();
		datPer = new DataPersona();
		datElem = new DataElemento();
		
	}
	
	
	public void add(Reserva r) throws SQLException, AppDataException{
		/*Reserva res = new Reserva();
		try {
			//res=datRes.getOne(r);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//res.get*/
		datRes.add(r);
	}

	public void update(Reserva r) throws SQLException, AppDataException{
		datRes.update(r);
	}

	public void delete(Reserva r) throws SQLException, AppDataException{
		datRes.delete(r);
	}
	
	public Reserva getOne(Reserva r)throws Exception{
		return datRes.getOne(r);
	}	
	
	

	

	
	
}

