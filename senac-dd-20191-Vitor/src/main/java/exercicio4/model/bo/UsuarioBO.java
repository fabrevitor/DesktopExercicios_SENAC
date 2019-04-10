package exercicio4.model.bo;

import java.util.ArrayList;

import exercicio4.model.dao.Banco;
import exercicio4.model.dao.UsuarioDAO;
import exercicio4.model.vo.NivelVO;
import exercicio4.model.vo.UsuarioVO;

public class UsuarioBO {
	
	public String cadastrar(String nome, String email, NivelVO nivel, String senha) {
		String mensagem = "";
		UsuarioDAO uDAO = new UsuarioDAO();
		if(uDAO.existeRegistroPorNome(nome)) {
			mensagem = "Já existe usuário cadastrado com este nome: "
					+ nome;
		}  
		if(nome.trim().length() <= 3) {
			mensagem = "Nome tem que ter mais de 3 caracteres!";
		}	
		
		if(senha.length() < 6) {
			mensagem = "Senha inválida. Deve ter pelo menos 6 caracteres.";
		}
		
		if(mensagem == "") {
			UsuarioVO usuarioVO = new UsuarioVO(nome, email, senha, nivel);
				int statusPersistencia = uDAO.cadastrarUsuarioDAO(usuarioVO);
				if(statusPersistencia == 1) {
					mensagem = "Usuário salvo com sucesso!";
				} else if (statusPersistencia == 0) {
					mensagem = "Erro ao salvar Usuário.";
				}
			}	
	return mensagem;
	}

	public String excluirBO(UsuarioVO selectedItem) {
		String mensagem = "";
		
		UsuarioDAO dao = new UsuarioDAO();
		int codigoRetorno = dao.excluirUsuarioDAO(selectedItem);
		
		if(codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO_EXCLUSAO) {
			mensagem = "Usuário" + selectedItem.toString() + " excluído com sucesso!";
		} else {
			mensagem = "Erro ao excluir usuário!";
		}
		return mensagem;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosBO() {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.consultarTodosUsuariosDAO(); 
	}
}
