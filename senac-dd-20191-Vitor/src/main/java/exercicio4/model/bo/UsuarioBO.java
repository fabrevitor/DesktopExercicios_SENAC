package exercicio4.model.bo;

import java.util.ArrayList;

import exercicio4.model.dao.UsuarioDAO;
import exercicio4.model.vo.UsuarioVO;

public class UsuarioBO {
	
	public String cadastrar(UsuarioVO novoUsuario) {
		
		String mensagem = "";
		UsuarioDAO uDAO = new UsuarioDAO();
		if(uDAO.existeRegistroPorNome(novoUsuario.getNome())) {
			mensagem = "Já existe usuário cadastrado com este nome: "
					+ novoUsuario.getNome();
		} else {
			int statusPersistencia = uDAO.cadastrarUsuarioDAO(novoUsuario);
			
			if(statusPersistencia == 1) {
				mensagem = "Usuário salvo com sucesso!";
			} else if (statusPersistencia == 0) {
				mensagem = "Erro ao salvar Usuário.";
			}
		}
	return mensagem;
	}
	public String atualizar(UsuarioVO usuario) {
		String mensagem = "";
		UsuarioDAO uDAO = new UsuarioDAO();
		
		if(usuario == null) {
			mensagem = "Usuário está nulo, favor preencher.";
		} else if (usuario.getId() > 0) {
			mensagem = "Usuário deve possuir um id, erro ao consultar!";
		}
		
		if(uDAO.existeRegistroPorNome(usuario.getNome())) {
			mensagem = "Já existe usuário cadastrado com este nome: " + usuario.getNome();
		} else {
			int statusPersistencia = uDAO.atualizarUsuario(usuario);
			
			if(statusPersistencia == 1) {
				mensagem = "Usuário atualizado com sucesso!";
			} else if(statusPersistencia == 0) {
				mensagem = "Erro ao atualizar dados.";
			}
		}
	return mensagem;
	}
	public UsuarioVO consultarUsuarioPorNome(String nome) {
			UsuarioDAO dao = new UsuarioDAO();
			return dao.consultarUsuarioPorNome(nome);
	}
	
	public ArrayList<UsuarioVO> consultarTodos(){
		UsuarioDAO dao = new UsuarioDAO();
		return dao.consultarTodos();
	}
	
}
