package com.geslib.back.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable 
{
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;
	
	@NonNull
	@Column(name="dni", length = 9)
	@EqualsAndHashCode.Include
	private String dni;
	
	@NonNull
	@Column(name="email", length = 15)
	private String email;
	
	@NonNull
	@Column(name="nickname", length = 15)
	private String nickname;
	
	@NonNull
	@Column(name="administrador")
	private boolean administrador;
	
	
	@NonNull
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@NonNull
	@Enumerated(EnumType.STRING)
	@Column(name="sexo")
	private Sexo sexo;
	
	@NonNull
	@Column(name="nombre", length = 15)
	private String nombre;
	
	@NonNull
	@Column(name="apellidos", length = 20)
	private String apellidos;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_direccion")
	Direccion direccion;
	
	private static final long serialVersionUID = 1L;
	

}
