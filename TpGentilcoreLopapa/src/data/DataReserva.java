package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import business.entities.Persona;
import business.entities.Reserva;
import tools.AppDataException;

public class DataReserva {
	
	
	
	public void add(Reserva r)throws SQLException,AppDataException{
		PreparedStatement pstmt = null;
		ResultSet keyResultSet = null;
		try {
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "insert into reserva("
						+ " id_persona, "
						+ " id_elemento, "
					//	+ " fecha_hora_reserva_hecha,"
						+ " fecha_hora_desde_solicitada,"
						+ " fecha_hora_hasta_solicitada, "
					//	+ " fecha_hora_entregado, "				//este solo se usa para cuando el administrador, o quien sea, registre que se devolvió
						+ " detalle) "
					+ "values( ?,?,?,?,?); "
						,PreparedStatement.RETURN_GENERATED_KEYS);
		
			pstmt.setInt(1,r.getPersona().getId());
			pstmt.setInt(2, r.getElemento().getId_elemento());
		//	pstmt.setDate(3, (java.sql.Date)r.getFecha_hora_reserva_hecha());
	
					//el tipo cuando quiera ingresar una nueva reserva, se va a crear un nuevo registro en la BD y por lo tanto un nuevo timestamp de ese momento.
					
					// de todos modos me parece que no la vamos a necesitar a esta. xq yo la habia pensado para restar con el dato del tiempo que tiene TipoDeElemento
					//O sea, "fecha_hora_reserva_hecha" se va a actualizar cuando se CREA la reserva. (o sea que ya paso todas las validaciones)
					//pero la diferencia de tiempo que tenemos que hacer es una validacion que se hace antes que se crea la reserva.
					//si vos la pensaste para usarla en otro momento la dejamos
			
			pstmt.setString(3, String.valueOf( r.getFecha_hora_desde_solicitada()));
			pstmt.setString(4, String.valueOf( r.getFecha_hora_hasta_solicitada()));
		//	pstmt.setDate(5, (java.sql.Date)r.getFecha_hora_entregado());     //este solo se usa para cuando el administrador, o quien sea, registre que se devolvió
			pstmt.setString(5,r.getDetalle());
			pstmt.executeUpdate();							//execute= ejecuta todo      /executequery solo consultas select   /executeupdate solo add update o delete
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
	

	public void updateParaCerrarRes(Reserva r)throws SQLException,AppDataException{
		PreparedStatement pstmt=null;
		try{
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ " update reserva "
					+ " set fecha_hora_entregado=? "
					+ " where id_reserva=? and id_persona=? ");
			
			pstmt.setString(1, String.valueOf(r.getFecha_hora_entregado()));	
			pstmt.setInt(2, r.getId_reserva());
			pstmt.setInt(3, r.getPersona().getId());
		
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
					+ "select * from reserva where id_reserva=?;");
			pstmt.setInt(1, r.getId_reserva());
			rs=pstmt.executeQuery();
			if(rs.next() && rs!=null){
				reserva=new Reserva();
				reserva.setId_reserva(rs.getInt("id_reserva"));
				reserva.setPersona(new DataPersona().getOne(rs.getInt("id_persona")));
				reserva.setElemento(new DataElemento().getOne(rs.getInt("id_elemento")));
				reserva.setFecha_hora_reserva_hecha(rs.getDate("fecha_hora_reserva_hecha"));
				reserva.setFecha_hora_desde_solicitada(rs.getDate("fecha_hora_desde_solicitada"));
				reserva.setFecha_hora_hasta_solicitada(rs.getDate("fecha_hora_hasta_solicitada"));
				reserva.setFecha_hora_entregado(rs.getDate("fecha_hora_entregado"));
				reserva.setDetalle(rs.getString("detalle"));
			}
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al buscar una reserva");
		}
		finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(rs!=null){rs.close();}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw new AppDataException(sqlex,"Error al intentar cerrar conexion,ResultSet o PreparedStatement");
			}
		}
		return reserva;
	}
	


	public ArrayList<Reserva> getPendientes(Persona p) throws SQLException,AppDataException{
		PreparedStatement stmt = null;
		ResultSet rs=null;
		ArrayList<Reserva> res= new ArrayList<Reserva>();
		DataElemento de = new DataElemento();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(""
						+ "select * "
						+ " from reserva "
						+ " where fecha_hora_entregado is null 	"
						+ "		and id_persona=?"
						+ "		and datediff(fecha_hora_desde_solicitada,now()) > 0 ");
			
			stmt.setInt(1, p.getId());
			rs = stmt.executeQuery(); 	
					if(rs!=null){
						while(rs.next()){
							Reserva r= new Reserva();
							r.setPersona(p);
							r.setId_reserva(rs.getInt("id_reserva"));
							int idEle= rs.getInt("id_elemento");
							r.setElemento(de.getOne(idEle));
							r.setFecha_hora_desde_solicitada(rs.getDate("fecha_hora_desde_solicitada"));
							r.setFecha_hora_hasta_solicitada(rs.getDate("fecha_hora_hasta_solicitada"));
							r.setFecha_hora_entregado(rs.getDate("fecha_hora_entregado"));
							r.setDetalle(rs.getString("detalle"));
				
							res.add(r);
						}
					}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al recuperar todas las reservas");
		}
		    finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException sqlex) {
				throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement");
			}
		}
		return res;
	}
	

}
