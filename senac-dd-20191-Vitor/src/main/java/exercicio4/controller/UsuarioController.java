package exercicio4.controller;

import exercicio4.model.bo.UsuarioBO;
import exercicio4.model.vo.NivelVO;

public class UsuarioController {
	public String cadastrarUsuarioController(String nome, String email, NivelVO nivel, String senha) {
String mensagem = "";
			UsuarioBO usuarioBO = new UsuarioBO();
			mensagem = usuarioBO.cadastrar(nome,email,nivel,senha);
			return mensagem;
	}
}
