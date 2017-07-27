package data;
import java.util.ArrayList;
import java.sql.*;

import business.entities.*;


public class DataCategoria {

	public ArrayList<Categoria> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		
		ArrayList<Categoria> categorias=new ArrayList<Categoria>();
		try{
			stmt=FactoryConexion.getInstancia().getConn().createStatement();
			rs=stmt.executeQuery("select* from categoria;");
			if(rs!=null){
				while(rs.next()){
					Categoria cat=new Categoria();
					cat.setId(rs.getInt("id"));
					cat.setDescripcion(rs.getString("descripcion"));
					categorias.add(cat);
				}
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
			}
		
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return categorias;
	}
	
	
	/*public void add(Categoria cat){
		PreparedStatement
	}*/
	
	
	
	
	
}
