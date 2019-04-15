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
	public boolean existeRegistroPorEmail(String email) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM USUARIO WHERE UPPER(EMAIL) ='" + email.toUpperCase() + "'";
		try {
			resultado = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar consulta que verifica existência de usuário por email."
					+ "Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return true;
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
		String query = "SELECT * FROM USUARIO";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setId(resultado.getInt("ID_USUARIO"));
				usuarioVO.setNome(resultado.getString("Nome"));
				usuarioVO.setEmail(resultado.getString("Email"));
				usuarioVO.setSenha(resultado.getString("Senha"));
				int idNivel = resultado.getInt("ID_NIVEL");
				
				NivelDAO nivelDAO = new NivelDAO();
				NivelVO nivel = nivelDAO.consultarPorId(idNivel);
				usuarioVO.setNivel(nivel);

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
	public UsuarioVO isAdminDAO(String email, String senha) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UsuarioVO usuarioVO = new UsuarioVO();
		String query = "SELECT * FROM USUARIO WHERE EMAIL= '" + email + "' AND SENHA = '" + senha + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				usuarioVO.setId(resultado.getInt(1));
				usuarioVO.setNome(resultado.getString(2));
				usuarioVO.setEmail(resultado.getString(3));
				usuarioVO.setSenha(resultado.getString(4));
				NivelVO nivelVO = new NivelVO();
				nivelVO.setId(resultado.getInt(5));
				usuarioVO.setNivel(nivelVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica se o usuário é admin! Erro:" + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarioVO;
	}
	public ArrayList<UsuarioVO> listarUsuariosNivelDAO(String descricao) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		String query = "SELECT * FROM USUARIO INNER JOIN NIVEL ON USUARIO.ID_NIVEL = NIVEL.ID_NIVEL WHERE NIVEL.DESCRICAO ='" + descricao + "'";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setId(resultado.getInt(1));
				usuarioVO.setNome(resultado.getString(2));
				usuarioVO.setEmail(resultado.getString(3));
				usuarioVO.setSenha(resultado.getString(4));
				NivelVO nivelVO = new NivelVO();
				nivelVO.setDescricao(resultado.getString(7));
				usuarioVO.setNivel(nivelVO);  
				usuarios.add(usuarioVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a query de listar usuarios por nivel.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarios;
	}
	public ArrayList<UsuarioVO> listarUsuariosNomeDAO(String text) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		String query = "SELECT * FROM USUARIO WHERE NOME LIKE'%" + text + "%'";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setId(resultado.getInt(1));
				usuarioVO.setNome(resultado.getString(2));
				usuarioVO.setEmail(resultado.getString(3));
				usuarioVO.setSenha(resultado.getString(4));
				NivelVO nivelVO = new NivelVO();
				nivelVO.setId(resultado.getInt(5));
				usuarioVO.setNivel(nivelVO);
				usuarios.add(usuarioVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a query de listar usuarios por nome.");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarios;
	}
}
