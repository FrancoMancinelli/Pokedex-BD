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

	public ArrayList<Tipos> getAll() {
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


	public Tipos get(int idTipos) {
		final String QUERY = "SELECT id, nombre"
				+ " FROM tipos WHERE id = " + idTipos;
		ArrayList<Tipos> tipos = new ArrayList<Tipos>();
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