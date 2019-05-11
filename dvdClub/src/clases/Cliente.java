package clases;

import java.util.*;

public class Cliente implements Comparable<Cliente>{
	
	private String nombre;
	private TreeSet<DVD> coleccion;
	
	public Cliente(String nombre) {
		this.nombre=nombre;
		this.coleccion=new TreeSet<DVD>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<DVD> getColeccion() {
		return coleccion;
	}

	public boolean alquila(DVD dvd) {
		return this.coleccion.add(dvd);
	}
	
	public DVD devuelve(String titulo) {
		boolean f=false;
		DVD dvd =null;
		Iterator<DVD> i = this.coleccion.iterator();
		while(!f&&i.hasNext()) {
			dvd = i.next();
			if(dvd.getTitulo().equals(titulo)) {
				f=true;
				i.remove();
			}
		}
		if(!f) {
			dvd=null;
		}
		return dvd;
	}
	
	public boolean tieneDVD(String titulo) {
		Iterator<DVD> i = this.coleccion.iterator();
		boolean f=false;
		while(!f&&i.hasNext()) {
			if(i.next().getTitulo()==titulo) {
				f=true;
			}
		}
		return f;
	}
	
	@Override
	public String toString() {
		Iterator<DVD> i = this.coleccion.iterator();
		String cadena="Nombre: "+this.nombre+"\nPeliculas:";
		while(i.hasNext()) {
			cadena+="\n\t-"+i.next().getTitulo();
		}
		return cadena+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coleccion == null) ? 0 : coleccion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (coleccion == null) {
			if (other.coleccion != null)
				return false;
		} else if (!coleccion.equals(other.coleccion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cliente otro) {
		// TODO Auto-generated method stub
		return this.nombre.compareToIgnoreCase(otro.nombre);
	}

}
