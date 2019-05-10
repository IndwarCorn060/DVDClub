package clases;

import javax.swing.JFrame;

public class Prueba {

	public static void main(String[] args) throws DVDClubException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
				Vista miVista = new Vista();
				
				// Crear un objeto Controlador (programa los eventos)
				//Controlador ctr = new Controlador(miVista,misPropiedades);
				// Llamar al método que añade "control" a los componentes
				//miVista.control(ctr);
				
				// Crear el objeto Ventana (JFrame)
				JFrame ventana = new JFrame("inmoviliaria");
				ventana.setContentPane(miVista);
				ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventana.pack();
				ventana.setResizable(false);
				ventana.setVisible(true);
	}

}
