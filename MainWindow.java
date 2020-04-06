package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;

public class MainWindow {

	private JFrame frame;
	private JTextField textNomeComp;
	private JTextField textAtuacaoComp;
	private JTextField textCnpjComp;
	private JTextField textEnderecoComp;
	private JTextField textCepComp;
	private JTextField textNomeFunc;
	private JTextField textIdadeFunc;
	private JTextField textSexoFunc;
	private JTextField textCargoFunc;
	private JTextField textEnderecoFunc;
	private JTextField textCepFunc;
	private JTextField textPctMFunc;
	private JTextField textPctTFunc;

	private List<Compania> companias = new ArrayList<Compania>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 980, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblResultado = new JLabel("Resultado: ");
		lblResultado.setForeground(Color.GREEN);
		lblResultado.setFont(new Font("Arial", Font.BOLD, 15));
		lblResultado.setBounds(675, 276, 89, 31);
		frame.getContentPane().add(lblResultado);

		JLabel valorResult = new JLabel("");
		valorResult.setFont(new Font("Arial", Font.BOLD, 15));
		valorResult.setForeground(Color.GREEN);
		valorResult.setBounds(774, 276, 163, 31);
		frame.getContentPane().add(valorResult);

		lblResultado.setVisible(false);
		valorResult.setVisible(false);

		JLabel lblCompania = new JLabel("");
		lblCompania.setBounds(10, 11, 964, 71);
		frame.getContentPane().add(lblCompania);
		lblCompania.setFont(new Font("Arial", Font.BOLD, 20));
		lblCompania.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCalculoDeArvores = new JLabel("Quantidade de papeis em árvores");
		lblCalculoDeArvores.setBounds(675, 137, 228, 14);
		frame.getContentPane().add(lblCalculoDeArvores);
		lblCalculoDeArvores.setFont(new Font("Arial", Font.PLAIN, 15));

		JButton btnCalcule = new JButton("Calcule");

