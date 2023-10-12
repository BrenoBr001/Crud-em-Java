package view;
import controler.Criptografia;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.Criptografia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;

public class Jlogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jlogin frame = new Jlogin();
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
	public Jlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 556);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(242, 93, 379, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(51, 55, 80, 14);
		panel.add(lblNewLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textFieldUsuario.setBounds(146, 52, 149, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 116, 68, 14);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		passwordField.setBounds(146, 113, 149, 20);
		panel.add(passwordField);
		
		//evento no botão "Entrar"
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Criptografia criptografia = new Criptografia(passwordField.getText(), Criptografia.MD5);
						try {
							System.out.println(criptografia.criptografar());
						} catch (NoSuchAlgorithmException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					if(textFieldUsuario.getText()!= null && !textFieldUsuario.getText().isEmpty() &&
					passwordField.getText()!= null && !passwordField.getText().isEmpty()) {
				try {
					if(criptografia.criptografar().equals("4BADAEE57FED5610012A296273158F5F")){
						JOptionPane.showMessageDialog(btnNewButton, "Informações Válidas");
						dispose();
					JPrincipal jPrincipal = new JPrincipal();
					jPrincipal.setLocationRelativeTo(null);
					jPrincipal.setVisible(true);
					
					}
				} catch (HeadlessException | NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				}else {
				JOptionPane.showMessageDialog(btnNewButton, "Informações Iválidas");
			}
		}
		});
		
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(162, 170, 111, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Bem Vindo(a)!");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(184, 11, 89, 14);
		panel.add(lblNewLabel_2);
	}
}
