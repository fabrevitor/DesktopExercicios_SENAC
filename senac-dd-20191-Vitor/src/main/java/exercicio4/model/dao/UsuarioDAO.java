package exercicio4.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import exercicio4.model.vo.UsuarioVO;

public class UsuarioDAO {
	public boolean existeRegistroPorNome(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM USUARIO WHERE UPPER(NOME) ='" + nome.toUpperCase() + "'";
		try {
			resultado = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar consulta que verifica existência de Usuário por nome."
					+ "Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}
	
	public int cadastrarUsuarioDAO(UsuarioVO usuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		int resultado = 0;
		String query = "INSERT INTO USUARIO (NOME,EMAIL, SENHA, NIVEL) VALUES('"
		+ usuario.getNome()+ "','" + usuario.getEmail() + "','" + usuario.getSenha() + "','"
		+ usuario.getNivel() + "')";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao executar a Query de Cadastro de Usuário. Causa do erro: " 
			+ e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}
}
