package com.geslib.back.modelo;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="direcciones")
public class Direccion implements Serializable 
{

	@Id
	@Column(name="id_direccion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDireccion;
	
	@NonNull
	@Enumerated
	@Column(name="provincia")
	private Provincia provincia;
	
	@NonNull
	@Column(name="localidad", length = 50)
	private String localidad;
	
	@NonNull
	@Column(name="cp",length = 5)
	private String cp;
	
	@NonNull
	@Column(name="calle", length = 20)
	private String calle;
	
	@NonNull
	@Column(name="numero_calle")
	private int numeroCalle;
	
	@Column(name="piso")
	private int piso;
	

	@Column(name="letra")
	private char letra;
	
	
	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public int getNumeroCalle() {
		return numeroCalle;
	}


	public void setNumeroCalle(int numeroCalle) {
		this.numeroCalle = numeroCalle;
	}


	public int getPiso() {
		return piso;
	}


	public void setPiso(int piso) {
		this.piso = piso;
	}


	public char getLetra() {
		return letra;
	}


	public void setLetra(char letra) {
		this.letra = letra;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Direccion() {
		this(Provincia.Madrid,"","28030","",1,0,(char) 0);
	}
	public Direccion(@NonNull Provincia provincia, @NonNull String localidad, @NonNull String cp,
			@NonNull String calle, @NonNull int numeroCalle, int piso, char letra) {
		this.provincia = provincia;
		this.localidad = localidad;
		this.cp = cp;
		this.calle = calle;
		this.numeroCalle = numeroCalle;
		this.piso = piso;
		this.letra = letra;
	}


	private static final long serialVersionUID = 1L;
}
