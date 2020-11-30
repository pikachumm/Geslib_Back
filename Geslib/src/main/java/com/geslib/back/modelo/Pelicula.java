package com.geslib.back.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.NonNull;


/** 
 *Modelo de Pelicula extiende de material consta de constructores
 *por defecto sin paramentros con todos los parametros y con
 *todos los parametros excepto el id,getters, setters hashcode e equals
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Entity
@Table(name="peliculas")
public class Pelicula extends Material
{
	
	
	@Column(name="duracion")
	private int duracion;
	
	@NonNull
	@Enumerated(EnumType.STRING)
	@Column(name="formato")
	private Formato formato;
	
	private static final long serialVersionUID = 1L;
	
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		if(duracion > 0) {
		this.duracion = duracion;
		}
		else {
			this.duracion = 0;
		}
	}
	public Formato getFormato() {
		return formato;
	}
	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Pelicula() {
		super();
		duracion=0;
		formato = Formato.DVD;
	}
	public Pelicula(Date fechaPublicacion, Genero genero, @NonNull String titulo, @NonNull String descripcion,
			String imagen, @NonNull int unidadesDisponibles, int duracion, Formato formato) {
		super(fechaPublicacion, genero, titulo, descripcion, imagen, unidadesDisponibles);
		this.duracion = duracion;
		this.formato = formato;
	}
	
}
