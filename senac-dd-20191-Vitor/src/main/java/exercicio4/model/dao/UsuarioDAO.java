package exercicio4.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exercicio4.model.vo.NivelVO;
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
		String query = "INSERT INTO USUARIO (NOME,EMAIL, SENHA, ID_NIVEL) VALUES('"
		+ usuario.getNome()+ "','" + usuario.getEmail() + "','" + usuario.getSenha() + "','"
		+ usuario.getNivel().getId() + "')";
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
	public int excluirUsuarioDAO(UsuarioVO selectedItem) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM USUARIO WHERE ID_USUARIO = " + selectedItem.getId();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query que exclui usuário. Causa: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}
	public ArrayList<UsuarioVO> consultarTodosUsuariosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		String query = "SELECT ID_USUARIO, NOME, DESCRICAO FROM USUARIO INNER JOIN NIVEL ON NIVEL.ID_NIVEL = USUARIO.ID_NIVEL";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setId(Integer.parseInt(resultado.getString(1)));
				usuarioVO.setNome(resultado.getString(2));
				NivelVO nivelVO = new NivelVO();
				nivelVO.setDescricao(resultado.getString(3));
				usuarioVO.setNivel(nivelVO);
				
				usuarios.add(usuarioVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar usuários.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarios;
	}
}
