package business.logic;

import java.util.ArrayList;

import business.entities.TipoDeElemento;
import data.DataTipoDeElemento;

public class CtrlTipoDeElementoLogic {
	private DataTipoDeElemento dataTdE;
	private ArrayList<DataTipoDeElemento> tdes; 
	
	public CtrlTipoDeElementoLogic(){
		this.dataTdE=new DataTipoDeElemento();
	}
	
	public TipoDeElemento getOne(int id_elemento)throws Exception{
		TipoDeElemento tde = new TipoDeElemento();
		tde.setId(id_elemento);
		return getOne(tde);
	}
	
	public TipoDeElemento getOne(TipoDeElemento tde) throws Exception{
		return this.dataTdE.getOne(tde);
	}
	
	
	public ArrayList<TipoDeElemento> getAll() throws Exception{
		return dataTdE.getAll();
	}	
	
	public void add(TipoDeElemento tde) throws Exception{
		dataTdE.add(tde);
	}	
	public void update(TipoDeElemento tde) throws Exception{
		dataTdE.update(tde);
	}
	public void delete(TipoDeElemento tde) throws Exception{
		dataTdE.delete(tde);
	}
	

	
}
