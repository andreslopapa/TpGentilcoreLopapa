package business.logic;

import java.sql.SQLException;

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
		datRes.add(r);
	}

}