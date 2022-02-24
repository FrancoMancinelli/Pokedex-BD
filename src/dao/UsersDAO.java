package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Pokemon;
import models.Usuario;

public class UsersDAO extends AbstractDAO {

	/**
	 * Método que busca la existencia del nombre de un usuario en la base de datos
	 * @param usuario Nombre del usuario a buscar
	 * @return True en caso de que ya alguien tenga ese nombre, False en caso contrario
	 */
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

	/**
	 * Método que coomprueba si existe un usuario en la base de datos
	 * según nombre y contraseña
	 * @param usuario El usuario a buscar
	 * @return True en caso de encontrar al usuario
	 */
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

	/**
	 * Inserta un usuario en la base de datos
	 * @param usuario Usuario a insertar
	 */
	public void registro(Usuario usuario) {
		final String INSERT = "INSERT INTO pokedex.users (username, password)"
							+ " VALUES ('"+ usuario.getUsername() +"', '"+ usuario.getPassword() +"');";
		try { 
		 stmt.executeUpdate(INSERT);		      
		} catch (SQLException e) {
		 e.printStackTrace();
		} 

	}
	
	/**
	 * Elimina un usuario de la base de datos
	 * @param nombre El nombre del usuario a eliminar
	 */
	public void deleteUsuario(String nombre) {
		final String DELETE = "DELETE FROM users WHERE username = '" + nombre + "'";
		try {
			stmt.executeUpdate(DELETE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Actualiza el nombre de un usuario en la base de datos
	 * @param anterior El nombre anterior del usuario 
	 * @param nuevo El nombre nuevo a actualizar
	 */
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
	
	/**
	 * Actualiza la contraseña de un usuario en la base de datos
	 * @param pass La contraseña nueva a actualizar
	 * @param user El nombre del usuario a actualizar la contraseña
	 */
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
	
	/**
	 * Busca la id de un usuario
	 * @param nombre El nombre del usuario a quien le buscaremos la id
	 * @return La id del usuario, si no la encuentra devolverá -1
	 */
	public int consultaID(String nombre) {
		final String QUERY = "SELECT idusers FROM users WHERE username = '"+nombre+"'";

		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		        	 //Display Values
		           return rs.getInt("idusers");
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		return -1; 
	}


}
