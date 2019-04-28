package exercicio4.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

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
		frmCadastroDeUsuarios.setBounds(100, 100, 612, 405);
		frmCadastroDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeUsuarios.getContentPane()
				.setLayout(new FormLayout(
						new ColumnSpec[] { ColumnSpec.decode("52px"), ColumnSpec.decode("281px"),
								ColumnSpec.decode("80px"), ColumnSpec.decode("185px"), },
						new RowSpec[] { FormSpecs.PARAGRAPH_GAP_ROWSPEC, RowSpec.decode("30px"),
								FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("30px"), FormSpecs.RELATED_GAP_ROWSPEC,
								RowSpec.decode("30px"), FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("230px"), }));

		JLabel lblNome = new JLabel("Nome:");
		frmCadastroDeUsuarios.getContentPane().add(lblNome, "1, 2, right, center");

		txtNome = new JTextField();
		frmCadastroDeUsuarios.getContentPane().add(txtNome, "2, 2, 2, 1, fill, fill");
		txtNome.setColumns(10);

		JLabel lblNivel = new JLabel("Nível:");
		frmCadastroDeUsuarios.getContentPane().add(lblNivel, "1, 4, right, center");

		// Novo componente: Combobox
		cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(niveis.toArray()));

		// Inicia sem nada selecionado no combo
		cbNivel.setSelectedIndex(-1);
		frmCadastroDeUsuarios.getContentPane().add(cbNivel, "2, 4, 2, 1, fill, fill");

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
				for (int i = 0; i < usuarios.size(); i++) {
					linha[0] = usuarios.get(i).getId();
					linha[1] = usuarios.get(i).getNome();
					model.addRow(linha);
				}
			}
		});
		frmCadastroDeUsuarios.getContentPane().add(btnConsultarPorNivel, "4, 4, left, fill");

		JButton btnConsultarPorNome = new JButton("Consultar por nome");
		btnConsultarPorNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
				UsuarioController controller = new UsuarioController();
				usuarios = controller.listarUsuariosNomeController(txtNome.getText());

				DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
				Object linha[] = new Object[2];
				for (int i = 0; i < usuarios.size(); i++) {
					linha[0] = usuarios.get(i).getId();
					linha[1] = usuarios.get(i).getNome();
					model.addRow(linha);
				}
			}
		});
		frmCadastroDeUsuarios.getContentPane().add(btnConsultarPorNome, "4, 2, left, fill");

		JButton btnConsultarTodos = new JButton("Consultar todos");
		frmCadastroDeUsuarios.getContentPane().add(btnConsultarTodos, "2, 6, fill, fill");
		btnConsultarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();

				UsuarioController controller = new UsuarioController();
				usuarios = controller.consultarTodosUsuariosController();

				DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
				Object linha[] = new Object[2];
				for (int i = 0; i < usuarios.size(); i++) {
					linha[0] = usuarios.get(i).getId();
					linha[1] = usuarios.get(i).getNome();
					model.addRow(linha);
				}
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		frmCadastroDeUsuarios.getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				cbNivel.setSelectedIndex(-1);
			}
		});
		frmCadastroDeUsuarios.getContentPane().add(btnLimpar);

		tblUsuarios = new JTable();
		tblUsuarios.setVisible(true);

		tblUsuarios
				.setModel(new DefaultTableModel(new Object[][] { { "id", "Nome" }, }, new String[] { "id", "Nome" }));
		frmCadastroDeUsuarios.getContentPane().add(tblUsuarios, "2, 8, 3, 1, fill, fill");
	}

	protected void atualizarTabelaUsuarios(ArrayList<UsuarioVO> usuarios) {
		DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();

		Object novaLinha[] = new Object[2];
		for (UsuarioVO usuario : usuarios) {
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
