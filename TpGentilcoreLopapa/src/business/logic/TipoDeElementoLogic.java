package business.logic;

import java.util.ArrayList;

import business.entities.Persona;
import business.entities.TipoDeElemento;
import data.DataTipoDeElemento;

public class TipoDeElementoLogic {
	private DataTipoDeElemento dataTdE;
	private ArrayList<DataTipoDeElemento> tdes; 
	
	
	public TipoDeElemento getOne(int id_elemento)throws Exception{
		TipoDeElemento tde = new TipoDeElemento();
		tde.setId(id_elemento);
		return getOne(tde);
	}
	
	public TipoDeElemento getOne(TipoDeElemento tde) throws Exception{
		return this.dataTdE.getOne(tde);
	}
	
	
	public ArrayList<DataTipoDeElemento> getAll() throws Exception{
		return dataTdE.getAll();
	}	
	

}
