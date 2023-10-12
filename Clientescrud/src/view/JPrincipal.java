package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextArea;
import controler.Conexao;
import dao.DAO;
import dao.bd;
import model.Cliente;
import model.ModeloTabela;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class JPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBuscar;
	private JTable table;
	private ArrayList<Cliente>clientes;
	private JTextArea textAreaEndereco;
	private JPrincipal jPrincipal;
	private TableRowSorter<ModeloTabela> rowSorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JPrincipal() {
		this.jPrincipal = this;
		DAO dao = new DAO();
		try {
			clientes = dao.listarClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
// JTextArea textAreaEndereco = new JTextArea();
//		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 556);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastro jCadastro = new JCadastro(null, jPrincipal); 
				jCadastro.setLocationRelativeTo(jCadastro);
				jCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				jCadastro.setVisible(true);
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(34, 38, 137, 23);
		contentPane.add(btnNewButton);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filtrar();
			}


		});
		textFieldBuscar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textFieldBuscar.setBounds(181, 37, 635, 23);
		contentPane.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 95, 782, 350);
		contentPane.add(scrollPane);
		
		ModeloTabela modeloTabela = new ModeloTabela(clientes);
		
		table = new JTable();
		table.setModel(modeloTabela);
		table.addMouseListener(new MouseAdapter() {
			@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton()==1 ) { //1 botao esquerdo do mouse 2 scroll, 3 botao direito;
				try {
					Cliente clienteSelecionado = dao.consultarCliente(modeloTabela.getValueAt(table.getSelectedRow(),0).toString());
					JCadastro jCadastro = new JCadastro(clienteSelecionado, jPrincipal);
					jCadastro.setLocationRelativeTo(jCadastro);
					jCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					jCadastro.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		}
		});
		rowSorter = new TableRowSorter<>(modeloTabela);
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);

	}
	private void filtrar() {
		String busca = textFieldBuscar.getText().trim();
		if(busca.length()== 0) {
			rowSorter.setRowFilter(null);
		}else {
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+busca));
		}
			
	}
}
