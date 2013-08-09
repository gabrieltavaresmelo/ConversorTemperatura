package br.com.temperatura;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import br.com.temperatura.view.ConversorOverview;

public class MainApplication {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {				
				ConversorOverview telaPrincipal = new ConversorOverview();
				telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				telaPrincipal.setVisible(true);
			}
		});
	}
}
