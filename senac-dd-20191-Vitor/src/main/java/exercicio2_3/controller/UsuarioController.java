package exercicio2_3.controller;

import java.util.ArrayList;

import exercicio2_3.model.bo.UsuarioBO;
import exercicio2_3.model.vo.NivelVO;
import exercicio2_3.model.vo.UsuarioVO;

public class UsuarioController {
	
	public String cadastrarUsuarioController(String nome, String email, String senha, String confirmacao, int idNivel){
		String mensagem = "";
		if (nome == null || nome.trim().isEmpty()) {
			mensagem = "Preencha o nome corretamente!";
		} else if (email == null || email.isEmpty()) {
			mensagem = "Preencha o email corretamente!";
		} else if (senha != confirmacao || senha == null || senha.isEmpty()) {
			mensagem = "Preencha a senha e confirmação corretamente!";
		} else {
			UsuarioBO usuarioBO = new UsuarioBO();
			NivelVO nivel = new NivelVO();
			nivel.setIdNivel(idNivel);
			UsuarioVO usuarioVO = new UsuarioVO(nome, email, senha, nivel);
			mensagem = usuarioBO.cadastrarUsuarioBO(usuarioVO);
		}
		return mensagem;
	}
	public ArrayList<UsuarioVO> consultarTodosUsuariosController(){
		UsuarioBO usuarioBO = new UsuarioBO();
		return usuarioBO.consultarUsuariosBO();
	}
	public void excluirUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.excluirUsuarioBO(usuarioVO);
	}
}
