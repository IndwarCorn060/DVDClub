package clases;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaCreacion extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Vista miVista;
	private JFrame ventana;
	private DVDClub club;
	private Controlador controlador;

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
		this.crear_txtFilePeli = new JTextField("peliculas.txt",10);
		this.crear_txtFileCliente = new JTextField("clientes.txt",10);
		this.crear_pNorte = new JPanel();
		this.crear_pNorte.setLayout(new BoxLayout(this.crear_pNorte, BoxLayout.Y_AXIS));
		this.crear_pNorte.setBorder(BorderFactory.createTitledBorder("Creacion DVDClub a partir de datos Existentes"));
		this.crear_pNorte_p1 = new JPanel();
		this.crear_pNorte_p2 = new JPanel();
		this.crear_pNorte_p3 = new JPanel();
		this.crear_pSur = new JPanel();
		this.crear_pSur.setBorder(BorderFactory.createTitledBorder("Creacion DVDClub sin datos previos(en Blanco)"));
	}
	
	private void montarComponentes(Container cp) {
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
		super("Creacion DVDClub");
		this.crearComponentes();
		Container cp = this.getContentPane();
		//JPanel cp = new JPanel();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		this.montarComponentes(cp);
		this.crear_btnCrear1.addActionListener(this);
		this.crear_btnCrear2.addActionListener(this);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.miVista = new Vista();
		this.ventana = new JFrame("inmoviliaria");
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setResizable(false);
		ventana.setVisible(true);
		this.dispose();
		if(e.getSource()==this.crear_btnCrear1) {
			this.club = new DVDClub(this.crear_txtFilePeli.getText(),this.crear_txtFileCliente.getText());
		}
		else if (e.getSource()==this.crear_btnCrear2) {
			this.club = new DVDClub();
		}
		this.controlador = new Controlador(miVista, this.club);
		this.miVista.control(this.controlador);
		this.controlador.actualizar();
	}

}
