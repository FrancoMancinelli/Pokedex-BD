package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	protected final String DB_URL = "jdbc:mysql://localhost/pokedex";
	protected final String USER = "fran";
	protected final String PASS = "test";
	
	protected Connection conn;
	protected Statement stmt;
	
	public AbstractDAO() {
		try {
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
			this.stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
