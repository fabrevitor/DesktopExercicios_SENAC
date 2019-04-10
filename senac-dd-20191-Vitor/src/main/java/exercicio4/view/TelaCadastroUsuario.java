package exercicio4.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import exercicio4.controller.UsuarioController;
import exercicio4.model.bo.NivelBO;
import exercicio4.model.vo.NivelVO;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuario {
	private JFrame frmCadastroDeUsuarios;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JComboBox<Object> cbNivel;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmacaoSenha;
	private List<NivelVO> niveis;
	/**
	 * Launch the application.
	 */
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
	/**
	 * Create the application.
	 */
	public TelaCadastroUsuario() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//TODO consultar os níveis no banco (criei na mão aqui :D)
		consultarNiveis();
		//TODO alterar esta chamada AQUI
		frmCadastroDeUsuarios = new JFrame();
		frmCadastroDeUsuarios.setTitle("Cadastro de usuários");
		frmCadastroDeUsuarios.setBounds(100, 100, 370, 220);
		frmCadastroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeUsuarios.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 20, 55, 15);
		frmCadastroDeUsuarios.getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 55, 55, 15);
		frmCadastroDeUsuarios.getContentPane().add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(20, 90, 55, 15);
		frmCadastroDeUsuarios.getContentPane().add(lblSenha);
		
		JLabel lblConfirmaoDeSenha = new JLabel("Confirmação:");
		lblConfirmaoDeSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmaoDeSenha.setBounds(165, 90, 94, 16);
		frmCadastroDeUsuarios.getContentPane().add(lblConfirmaoDeSenha);
		
		JLabel lblNivel = new JLabel("Nível:");
		lblNivel.setBounds(20, 125, 55, 15);
		frmCadastroDeUsuarios.getContentPane().add(lblNivel);
		
		txtNome = new JTextField();
		txtNome.setBounds(70, 15, 280, 28);
		frmCadastroDeUsuarios.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(70, 50, 280, 28);
		frmCadastroDeUsuarios.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(70, 85, 90, 28);
		frmCadastroDeUsuarios.getContentPane().add(pfSenha);
		
		pfConfirmacaoSenha = new JPasswordField();
		pfConfirmacaoSenha.setBounds(260, 84, 90, 28);
		frmCadastroDeUsuarios.getContentPane().add(pfConfirmacaoSenha);
		
		consultarNiveis();
		//Novo componente: Combobox
		cbNivel = new JComboBox<Object>();
		cbNivel.setModel(new DefaultComboBoxModel<Object>(niveis.toArray()));
		
		//Inicia sem nada selecionado no combo
		cbNivel.setSelectedIndex(-1);
		
		cbNivel.setBounds(70, 120, 280, 28);
		frmCadastroDeUsuarios.getContentPane().add(cbNivel);
		
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
		btnLimpar.setBounds(190, 155, 160, 35);
		frmCadastroDeUsuarios.getContentPane().add(btnLimpar);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String senha = pfSenha.getText();
				String senhaConfirmacao = pfConfirmacaoSenha.getText();
				NivelVO nivel = (NivelVO) cbNivel.getSelectedItem();
				
				UsuarioController controladoraUsuario = new UsuarioController();
				String mensagem = controladoraUsuario.cadastrarUsuarioController(nome, email, nivel,senha);
				
				JOptionPane.showMessageDialog(null, mensagem);
				
			}
		});
		button.setBounds(20, 155, 160, 35);
		frmCadastroDeUsuarios.getContentPane().add(button);
	}
	private void consultarNiveis() {
		NivelBO nivelBO = new NivelBO();
		niveis = nivelBO.consultarNiveisBO();
	}
}
