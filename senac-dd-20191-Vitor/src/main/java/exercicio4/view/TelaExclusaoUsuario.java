package exercicio4.view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exercicio4.controller.UsuarioController;
import exercicio4.model.vo.UsuarioVO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExclusaoUsuario {

	private JFrame frmExclusaoDeUsuario;
	private JComboBox cbUsuarios;
	private ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public TelaExclusaoUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		consultarUsuarios();
		frmExclusaoDeUsuario = new JFrame();
		frmExclusaoDeUsuario.setTitle("Exclusão de Usuário");
		frmExclusaoDeUsuario.setBounds(100, 100, 356, 163);
		frmExclusaoDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExclusaoDeUsuario.getContentPane().setLayout(null);
		
		cbUsuarios = new JComboBox(usuarios.toArray());
		cbUsuarios.setBounds(10, 11, 323, 39);
		frmExclusaoDeUsuario.getContentPane().add(cbUsuarios);
		cbUsuarios.setSelectedIndex(-1);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsuarioController controladora = new UsuarioController();
				String mensagem = controladora.excluirUsuarioController((UsuarioVO)cbUsuarios.getSelectedItem());
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