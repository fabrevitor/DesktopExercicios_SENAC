package exercicio2_3.view;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import exercicio2_3.model.vo.UsuarioVO;
public class MenuPrincipal {
	public void apresentarMenu(ArrayList<UsuarioVO> usuarios) {		
		String textoMenu = "INDIQUE A OPÇÃO DESEJADA!\n" + Menu.MENU_CADASTRO + "- Cadastrar\n" +
				Menu.MENU_EXCLUSAO + "- Excluir\n" + Menu.MENU_CONSULTA + "- Consultar\n"
				+ Menu.SAIR + "- Sair";
		int opcao = Integer.parseInt((String) JOptionPane.showInputDialog
				(null,textoMenu,"BEM-VINDO",JOptionPane.PLAIN_MESSAGE, Menu.icon, null, "Digite aqui"));
		switch(opcao) {
		case Menu.MENU_CADASTRO:
			MenuCadastro menuCadastro = new MenuCadastro();
			menuCadastro.apresentarMenuCadastro(usuarios);
			break;
		case Menu.MENU_EXCLUSAO:
			MenuExclusao menuExclusao = new MenuExclusao();
			menuExclusao.apresentarMenuExclusao(usuarios);
			break;
		case Menu.MENU_CONSULTA:
			MenuConsulta menuConsulta = new MenuConsulta();
			menuConsulta.apresentarMenuConsulta(usuarios);
			break;
		case Menu.SAIR:
			int sair = (JOptionPane.showConfirmDialog(null, "SIM para encerrar e NÃO para voltar ao MENU", 
					"Deseja mesmo sair?", JOptionPane.YES_NO_OPTION));
			switch(sair) {
			case Menu.NAO:
				apresentarMenu(usuarios);		
				break;
			case Menu.SIM:
				break;
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA", null, JOptionPane.WARNING_MESSAGE, Menu.icon);
			apresentarMenu(usuarios);
		}
	}
}
