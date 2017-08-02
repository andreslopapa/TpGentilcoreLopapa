package data;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

import java.sql.*;

import business.entities.*;
import tools.*;

public class DataCategoria {

	public ArrayList<Categoria> getAll()throws SQLException,AppDataException{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Categoria> categorias=new ArrayList<Categoria>();
		try{
			stmt=FactoryConexion.getInstancia().getConn().createStatement();
			rs=stmt.executeQuery("select id_categoria,descripcion from categoria;");
			if(rs!=null){
				while(rs.next()){
					Categoria cat=new Categoria();
					cat.setId(rs.getInt("id_categoria"));
					cat.setDescripcion(rs.getString("descripcion"));
					categorias.add(cat);
				}
			}
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al traer todas las categorias de la base de datos");
			}		
		finally{
				try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					FactoryConexion.getInstancia().releaseConn();
					}
				catch(SQLException sqlex){
					throw new AppDataException(sqlex,"Error al cerrar conexion, resultset o statement");
					}
			
		}
		
	
		return categorias;
	}
	//wacho nunca vas a buscar una categoria con el objeto entero,o con el id o con la descripcion
	//lo mismo para cualquier otro objeto
	
	public Categoria getOne(Categoria cat)throws SQLException,AppDataException{
		Categoria c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_categoria, descripcion from categoria where id_categoria=?");
			stmt.setInt(1,cat.getId());
			rs= stmt.executeQuery();
			if(rs != null && rs.next()){
				c = new Categoria();
				c.setId(rs.getInt("id_categoria"));
				c.setDescripcion(rs.getString("descripcion"));
				
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		
		finally{
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return c;
	}

	//SI EL PARAMETRO ES ENTERO
	public Categoria getOne(int idcat)throws SQLException,AppDataException{
		Categoria c = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from categoria where id_categoria=?");
			pstmt.setInt(1,idcat);
			rs= pstmt.executeQuery();
			if(rs != null && rs.next()){
				c = new Categoria();
				c.setId(rs.getInt("id_categoria"));
				c.setDescripcion(rs.getString("descripcion"));
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al buscar una categoria por id");
		}		
		finally{
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
		} }
		return c;		//RETURN CATEGORIA O UN ENTERO DE LA CATEGORIA??->Retornas la categoria papa,siempre un objeto
	}
	
	
	public void add(Categoria cat)throws SQLException,AppDataException{
		PreparedStatement pstmt=null;
		ResultSet keyResulset=null;
		try{
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into categoria(descripcion) values(?);",PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,cat.getDescripcion());
			pstmt.executeUpdate();
			keyResulset=pstmt.getGeneratedKeys();					
			if(keyResulset!=null && keyResulset.next()==true){
				cat.setId(keyResulset.getInt(1));
			}
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al agregar categoria");
		}
		try{
			if(keyResulset!=null)keyResulset.close();
			if(pstmt!=null)pstmt.close();
			FactoryConexion.getInstancia().releaseConn();}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
		}
	}
}