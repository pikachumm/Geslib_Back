package com.geslib.back.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.NonNull;



@Entity
@DiscriminatorValue("libro")
public class Libro extends Material 
{

	@NonNull
	@Column(name="isbn")
	private String isbn;
	
	@NonNull
	@Column(name="editorial")
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
	
	
}
