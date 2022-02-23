package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Pokemon;
import models.Usuario;

public class UsersDAO extends AbstractDAO {


	public void consultaCompleta() {
		final String QUERY = "SELECT username, password FROM users";

		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		            System.out.print("Username:  " + rs.getString("username"));
		            System.out.println(", Password:  " + rs.getString("password"));
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	}
	
	public boolean usuariosExistente(String usuario) {
		final String QUERY = "SELECT username FROM users WHERE username = '" + usuario + "'";

		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values		            
		        	 return true;
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		return false; 
	}

	public boolean login(Usuario usuario) {
		final String QUERY = "SELECT username, password FROM users "+
							"WHERE username = '" + usuario.getUsername() + "' AND " +
							"password = '" + usuario.getPassword() + "'";
		try { 
	         ResultSet rs = stmt.executeQuery(QUERY);		      
	         return rs.next();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
			return false;
	}


	public void registro(Usuario usuario) {
		final String INSERT = "INSERT INTO pokedex.users (username, password)"
							+ " VALUES ('"+ usuario.getUsername() +"', '"+ usuario.getPassword() +"');";
		try { 
		 stmt.executeUpdate(INSERT);		      
		} catch (SQLException e) {
		 e.printStackTrace();
		} 

	}
	
	public void deleteUsuario(String nombre) {
		final String DELETE = "DELETE FROM users WHERE username = '" + nombre + "'";
		try {
			stmt.executeUpdate(DELETE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateNombre(String anterior, String nuevo) {
		final String UPDATE = "UPDATE pokedex.users\r\n"
				+ "SET\r\n"
				+ "username = '"+nuevo+"'\r\n"
				+ "WHERE username = '"+anterior+"';";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePassword(String pass, String user) {
		final String UPDATE = "UPDATE pokedex.users\r\n"
				+ "SET\r\n"
				+ "password = '"+pass+"'\r\n"
				+ "WHERE username = '"+user+"';";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int consultaID(String nombre) {
		final String QUERY = "SELECT idusers FROM users WHERE username = '"+nombre+"'";

		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		           return rs.getInt("idusers");
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		return -1; 
	}


}
