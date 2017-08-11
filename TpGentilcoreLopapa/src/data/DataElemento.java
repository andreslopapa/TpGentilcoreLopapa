package data;

import java.util.ArrayList;
import java.sql.*;
import business.entities.Elemento;
import business.entities.Persona;
import tools.AppDataException;

public class DataElemento {
	//id_elemento, nombre, tipo
	
	public ArrayList<Elemento> getAll() throws SQLException, AppDataException{
		Statement stmt = null;
		ResultSet rs=null;
		ArrayList<Elemento> elems= new ArrayList<Elemento>(); 
		DataTipoDeElemento dtde = new DataTipoDeElemento();	
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select id_elemento, nombre, tipo from elemento");
			if(rs!=null){
				while(rs.next()){
					Elemento el = new Elemento();
					el.setNombre(rs.getString("nombre"));
					el.setId_elemento(rs.getInt("id_elemento"));
					int idTipEl = rs.getInt("tipo");
					el.setTipo(dtde.getOne(idTipEl));
					elems.add(el);				
				}
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al recuperar todos los elementos");
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement (Clase: DataElemento)");
		}		
		return elems;	
	}

	public Elemento getOne(Elemento elem) throws SQLException, AppDataException{
		Elemento e =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DataTipoDeElemento dtde = new DataTipoDeElemento();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_elemento, nombre, tipo from elemento where id_elemento=?");
			stmt.setInt(1,elem.getId_elemento());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
				e = new Elemento();
				e.setId_elemento(rs.getInt("id_elemento"));
				e.setNombre(rs.getString("nombre"));
				int idTipo = rs.getInt("tipo");
				e.setTipo(dtde.getOne(idTipo));
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al buscar una Elemento");
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al cerrar conexion en busqueda de elemento");
		}
		
		return e;
	}
	
	
	public Elemento getOne(int id_elem_p) throws SQLException, AppDataException{
		Elemento e =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DataTipoDeElemento dtde = new DataTipoDeElemento();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_elemento, nombre, tipo from elemento where id_elemento=?");
			stmt.setInt(1,id_elem_p);
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
				e = new Elemento();
				e.setId_elemento(rs.getInt("id_elemento"));
				e.setNombre(rs.getString("nombre"));
				int idTipo = rs.getInt("tipo");
				e.setTipo(dtde.getOne(idTipo));
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al buscar una Elemento");
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al cerrar conexion en busqueda de elemento");
		}
		
		return e;
	}
	
	
}
