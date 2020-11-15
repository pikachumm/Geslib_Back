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

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="direcciones")
public class Direccion implements Serializable 
{

	@Id
	@Column(name="id_direccion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDireccion;
	
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
	
	@NonNull
	@Column(name="piso")
	private int piso;
	
	@NonNull
	@Column(name="letra")
	private char letra;
	
	
	private static final long serialVersionUID = 1L;
}
