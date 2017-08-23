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

			pstmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into reserva(id_persona, id_elemento, fecha_hora_desde_solicitada,fecha_hora_hasta_solicitada,detalle) values(?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
		
			pstmt.setInt(1,r.getId_persona().getId());
			pstmt.setInt(2, r.getId_elemento().getId_elemento());
			pstmt.setDate(3, (Date) r.getFecha_hora_desde_solicitada());
			pstmt.setDate(4, (Date) r.getFecha_hora_hasta_solicitada());
			pstmt.executeUpdate();		//execute no??
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
