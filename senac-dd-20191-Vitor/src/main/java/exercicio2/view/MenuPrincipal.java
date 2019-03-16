package exercicio2.view;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import exercicio2.model.vo.Usuario;

public class MenuPrincipal {

	public static final int MENU_CADASTRO = 1;
	public static final int MENU_EXCLUSAO = 2;
	public static final int MENU_CONSULTA = 3;
	public static final int SAIR = 4;
	public static final int NAO = 1;
	public static final int SIM = 0;
	public static ImageIcon icon = new ImageIcon("D:\\Vitor\\Desktop\\senac.png",
            "LOGO SENAC");
	
	public void apresentarMenu(ArrayList<Usuario> usuarios) {		
		String textoMenu = "INDIQUE A OPÇÃO DESEJADA!\n" + MENU_CADASTRO + "- Cadastrar\n" +
				MENU_EXCLUSAO + "- Excluir\n" + MENU_CONSULTA + "- Consultar\n"
				+ SAIR + "- Sair";
	
		int opcao = Integer.parseInt((String) JOptionPane.showInputDialog
				(null,textoMenu,"BEM-VINDO",JOptionPane.PLAIN_MESSAGE, icon, null, "Digite aqui"));
		switch(opcao) {
		case MENU_CADASTRO:
			MenuCadastro menuCadastro = new MenuCadastro();
			menuCadastro.apresentarMenuCadastro(usuarios);
			break;
		case MENU_EXCLUSAO:
			MenuCadastro menuExclusao = new MenuCadastro();
			menuExclusao.apresentarMenuExclusao(usuarios);
			break;
		case MENU_CONSULTA:
			MenuConsulta menuConsulta = new MenuConsulta();
			menuConsulta.apresentarMenuConsulta(usuarios);
			break;
		case SAIR:
			int sair = (JOptionPane.showConfirmDialog(null, "SIM para encerrar e NÃO para voltar ao MENU", 
					"Deseja mesmo sair?", JOptionPane.YES_NO_OPTION));
			switch(sair) {
			case NAO:
				apresentarMenu(usuarios);		
				break;
			case SIM:
				break;
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA", null, JOptionPane.WARNING_MESSAGE, icon);
			apresentarMenu(usuarios);
		}
	}
}
