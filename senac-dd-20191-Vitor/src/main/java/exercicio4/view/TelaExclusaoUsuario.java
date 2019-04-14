package exercicio4.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exercicio4.controller.UsuarioController;
import exercicio4.model.vo.UsuarioVO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExclusaoUsuario {

	private JFrame frmExclusaoDeUsuario;
	@SuppressWarnings("rawtypes")
	private JComboBox cbUsuarios;
	private ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
	private JTextField textFieldEmail;
	private JPasswordField pfSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExclusaoUsuario window = new TelaExclusaoUsuario();
					window.frmExclusaoDeUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaExclusaoUsuario() {
		initialize();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		consultarUsuarios();
		
		frmExclusaoDeUsuario = new JFrame();
		frmExclusaoDeUsuario.setTitle("Exclusão de Usuário");
		frmExclusaoDeUsuario.setBounds(100, 100, 356, 163);
		frmExclusaoDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExclusaoDeUsuario.getContentPane().setLayout(null);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(10, 55, 40, 20);
		frmExclusaoDeUsuario.add(labelEmail);
		
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setBounds(190, 55, 50, 20);
		frmExclusaoDeUsuario.add(labelSenha);
		
	    textFieldEmail = new JTextField();
		textFieldEmail.setBounds(55, 55, 130, 20);
		frmExclusaoDeUsuario.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(235, 55, 120, 20);
		frmExclusaoDeUsuario.add(pfSenha);
		pfSenha.setColumns(10);

		cbUsuarios = new JComboBox(usuarios.toArray());
		cbUsuarios.setBounds(10, 11, 323, 39);
		frmExclusaoDeUsuario.getContentPane().add(cbUsuarios);
		cbUsuarios.setSelectedIndex(-1);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mensagem = "";
				UsuarioController controladora = new UsuarioController();
				String email = textFieldEmail.getText();
				String senha = String.copyValueOf(pfSenha.getPassword());
				
				if(controladora.isAdminController(email, senha) == "") {
					controladora.excluirUsuarioController((UsuarioVO)cbUsuarios.getSelectedItem());
					mensagem = "Usuário excluído com sucesso!";
				} else {
					mensagem = controladora.isAdminController(email, senha);
				}
				JOptionPane.showMessageDialog(null, mensagem);
				consultarUsuarios();
			}
		});
		btnExcluir.setBounds(110, 75, 131, 38);
		frmExclusaoDeUsuario.getContentPane().add(btnExcluir);
	}

	private void consultarUsuarios() {
		UsuarioController controller = new UsuarioController();
		usuarios = controller.consultarTodosUsuariosController();
	}
}