package com.geslib.back.Temporals;

import java.io.Serializable;

public class Mensaje implements Serializable{
	private String texto;
	public Mensaje() {
		
	}
	public Mensaje(String texto) {
		this.texto = texto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	

}
