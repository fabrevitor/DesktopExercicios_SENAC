package exercicio4.controller;

import java.util.ArrayList;

import exercicio4.model.bo.UsuarioBO;
import exercicio4.model.dao.UsuarioDAO;
import exercicio4.model.vo.NivelVO;
import exercicio4.model.vo.UsuarioVO;

public class UsuarioController {
	private boolean validarCampo(String campo) {
		if (campo.trim() == "" || campo == null) {
			return false;
		} else {
			return true;
		}
	}

	public String cadastrarUsuarioController(String nome, String email, NivelVO nivel, String senha,
			String senhaConfirmacao) {
		String mensagem = "";

		UsuarioBO usuarioBO = new UsuarioBO();
		mensagem = usuarioBO.cadastrar(nome, email, nivel, senha, senhaConfirmacao);
		return mensagem;
	}

	public String excluirUsuarioController(UsuarioVO selectedItem) {
		String mensagem = "";
		if (selectedItem == null) {
			mensagem = "Selecione um usuário!";
		}
		if (mensagem.isEmpty()) {
			UsuarioBO bo = new UsuarioBO();
			mensagem = bo.excluirBO(selectedItem);
		}
		return mensagem;
	}

	public String isAdminController(String email, String senha) {
		String mensagem = "";
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioBO usuarioBO = new UsuarioBO();

		if (this.validarCampo(email) || this.validarCampo(senha)) {
			if (usuarioDAO.existeRegistroPorEmail(email)) {
				if (usuarioBO.isAdminBO(email, senha).getNivel().getId() == 1) {
					mensagem = "";
				} else {
					mensagem = "O usuário informado não é Admin.";
				}
			} else {
				mensagem = "Email não corresponde a nenhum usuário!";
			}
		} else {
			mensagem = "Email ou senha estão incorretos!!";
		}
		return mensagem;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosController() {
		UsuarioBO bo = new UsuarioBO();
		return bo.consultarTodosUsuariosBO();
	}

	public ArrayList<UsuarioVO> listarUsuariosNivelController(String descricao) {
		UsuarioBO usuarioBO = new UsuarioBO();
		return usuarioBO.listarUsuariosNivelBO(descricao);
	}

	public ArrayList<UsuarioVO> listarUsuariosNomeController(String text) {
		UsuarioBO usuarioBO = new UsuarioBO();
		return usuarioBO.listarUsuariosNomeBO(text);
	}
}
