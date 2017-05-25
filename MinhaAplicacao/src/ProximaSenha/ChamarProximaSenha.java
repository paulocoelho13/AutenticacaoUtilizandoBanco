package ProximaSenha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JCheckBox;

public class ChamarProximaSenha extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
		/**
	 * Create the frame.
	 */
	public ChamarProximaSenha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNextSenha = new JButton("Next Senha");
		btnNextSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNextSenha.setBounds(146, 114, 117, 29);
		contentPane.add(btnNextSenha);
		
		JCheckBox chckbxPreferencial = new JCheckBox("Preferencial");
		chckbxPreferencial.setBounds(146, 149, 128, 23);
		contentPane.add(chckbxPreferencial);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}
}
