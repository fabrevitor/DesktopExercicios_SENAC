package exercicio2.view;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import exercicio2.model.vo.Usuario;

public class MenuCadastro {
	public static ImageIcon icon = new ImageIcon("D:\\Vitor\\Desktop\\senac.png",
            "LOGO SENAC");
	public static final int NAO = 1;
	public static final int SIM = 0;
	
	
	public void apresentarMenuCadastro(ArrayList<Usuario> usuarios) {
		int continuar = 0;
		int i = 0;
		
			while (continuar == 0) {
				String nome = (String) (JOptionPane.showInputDialog(null, "Digite o nome a ser cadastrado: ", 
						"Cadastro Nome", JOptionPane.PLAIN_MESSAGE, icon, null, "Digite aqui"));
			
				
				String email = (String) (JOptionPane.showInputDialog(null, "Digite o email a ser cadastrado: ", 
						"Cadastro Email", JOptionPane.PLAIN_MESSAGE, icon, null, "Digite aqui"));
		
				
				String senha = (String) (JOptionPane.showInputDialog(null, "Digite a senha a ser cadastrada: ", 
				
						"Cadastro Senha", JOptionPane.PLAIN_MESSAGE, icon, null, "Digite aqui"));
			
				
				int nivel = Integer.parseInt((String) (JOptionPane.showInputDialog(null, "Digite o nível(1-ADMIN, 2-NORMAL): ", 
						"Cadastro Nível", JOptionPane.PLAIN_MESSAGE, icon, null, "Digite aqui")));
				
				Usuario usuario = new Usuario(i, nome, email, senha,nivel);
				JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!\n" + usuario.toString(), "Confirmação de cadastro",
				           JOptionPane.PLAIN_MESSAGE);
				
				i = i + 1;
				usuarios.add(usuario);
				
				int sair = (JOptionPane.showConfirmDialog(null,"Deseja cadastrar mais um usuário?", 
						"Cadastro Usuário", JOptionPane.YES_NO_OPTION));
				switch(sair) {
				case NAO:
					continuar = 1;
					MenuPrincipal menu = new MenuPrincipal();
					menu.apresentarMenu(usuarios);		
					break;
				case SIM:
					apresentarMenuCadastro(usuarios);
					break;
				}
		}
	}
	public void apresentarMenuExclusao(ArrayList<Usuario> usuarios) {
		int idExcluir = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Digite o id do usuário a ser excluído: ",
				"Exclusão Usuário", JOptionPane.WARNING_MESSAGE, icon, null, "Digite aqui: "));
		for(int i = 0; i < usuarios.size(); i++)
		{
			Usuario u = usuarios.get(i);

			if(u.getId() == idExcluir)
			{
				usuarios.remove(u);
				break;
			}
		}
	}
	
}

