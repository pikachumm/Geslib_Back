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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;


/** 
 *Modelo de Reserva almacenara la informacion sobre las 
 *reservas que realiza cada usuario consta de constructores
 *por defecto sin paramentros con todos los parametros y con
 *todos los parametros excepto el id
 *getters y setters hascode e equals
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Entity
@Table(name= "reservas")
public class Reserva implements Serializable{
	
	@Id
	@Column(name="id_reserva")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReserva;
	
	@NonNull
	@Column(name="unidades")
	private int unidades;
	
	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_usuario")
	Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_material")
	Material material;
	
	private static final long serialVersionUID = 1L;
	public Reserva () {
		
	}
	public Reserva(int idReserva, @NonNull int unidades, @NonNull Date fechaCreacion, Usuario usuario,
			Material material) {
		super();
		this.idReserva = idReserva;
		this.unidades = unidades;
		this.fechaCreacion = fechaCreacion;
		this.usuario = usuario;
		this.material = material;
	}

	public Reserva(@NonNull int unidades, @NonNull Date fechaCreacion, Usuario usuario, Material material) {
		super();
		this.unidades = unidades;
		this.fechaCreacion = fechaCreacion;
		this.usuario = usuario;
		this.material = material;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
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
	
}
