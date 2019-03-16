package exercicio2.executavel;

import java.util.ArrayList;

import exercicio2.model.vo.Usuario;
import exercicio2.view.MenuPrincipal;

public class Executavel {
	public static void main(String[] args) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		MenuPrincipal menu = new MenuPrincipal();
		menu.apresentarMenu(usuarios);
	}
}
