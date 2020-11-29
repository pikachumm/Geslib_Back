package com.geslib.back.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
	private String dni;
	
	@NonNull
	@Column(name="email", length = 15)
	private String email;
	@NonNull
	@Column(name = "password")
	private String password;
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
	  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "users_roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id")
	            )
	    private Set<Rol> roles = new HashSet(); 
	public Usuario() {

	}
	public Usuario(long idUsuario, @NonNull String dni, @NonNull String email, @NonNull String password,
			@NonNull String nickname, @NonNull boolean administrador, @NonNull LocalDate fechaNacimiento,
			@NonNull Sexo sexo, @NonNull String nombre, @NonNull String apellidos, Direccion direccion,
			Set<Rol> roles) {
		this.idUsuario = idUsuario;
		this.dni = dni;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.administrador = administrador;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.roles = roles;
	}
	public Usuario(@NonNull String dni, @NonNull String email, @NonNull String password, @NonNull String nickname,
			@NonNull boolean administrador, @NonNull LocalDate fechaNacimiento, @NonNull Sexo sexo,
			@NonNull String nombre, @NonNull String apellidos, Direccion direccion) {
		super();
		this.dni = dni;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.administrador = administrador;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}
	public Usuario(@NonNull String dni, @NonNull String email, @NonNull String password, @NonNull String nickname,
			@NonNull boolean administrador, @NonNull LocalDate fechaNacimiento, @NonNull Sexo sexo,
			@NonNull String nombre, @NonNull String apellidos, Direccion direccion, Set<Rol> roles) {
		super();
		this.dni = dni;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.administrador = administrador;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.roles = roles;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
}
