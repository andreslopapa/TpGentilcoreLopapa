package business.logic;
import java.util.ArrayList;

import business.entities.Elemento;
import business.entities.Persona;
import data.DataElemento;

public class ElementoLogic {
	private DataElemento dataElem;
	
	
	public ElementoLogic(){
		dataElem = new DataElemento();			
	}
	
	public void add(Elemento e) throws Exception{
		dataElem.add(e);
	}

	public Elemento getByOne(Elemento e) throws Exception{
		return this.dataElem.getByOne(e);
	}
		
/*	public Persona getByDni(String dni) throws Exception{
		Persona p = new Persona();
		p.setDni(dni);
		return getByDni(p);
	}*/
	
	public void update(Elemento e) throws Exception{
		dataElem.update(e);
	}
	
	public void delete(Elemento e) throws Exception{
		dataElem.delete(e);
	}
	
	/*
	 * public ArrayList<Persona> getAll() throws Exception{
		return dataElem.getAll();
	}*/
	
}


