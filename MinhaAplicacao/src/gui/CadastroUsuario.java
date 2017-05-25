package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDAO;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JTextField email;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CadastroUsuario frame = new CadastroUsuario();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Cadastro Usuario");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCadastroNovoUsuario = new JLabel("Cadastro Novo Usuario");
		lblCadastroNovoUsuario.setBounds(25, 10, 145, 16);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 45, 41, 16);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(25, 70, 27, 16);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setBounds(25, 93, 42, 16);
		
		
		
		nome = new JTextField();
		nome.setBounds(79, 88, 130, 26);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(79, 65, 130, 26);
		cpf.setColumns(10);
		
		email = new JTextField();
		email.setBounds(78, 40, 130, 26);
		email.setColumns(10);
		
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				// instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
				Usuario usuarios = new Usuario();
				usuarios.setEmail(email.getText());
				usuarios.setCpf(cpf.getText());
				usuarios.setNome(nome.getText());	
				usuarios.setSenha(senha.getText());

				// fazendo a validação dos dados
				if(nome.getText().isEmpty() || cpf.getText().isEmpty() || email.getText().isEmpty() || senha.getText().isEmpty()) {
				   JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
				}
				else {

				    // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
				    UsuarioDAO dao = new UsuarioDAO();
				    dao.adiciona(usuarios);
				    System.out.println(usuarios);
				    JOptionPane.showMessageDialog(null, "Usuário "+nome.getText()+" inserido com sucesso! ");
				}

				// apaga os dados preenchidos nos campos de texto
				nome.setText("");
				cpf.setText("");
				email.setText("");
				senha.setText("");
			}
		});
		btnCadastrar.setBounds(88, 189, 121, 29);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(215, 189, 90, 29);
		btnLimpar.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				cpf.setText("");
				email.setText("");
				senha.setText("");
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblCadastroNovoUsuario);
		contentPane.add(lblNome);
		contentPane.add(lblCpf);
		contentPane.add(lblEmail);
		contentPane.add(nome);
		contentPane.add(cpf);
		contentPane.add(email); 
		contentPane.add(btnCadastrar);
		contentPane.add(btnLimpar);
		
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				contentPane.setVisible(false);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnSair.setBounds(143, 230, 117, 29);
		contentPane.add(btnSair);
		
		senha = new JPasswordField();
		senha.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			}
		});
		senha.setBounds(79, 116, 130, 26);
		contentPane.add(senha);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(25, 121, 61, 16);
		contentPane.add(lblSenha);
	}
}
