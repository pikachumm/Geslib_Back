package com.geslib.back.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.NonNull;


@Entity
@Table(name= "comentarios")
public class Comentario implements Serializable
{	
	
	@Id
	@Column(name="id_comentario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idComentario;
	
	@NonNull
	@Column(name="titulo",length = 20)
	private String titulo;
	
	@NonNull
	@Column(name="texto", length = 150)
	private String texto;
	
	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_usuario")
	Usuario usuario;
	
	@NonNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_material")
	Material material;
	
	public Comentario() {
		titulo="";
		texto="";
		fechaCreacion = new Date();
		usuario = new Usuario();
		material = new Material();
	}

	public Comentario(@NonNull String titulo, @NonNull String texto, @NonNull Date fechaCreacion, Usuario usuario,
			@NonNull Material material) {
		this.titulo = titulo;
		this.texto = texto;
		this.fechaCreacion = fechaCreacion;
		this.usuario = usuario;
		this.material = material;
	}
	


	public int getIdComentario() {
		return idComentario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idComentario ^ (idComentario >>> 32));
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
		Comentario other = (Comentario) obj;
		if (idComentario != other.idComentario)
			return false;
		return true;
	}







	private static final long serialVersionUID = 1L;

}
