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
							p.setUsuario(rs.getString("usuario"));		
							p.setContrasenia(rs.getString("contrasenia"));	//NO DEBERÍA SER ALGUN METODO DE CONTRASEÑAS?							
							p.setEmail(rs.getString("email"));
							p.setHabilitado(rs.getBoolean("habilitado"));
							p.setCategoria(rs.getInt("categoria"));
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
		Persona p = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, apellido, dni, usuario, contrasenia, email , habilitado from persona where dni=?");
			stmt.setString(1, p.getDni());
			rs = stmt.executeQuery();
			if(rs!=)
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	*/


	
	
	
	public void add(Persona p){
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into persona(dni, nombre, apellido, usuario, contrasenia, email, habilitado, id_categoria) value(?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setString(4, p.getUsuario());
			stmt.setString(5, p.getContrasenia());
			stmt.setString(6, p.getEmail());			
			stmt.setBoolean(7, p.isHabilitado());
			stmt.setInt(8, p.getCategoria().getId());
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
