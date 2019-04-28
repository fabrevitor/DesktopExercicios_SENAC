package exercicio4.view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import exercicio4.controller.UsuarioController;
import exercicio4.model.bo.NivelBO;
import exercicio4.model.vo.NivelVO;

public class TelaCadastroUsuario {
	private JFrame frmCadastroDeUsuarios;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JComboBox<Object> cbNivel;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmacaoSenha;
	private List<NivelVO> niveis;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario window = new TelaCadastroUsuario();
					window.frmCadastroDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroUsuario() {
		initialize();
	}

	private void initialize() {
		consultarNiveis();

		frmCadastroDeUsuarios = new JFrame();
		frmCadastroDeUsuarios.getContentPane().setBackground(SystemColor.menu);
		frmCadastroDeUsuarios.setTitle("Cadastro de usuários");
		frmCadastroDeUsuarios.setBounds(100, 100, 424, 230);
		frmCadastroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeUsuarios.getContentPane()
				.setLayout(new FormLayout(
						new ColumnSpec[] { ColumnSpec.decode("46px"), ColumnSpec.decode("140px"),
								FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("15px"),
								FormSpecs.UNRELATED_GAP_COLSPEC, ColumnSpec.decode("69px"),
								FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("90px"), },
						new RowSpec[] { FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("28px"),
								FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("28px"), FormSpecs.RELATED_GAP_ROWSPEC,
								RowSpec.decode("29px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("28px"),
								FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("35px"), }));

		JLabel lblNome = new JLabel("Nome:");
		frmCadastroDeUsuarios.getContentPane().add(lblNome, "1, 2, left, center");

		JLabel lblEmail = new JLabel("Email:");
		frmCadastroDeUsuarios.getContentPane().add(lblEmail, "1, 4, left, center");

		JLabel lblSenha = new JLabel("Senha:");
		frmCadastroDeUsuarios.getContentPane().add(lblSenha, "1, 6, left, center");

		JLabel lblConfirmaoDeSenha = new JLabel("Confirmação:");
		lblConfirmaoDeSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		frmCadastroDeUsuarios.getContentPane().add(lblConfirmaoDeSenha, "4, 6, 3, 1, fill, center");

		txtNome = new JTextField();
		frmCadastroDeUsuarios.getContentPane().add(txtNome, "2, 2, 7, 1, fill, fill");
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		frmCadastroDeUsuarios.getContentPane().add(txtEmail, "2, 4, 7, 1, fill, fill");
		txtEmail.setColumns(10);

		pfSenha = new JPasswordField();
		frmCadastroDeUsuarios.getContentPane().add(pfSenha, "2, 6, fill, fill");

		pfConfirmacaoSenha = new JPasswordField();
		frmCadastroDeUsuarios.getContentPane().add(pfConfirmacaoSenha, "7, 6, 2, 1, fill, fill");

		consultarNiveis();

		JLabel lblNivel = new JLabel("Nível:");
		lblNivel.setForeground(SystemColor.textHighlight);
		frmCadastroDeUsuarios.getContentPane().add(lblNivel, "1, 8, left, center");
		cbNivel = new JComboBox<Object>();
		cbNivel.setModel(new DefaultComboBoxModel<Object>(niveis.toArray()));

		cbNivel.setSelectedIndex(-1);
		frmCadastroDeUsuarios.getContentPane().add(cbNivel, "2, 8, 7, 1, fill, fill");

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtEmail.setText("");
				pfSenha.setText("");
				pfConfirmacaoSenha.setText("");
				cbNivel.setSelectedIndex(-1);
			}
		});
		frmCadastroDeUsuarios.getContentPane().add(btnLimpar, "6, 10, 3, 1, fill, fill");

		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String senha = String.copyValueOf(pfSenha.getPassword());
				String senhaConfirmacao = String.copyValueOf(pfConfirmacaoSenha.getPassword());
				// MÉTODO GetPass SEM MUDAR A SENHA PARA CHAR[] :
				// String.valueOf(passwordField.getPassword());
				NivelVO nivel = (NivelVO) cbNivel.getSelectedItem();

				UsuarioController controladoraUsuario = new UsuarioController();
				String mensagem = controladoraUsuario.cadastrarUsuarioController(nome, email, nivel, senha,
						senhaConfirmacao);

				JOptionPane.showMessageDialog(null, mensagem);

			}
		});
		frmCadastroDeUsuarios.getContentPane().add(button, "2, 10, 3, 1, fill, fill");
	}

	private void consultarNiveis() {
		NivelBO nivelBO = new NivelBO();
		niveis = nivelBO.consultarNiveisBO();
	}
}
