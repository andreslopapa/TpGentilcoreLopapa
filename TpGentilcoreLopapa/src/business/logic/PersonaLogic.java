package business.logic;

import java.util.ArrayList;

import business.entities.Persona;
import data.DataPersona;

public class PersonaLogic {
	
	private DataPersona dataPer;
	private ArrayList<Persona> pers;
	
	public PersonaLogic(){
		dataPer = new DataPersona();
		pers =new ArrayList<Persona>();
		pers.add(new Persona("Alberto","Gentilcore","373737","alberto74","151515","gentilcore.ac@hotmail.com",1,true));	//VERIFICAR CATEGORIA (1)
		pers.add(new Persona("Andres","Lopapa","383838","lopa95","161616","NoSeElCorreo@hotmail.com",2,true));	//VERIFICAR CATEGORIA (2) puse una por poner
	}
	
	public void add(Persona p){
		dataPer.add(p);
	}
/*--------------------------------------------------------------------------------------------
	public void delete(Persona p){
		dataPer.remove(p);
	}
	
	public void update(Persona p){
		dataPer.delete(p);
		dataPer.add(p);
	}*/
	
}
