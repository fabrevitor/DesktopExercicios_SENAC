package exercicio2.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import exercicio2.model.vo.Usuario;

public class MenuConsulta{
	
	public void apresentarMenuConsulta(ArrayList<Usuario> usuarios) {
		for(int i = 0; i > usuarios.size(); i++) {
			Usuario usuarioImprimir = new Usuario();
			usuarioImprimir.setId(usuarios.get(i).getId());
			usuarioImprimir.setNome(usuarios.get(i).getNome());
			usuarioImprimir.setEmail(usuarios.get(i).getEmail());
			usuarioImprimir.setSenha(usuarios.get(i).getSenha());
			
			JOptionPane.showMessageDialog(null, usuarioImprimir.toString());
	}
}
}