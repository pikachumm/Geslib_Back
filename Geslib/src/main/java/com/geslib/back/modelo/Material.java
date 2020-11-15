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

	@NonNull
	@Id
	@Column(name="id_material")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="creador")
	Usuario usuario;
	
	@NonNull
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
	
}
