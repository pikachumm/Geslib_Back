package com.geslib.back.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
@SuperBuilder
@Entity
@Table(name="materiales")
@DiscriminatorColumn(name="tipo")
public class Material implements Serializable
{

	@Id
	@Column(name="id_material")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="creador")
	Usuario usuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_publicacion")
	private Date fechaPublicacion;
	
	@Enumerated
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
	@Column(name="unidadesdisponibles")
	private int unidadesDisponibles;

	private static final long serialVersionUID = 1L;

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		this.unidadesDisponibles = unidadesDisponibles;
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
	
}