		btnCalcule.setBounds(675, 162, 228, 23);
		frame.getContentPane().add(btnCalcule);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 162, 303, 128);
		frame.getContentPane().add(scrollPane);

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);

		JLabel lblNewLabel = new JLabel("Lista Companhia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 137, 303, 20);
		frame.getContentPane().add(lblNewLabel);

		textNomeComp = new JTextField();
		textNomeComp.setBounds(131, 305, 182, 20);
		frame.getContentPane().add(textNomeComp);
		textNomeComp.setColumns(10);

		textAtuacaoComp = new JTextField();
		textAtuacaoComp.setColumns(10);
		textAtuacaoComp.setBounds(131, 336, 182, 20);
		frame.getContentPane().add(textAtuacaoComp);

		textCnpjComp = new JTextField();
		textCnpjComp.setColumns(10);
		textCnpjComp.setBounds(131, 367, 182, 20);
		frame.getContentPane().add(textCnpjComp);

		textEnderecoComp = new JTextField();
		textEnderecoComp.setColumns(10);
		textEnderecoComp.setBounds(131, 398, 182, 20);
		frame.getContentPane().add(textEnderecoComp);

		textCepComp = new JTextField();
		textCepComp.setColumns(10);
		textCepComp.setBounds(131, 429, 182, 20);
		frame.getContentPane().add(textCepComp);

		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setBounds(10, 308, 111, 14);
		frame.getContentPane().add(lblNome_1);

		JLabel lblAtuacao_1 = new JLabel("Atuação:");
		lblAtuacao_1.setBounds(10, 339, 111, 14);
		frame.getContentPane().add(lblAtuacao_1);

		JLabel lblCnpj_1 = new JLabel("CNPJ:");
		lblCnpj_1.setBounds(10, 370, 111, 14);
		frame.getContentPane().add(lblCnpj_1);

		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(10, 401, 111, 14);
		frame.getContentPane().add(lblEndereco);

		JLabel lblCep_1 = new JLabel("CEP:");
		lblCep_1.setBounds(10, 432, 111, 14);
		frame.getContentPane().add(lblCep_1);

		JButton btnCompania = new JButton(" Companhia:");
		btnCompania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				companias.add(new Compania(textNomeComp.getText(), textAtuacaoComp.getText(), textCnpjComp.getText(),
						textEnderecoComp.getText(), textCepComp.getText()));
				list.setListData(companias.stream().map(compania -> compania.getNome()).toArray());

			}
		});
		btnCompania.setBounds(131, 472, 182, 23);
		frame.getContentPane().add(btnCompania);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() >= 0) {
					companias.remove(list.getSelectedIndex());
					list.setListData(companias.stream().map(compania -> compania.getNome()).toArray());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma companhia:");
				}

			}
		});
		btnExcluir.setBounds(10, 472, 89, 23);
		frame.getContentPane().add(btnExcluir);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(324, 163, 301, 126);
		frame.getContentPane().add(scrollPane_1);

		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list_1);

		JLabel lblListaFuncionarios = new JLabel("Lista Funcionários:");
		lblListaFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaFuncionarios.setFont(new Font("Arial", Font.PLAIN, 15));
		lblListaFuncionarios.setBounds(324, 137, 303, 20);
		frame.getContentPane().add(lblListaFuncionarios);

		textNomeFunc = new JTextField();
		textNomeFunc.setColumns(10);
		textNomeFunc.setBounds(445, 305, 182, 20);
		frame.getContentPane().add(textNomeFunc);

		textIdadeFunc = new JTextField();
		textIdadeFunc.setColumns(10);
		textIdadeFunc.setBounds(445, 336, 182, 20);
		frame.getContentPane().add(textIdadeFunc);

		textSexoFunc = new JTextField();
		textSexoFunc.setColumns(10);
		textSexoFunc.setBounds(445, 367, 182, 20);
		frame.getContentPane().add(textSexoFunc);

		textCargoFunc = new JTextField();
		textCargoFunc.setColumns(10);
		textCargoFunc.setBounds(445, 398, 182, 20);
		frame.getContentPane().add(textCargoFunc);

		textEnderecoFunc = new JTextField();
		textEnderecoFunc.setColumns(10);
		textEnderecoFunc.setBounds(445, 429, 182, 20);
		frame.getContentPane().add(textEnderecoFunc);

		JLabel label = new JLabel("Nome:");
		label.setBounds(324, 308, 111, 14);
		frame.getContentPane().add(label);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(324, 339, 111, 14);
		frame.getContentPane().add(lblIdade);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(324, 370, 111, 14);
		frame.getContentPane().add(lblSexo);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(324, 401, 111, 14);
		frame.getContentPane().add(lblCargo);

		JLabel lblEndereco_1 = new JLabel("Endereço:");
		lblEndereco_1.setBounds(324, 432, 111, 14);
		frame.getContentPane().add(lblEndereco_1);

		textCepFunc = new JTextField();
		textCepFunc.setColumns(10);
		textCepFunc.setBounds(446, 460, 182, 20);
		frame.getContentPane().add(textCepFunc);

		textPctMFunc = new JTextField();
		textPctMFunc.setColumns(10);
		textPctMFunc.setBounds(498, 491, 130, 20);
		frame.getContentPane().add(textPctMFunc);

		textPctTFunc = new JTextField();
		textPctTFunc.setColumns(10);
		textPctTFunc.setBounds(498, 522, 130, 20);
		frame.getContentPane().add(textPctTFunc);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(325, 463, 111, 14);
		frame.getContentPane().add(lblCep);

		JLabel lblPacotesDePapel = new JLabel("Pacotes de papeis por mês:");
		lblPacotesDePapel.setBounds(325, 494, 163, 14);
		frame.getContentPane().add(lblPacotesDePapel);

		JLabel lblTipoDePacote = new JLabel("Tipo de folha: ");
		lblTipoDePacote.setBounds(325, 525, 111, 14);
		frame.getContentPane().add(lblTipoDePacote);

		JButton btnFuncionario = new JButton(" Funcionário");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() >= 0) {
					companias.get(list.getSelectedIndex()).adicionarEmpregado(textNomeFunc.getText(),
							Integer.parseInt(textIdadeFunc.getText()), textSexoFunc.getText().charAt(0),
							textCargoFunc.getText(), textEnderecoFunc.getText(), textCepFunc.getText(),
							Integer.parseInt(textPctMFunc.getText()), textPctTFunc.getText());
					list_1.setListData(companias.get(list.getSelectedIndex()).getEmpregados().stream()
							.map(empregado -> empregado.getNome()).toArray());
				} else {
					JOptionPane.showMessageDialog(null, "Adicione uma companhia");
				}

			}
		});
		btnFuncionario.setBounds(486, 564, 139, 123);
		frame.getContentPane().add(btnFuncionario);

		JButton btnExcluirFuncionario = new JButton("Excluir Funcionário");
		btnExcluirFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() >= 0 && list_1.getSelectedIndex() >= 0) {
					companias.get(list.getSelectedIndex()).removerEmpregado(list_1.getSelectedIndex());
					list_1.setListData(companias.get(list.getSelectedIndex()).getEmpregados().stream()
							.map(empregado -> empregado.getNome()).toArray());
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma compania e um funcionário");
				}
			}
		});
		btnExcluirFuncionario.setBounds(324, 564, 121, 23);
		frame.getContentPane().add(btnExcluirFuncionario);

		JButton btnNewButton = new JButton("Atualizar Listas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {
					list_1.setListData(companias.get(list.getSelectedIndex()).getEmpregados().stream()
							.map(empregado -> empregado.getNome()).toArray());
				} else {
					list.setListData(companias.stream().map(compania -> compania.getNome()).toArray());
					list_1.setListData(new ArrayList<String>().toArray());
				}

			}
		});
		btnNewButton.setBounds(10, 564, 303, 23);
		frame.getContentPane().add(btnNewButton);

		btnCalcule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (list.getSelectedIndex() >= 0) {
					lblResultado.setText("" + companias.get(list.getSelectedIndex()).mediaAnoArvoresDesmatadas());
				}

				lblResultado.setVisible(true);
				valorResult.setVisible(true);
			}
		});

		if (companias.size() == 0) {
			lblCompania.setText("APS 2019.");
		}
	}
}
