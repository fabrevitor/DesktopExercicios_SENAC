package exercicio2_3.executavel;

import java.util.ArrayList;

import exercicio2_3.model.vo.UsuarioVO;
import exercicio2_3.view.MenuPrincipal;

public class Executavel {
	public static void main(String[] args) {
		ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		MenuPrincipal menu = new MenuPrincipal();

		menu.apresentarMenu(usuarios);
	}
}
