package data;

import java.util.ArrayList;
import java.security.KeyStore.ProtectionParameter;
import java.sql.*;

import business.entities.*;
import tools.AppDataException;


public class DataPersona{
	
	public ArrayList<Persona> getAll() throws SQLException,AppDataException{
		Statement stmt = null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		DataCategoria dc = new DataCategoria();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			
			rs = stmt.executeQuery("select * from persona"); 	
					if(rs!=null){
						while(rs.next()){
							Persona p= new Persona();
							p.setId(rs.getInt("id_persona"));
							p.setNombre(rs.getString("nombre"));
							p.setApellido(rs.getString("apellido"));
							p.setDni(rs.getString("dni"));
							p.setUsuario(rs.getString("usuario"));		
							p.setContrasenia(rs.getString("contrasenia"));	//NO DEBER�A SER ALGUN METODO DE CONTRASE�AS?							
							p.setEmail(rs.getString("email"));
							p.setHabilitado(rs.getBoolean("habilitado"));
							int idCat= rs.getInt("id_categoria");
							p.setCategoria(dc.getOne(idCat));
							pers.add(p);
						}
					}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al recuperar todas las personas");
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
		}		
		return pers;
	}
	

	public void update(Persona p) throws SQLException,AppDataException{
	PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"update persona set dni=?, nombre=?, apellido=?, usuario=?, contrasenia=?, email=?, habilitado=? , id_categoria=?"+
					" where dni=?");
			
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setString(4, p.getUsuario());
			stmt.setString(5, p.getContrasenia());
			stmt.setString(6, p.getEmail());	
			stmt.setBoolean(7, p.isHabilitado());
			stmt.setInt(8, p.getCategoria().getId());
			stmt.setString(9, p.getDni());
			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException sqlex) {
				throw new AppDataException(sqlex, "Error al cerrar conexion de update, statement");
			} 
		}	
	}

	
	public void delete(Persona p) throws SQLException,AppDataException{
		PreparedStatement stmt = null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from persona where dni=?");
			stmt.setString(1,p.getDni());
			stmt.execute();
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
		}
	}
	
	
	public Persona getByDni(Persona per) throws Exception{
		Persona p = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DataCategoria dc = new DataCategoria();
		try {
			pstmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from persona where dni=?");
			pstmt.setString(1, per.getDni());
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				p= new Persona();
				p.setId(rs.getInt("id_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
				p.setUsuario(rs.getString("usuario"));		
				p.setContrasenia(rs.getString("contrasenia"));	//NO DEBERIA SER ALGUN METODO DE CONTRASEnia?							
				p.setEmail(rs.getString("email"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				int idCat= rs.getInt("id_categoria");
				p.setCategoria(dc.getOne(idCat));
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al buscar una persona");
		}
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
		}
		return p;
	}	
	
	
	public void add(Persona p)throws SQLException,AppDataException{
		PreparedStatement pstmt = null;
		ResultSet keyResultSet = null;
		try {
			pstmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into persona(dni, nombre, apellido, usuario, contrasenia, email, habilitado, id_categoria) values(?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			pstmt.setString(1, p.getDni());
			pstmt.setString(2, p.getNombre());
			pstmt.setString(3, p.getApellido());
			pstmt.setString(4, p.getUsuario());
			pstmt.setString(5, p.getContrasenia());
			pstmt.setString(6, p.getEmail());			
			pstmt.setBoolean(7, p.isHabilitado());
			pstmt.setInt(8, p.getCategoria().getId());
			pstmt.executeUpdate();
			keyResultSet = pstmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId(keyResultSet.getInt(1));				
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex,"Error al agregar persona");
		}
		try {
			if(keyResultSet!=null) keyResultSet.close();
			if(pstmt!=null) pstmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
		}
	}
	
}