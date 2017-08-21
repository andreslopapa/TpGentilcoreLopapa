package business.logic;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import business.entities.Elemento;
import data.DataElemento;

public class CtrlElementoLogic {
	private DataElemento dataElem;
	
	
	public CtrlElementoLogic(){
		dataElem = new DataElemento();			
	}
	
	public ArrayList<Elemento> getAll()throws Exception{
		return dataElem.getAll();
	}
	
	public ArrayList<Elemento> getSome(Elemento ele,int indice,int cantidad)throws Exception{
		if(ele==null){return dataElem.getSome(indice, cantidad);}
		if(ele.getNombre()!=null && ele.getTipo()!=null){
			return dataElem.getSome(ele.getNombre(),ele.getTipo().getId(),indice, cantidad);}
		if(ele.getNombre()!=null){return dataElem.getSome(ele.getNombre(), indice,cantidad);}
		if(ele.getTipo()!=null){return dataElem.getSome(ele.getTipo().getId(), indice,cantidad);}
		ArrayList<Elemento> elementos= new ArrayList<Elemento>();
		elementos.add(dataElem.getOne(ele));
		return elementos;
		
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
	

}


