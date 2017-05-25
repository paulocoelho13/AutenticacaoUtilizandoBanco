package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ProximaSenha.ChamarProximaSenha;
import Tvs.TvSenhaNormal;
import factory.ConnectionFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import dao.UsuarioDAO;
import modelo.Usuario;


public class Login extends JFrame {

	protected static final Object Entrar = null;
	private Connection connection;

	private JTextField txtUsuario;
	private JPasswordField txTSenha;
	private JButton login, limpa;
	private JButton cadastrar;
	private JLabel user, pass;
	CadastroUsuario cadastroUsuario = new CadastroUsuario();
	// TvSenhaNormal tvSenhaNormal = new TvSenhaNormal();
	ChamarProximaSenha chamarProximaSenha = new ChamarProximaSenha();
	
	
	public void logar() {
		String sql = "SELECT * FROM usuarios WHERE cpf =? and senha =?";
		try {
			// as linhas abaixo preparam a consulta ao banco em funcao do
			// que foi digitado nas caixas de texto. o ? é subsastituido pelo
			// conteudo das variaveis
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, txtUsuario.getText());
			stmt.setString(2, txTSenha.getText());

			// a linha abaixo executa a query
			ResultSet resultSet = stmt.executeQuery();

			// se existir usuario e senha correspondente
			if (resultSet.next()) {
				chamarProximaSenha.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha Invalida");
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DEU PAU");
		}
	}
	public Login() {
		super("Login em Java");
		this.connection = new ConnectionFactory().getConnection();
		setAutoRequestFocus(false);
		getContentPane().setLayout(null);

		user = new JLabel("Usuário:");
		user.setBounds(72, 34, 52, 16);
		getContentPane().add(user);

		txtUsuario = new JTextField(15);
		txtUsuario.setBounds(129, 29, 190, 26);
		getContentPane().add(txtUsuario);

		pass = new JLabel("Senha:   ");
		pass.setBounds(72, 62, 53, 16);
		getContentPane().add(pass);

		txTSenha = new JPasswordField(15);
		txTSenha.setBounds(129, 57, 190, 26);
		getContentPane().add(txTSenha);

		login = new JButton("Entrar");
		login.setBounds(129, 113, 81, 29);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				logar();
				// chamando o metodo logar

			}
		}

		);

		getContentPane().add(login);

		limpa = new JButton("Limpar");
		limpa.setBounds(172, 177, 87, 29);
		limpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (evento.getSource() == limpa) {
					txtUsuario.setText("");
					txTSenha.setText("");
				}
			}
		});
		getContentPane().add(limpa);

		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(222, 113, 104, 29);
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (evento.getSource() == cadastrar) {
					cadastroUsuario.setVisible(true);
				}
			}
		});
		getContentPane().add(cadastrar);
	}



}
