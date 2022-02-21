package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;

public class PokemonDAO {

	final String DB_URL = "jdbc:mysql://localhost/pokedex";
	final String USER = "fran";
	final String PASS = "#IltwwAmh3127";
	private TiposDAO tiposDAO;
	
	public PokemonDAO() {
		this.tiposDAO = new TiposDAO();
	}
	
	public Pokemon consultaFirst() {
		final String QUERY = "SELECT numero, nombre, altura, peso, categoria, habilidad"
				+ " FROM pokemones LIMIT 1";

		try { 
				 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	int numero = rs.getInt("numero");
		        	 	String nombre = rs.getString("nombre");
		        	 	double altura = rs.getDouble("altura");
		        	 	double peso = rs.getDouble("peso");
		        	 	String categoria = rs.getString("categoria");
		        	 	String habilidad = rs.getString("habilidad");
		        	 	Pokemon p = new Pokemon(numero, nombre, altura, peso, categoria, habilidad);
		        	 	return p;
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
				return null;
	}
	
	public ArrayList<Pokemon> getAll() {
		final String QUERY = "SELECT numero, nombre, altura, peso, categoria, habilidad"
				+ ", idTipo1, idTipo2"
				+ " FROM pokemones";
		ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
		try { 
				 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	int numero = rs.getInt("numero");
		        	 	String nombre = rs.getString("nombre");
		        	 	double altura = rs.getDouble("altura");
		        	 	double peso = rs.getDouble("peso");
		        	 	String categoria = rs.getString("categoria");
		        	 	String habilidad = rs.getString("habilidad");
		        	 	Pokemon p = new Pokemon(numero, nombre, altura, peso, categoria, habilidad);
		        	 	p.setTipo1(tiposDAO.get(rs.getInt("idTipo1")));
		        	 	p.setTipo2(tiposDAO.get(rs.getInt("idTipo2")));
		        	 	pokemones.add(p);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
				return pokemones;
	}
	
	public void insertPokemon(Pokemon p) {
		final String INSERT = "INSERT INTO pokedex.pokemones (numero, nombre, altura, peso, categoria, habilidad, idTipo1, idTipo2)"
				+ " VALUES ('0', '"+ p.getNombre() +"', '"+ p.getAltura() +"', '"+ p.getPeso() +"', '" + p.getCategoria()
				+ "', '"+ p.getHabilidad() + "', '"+p.getTipo1().getId()
				+"', '"+(p.getTipo2() != null ? String.valueOf(p.getTipo2().getId()) : "NULL") + "');";
		try { 
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);		      
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void deletePokemon(Pokemon p) {
		final String DELETE = "DELETE FROM pokemones WHERE numero = " + p.getNumero();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(DELETE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePokemon(Pokemon p) {
		final String UPDATE = "UPDATE pokedex.pokemones\r\n"
				+ "SET\r\n"
				+ "nombre = '"+p.getNombre()+"',\r\n"
				+ "altura = '"+p.getAltura()+"',\r\n"
				+ "peso = '"+p.getPeso()+"',\r\n"
				+ "categoria = '"+p.getCategoria()+"',\r\n"
				+ "habilidad = '"+p.getHabilidad()+"' \r\n"
				+ "WHERE numero = "+p.getNumero()+";";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
