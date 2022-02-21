package models;

public class Usuario {

	//Atributos
	protected int id;
	protected String username;
	protected String password;
	
	/**
	 * Construye un usuario
	 * @param username Nombre del usuario
	 * @param password Contraseña del usuario
	 */
	public Usuario(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
