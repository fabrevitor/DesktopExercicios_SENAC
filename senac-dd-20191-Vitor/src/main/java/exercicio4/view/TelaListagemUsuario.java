package exercicio4.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exercicio4.controller.UsuarioController;
import exercicio4.model.bo.NivelBO;
import exercicio4.model.vo.NivelVO;
import exercicio4.model.vo.UsuarioVO;
/**
 * 
 * Tela de listagem de usuários (item 1c da Atividade 4)
 * 
 * @author Vilmar César Pereira Júnior
 *
 */
public class TelaListagemUsuario {

	private JFrame frmCadastroDeUsuarios;
	private JTextField txtNome;
	@SuppressWarnings("rawtypes")
	private JComboBox cbNivel;
	private List<NivelVO> niveis;
	private JTable tblUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemUsuario window = new TelaListagemUsuario();
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
	public TelaListagemUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {

		consultarNiveis();

		frmCadastroDeUsuarios = new JFrame();
		frmCadastroDeUsuarios.setTitle("Consulta de usuários");
		frmCadastroDeUsuarios.setBounds(100, 100, 585, 405);
		frmCadastroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeUsuarios.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 20, 55, 15);
		frmCadastroDeUsuarios.getContentPane().add(lblNome);

		JLabel lblNivel = new JLabel("Nível:");
		lblNivel.setBounds(20, 55, 55, 15);
		frmCadastroDeUsuarios.getContentPane().add(lblNivel);

		txtNome = new JTextField();
		txtNome.setBounds(70, 15, 320, 28);
		frmCadastroDeUsuarios.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		//Novo componente: Combobox
		cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(niveis.toArray()));

		//Inicia sem nada selecionado no combo
		cbNivel.setSelectedIndex(-1);

		cbNivel.setBounds(70, 50, 320, 28);
		frmCadastroDeUsuarios.getContentPane().add(cbNivel);

		JButton btnConsultarPorNivel = new JButton("Consultar por nível");
		btnConsultarPorNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
				
				UsuarioController controller = new UsuarioController();
				NivelVO nivelVO = new NivelVO();
				nivelVO = (NivelVO) cbNivel.getSelectedItem();
				usuarios = controller.listarUsuariosNivelController(nivelVO.getDescricao());
				
				DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
				Object linha[] = new Object[2];
				for(int i = 0; i < usuarios.size(); i++) {
					linha[0] = usuarios.get(i).getId();
					linha[1] = usuarios.get(i).getNome();
					model.addRow(linha);
				}
			}
		});
		btnConsultarPorNivel.setBounds(390, 49, 160, 30);
		frmCadastroDeUsuarios.getContentPane().add(btnConsultarPorNivel);

		JButton btnConsultarPorNome = new JButton("Consultar por nome");
		btnConsultarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<UsuarioVO> usuarios = new ArrayList <UsuarioVO>();
				UsuarioController controller = new UsuarioController();
				usuarios = controller.listarUsuariosNomeController(txtNome.getText());
				
				DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
				Object linha[] = new Object[2];
				for(int i = 0; i < usuarios.size(); i++) {
					linha[0] = usuarios.get(i).getId();
					linha[1] = usuarios.get(i).getNome();
					model.addRow(linha);
				}
			}
		});
		btnConsultarPorNome.setBounds(390, 14, 160, 30);
		frmCadastroDeUsuarios.getContentPane().add(btnConsultarPorNome);

		JButton btnConsultarTodos = new JButton("Consultar todos");
		btnConsultarTodos.setBounds(70, 85, 240, 30);
		frmCadastroDeUsuarios.getContentPane().add(btnConsultarTodos);
		btnConsultarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
				
				UsuarioController controller = new UsuarioController();
				usuarios = controller.consultarTodosUsuariosController();
				
				DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
				Object linha[] = new Object[2];
				for(int i = 0; i < usuarios.size(); i++) {
					linha[0] = usuarios.get(i).getId();
					linha[1] = usuarios.get(i).getNome();
					model.addRow(linha);
				}
			}
		}
		);

		JButton btnLimpar = new JButton("Limpar");
		frmCadastroDeUsuarios.getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				cbNivel.setSelectedIndex(-1);
			}
		});
		btnLimpar.setBounds(310, 85, 240, 30);
		frmCadastroDeUsuarios.getContentPane().add(btnLimpar);
		
		tblUsuarios = new JTable();
		tblUsuarios.setVisible(true);

		tblUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
				{"id", "Nome"},
			},
			new String[] {
				"id", "Nome"
			}
		));

		tblUsuarios.setBounds(70, 120, 480, 230);
		frmCadastroDeUsuarios.getContentPane().add(tblUsuarios);
	}
	protected void atualizarTabelaUsuarios(ArrayList<UsuarioVO> usuarios) {
		DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
		
		Object novaLinha[] = new Object[2];
		for(UsuarioVO usuario: usuarios){
			novaLinha[0] = usuario.getId();
			novaLinha[1] = usuario.getNome();
			model.addRow(novaLinha);
		}
	}
	private void consultarNiveis() {
		NivelBO nivelBO = new NivelBO();
		niveis = nivelBO.consultarNiveisBO();
	}
}
