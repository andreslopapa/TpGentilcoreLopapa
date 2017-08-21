package business.logic;
import java.util.ArrayList;

import business.entities.Elemento;
import business.entities.TipoDeElemento;
import data.DataElemento;
import data.DataTipoDeElemento;

public class CtrlElementoLogic {
	private DataElemento dataElem;
	private DataTipoDeElemento dataTipoElem;
		
	public CtrlElementoLogic(){
		dataElem = new DataElemento();		
		dataTipoElem = new DataTipoDeElemento();
	}
	
	public ArrayList<Elemento> getAll()throws Exception{
		return dataElem.getAll();
	}
	
	public ArrayList<Elemento> getSome(int indice,int cantidad)throws Exception{
		return dataElem.getSome(indice, cantidad);
	}
	
	public int getCantidad()throws Exception{
		return dataElem.getCantidad();
	}
	
	public void add(Elemento e) throws Exception{
		dataElem.add(e);
	}

	public Elemento getOne(Elemento e) throws Exception{
		return this.dataElem.getOne(e);
	}
	
	public Elemento getOne(int id_elem) throws Exception{
		Elemento e = new Elemento();
		e.setId_elemento(id_elem);
		return getOne(e);
	}
	
	public void update(Elemento e) throws Exception{
		dataElem.update(e);
	}
	
	public void delete(Elemento e) throws Exception{
		dataElem.delete(e);
	}
	
	public ArrayList<TipoDeElemento> getTipoDeElemento() throws Exception{
		return dataTipoElem.getAll();
	}
	
}