package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import business.entities.TipoDeElemento;
import tools.AppDataException;

public class DataTipoDeElemento {


	public TipoDeElemento getOne(TipoDeElemento tde_p)throws SQLException,AppDataException{
		TipoDeElemento te = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_tipodeelemento, nombre, cantmaxrespen, limite_horas_res, dias_max_anticipacion "
					+ "where id_tipodeelemento=?");
			stmt.setInt(1,tde_p.getId());
			rs= stmt.executeQuery();
			if(rs != null && rs.next()){
				te = new TipoDeElemento();
				te.setId(rs.getInt("id_tipodeelemento"));
				te.setNombre(rs.getString("nombre"));
				te.setCant_max_res_pen(rs.getInt("cantmaxrespen"));
				te.setLimite_horas_res(rs.getInt("limite_horas_res"));
				te.setDias_max_anticipacion(rs.getInt("dias_max_anticipacion"));
				
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
		return te;
	}
	
	
	

	public TipoDeElemento getOne(int tde_p)throws SQLException,AppDataException{
		TipoDeElemento te = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_tipodeelemento, nombre, cantmaxrespen, limite_horas_res, dias_max_anticipacion "
					+ "where id_tipodeelemento=?");
			stmt.setInt(1,tde_p);
			rs= stmt.executeQuery();
			if(rs != null && rs.next()){
				te = new TipoDeElemento();
				te.setId(rs.getInt("id_tipodeelemento"));
				te.setNombre(rs.getString("nombre"));
				te.setCant_max_res_pen(rs.getInt("cantmaxrespen"));
				te.setLimite_horas_res(rs.getInt("limite_horas_res"));
				te.setDias_max_anticipacion(rs.getInt("dias_max_anticipacion"));
				
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
		return te;
	}
	
	
	public ArrayList<TipoDeElemento> getAll()throws SQLException,AppDataException{
		ArrayList<TipoDeElemento> elementos=null;
		Statement stmt=null;
		ResultSet res=null;
		try{
			stmt=(Statement) FactoryConexion.getInstancia().getConn().createStatement();
			res=stmt.executeQuery("select* from elemento;");
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al recuperar todos los elementos");
		}
		finally{
			
		}
		return elementos;
	}
}
