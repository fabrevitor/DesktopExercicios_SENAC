package exercicio4.model.bo;

import java.util.ArrayList;

import exercicio4.model.dao.Banco;
import exercicio4.model.dao.UsuarioDAO;
import exercicio4.model.vo.NivelVO;
import exercicio4.model.vo.UsuarioVO;

public class UsuarioBO {

	public String cadastrar(String nome, String email, NivelVO nivel, String senha, String senhaConfirmacao) {
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

		if(!senhaConfirmacao.equals(senha)) {
			mensagem = "As senhas informadas diferem, favor digitar senhas iguais!";
		}
		String[] testeEmail = email.split("@");
		if(testeEmail.length != 2){
			mensagem = "O email digitado é inválido, favor digitar corretamente.";
		}

		if(mensagem == "") {
			UsuarioVO usuarioVO = new UsuarioVO(nome, email, senha, nivel);
			int statusPersistencia = uDAO.cadastrarUsuarioDAO(usuarioVO);
			if(statusPersistencia == 1) {
				mensagem = "Usuário cadastrado com sucesso!";
			} else if (statusPersistencia == 0) {
				mensagem = "Erro ao cadastrar Usuário, favor verificar.";
			}
		}	
		return mensagem;
	}

	public String excluirBO(UsuarioVO selectedItem) {
		String mensagem = "";
		UsuarioDAO dao = new UsuarioDAO();
		int codigoRetorno = dao.excluirUsuarioDAO(selectedItem);

		if(codigoRetorno == Banco.CODIGO_RETORNO_ERRO_EXCLUSAO) {
			mensagem = "Erro ao excluir usuário!";
		}
		return mensagem;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosBO() {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.consultarTodosUsuariosDAO(); 
	}

	public UsuarioVO isAdminBO(String email, String senha) {

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		UsuarioVO usuarioVO = new UsuarioVO();
		usuarioVO = usuarioDAO.isAdminDAO(email,senha);

		return usuarioVO;
	}

	public ArrayList<UsuarioVO> listarUsuariosNivelBO(String descricao) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.listarUsuariosNivelDAO(descricao);
	}

	public ArrayList<UsuarioVO> listarUsuariosNomeBO(String text) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.listarUsuariosNomeDAO(text);
	}
}
