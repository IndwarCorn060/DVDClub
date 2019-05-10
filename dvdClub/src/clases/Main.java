package clases;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vista miVista = new Vista();
		JFrame ventana = new JFrame("inmoviliaria");
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setResizable(false);
		ventana.setVisible(true);
	}

}
