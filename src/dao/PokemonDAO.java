package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import models.Pokemon;

public class PokemonDAO extends AbstractDAO {

	private TiposDAO tiposDAO;

	public PokemonDAO() {
		this.tiposDAO = new TiposDAO();
	}

	public Pokemon consultaFirst() {
		final String QUERY = "SELECT numero, nombre, altura, peso, categoria, habilidad, imagen"
				+ " FROM pokemones LIMIT 1";

		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	int numero = rs.getInt("numero");
		        	 	String nombre = rs.getString("nombre");
		        	 	double altura = rs.getDouble("altura");
		        	 	double peso = rs.getDouble("peso");
		        	 	String categoria = rs.getString("categoria");
		        	 	String habilidad = rs.getString("habilidad");
		        	 	String imagen = rs.getString("imagen");
		        	 	Pokemon p = new Pokemon(numero, nombre, altura, peso, categoria, habilidad, imagen);
		        	 	return p;
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
				return null;
	}

	public ArrayList<Pokemon> getAll() {
		final String QUERY = "SELECT numero, nombre, altura, peso, categoria, habilidad, imagen"
				+ ", idTipo1, idTipo2"
				+ " FROM pokemones";
		ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	int numero = rs.getInt("numero");
		        	 	String nombre = rs.getString("nombre");
		        	 	double altura = rs.getDouble("altura");
		        	 	double peso = rs.getDouble("peso");
		        	 	String categoria = rs.getString("categoria");
		        	 	String habilidad = rs.getString("habilidad");
		        	 	String img = rs.getString("imagen");
		        	 	Pokemon p = new Pokemon(numero, nombre, altura, peso, categoria, habilidad, img);
		        	 	p.setTipo1(tiposDAO.getTipo1(rs.getInt("idTipo1")));
		        	 	p.setTipo2(tiposDAO.getTipo2(rs.getInt("idTipo2")));
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
				+"', '"+p.getTipo2().getId() + "');";
		try { 
			stmt.executeUpdate(INSERT);		      
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void deletePokemon(Pokemon p) {
		final String DELETE = "DELETE FROM pokemones WHERE numero = " + p.getNumero();
		try {
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
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean pokemonExistente(String nombre) {
		final String QUERY = "SELECT nombre FROM pokemones WHERE nombre = '" + nombre + "'";

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
}