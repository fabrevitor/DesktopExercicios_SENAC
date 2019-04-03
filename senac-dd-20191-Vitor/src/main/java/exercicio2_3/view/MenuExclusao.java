package exercicio2_3.view;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import exercicio2_3.model.vo.UsuarioVO;
public class MenuExclusao {
	public void apresentarMenuExclusao(ArrayList<UsuarioVO> usuarios) {
		int idExcluir = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Digite o id do usuário a ser excluído: ",
				"Exclusão Usuário", JOptionPane.WARNING_MESSAGE, Menu.icon, null, "Digite aqui: "));
		for(int i = 0; i < usuarios.size(); i++)
		{
			UsuarioVO u = usuarios.get(i);

			if(u.getId() == idExcluir)
			{
				usuarios.remove(u);
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Usuário ID:" + idExcluir + " excluído com sucesso!");
	}
}
