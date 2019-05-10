package clases;

import java.awt.*;

import javax.swing.*;

public class Vista extends JPanel{
	
	private static final long serialVersionUID = 1L;

	//principal
	private JTabbedPane tabbedPane;
	
	//añadir peliculas
	private JTextField pes1_txtCodigo, pes1_txtTitulo, pes1_txtDirector;
	private JTextArea pes1_txtActores;
	private JButton pes1_btnAnadir, pes1_btnCancelar;
	
	private JPanel pes1, pes1_p1, pes1_p1_pCentro, pes1_p1_pCentro_p1, pes1_p1_pCentro_p1_cod, pes1_p1_pCentro_p1_titulo, pes1_p1_pCentro_p1_director, pes1_p1_pCentro_actores, pes1_p1_pSur;
	private JScrollPane pes1_txtActores_Scroll;
	
	//Añadir cliente
	private JTextField pes2_txtCliente;
	private JButton pes2_btnAnadir, pes2_btnCancelar;
	
	private JPanel pes2, pes2_p1, pes2_p2;
	
	//peliculas Disponibles
	private JTextArea pes3_txtDVDDisponibles;
	private JScrollPane pes3_txtDVDDisponibles_Scroll;
	private JButton pes3_btnActualizar;
	
	private JPanel pes3, pes3_p1;
	
	//alquiler peliculas
	private JLabel pes4_etqtListClien, pes4_etqtListPeli;
	private JComboBox<Cliente> pes4_boxListClien;
	private JComboBox<DVD> pes4_boxListPeli;
	private JButton pes4_btnAlquilar, pes4_btnCancelar;
	
	private JPanel pes4, pes4_p1, pes4_p1_p1, pes4_p1_p2, pes4_p1_p3;
	
	//devolver pelicula
	private JLabel pes5_etqtListClien, pes5_etqtListPeli;
	private JComboBox<Cliente> pes5_boxListClien;
	private JComboBox<DVD> pes5_boxListPeli;
	private JButton pes5_btnDevolver, pes5_btnCancelar;
	
	private JPanel pes5, pes5_p1, pes5_p1_p1, pes5_p1_p2, pes5_p1_p3;
	
	private void crearComponentesPes1() {
		this.pes1_btnAnadir = new JButton("Añadir");
		this.pes1_btnCancelar = new JButton("Cancelar");
		this.pes1_txtCodigo = new JTextField(8);
		this.pes1_txtTitulo = new JTextField(12);
		this.pes1_txtDirector = new JTextField(12);
		this.pes1_txtActores = new JTextArea("nombres separados por lienas",3,15);
		this.pes1_txtActores_Scroll = new JScrollPane(this.pes1_txtActores);
		
		this.pes1 = new JPanel();
		this.pes1_p1 = new JPanel();
		this.pes1_p1.setLayout(new BorderLayout());
		this.pes1_p1.setBorder(BorderFactory.createTitledBorder("DATOS PELICULA"));
		this.pes1_p1_pCentro = new JPanel();
		this.pes1_p1_pCentro.setLayout(new GridLayout(1,2));
		this.pes1_p1_pCentro_p1 = new JPanel();
		this.pes1_p1_pCentro_p1.setLayout(new GridLayout(3,1));
		this.pes1_p1_pCentro_p1_cod = new JPanel();
		this.pes1_p1_pCentro_p1_cod.setBorder(BorderFactory.createTitledBorder("Codigo"));
		this.pes1_p1_pCentro_p1_titulo = new JPanel();
		this.pes1_p1_pCentro_p1_titulo.setBorder(BorderFactory.createTitledBorder("Titulo"));
		this.pes1_p1_pCentro_p1_director = new JPanel();
		this.pes1_p1_pCentro_p1_director.setBorder(BorderFactory.createTitledBorder("Director"));
		this.pes1_p1_pCentro_actores = new JPanel();
		this.pes1_p1_pCentro_actores.setBorder(BorderFactory.createTitledBorder("Actores"));
		this.pes1_p1_pSur = new JPanel();
	}
	
