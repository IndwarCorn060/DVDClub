package clases;

import java.io.*;
import java.util.*;

public class DVDClub {
	
	private TreeSet<DVD> dvds;
	private TreeSet<Cliente> clientes;
	
	public DVDClub() {
		this.dvds = new TreeSet<DVD>();
		this.clientes = new TreeSet<Cliente>();
	}
	
	public DVDClub(String dvdFile, String clientesFile) {
		this();
		cargaPeliculas(dvdFile);
		cargarClientes(clientesFile);
	}

	
	private void cargaPeliculas(String dvdFile) {
		File fichero = new File("./src/clases/"+dvdFile);
		BufferedReader entrada = null;
		
		try {
			//abrir buffo de lectura a partir de un buffer
			entrada = new BufferedReader(new FileReader(fichero));
			//recorrer el archivo linmea a linea  y mostrarlo por pantalla
			String s;
			while((s=entrada.readLine())!=null) {
				StringTokenizer t1 = new StringTokenizer(s,"*");
				String codigo, titulo, director;
				List<String> actores = new LinkedList<String>();
				codigo = t1.nextToken();
				titulo = t1.nextToken();
				director = t1.nextToken();
				StringTokenizer t2 = new StringTokenizer(t1.nextToken(),",");
				while(t2.hasMoreTokens()) {
					actores.add(t2.nextToken());
				}
				this.dvds.add(new DVD(codigo,titulo,director,actores));
			}
		}
		catch(FileNotFoundException e1) {
			System.out.println("Archivo no encontrado");
		}
		catch(IOException e2) {
			System.out.println("Error: "+e2.getMessage());
		}
		
		finally {
			try {
				if(entrada!=null) {
					entrada.close();
				}
			}
			catch(IOException e1) {
				System.out.println("Problema al cerrar el fichero");
			}
			catch(NullPointerException e2) {
				System.out.println("Problemas al cerrar el arhcivo");
			}
		}
	}
	
	private void cargarClientes(String clientesFile) {
		File fichero = new File("./src/clases/"+clientesFile);
		BufferedReader entrada = null;
		try {
			//abrir buffo de lectura a partir de un buffer
			entrada = new BufferedReader(new FileReader(fichero));
			//recorrer el archivo linmea a linea  y mostrarlo por pantalla
			String s;
			while((s=entrada.readLine())!=null) {
				this.clientes.add(new Cliente(s));
			}
		}
		catch(FileNotFoundException e1) {
			System.out.println("Archivo no encontrado");
		}
		catch(IOException e2) {
			System.out.println("Error: "+e2.getMessage());
		}
		
		finally {
			try {
				if(entrada!=null) {
					entrada.close();
				}
			}
			catch(IOException e1) {
				System.out.println("Problema al cerrar el fichero");
			}
			catch(NullPointerException e2) {
				System.out.println("Problemas al cerrar el arhcivo");
			}
		}
	}
	
	public boolean anadirCliente(String nombre) {
		Cliente cliente = new Cliente(nombre);
		return this.clientes.add(cliente);
	}
	
	public boolean anadirDVD(String codigo, String titulo, String director, List<String> actores) {
		DVD dvd = new DVD(codigo, titulo, director, actores);
		return this.dvds.add(dvd);
	}
	
	public boolean anadirDVD(DVD dvd) {
		return this.dvds.add(dvd);
	}
	
	public DVD sacarPelicula(String titulo) {
		DVD dvd = null;
		boolean f=false;
		Iterator<DVD> i = this.dvds.iterator();
		while(!f&&i.hasNext()) {
			dvd = i.next();
			if(dvd.getTitulo().equalsIgnoreCase(titulo)) {
				f=true;
				i.remove();
			}
		}
		if(!f) {
			dvd = null;
		}
		return dvd;
	}
	
	public Cliente cliente (String nombre) {
		Cliente cliente = null;
		Iterator<Cliente> i = this.clientes.iterator();
		boolean f=false;
		while(!f&&i.hasNext()) {
			cliente = i.next();
			if(cliente.getNombre().equalsIgnoreCase(nombre)) {
				f=true;
			}
		}
		if(!f) {
			cliente=null;
		}
		return cliente;
	}
	
	public boolean alquila(String titulo, String nombre) throws DVDClubException {
		DVD dvd = sacarPelicula(titulo);
		if(cliente(nombre)!=null&&!cliente(nombre).tieneDVD(titulo)&&dvd!=null) {
			return cliente(nombre).alquila(dvd);
		}
		else {
			if(dvd!=null) {
				anadirDVD(dvd);
			}
			throw new DVDClubException("Película no disponible");
		}
	}
	
	public boolean devuelve(String titulo, String nombre) throws DVDClubException {
		if(cliente(nombre)!=null&&cliente(nombre).tieneDVD(titulo)) {
			return anadirDVD(cliente(nombre).devuelve(titulo));
		}
		else {
			if(cliente(nombre)==null) {
				throw new DVDClubException("Cliente no encontrado.");
			}
			else {
				throw new DVDClubException("El cliente no tiene la Pelicula '"+titulo+"'.");
			}
		}
	}
	
	public String disponibles() {
		String cadena = "Peliculas Disponibles:";
		Iterator<DVD> i = this.dvds.iterator();
		DVD aux ;
		while(i.hasNext()) {
			aux = i.next();
			cadena+="\n\t- "+aux.getCodigo()+" - "+aux.getTitulo();
		}
		return cadena;
	}
	
	public String alquiladas(String nombre) {
		if(cliente(nombre)!=null) {
			String cadena="Peliculas alquiladas por: "+nombre;
			Iterator<DVD> i = cliente(nombre).getColeccion().iterator();
			DVD dvd=null;
			while(i.hasNext()) {
				dvd = i.next();
				cadena+="\n\t-"+dvd.getCodigo()+" - "+dvd.getTitulo();
			}
			return (dvd!=null)?cadena:cadena+"\n\tNo hay peliculas";
		}
		else {
			return "Error, cliente no encontrado";
		}
	}

	
	public HashSet<DVD> getPeliculasCliente(String nombre) {
		if(cliente(nombre)!=null) {
			return cliente(nombre).getColeccion();
		}
		else {
			System.out.println("Cliente no encontrado");
			HashSet<DVD> vacio = new HashSet<DVD>();
			return vacio;
		}
	}
	
	public TreeSet<DVD> copias(String titulo) {
		TreeSet<DVD> copias = new TreeSet<DVD>();
		Iterator<DVD> i = this.dvds.iterator();
		DVD dvd=null;
		while(i.hasNext()) {
			dvd = i.next();
			if(dvd.getTitulo().equals(titulo)) {
				copias.add(dvd);
			}
		}
		return copias;
	}

	public TreeSet<DVD> getDvds() {
		return dvds;
	}

	public TreeSet<Cliente> getClientes() {
		return clientes;
	}
	
	
	

}
