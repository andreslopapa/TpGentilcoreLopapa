package business.logic;
import java.util.ArrayList;

import business.entities.Elemento;
import business.entities.Persona;
import data.DataElemento;

public class CtrlElementoLogic {
	private DataElemento dataElem;
	
	
	public CtrlElementoLogic(){
		dataElem = new DataElemento();			
	}
	
	public ArrayList<Elemento> getAll()throws Exception{
		return dataElem.getAll();
	}
	
	public ArrayList<Elemento> getSome(int indice,int cantidad)throws Exception{
		return dataElem.getSome(indice, cantidad);
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
	

}


