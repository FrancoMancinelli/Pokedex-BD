package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Usuario;

public class UsersDAO extends AbstractDAO {


	public void consulta() {
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


}