	private void crearComponentesPes2() {
		this.pes2_txtCliente = new JTextField(12);
		this.pes2_btnAnadir = new JButton("Añadir");
		this.pes2_btnCancelar = new JButton("Cancelar");
		
		this.pes2 = new JPanel();
		this.pes2.setLayout(new BorderLayout());
		this.pes2_p1 = new JPanel();
		this.pes2_p1.setBorder(BorderFactory.createTitledBorder("Nombre del Cliente"));
		this.pes2_p2 = new JPanel();
	}
	
	private void crearComponentesPes3() {
		this.pes3_txtDVDDisponibles = new JTextArea(15,40);
		this.pes3_txtDVDDisponibles.setEditable(false);
		this.pes3_txtDVDDisponibles_Scroll = new JScrollPane(this.pes3_txtDVDDisponibles);
		this.pes3_btnActualizar = new JButton("Actualizar lista");
		
		this.pes3 = new JPanel();
		this.pes3.setLayout(new BorderLayout());
		this.pes3_p1 = new JPanel();
		this.pes3_p1.setBorder(BorderFactory.createTitledBorder("Peliculas disponibles en el DVDClub"));
	}
	
	private void crearComponentesPes4() {
		this.pes4_etqtListClien = new JLabel("Listado de Clientes");
		this.pes4_etqtListPeli = new JLabel("Listado de Peliculas");
		this.pes4_boxListClien = new JComboBox<Cliente>();
		this.pes4_boxListPeli = new JComboBox<DVD>();
		this.pes4_btnAlquilar = new JButton("Alquilar");
		this.pes4_btnCancelar = new JButton("Cancelar");
		
		this.pes4 = new JPanel();
		this.pes4_p1 = new JPanel();
		this.pes4_p1.setLayout(new BoxLayout(this.pes4_p1, BoxLayout.Y_AXIS));
		this.pes4_p1.setBorder(BorderFactory.createTitledBorder("Alquiler de Peliculas"));
		this.pes4_p1_p1 = new JPanel();
		this.pes4_p1_p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.pes4_p1_p2 = new JPanel();
		this.pes4_p1_p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.pes4_p1_p3 = new JPanel();
	}
	
	private void crearComponentesPes5() {
		this.pes5_etqtListClien = new JLabel("Listado de Clientes");
		this.pes5_etqtListPeli = new JLabel("Peliculas alquiladas");
		this.pes5_boxListClien = new JComboBox<Cliente>();
		this.pes5_boxListPeli = new JComboBox<DVD>();
		this.pes5_btnDevolver = new JButton("Devolver");
		this.pes5_btnCancelar = new JButton("Cancelar");
		
		this.pes5 = new JPanel();
		this.pes5_p1 = new JPanel();
		this.pes5_p1.setLayout(new BoxLayout(this.pes5_p1, BoxLayout.Y_AXIS));
		this.pes5_p1.setBorder(BorderFactory.createTitledBorder("Alquiler de Peliculas"));
		this.pes5_p1_p1 = new JPanel();
		this.pes5_p1_p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.pes5_p1_p2 = new JPanel();
		this.pes5_p1_p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.pes5_p1_p3 = new JPanel();
	}
	
	private void crearComponentes() {
		this.crearComponentesPes1();
		this.crearComponentesPes2();
		this.crearComponentesPes3();
		this.crearComponentesPes4();
		this.crearComponentesPes5();
		this.tabbedPane = new JTabbedPane();
		setLayout(new GridLayout(1, 1));
	}
	
