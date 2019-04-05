package exercicio4.controller;


import exercicio4.model.bo.UsuarioBO;
import exercicio4.model.vo.UsuarioVO;

public class UsuarioController {
	public String cadastrarUsuarioController(String nome, String email, String senha, int idNivel) {
		String mensagem = "";
		
		//mensagem = validarCampos(nome,preco);
		if(mensagem == "") {
			UsuarioVO novoUsuario = new UsuarioVO();
			novoUsuario.setNome(nome);
			novoUsuario.setEmail(email);
			novoUsuario.setSenha(senha);
			novoUsuario.getNivel().setIdNivel(idNivel);
			
			UsuarioBO bo = new UsuarioBO();
			mensagem = bo.cadastrar(novoUsuario);
		}
	return mensagem;
	}
}
