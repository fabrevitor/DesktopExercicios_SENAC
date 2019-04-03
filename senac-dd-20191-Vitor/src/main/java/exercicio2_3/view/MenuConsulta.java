package exercicio2_3.view;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import exercicio2_3.model.vo.UsuarioVO;
public class MenuConsulta{
	public void apresentarMenuConsulta(ArrayList<UsuarioVO> usuarios) {
		for(int i = 0; i < usuarios.size(); i++) {
			UsuarioVO usuarioImprimir = new UsuarioVO();
			usuarioImprimir.setId(usuarios.get(i).getId());
			usuarioImprimir.setNome(usuarios.get(i).getNome());
			usuarioImprimir.setEmail(usuarios.get(i).getEmail());
			usuarioImprimir.setSenha(usuarios.get(i).getSenha());
			JOptionPane.showMessageDialog(null, usuarioImprimir.toString());
	}
}
}