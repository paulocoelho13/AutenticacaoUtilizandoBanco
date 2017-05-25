package Principal;

import javax.swing.JFrame;

import gui.Login;

public class Main {
	public static void main(String[] args) {
		  Login texfield = new Login();
		  
		  texfield.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  texfield.setSize(460,230);
		  texfield.setVisible(true);
	}

}