package com.geslib.back.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.NonNull;


/** 
 *Modelo de Libro extiende de material consta de constructores
 *por defecto sin paramentros con todos los parametros y con
 *todos los parametros excepto el id,getters, setters hashcode e equals
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Entity
@DiscriminatorValue("libro")
public class Libro extends Material 
{

	@NonNull
	@Column(name="isbn", length = 13, unique = true)
	private String isbn;
	
	@NonNull
	@Column(name="editorial", length = 30)
	private String editorial;
	
	@Column(name="numero_paginas")
	private int numeroPaginas;
	
	private static final long serialVersionUID = 1L;
	public Libro() {
		super();
		isbn="";
		editorial="";
		numeroPaginas=0;
	}
	
	public Libro(Date fechaPublicacion, Genero genero, @NonNull String titulo, @NonNull String descripcion,
			String imagen, @NonNull int unidadesDisponibles, @NonNull String isbn, @NonNull String editorial,
			int numeroPaginas) {
		super(fechaPublicacion, genero, titulo, descripcion, imagen, unidadesDisponibles);
		this.isbn = isbn;
		this.editorial = editorial;
		this.numeroPaginas = numeroPaginas;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		Libro other = (Libro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	
	
}
