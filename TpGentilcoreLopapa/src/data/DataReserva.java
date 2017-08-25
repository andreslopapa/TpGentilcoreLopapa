package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.entities.Persona;
import business.entities.Reserva;
import tools.AppDataException;

public class DataReserva {
	
	public void add(Reserva r)throws SQLException,AppDataException{
		PreparedStatement pstmt = null;
		ResultSet keyResultSet = null;
		try {

//INSERT
//insert into reserva(id_persona, id_elemento, fecha_hora_desde_solicitada,fecha_hora_hasta_solicitada,detalle) values(2,3,20170820,20170824,'Se entregó con raya superior');
//en realidad se utilizan estos campos, pero algunos se actualizan solos
// id_reserva, id_persona, id_elemento, fecha_hora_reserva_hecha, fecha_hora_desde_solicitada, fecha_hora_hasta_solicitada, fecha_hora_entregado, detalle

//			pstmt = FactoryConexion.getInstancia().getConn().prepareStatement(
//					"insert into reserva(id_persona, id_elemento, fecha_hora_desde_solicitada,fecha_hora_hasta_solicitada,detalle) values(?,?,?,?)",
//					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "insert into reserva(id_persona, id_elemento,fecha_hora_reserva_hecha,"
					+ " fecha_hora_desde_solicitada,fecha_hora_hasta_solicitada,"
					+ "fecha_hora_entregado,detalle) values(?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
		
			pstmt.setInt(1,r.getPersona().getId());
			pstmt.setInt(2, r.getElemento().getId_elemento());
			pstmt.setDate(3, (Date)r.getFecha_hora_reserva_hecha());
			//Por ahi el tipo borro una reserva y quiere volver a ingresarla, no va a poder 
			//ingresar cuando se hizo si se actualiza solo
			//no se si vamos a hacerlo pero asi funcioan de cualquier forma
			pstmt.setDate(4, (Date) r.getFecha_hora_desde_solicitada());
			pstmt.setDate(5, (Date) r.getFecha_hora_hasta_solicitada());
			pstmt.setDate(6, (Date)r.getFecha_hora_entregado());//si agrega una reserva borrada 
			pstmt.setString(7,r.getDetalle());
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
	
	public Reserva getOne(Reserva r)throws SQLException,AppDataException{
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
	
	
	
	
	
	//INSERT
//insert into reserva(id_persona, id_elemento, fecha_hora_desde_solicitada,fecha_hora_hasta_solicitada,detalle) values(2,3,20170820,20170824,'Se entregó con raya superior');

	
	
/*posible query //// con FORMATO*/
/*
select  per.apellido, 
		per.nombre,
		Concat(per.apellido, N', ',per.nombre) as 'Nombre y Apellido',
		res.id_elemento, 
        DATE_FORMAT(fecha_hora_reserva_hecha,'%d/%m/%Y a las %H:%i') as 'Fecha y hora de fin de reserva',        
		DATE_FORMAT(fecha_hora_desde_solicitada,'%d/%m/%Y a las %H:%i') as 'Fecha y hora de inicio de reserva', 
		DATE_FORMAT(fecha_hora_hasta_solicitada,'%d/%m/%Y a las %H:%i') as 'Fecha y hora de fin de reserva', 
		fecha_hora_entregado			//esta será null por defecto, posible validador para cuando no se finalizo la reserva, por lo tanto no tiene fecha de fin
        res.detalle,
        elem.nombre
from reserva res
	inner join persona per on per.id_persona = res.id_persona
    inner join elemento elem on elem.id_elemento=res.id_elemento;    
*/
	
	
	
	
}