	private void montarComponentesPes1() {
		this.pes1.add(this.pes1_p1);
			this.pes1_p1.add(this.pes1_p1_pCentro, BorderLayout.CENTER);
				this.pes1_p1_pCentro.add(this.pes1_p1_pCentro_p1);
					this.pes1_p1_pCentro_p1.add(this.pes1_p1_pCentro_p1_cod);
						this.pes1_p1_pCentro_p1_cod.add(this.pes1_txtCodigo);
					this.pes1_p1_pCentro_p1.add(this.pes1_p1_pCentro_p1_titulo);
						this.pes1_p1_pCentro_p1_titulo.add(this.pes1_txtTitulo);
					this.pes1_p1_pCentro_p1.add(this.pes1_p1_pCentro_p1_director);
						this.pes1_p1_pCentro_p1_director.add(this.pes1_txtDirector);
				this.pes1_p1_pCentro.add(this.pes1_p1_pCentro_actores);
					this.pes1_p1_pCentro_actores.add(this.pes1_txtActores_Scroll);
			this.pes1_p1.add(this.pes1_p1_pSur, BorderLayout.SOUTH);
				this.pes1_p1_pSur.add(this.pes1_btnAnadir);
				this.pes1_p1_pSur.add(this.pes1_btnCancelar);
	}
	
	private void montarComponentesPes2() {
		this.pes2.add(this.pes2_p1, BorderLayout.CENTER);
			this.pes2_p1.add(this.pes2_txtCliente);
		this.pes2.add(this.pes2_p2, BorderLayout.SOUTH);
			this.pes2_p2.add(this.pes2_btnAnadir);
			this.pes2_p2.add(this.pes2_btnCancelar);
	}
	
	private void montarComponentesPes3() {
		this.pes3.add(this.pes3_p1, BorderLayout.CENTER);
			this.pes3_p1.add(this.pes3_txtDVDDisponibles_Scroll);
		this.pes3.add(this.pes3_btnActualizar, BorderLayout.SOUTH);
	}

	private void montarComponentesPes4() {
		this.pes4.add(this.pes4_p1);
		this.pes4_p1.add(this.pes4_p1_p1);
			this.pes4_p1_p1.add(this.pes4_etqtListClien);
			this.pes4_p1_p1.add(this.pes4_boxListClien);
		this.pes4_p1.add(this.pes4_p1_p2);
			this.pes4_p1_p2.add(this.pes4_etqtListPeli);
			this.pes4_p1_p2.add(this.pes4_boxListPeli);
		this.pes4_p1.add(this.pes4_p1_p3);
			this.pes4_p1_p3.add(this.pes4_btnAlquilar);
			this.pes4_p1_p3.add(this.pes4_btnCancelar);
	}
	
	private void montarComponentesPes5() {
		this.pes5.add(this.pes5_p1);
			this.pes5_p1.add(this.pes5_p1_p1);
				this.pes5_p1_p1.add(this.pes5_etqtListClien);
				this.pes5_p1_p1.add(this.pes5_boxListClien);
			this.pes5_p1.add(this.pes5_p1_p2);
				this.pes5_p1_p2.add(this.pes5_etqtListPeli);
				this.pes5_p1_p2.add(this.pes5_boxListPeli);
			this.pes5_p1.add(this.pes5_p1_p3);
				this.pes5_p1_p3.add(this.pes5_btnDevolver);
				this.pes5_p1_p3.add(this.pes5_btnCancelar);
	}
	
	private void montarComponentes() {
		this.montarComponentesPes1();
		this.tabbedPane.addTab("Añadir películas", this.pes1);
		this.montarComponentesPes2();
		this.tabbedPane.addTab("Añadir cliente", this.pes2);
		this.montarComponentesPes3();
		this.tabbedPane.addTab("Peliculas disponibles", this.pes3);
		this.montarComponentesPes4();
		this.tabbedPane.addTab("Alquiler peliculas", this.pes4);
		this.montarComponentesPes5();
		this.tabbedPane.addTab("Devolver películas", this.pes5);
	}
	
	public Vista() {
		VentanaCreacion creacion = new VentanaCreacion();
		this.crearComponentes();
		this.montarComponentes();
		this.setPreferredSize(new Dimension(610,350));
		this.add(this.tabbedPane);
	}

}
