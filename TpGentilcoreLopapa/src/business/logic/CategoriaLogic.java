package business.logic;

import java.util.ArrayList;
import business.entities.Categoria;
import data.DataCategoria;

public class CategoriaLogic {
	private DataCategoria dataCat;
	private ArrayList<Categoria> cats;
	
	public CategoriaLogic(){
		dataCat = new DataCategoria();
		cats = new ArrayList<Categoria>();
	}
	
	public void add(Categoria c) throws Exception{
		dataCat.add(c);
	}
	
	public Categoria getOne(Categoria c) throws Exception{
		return this.dataCat.getOne(c);
	}

	
	public Categoria getOne(int idCat) throws Exception{
		Categoria c = new Categoria();
		c.setId(idCat);
		return getOne(c);
	}
}
