package exercicio2.view;

import javax.swing.JOptionPane;

public class MenuPrincipal {

	public static void main(String[] args) {
		apresentarMenu();
		
	}

	private static void apresentarMenu() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog
				("1- CADASTRAR"
				+ "\n2- EXCLUIR"
				+ "\n3- CONSULTAR TODOS"
				+ "\n4- SAIR"));
	}

}
