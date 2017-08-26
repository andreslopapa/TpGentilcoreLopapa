package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


import business.entities.Reserva;
import tools.AppDataException;

public class DataReserva {
	
	
	
	public void add(Reserva r)throws SQLException,AppDataException{
		PreparedStatement pstmt = null;
		ResultSet keyResultSet = null;
		try {
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement(" "
					+ "insert into reserva("
					+ "id_persona, "
					+ "id_elemento, "
				//	+ "fecha_hora_reserva_hecha"
					+ " fecha_hora_desde_solicitada,"
					+ "fecha_hora_hasta_solicitada, "
					+ " fecha_hora_entregado, "
					+ "detalle) "
					+ "values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
		
			pstmt.setInt(1,r.getPersona().getId());
			pstmt.setInt(2, r.getElemento().getId_elemento());
		//	pstmt.setDate(3, (java.sql.Date)r.getFecha_hora_reserva_hecha());
						//Por ahi el tipo borro una reserva y quiere volver a ingresarla, no va a poder 
						//ingresar cuando se hizo si se actualiza solo
						//no se si vamos a hacerlo pero asi funcioan de cualquier forma
			pstmt.setDate(3, (java.sql.Date) r.getFecha_hora_desde_solicitada());
			pstmt.setDate(4, (java.sql.Date) r.getFecha_hora_hasta_solicitada());
			pstmt.setDate(6, (java.sql.Date)r.getFecha_hora_entregado());//si agrega una reserva borrada 
			pstmt.setString(5,r.getDetalle());
			pstmt.executeUpdate();		//execute no? El execute te hace cualquier cosa,el
			//executequery solo consultas select y el executeupdate solo add update o delete
			//es para q no metas la pata poner executeupdate
			keyResultSet = pstmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				r.setId_reserva(keyResultSet.getInt(1));				
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex,"Error al crear reserva");
		}
		finally{
			try {
				if(keyResultSet!=null) keyResultSet.close();
				if(pstmt!=null) pstmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException sqlex) {
				throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
			}
		}
	}
	
	
	
	
	public void delete(Reserva r)throws SQLException,AppDataException{
		PreparedStatement pstmt=null;
		try{
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "delete from reserva where id_reserva=?");
			pstmt.setInt(1,r.getId_reserva());
			pstmt.executeUpdate();
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al intentar borrar reserva");
		}
		finally{
			try{
				if(pstmt!=null){}pstmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw new AppDataException(sqlex,"Error al cerrar PreparedStatement o Conexion");
			}
		}
	}
	
	
	
	
	public void update(Reserva r)throws SQLException,AppDataException{
		PreparedStatement pstmt=null;
		try{
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "update reserva set fecha_hora_reserva_hecha=?,"
					+ "set fecha_hora_desde_solicitada=?,set fecha_hora_hasta_solicitada=?,"
					+ "set fecha_hora_entregado=?,set detalle=?");
			pstmt.executeUpdate();
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al modificar reserva");
		}
		finally{
			try{
				if(pstmt!=null){pstmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw new AppDataException(sqlex,"Error al intentar cerrar conexion o PreparedStatement");
			}
		}
	}
	
	
	
	public Reserva getOne(Reserva r)throws Exception{
		Reserva reserva=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "select* from reserva where id_reserva=?;");
			pstmt.setInt(1, r.getId_reserva());
			rs=pstmt.executeQuery();
			if(rs.next() && rs!=null){
				reserva=new Reserva();
				reserva.setId_reserva(rs.getInt("id_reserva"));
				reserva.setPersona(new DataPersona().getOne(rs.getInt("id_persona")));
				reserva.setFecha_hora_reserva_hecha(rs.getDate("fecha_hora_reserva_hecha"));
			}
		}
		catch(SQLException sqlex){}
		finally{}
		return reserva;
	}

}
