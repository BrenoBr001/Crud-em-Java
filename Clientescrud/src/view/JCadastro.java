package view;

import view.JPrincipal;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import controler.Conexao;
import model.Usuario;
import view.JPrincipal;

import dao.DAO;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Cliente;
public class JCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpfcnpj;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextArea textAreaEndereco;
	private JButton btnNewButton_1;
	private JTextField textFieldEndereco;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastro frame = new JCadastro(null, null);
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
	public JCadastro(Cliente clienteSelecionado, JPrincipal jPrincipal) {
		DAO dao = new DAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 556);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setForeground(SystemColor.windowText);
		contentPane.setFocusTraversalPolicyProvider(true);
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(108, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textFieldNome.setBounds(108, 36, 662, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPFCNPJ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(108, 79, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(474, 79, 112, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldCpfcnpj = new JTextField();
		textFieldCpfcnpj.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textFieldCpfcnpj.setBounds(108, 104, 304, 20);
		contentPane.add(textFieldCpfcnpj);
		textFieldCpfcnpj.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(474, 104, 296, 20);
		contentPane.add(textFieldTelefone);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(108, 158, 62, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textFieldEmail.setBounds(108, 183, 662, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(108, 227, 80, 20);
		contentPane.add(lblNewLabel_4);
		

		
		JButton btnNewButtonIncluir = new JButton(clienteSelecionado == null ? "Incluir" : "Alterar"); //precisa funcionar a logica de alterar
		btnNewButtonIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				//String id, String nome, String cpfcnpj, String email, String telefone, String endereco
				Cliente cliente = new Cliente(null, textFieldNome.getText(), textFieldCpfcnpj.getText(), 
						textFieldEmail.getText(), textFieldTelefone.getText(), textFieldEndereco.getText());
				if(clienteSelecionado==null) {
					if(!"".equalsIgnoreCase(textFieldNome.getText()) && !"".equalsIgnoreCase(textFieldCpfcnpj.getText())){
						dao.cadastrarCliente(cliente);
						abrirTelaPrincipal(jPrincipal);
					}else {
						JOptionPane.showMessageDialog(null, "Confira os campos Nome e CPF/CNPJ");
					}
				
				}else {
					if(!"".equalsIgnoreCase(textFieldNome.getText()) && !"".equalsIgnoreCase(textFieldCpfcnpj.getText())){
					dao.alterarCliente(clienteSelecionado.getId(), cliente);
					abrirTelaPrincipal(jPrincipal);
				}else {
					JOptionPane.showMessageDialog(null, "Confira os campos Nome e CPF/CNPJ");
				}
			}
			}
			});
		
		btnNewButtonIncluir.setForeground(SystemColor.text);
		btnNewButtonIncluir.setBackground(SystemColor.textHighlight);
		btnNewButtonIncluir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButtonIncluir.setBounds(643, 356, 127, 23);
		contentPane.add(btnNewButtonIncluir);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.excluirCliente(clienteSelecionado.getId());
				abrirTelaPrincipal(jPrincipal);
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(108, 356, 127, 23);
		btnNewButton.setVisible(false);
		contentPane.add(btnNewButton);
		
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textFieldEndereco.setBounds(108, 258, 662, 20);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		if(clienteSelecionado!=null) {
		preencherCampos(clienteSelecionado);
		btnNewButton.setVisible(true);
		}
	}
		
		private void preencherCampos(Cliente clienteSelecionado) {
			textFieldNome.setText(clienteSelecionado.getNome());
			textFieldCpfcnpj.setText(clienteSelecionado.getCpfcnpj());
			textFieldEmail.setText(clienteSelecionado.getEmail());
			textFieldTelefone.setText(clienteSelecionado.getTelefone());
			textFieldEndereco.setText(clienteSelecionado.getEndereco());}
			
			private void abrirTelaPrincipal(JPrincipal jPrincipal) {
				jPrincipal.dispose();
				jPrincipal = new JPrincipal();
				jPrincipal.setLocationRelativeTo(jPrincipal);
				jPrincipal.setVisible(true);
			}
		
	}

