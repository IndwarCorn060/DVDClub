package clases;

import java.util.*;

public class DVD implements Comparable<DVD> {
	
	private String codigo;
	private String titulo;
	private String director;
	private List<String> actores;
	
	public DVD(String codigo, String titulo, String director, List<String> actores) {
		this.codigo=codigo;
		this.titulo=titulo;
		this.director=director;
		this.actores=actores;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	public List<String> getActores() {
		return actores;
	}

	public void setActores(List<String> actores) { //??
		this.actores = actores;
	}

	/*@Override
	public boolean equals(Object ob) {
		DVD dvd2=(DVD)ob;
		return this.codigo.equals(dvd2.getCodigo());
	}*/
	
	
	
	public boolean equals(DVD dvd1, DVD dvd2) {
		return dvd1.getCodigo().equals(dvd2.getCodigo());
	}
	
	

	/*@Override
	public int compareTo(DVD codigo2) {                     NO, hay que comparar con los numeros
		return this.codigo.compareTo(codigo2.getCodigo());
	}*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actores == null) ? 0 : actores.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		DVD other = (DVD) obj;
		if (actores == null) {
			if (other.actores != null)
				return false;
		} else if (!actores.equals(other.actores))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public int compareTo(DVD codigo2) {
		return Integer.parseInt(this.codigo)-Integer.parseInt(codigo2.getCodigo());
	}
	
	@Override
	public String toString() {
		
		return this.codigo+" '"+this.titulo+"' dirigida por "+this.director+" e interpretada por "+this.actores.toString()+"\n";
	}

	

}
