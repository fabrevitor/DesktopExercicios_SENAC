package exercicio2_3.model.bo;

import java.util.ArrayList;

import exercicio2_3.model.dao.UsuarioDAO;
import exercicio2_3.model.vo.UsuarioVO;

public class UsuarioBO {
	public String cadastrarUsuarioBO (UsuarioVO usuarioVO) {
		String mensagem = "";

		//TODO verificar Regras de Negócio
		
		//Caso tudo ok -> chamar DAO para salvar o novo usuário
		
		//UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		return mensagem;
	}
	
	public ArrayList<UsuarioVO> consultarUsuariosBO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> usuariosVO = usuarioDAO.consultarTodosUsuariosDAO();
		return usuariosVO;
	}

	public void excluirUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
	}
}
