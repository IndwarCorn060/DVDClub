package clases;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaCreacion extends JDialog{
	
	private static final long serialVersionUID = 1L;

	//dialogo para creacion
	private JLabel crear_etqtNombrePeli, crear_etqtNombreCliente;
	private JTextField crear_txtFilePeli, crear_txtFileCliente;
	private JButton crear_btnCrear1, crear_btnCrear2;
		
	private JPanel crear_pNorte, crear_pNorte_p1, crear_pNorte_p2, crear_pNorte_p3, crear_pSur;
		
	private void crearComponentes() {
		this.crear_etqtNombrePeli = new JLabel("Nombre fichero peliculas:");
		this.crear_etqtNombreCliente = new JLabel("Nombre fichero clientes:");
		this.crear_btnCrear1 = new JButton("Crear DVDClub");
		this.crear_btnCrear2 = new JButton("Crear DVDClub");
		this.crear_txtFilePeli = new JTextField(10);
		this.crear_txtFileCliente = new JTextField(10);
		this.crear_pNorte = new JPanel();
		this.crear_pNorte.setLayout(new BoxLayout(this.crear_pNorte, BoxLayout.Y_AXIS));
		this.crear_pNorte.setBorder(BorderFactory.createTitledBorder("Creacion DVDClub a partir de datos Existentes"));
		this.crear_pNorte_p1 = new JPanel();
		this.crear_pNorte_p2 = new JPanel();
		this.crear_pNorte_p3 = new JPanel();
		this.crear_pSur = new JPanel();
		this.crear_pSur.setBorder(BorderFactory.createTitledBorder("Creacion DVDClub sin datos previos(en Blanco)"));
	}
	
	private void montarComponentes(JPanel cp) {
		cp.add(this.crear_pNorte);
			this.crear_pNorte.add(this.crear_pNorte_p1);
				this.crear_pNorte_p1.add(this.crear_etqtNombrePeli);
				this.crear_pNorte_p1.add(this.crear_txtFilePeli);
			this.crear_pNorte.add(this.crear_pNorte_p2);
				this.crear_pNorte_p2.add(this.crear_etqtNombreCliente);
				this.crear_pNorte_p2.add(this.crear_txtFileCliente);
			this.crear_pNorte.add(this.crear_pNorte_p3);
				this.crear_pNorte_p3.add(this.crear_btnCrear1);
		cp.add(this.crear_pSur);
			this.crear_pSur.add(this.crear_btnCrear2);
	}
	
	public VentanaCreacion() {
		this.setModal(true);
		//super("Creacion DVDClub");
		this.crearComponentes();
		//Container cp = this.getContentPane();
		//cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		JPanel cp = new JPanel();
		this.montarComponentes(cp);
		this.add(cp);
		ControlBoton control = new ControlBoton();
		this.crear_btnCrear1.addActionListener(control);
		this.crear_btnCrear2.addActionListener(control);
		
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	class ControlBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==crear_btnCrear1) {
				
			}
			else if(e.getSource()==crear_btnCrear2) {
				
			}
		}
		
	}

}
