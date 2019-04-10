package exercicio4.controller;

import java.util.ArrayList;

import exercicio4.model.bo.UsuarioBO;
import exercicio4.model.vo.NivelVO;
import exercicio4.model.vo.UsuarioVO;

public class UsuarioController {
	public String cadastrarUsuarioController(String nome, String email, NivelVO nivel, String senha) {
			String mensagem = "";
			UsuarioBO usuarioBO = new UsuarioBO();
			mensagem = usuarioBO.cadastrar(nome,email,nivel,senha);
			return mensagem;
	}

	public String excluirUsuarioController(UsuarioVO selectedItem) {
		String mensagem = "";
		if (selectedItem == null) {
			mensagem = "Selecione um usuário!";
		}
		if(mensagem.isEmpty()) {
			UsuarioBO bo = new UsuarioBO();
			mensagem = bo.excluirBO(selectedItem);
		}
		return mensagem;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosController() {
		UsuarioBO bo = new UsuarioBO();
		return bo.consultarTodosUsuariosBO();
	}
}
