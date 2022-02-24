package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;
import models.Tipos;

public class TiposDAO extends AbstractDAO {

	/**
	 * Rellena un array con todos los tipos1 de la base de datos
	 * @return Un array relleno de los tipos
	 */
	public ArrayList<Tipos> getAllTipo1() {
		final String QUERY = "SELECT id, nombre"
				+ " FROM tipos";
		ArrayList<Tipos> tipos = new ArrayList<Tipos>();
		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	var id = rs.getInt("id");
		        	 	var nombre = rs.getString("nombre");
		        	 	Tipos t = new Tipos(id, nombre);
		        	 	tipos.add(t);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
				return tipos;
	}

	/**
	 * Busca un tipo de los tipos1 en la base de datos por medio de su id
	 * @param idTipos El id del tipo a buscar
	 * @return El tipo1 buscado
	 */
	public Tipos getTipo1(int idTipos) {
		final String QUERY = "SELECT id, nombre"
				+ " FROM tipos WHERE id = " + idTipos;
		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	var id = rs.getInt("id");
		        	 	var nombre = rs.getString("nombre");
		        	 	Tipos t = new Tipos(id, nombre);
		        	 	return t;
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
				return null;
	}
	
	/**
	 * Rellena un array con todos los tipos2 de la base de datos
	 * @return Un array relleno de los tipos
	 */
	public ArrayList<Tipos> getAllTipo2() {
		final String QUERY = "SELECT id, nombre"
				+ " FROM tipos2";
		ArrayList<Tipos> tipos = new ArrayList<Tipos>();
		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	var id = rs.getInt("id");
		        	 	var nombre = rs.getString("nombre");
		        	 	Tipos t = new Tipos(id, nombre);
		        	 	tipos.add(t);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
				return tipos;
	}

	/**
	 * Busca un tipo de los tipos2 en la base de datos por medio de su id
	 * @param idTipos El id del tipo a buscar
	 * @return El tipo2 buscado
	 */
	public Tipos getTipo2(int idTipos) {
		final String QUERY = "SELECT id, nombre"
				+ " FROM tipos2 WHERE id = " + idTipos;
		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	var id = rs.getInt("id");
		        	 	var nombre = rs.getString("nombre");
		        	 	Tipos t = new Tipos(id, nombre);
		        	 	return t;
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
				return null;
	}
}