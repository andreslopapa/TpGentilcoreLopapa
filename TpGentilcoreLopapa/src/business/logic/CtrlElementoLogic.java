package business.logic;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import business.entities.Elemento;
import business.entities.TipoDeElemento;
import data.DataElemento;
import data.DataTipoDeElemento;
import ui.Desktop.ListadoElementos;
import ui.Desktop.ListadoElementos.TipoBusqueda;

public class CtrlElementoLogic {
	private DataElemento dataElem;
	private DataTipoDeElemento dataTipoElem;
	public ArrayList<Elemento> elementos;	
	
	public CtrlElementoLogic(){
		dataElem = new DataElemento();		
		dataTipoElem = new DataTipoDeElemento();
		elementos=new ArrayList<Elemento>();
	}
	
	public ArrayList<Elemento> getAll()throws Exception{
		return dataElem.getAll();
	}
	
	public int getMaxId()throws Exception{
		return dataElem.getMaxId();
	}
	public ArrayList<Elemento> getSome(ListadoElementos.TipoBusqueda tipob,Elemento ele,int indice,int cantidad)throws Exception{
//		if(ele==null){return dataElem.getSome(indice, cantidad);}
//		if(ele.getNombre()!=null && ele.getTipo()!=null){
//			return dataElem.getSome(ele.getNombre(),ele.getTipo().getId(),indice, cantidad);}
//		if(ele.getNombre()!=null){return dataElem.getSome(ele.getNombre(), indice,cantidad);}
//		if(ele.getTipo()!=null){return dataElem.getSome(ele.getTipo().getId(), indice,cantidad);}
//		ArrayList<Elemento> elementos= new ArrayList<Elemento>();
//		Elemento elemento=dataElem.getOne(ele);
//		if(elemento!=null){
//			elementos.add(elemento);
//		}
//		return elementos;
		return dataElem.getSome(tipob,ele,indice,cantidad);
		
	}
	
	public int getCantidad(ListadoElementos.TipoBusqueda tipob,Elemento ele)throws Exception{
		
//		if(ele==null){return dataElem.getCantidad();}
//		if(ele.getNombre()!=null && ele.getTipo()!=null){
//			return dataElem.getCantidad(ele.getNombre(),ele.getTipo().getId());}
//		if(ele.getNombre()!=null){return dataElem.getCantidad(ele.getNombre());}
//		if(ele.getTipo()!=null){return dataElem.getCantidad(ele.getTipo().getId());}
//		return 1;
		return dataElem.getCantidad(tipob,ele);
		
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