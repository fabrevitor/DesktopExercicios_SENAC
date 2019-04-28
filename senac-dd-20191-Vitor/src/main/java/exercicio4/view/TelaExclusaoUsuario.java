package exercicio4.view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exercicio4.controller.UsuarioController;
import exercicio4.model.vo.UsuarioVO;

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
		frmExclusaoDeUsuario.setBounds(100, 100, 360, 148);
		frmExclusaoDeUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 40, 130, 165, 0 };
		gridBagLayout.rowHeights = new int[] { 39, 20, 38, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frmExclusaoDeUsuario.getContentPane().setLayout(gridBagLayout);

		cbUsuarios = new JComboBox(usuarios.toArray());
		GridBagConstraints gbc_cbUsuarios = new GridBagConstraints();
		gbc_cbUsuarios.fill = GridBagConstraints.BOTH;
		gbc_cbUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_cbUsuarios.gridwidth = 3;
		gbc_cbUsuarios.gridx = 0;
		gbc_cbUsuarios.gridy = 0;
		frmExclusaoDeUsuario.getContentPane().add(cbUsuarios, gbc_cbUsuarios);
		cbUsuarios.setSelectedIndex(-1);

		JLabel labelEmail = new JLabel("Email:");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.fill = GridBagConstraints.BOTH;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 1;
		frmExclusaoDeUsuario.getContentPane().add(labelEmail, gbc_labelEmail);

		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.anchor = GridBagConstraints.NORTH;
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 1;
		frmExclusaoDeUsuario.getContentPane().add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);

		pfSenha = new JPasswordField();
		GridBagConstraints gbc_pfSenha = new GridBagConstraints();
		gbc_pfSenha.anchor = GridBagConstraints.NORTHEAST;
		gbc_pfSenha.insets = new Insets(0, 0, 5, 0);
		gbc_pfSenha.gridx = 2;
		gbc_pfSenha.gridy = 1;
		frmExclusaoDeUsuario.getContentPane().add(pfSenha, gbc_pfSenha);
		pfSenha.setColumns(10);

		JLabel labelSenha = new JLabel("Senha:");
		GridBagConstraints gbc_labelSenha = new GridBagConstraints();
		gbc_labelSenha.anchor = GridBagConstraints.WEST;
		gbc_labelSenha.fill = GridBagConstraints.VERTICAL;
		gbc_labelSenha.insets = new Insets(0, 0, 5, 0);
		gbc_labelSenha.gridx = 2;
		gbc_labelSenha.gridy = 1;
		frmExclusaoDeUsuario.getContentPane().add(labelSenha, gbc_labelSenha);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mensagem = "";
				UsuarioController controladora = new UsuarioController();
				String email = textFieldEmail.getText();
				String senha = String.copyValueOf(pfSenha.getPassword());

				if (controladora.isAdminController(email, senha) == "") {
					controladora.excluirUsuarioController((UsuarioVO) cbUsuarios.getSelectedItem());
					mensagem = "Usuário excluído com sucesso!";
				} else {
					mensagem = controladora.isAdminController(email, senha);
				}
				JOptionPane.showMessageDialog(null, mensagem);
				consultarUsuarios();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.gridwidth = 3;
		gbc_btnExcluir.anchor = GridBagConstraints.SOUTH;
		gbc_btnExcluir.gridx = 0;
		gbc_btnExcluir.gridy = 2;
		frmExclusaoDeUsuario.getContentPane().add(btnExcluir, gbc_btnExcluir);
	}

	private void consultarUsuarios() {
		UsuarioController controller = new UsuarioController();
		usuarios = controller.consultarTodosUsuariosController();
	}
}