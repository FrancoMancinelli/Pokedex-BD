 package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Usuario;

public class UsersDAO {
	
	final String DB_URL = "jdbc:mysql://localhost/pokedex";
	final String USER = "fran";
	final String PASS = "#IltwwAmh3127";
	
	public void consulta() {
		final String QUERY = "SELECT username, password FROM users";

		try { 
				 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
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
			 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
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
		 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		 Statement stmt = conn.createStatement();
		 stmt.executeUpdate(INSERT);		      
		} catch (SQLException e) {
		 e.printStackTrace();
		} 

	}
	

}
