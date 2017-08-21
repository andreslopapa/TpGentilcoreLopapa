package data;

import java.util.ArrayList;
import java.sql.*;
import business.entities.Elemento;
import tools.AppDataException;

public class DataElemento {
	//id_elemento, nombre, tipo
	

	public ArrayList<Elemento> getAll() throws SQLException, AppDataException{
		Statement stmt = null;
		ResultSet rs=null;
		ArrayList<Elemento> elems= new ArrayList<Elemento>(); 
		DataTipoDeElemento dtde = new DataTipoDeElemento();	
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select* from elemento");
			if(rs!=null){
				while(rs.next()){
					Elemento el = new Elemento();
					el.setNombre(rs.getString("nombre"));
					el.setId_elemento(rs.getInt("id_elemento"));
					int idTipEl = rs.getInt("id_tipodeelemento");
					el.setTipo(dtde.getOne(idTipEl));
					elems.add(el);				
				}
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al recuperar todos los elementos");
		}
		finally{
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException sqlex) {
					throw new AppDataException(sqlex, "Error al cerrar conexion, resultset o statement (Clase: DataElemento)");
				}		
		}
		return elems;	
	}
	
	public ArrayList<Elemento> getSome(int indice,int cantTraer)throws SQLException,AppDataException{
		PreparedStatement pstmt=null;
		ResultSet res=null;
		ArrayList<Elemento> elementos=new ArrayList<Elemento>();
		try{
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement(""
					+ "select* from elemento "
					+ "limit ?,?");//usar lo del ID
			pstmt.setInt(1, indice);
			pstmt.setInt(2, cantTraer);
			res=pstmt.executeQuery();
			if(res!=null){
				while(res.next()){
					Elemento ele=new Elemento();
					ele.setId_elemento(res.getInt("id_elemento"));
					ele.setNombre(res.getString("nombre"));
					ele.setTipo(new DataTipoDeElemento().getOne(res.getInt("id_tipodeelemento")));
					elementos.add(ele);
				}
			}
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al traer un grupo de elementos");
		}
		finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(res!=null){res.close();}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw new AppDataException(sqlex,"Error al cerrar Conexion,ResultSet o PreparedStatement");
			}
		}
		return elementos;
		
	}
	
	
	public int getCantidad()throws SQLException,AppDataException{
		int cantidad=0;
		Statement stmt=null;
		ResultSet res=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().createStatement();
			res=stmt.executeQuery("select count(*) from elemento;");
			if(res!=null && res.next()){
				cantidad=res.getInt(1);
			}
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al contar elementos");
		}
		finally{
			try{
				if(stmt!=null){stmt.close();}
				if(res!=null){res.close();}
				FactoryConexion.getInstancia().releaseConn();}
			catch(SQLException sqlex){
				throw new AppDataException(sqlex,"Error al cerra Conexion,Statement o Resultset");
			}
		}
		return cantidad;
	}

	public Elemento getOne(Elemento elem) throws SQLException, AppDataException{
		Elemento e =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DataTipoDeElemento dtde = new DataTipoDeElemento();
		
		try {
			pstmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_elemento,nombre,id_tipodeelemento from elemento where id_elemento=?"
			/*//		
			 "select e.id_elemento, e.nombre_elemento, e.id_tipodeelemento"
					+ " from elemento e "
					+ " inner join tipodeelemento tde "
					+ "  on e.id_tipo=tde.id_tipodeelemento "
					+ " where e.id_elemento=? "*/
					);
			pstmt.setInt(1,elem.getId_elemento());
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				e = new Elemento();
				e.setId_elemento(rs.getInt("id_elemento"));
				e.setNombre(rs.getString("nombre"));

				//e.getTipo().setId(rs.getInt("id_tipo"));
				//e.getTipo().setNombre(rs.getString("nombre_tipo_elemento"));
				
				int idTipo = rs.getInt("id_tipodeelemento");
				e.setTipo(dtde.getOne(idTipo));
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al buscar una Elemento");
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException sqlex) {
				throw new AppDataException(sqlex, "Error al cerrar conexion en busqueda de elemento");
			}
		}
		
		return e;
	}
	
	
	public Elemento getOne(int id_elem_p) throws SQLException, AppDataException{
		Elemento e =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DataTipoDeElemento dtde = new DataTipoDeElemento();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from elemento where id_elemento=?"
			/*		"select e.id_elemento, e.nombre_elemento, e.id_tipo"
					+ " from elemento e "
					+ " inner join tipodeelemento tde "
					+ "  on e.id_tipo=tde.id_tipodeelemento "
					+ " where e.id_elemento=? "*/
					);
			stmt.setInt(1,id_elem_p);
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
				e = new Elemento();
				e.setId_elemento(rs.getInt("id_elemento"));
				e.setNombre(rs.getString("nombre"));

				//e.getTipo().setId(rs.getInt("id_tipo"));
				//e.getTipo().setNombre(rs.getString("nombre_tipo_elemento"));
				
				int idTipo = rs.getInt("id_tipodeelemento");
				e.setTipo(dtde.getOne(idTipo));
			}
		} catch (SQLException sqlex) {
			throw new AppDataException(sqlex, "Error al buscar una Elemento");
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException sqlex) {
				throw new AppDataException(sqlex, "Error al cerrar conexion en busqueda de elemento");
			}
		}
		return e;
	}
	
	public void add(Elemento ele)throws SQLException,AppDataException{
		PreparedStatement pstmt=null;
		ResultSet KeyRes=null;
		try{
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement("insert into elemento(nombre,id_tipodeelemento) values(?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, ele.getNombre());
			pstmt.setInt(2,ele.getTipo().getId());
			pstmt.executeUpdate();
			KeyRes=pstmt.getGeneratedKeys();
			if(KeyRes!=null && KeyRes.next()){
				ele.setId_elemento(KeyRes.getInt(1));
			}
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al agregar elemento");
		}
		finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(KeyRes!=null){KeyRes.close();}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw new AppDataException(sqlex,"Error al cerrar conexion, resultset o statement");
			}
			
		}
	}
	
	public void delete(Elemento ele)throws SQLException,AppDataException{
		PreparedStatement pstmt=null;
		try{
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement("delete from elemento where id_elemento=?");
			pstmt.setInt(1, ele.getId_elemento());
			pstmt.executeUpdate();
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al borrar elemento");
		}
		finally{
			try{
				if(pstmt!=null){pstmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw new AppDataException(sqlex,"Error al cerrar conexion o PreparedStatement");
			}
		}
	}
	
	public void update(Elemento ele)throws SQLException,AppDataException{
		PreparedStatement pstmt=null;
		try{
			pstmt=FactoryConexion.getInstancia().getConn().prepareStatement("update elemento set nombre=?,id_tipodeelemento=? where id_elemento=? ;");
			pstmt.setString(1, ele.getNombre());
			pstmt.setInt(2,ele.getTipo().getId());
			pstmt.setInt(3,ele.getId_elemento());
			pstmt.executeUpdate();
		}
		catch(SQLException sqlex){
			throw new AppDataException(sqlex,"Error al modificar elemento");
		}
		finally{
			try{
				if(pstmt!=null){pstmt.close();}
				FactoryConexion.getInstancia().releaseConn();
			}
			catch(SQLException sqlex){
				throw new AppDataException(sqlex,"Error al cerrar conexion o PreparedStatement");}
		}
	}
	
}
