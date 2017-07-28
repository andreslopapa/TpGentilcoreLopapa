package data;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

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
					cat.setId(rs.getInt("id_categoria"));
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
	
	
	public void add(Categoria cat){
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
		catch(SQLException ex){
			ex.printStackTrace();
		}
		try{
			if(keyResulset!=null)keyResulset.close();
			if(pstmt!=null)pstmt.close();
			FactoryConexion.getInstancia().releaseConn();}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	
	
	
	
}
