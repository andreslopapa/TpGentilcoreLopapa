package data;

import java.util.ArrayList;
import java.security.KeyStore.ProtectionParameter;
import java.sql.*;

import business.entities.*;

public class DataPersona {
	
	public ArrayList<Persona> getAll(){
		Statement stmt = null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			
			rs = stmt.executeQuery("select * from persona"); 	////////VERIFICAR EL NOMBRE DE LA TABLA
					if(rs!=null){
						while(rs.next()){
							Persona p= new Persona();
							p.setId(rs.getInt("id"));
							p.setNombre(rs.getString("nombre"));
							p.setApellido(rs.getString("apellido"));
							p.setDni(rs.getString("dni"));
							p.setHabilitado(rs.getBoolean("habilitado"));
							pers.add(p);
						}
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return pers;
	}

	
	

	
	
	/*
	public Persona getByDni(){
//
//completar//////////////////////////////////////////////////////////////
//		
	}
	*/
	
	
	
	
	
	
	public void add(Persona p){
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into persona(dni, nombre, apellido, habilitado) value(?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setBoolean(4, p.isHabilitado());
			stmt.executeUpdate();
			keyResultSet = stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId(keyResultSet.getInt(1));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			if(keyResultSet!=null) keyResultSet.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
