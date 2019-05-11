package clases;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Controlador implements ActionListener, ItemListener{
	
	private Vista mivista;
	private DVDClub club;

	public Controlador(Vista miVista, DVDClub club) {
		this.mivista = miVista;
		this.club = club;
	}
	
	private void llenarComboBox(JComboBox<String> box, TreeSet<?> lista) {
		box.removeAllItems();
		Iterator<?> i = lista.iterator();
		Object aux;
		while(i.hasNext()) {
			aux = i.next();
			if(aux instanceof Cliente) {
				box.addItem(((Cliente) aux).getNombre());
			}
			if(aux instanceof DVD) {
				box.addItem(((DVD) aux).getTitulo());
			}
		}
	}
	
	private void actualizarPanel() {
		this.mivista.getPes3_txtDVDDisponibles().setText("PLICULAS DISPONIBLES EN EL DVD CLUB:\n");
		Iterator<DVD> i = this.club.getDvds().iterator();
		DVD aux;
		while(i.hasNext()) {
			aux = i.next();
			this.mivista.getPes3_txtDVDDisponibles().append(aux.toString());
		}
	}
	
	public void actualizar() {
		this.actualizarPanel();
		this.llenarComboBox(this.mivista.getPes4_boxListClien(), this.club.getClientes());
		this.llenarComboBox(this.mivista.getPes4_boxListPeli(), this.club.getDvds());
		this.llenarComboBox(this.mivista.getPes5_boxListClien(), this.club.getClientes());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.mivista.getPes1_btnAnadir()) {
			try {
				Integer.parseInt(this.mivista.getPes1_txtCodigo().getText());
				String cod = this.mivista.getPes1_txtCodigo().getText();
				String titulo = this.mivista.getPes1_txtTitulo().getText();
				String director = this.mivista.getPes1_txtDirector().getText();
				String actoresString = this.mivista.getPes1_txtActores().getText();
				StringTokenizer i = new StringTokenizer(actoresString, "\n");
				List<String> actores = new LinkedList<String>();
				while(i.hasMoreTokens()) {
					actores.add(i.nextToken());
				}
				if(!this.club.anadirDVD(cod, titulo, director, actores)) {
					JOptionPane.showMessageDialog(null, "El codigo ya esta en uso", "Error", JOptionPane.ERROR_MESSAGE);
				}
				this.actualizar();
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Datos mal introducidos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource()==this.mivista.getPes1_btnCancelar()) {
			this.mivista.getPes1_txtCodigo().setText("");
			this.mivista.getPes1_txtTitulo().setText("");
			this.mivista.getPes1_txtDirector().setText("");
			this.mivista.getPes1_txtActores().setText("");
		}
		else if(e.getSource()==this.mivista.getPes2_btnAnadir()&&!this.mivista.getPes2_txtCliente().getText().equals("")) {
			this.club.anadirCliente(this.mivista.getPes2_txtCliente().getText());
			actualizar();
		}
		else if(e.getSource()==this.mivista.getPes2_btnCancelar()) {
			this.mivista.getPes2_txtCliente().setText("");
		}
		else if(e.getSource()==this.mivista.getPes3_btnActualizar()) {
			this.actualizar();
		}
		else if(e.getSource()==this.mivista.getPes4_btnAlquilar()&&this.mivista.getPes4_boxListPeli().getSelectedItem()!=null) {
			int selected = this.mivista.getPes4_boxListClien().getSelectedIndex();
			try {
				this.club.alquila((String)this.mivista.getPes4_boxListPeli().getSelectedItem(), (String)this.mivista.getPes4_boxListClien().getSelectedItem());
			} catch (DVDClubException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.actualizar();
			this.mivista.getPes4_boxListClien().setSelectedIndex(selected);
		}
		else if(e.getSource()==this.mivista.getPes4_btnCancelar()) {
			this.mivista.getPes4_boxListClien().setSelectedIndex(0);
			this.mivista.getPes4_boxListPeli().setSelectedIndex(0);
		}
		else if(e.getSource()==this.mivista.getPes5_btnDevolver()&&this.mivista.getPes5_boxListPeli().getSelectedItem()!=null) {
			int selected = this.mivista.getPes5_boxListClien().getSelectedIndex();
			try {
				this.club.devuelve((String)this.mivista.getPes5_boxListPeli().getSelectedItem(), (String)this.mivista.getPes5_boxListClien().getSelectedItem());
			} catch (DVDClubException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.actualizar();
			this.mivista.getPes5_boxListClien().setSelectedIndex(selected);
		}
		else if(e.getSource()==this.mivista.getPes5_btnCancelar()) {
			this.mivista.getPes5_boxListClien().setSelectedIndex(0);
			this.mivista.getPes5_boxListPeli().setSelectedIndex(0);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.mivista.getPes5_boxListClien()&&e.getStateChange()==ItemEvent.SELECTED) {
			String nombre = (String) e.getItem();
			TreeSet<DVD> lista = this.club.getPeliculasCliente(nombre);
			this.llenarComboBox(this.mivista.getPes5_boxListPeli(), lista);
		}
	}

}
