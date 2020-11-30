package com.geslib.back.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.NonNull;


/** 
 *Modelo de Material guarda la informacion comun de todos los
 *materiales consta de constructores por defecto sin paramentros con 
 *todos los parametros y con todos los parametros excepto el id
 *getters, setters, hascode e equals
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Entity
@Table(name="materiales")
@DiscriminatorColumn(name="tipo")
public class Material implements Serializable
{

	@Id
	@Column(name="id_material")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMaterial;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="fecha_publicacion")
	private Date fechaPublicacion;
	
	@Enumerated(EnumType.STRING)
	@Column(name="genero")
	private Genero genero;
	
	@NonNull
	@Column(name="titulo",length = 20)
	private String titulo;
	
	@NonNull
	@Column(name="descripcion",length = 150)
	private String descripcion;
	
	@Column(name="imagen")
	private String imagen;
	
	@NonNull
	@Column(name="unidades_disponibles")
	private int unidadesDisponibles;

	private static final long serialVersionUID = 1L;

	public int getIdMaterial() {
		return idMaterial;
	}



	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(int unidadesDisponibles) {
		if(unidadesDisponibles > 0) {
		this.unidadesDisponibles = unidadesDisponibles;
		}else {
			this.unidadesDisponibles = 0;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Material() {
		this(Genero.Comedia, "", "","",0);
		
	}
	public Material(Genero genero, @NonNull String titulo, @NonNull String descripcion,
			String imagen, @NonNull int unidadesDisponibles) {
		this.genero = genero;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.unidadesDisponibles = unidadesDisponibles;
	}
	public Material(@NonNull Date fechaPublicacion, Genero genero, @NonNull String titulo, @NonNull String descripcion,
			String imagen, @NonNull int unidadesDisponibles) {
		super();
		this.fechaPublicacion = fechaPublicacion;
		this.genero = genero;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.unidadesDisponibles = unidadesDisponibles;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMaterial;
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
		Material other = (Material) obj;
		if (idMaterial != other.idMaterial)
			return false;
		return true;
	}
	
	
}
