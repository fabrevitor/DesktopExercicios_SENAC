package exercicio4.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Banco {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String banco = "PROJETO1_DESKTOP";
	private static final String CONEXAO = "jdbc:mysql://localhost:3306/" + banco + "?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	public static final int CODIGO_RETORNO_ERRO_EXCLUSAO = 0;
	public static final int CODIGO_RETORNO_SUCESSO_EXCLUSAO = 1;
	
	/**
	 * Estabelece a conexão JBDC considerando as configurações da classe Banco.
	 * 
	 * @return Connection um objeto de conexão JDBC.
	 * 
	 * @throws ClassNotFoundException
	 *             caso o nome completo de DRIVER_MYSQL esteja incorreto ou o
	 *             driver JDBC do banco selecionado não foi adicionado ao
	 *             projeto (via .jar ou dependência no pom.xml).
	 * 
	 * @throws SQLException
	 *             caso a URL_CONEXAO, USUARIO e/ou SENHA estejam incorretos.
	 */
	
	public static Connection getConnection(){
		try {
			Connection conn = null;
			Class.forName(driver);
			conn = DriverManager.getConnection(CONEXAO, USUARIO, SENHA);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do Driver não foi encontrada. Causa: " + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao obter a Connection. Causa: " + e.getMessage());
			return null;
		}
	}
	
	public static void closeConnection(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conexão. Causa: " + e.getMessage());
		}	
	}
	
	/**
	 * 
	 * Solicita um objeto Statement para uma conexão. Este objeto serve para
	 * executar as operações SQL.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a criação da expressão
	 * SQL, geralmente com os métodos execute(sql), executeUpdate(sql) ou
	 * executeQuery(sql), onde "sql" é do tipo String.
	 * 
	 * @param conn uma conexão anteriormente criada.
	 * @return stmt um objeto do tipo Statement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static Statement getStatement(Connection conn){
		try {
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (SQLException e) {
			System.out.println("Erro ao obter o Statement. Causa: " + e.getMessage());
			return null;
		}
	}
		
	/**
	 * 
	 * Fecha um objeto Statement anteriormente criado.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a execução da expressão
	 * SQL.
	 * 
	 * @param stmt um objeto do tipo Statement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closeStatement(Statement stmt){
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do Statement. Causa: " + e.getMessage());
		}	
	}
	
	/**
	 * 
	 * Solicita um objeto PreparedStatement para uma conexão. Este objeto serve
	 * para executar as operações SQL.
	 * 
	 * @param conn uma conexão anteriormente criada.
	 * @return stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static PreparedStatement getPreparedStatement(Connection conn){
		try {
			PreparedStatement stmt = null;
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement. Causa: " + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * Fecha um objeto PreparedStatement anteriormente criado.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a execução da expressão
	 * SQL.
	 * 
	 * @param stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closePreparedStatement(Statement stmt){
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do PreparedStatement. Causa: " + e.getMessage());
		}	
	}
	
	/**
	 * 
	 * Fecha um objeto ResultSet anteriormente criado.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a consulta de todos os
	 * resultados e conversão para objetos.
	 * 
	 * @param result um objeto do tipo ResultSet
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closeResultSet(ResultSet result){
		try {
			if(result != null){
				result.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do ResultSet. Causa: " + e.getMessage());
		}
	}
}