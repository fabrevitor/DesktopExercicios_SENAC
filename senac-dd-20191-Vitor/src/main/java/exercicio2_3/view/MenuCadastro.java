package exercicio2_3.view;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import exercicio2_3.controller.UsuarioController;
import exercicio2_3.model.vo.UsuarioVO;
public class MenuCadastro {
	public void apresentarMenuCadastro(ArrayList<UsuarioVO> usuarios) {
		int continuar = 0;
			while (continuar == 0) {
				String nome = (String) (JOptionPane.showInputDialog(null, "Digite o nome a ser cadastrado: ", 
						"Cadastro Nome", JOptionPane.PLAIN_MESSAGE, Menu.icon, null, "Digite aqui"));
				String email = (String) (JOptionPane.showInputDialog(null, "Digite o email a ser cadastrado: ", 
						"Cadastro Email", JOptionPane.PLAIN_MESSAGE, Menu.icon, null, "Digite aqui"));
				String senha = (String) (JOptionPane.showInputDialog(null, "Digite a senha a ser cadastrada: ", 
						"Cadastro Senha", JOptionPane.PLAIN_MESSAGE, Menu.icon, null, "Digite aqui"));
				String confirmacao = (String) (JOptionPane.showInputDialog(null, "Digite a senha novamente: ", 
						"Cadastro Confirmação Senha", JOptionPane.PLAIN_MESSAGE, Menu.icon, null, "Digite aqui"));
				int idNivel = Integer.parseInt((String) (JOptionPane.showInputDialog(null, "Digite o nível(1-ADMIN, 2-NORMAL): ", 
						"Cadastro Nível", JOptionPane.PLAIN_MESSAGE, Menu.icon, null, "Digite aqui")));
				
				UsuarioController controller = new UsuarioController();
				controller.cadastrarUsuarioController(nome, email, senha,confirmacao, idNivel);
				
				int sair = (JOptionPane.showConfirmDialog(null,"Deseja cadastrar mais um usuário?", 
						"Cadastro Usuário", JOptionPane.YES_NO_OPTION));
				switch(sair) {
				case Menu.NAO:
					continuar = 1;
					MenuPrincipal menu = new MenuPrincipal();
					menu.apresentarMenu(usuarios);		
					break;
				case Menu.SIM:
					apresentarMenuCadastro(usuarios);
					break;
				}
		}
	}	
}



