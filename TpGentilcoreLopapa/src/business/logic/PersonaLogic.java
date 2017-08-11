package business.logic;

import java.util.ArrayList;

import business.entities.Persona;
import data.DataPersona;

public class PersonaLogic {
	private DataPersona dataPer;
	private ArrayList<Persona> pers;
	
	public PersonaLogic(){
		dataPer = new DataPersona();
		pers = new ArrayList<Persona>();
	}
	
	public void add(Persona p) throws Exception{
		dataPer.add(p);
	}
	
	public Persona getByDni(Persona p) throws Exception{
		return this.dataPer.getByDni(p);
	}
		
	public Persona getByDni(String dni) throws Exception{
		Persona p = new Persona();
		p.setDni(dni);
		return getByDni(p);
	}
	
	public void update(Persona p) throws Exception{
		dataPer.update(p);
	}
	
	public void delete(Persona p) throws Exception{
		dataPer.delete(p);
	}
	
	public ArrayList<Persona> getAll() throws Exception{
		return dataPer.getAll();

	}
	
	public Persona getLoggedUser(String usuario,String pass)throws Exception{
		return dataPer.getLoggedUser(usuario, pass);
	}

	}	


