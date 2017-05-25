package Tvs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class TvSenhaNormal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TvSenhaNormal frame = new TvSenhaNormal();
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
	public TvSenhaNormal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGuich = new JLabel("GUICHÊ");
		lblGuich.setBounds(6, 25, 61, 16);
		contentPane.add(lblGuich);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(6, 149, 61, 16);
		contentPane.add(lblSenha);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblGuich, lblSenha}));
	}

}
