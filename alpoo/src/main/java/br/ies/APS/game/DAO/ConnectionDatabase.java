package br.ies.APS.game.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {
	private Statement statement;
	private Connection connection;
	private ResultSet resultSet;
	
	public void connect() {

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "12345");
			System.out.println("Conectou no banco de dados.");
		} catch (SQLException ex) {
			System.out.println("Não conectou ao banco de dados por algum erro de SQL.");
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			System.out.println("Não conectou ao banco de dados por algum erro de Classe.");
			ex.printStackTrace();
		}
	}
	
	public void disconnect(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Desconectou do banco de dados.");
			}
		} catch (SQLException ex) {
			System.out.println("Não conseguiu desconectar no Banco de Dados.");
			ex.printStackTrace();
		}
	}
	
	public void executeDML(String dml) {
		this.connect();
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(dml);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Não conseguiu executar o DML:\n" + dml);
		} finally {
			this.disconnect(connection);			
		}
	}
	
	public ResultSet consult(String consult) {
		this.connect();

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(consult);

		} catch (SQLException ex) {
			System.out.println("Não conseguiu executar a consulta:\n" + consult);
			ex.printStackTrace();
		} finally {
			this.disconnect(connection);
		}

		return resultSet;
	}
}
