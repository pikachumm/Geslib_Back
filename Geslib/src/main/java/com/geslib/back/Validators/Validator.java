package com.geslib.back.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.geslib.back.modelo.Comentario;
import com.geslib.back.modelo.Libro;
import com.geslib.back.modelo.Material;
import com.geslib.back.modelo.Pelicula;
import com.geslib.back.modelo.Reserva;
import com.geslib.back.modelo.Usuario;
import com.geslib.back.servicio.MaterialService;
import com.geslib.back.servicio.UsuarioService;

/** 
 * clase cuyo proposito consiste en validar las
 * diferentes clases
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
public class Validator {
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	MaterialService materialService;
	public boolean isValid(Comentario comentario) {
		boolean exito = true;
		if(comentario.getFechaCreacion() == null || !isValid(comentario.getMaterial())|| !isValid(comentario.getUsuario()) ||
		comentario.getTexto() == null || comentario.getTexto() == "" || comentario.getTitulo() == null) {
			exito = false;
		}
		return exito;
		
	}
	public boolean isValid(Material material) {
		boolean exito = true;
		if(material.getDescripcion() == null || material.getDescripcion() == ""
		|| material.getGenero() == null || material.getFechaPublicacion() == null || material.getTitulo() == null ||
		material.getTitulo() == "" || material.getUnidadesDisponibles() < 0) {
			exito = false;
		}
		 if (material instanceof Pelicula && exito == false) {
			Pelicula peli = (Pelicula) material;
			if(peli.getFormato() == null || peli.getDuracion() < 0) {
				
			}
			
		}
		if(material instanceof Libro && exito == false) {
			Libro libro = (Libro) material;
			if(libro.getIsbn() == null || libro.getEditorial() == null) {
				exito = false;
			}
		}
		return exito;
		
	} 
	public boolean isValid(Usuario usuario) {
		boolean exito = true;
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Pattern patron = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        Matcher mat = patron.matcher(usuario.getDni());
        if(!mat.matches() || usuario.getEmail().matches(regex) || usuario.getApellidos() != "" || 
        usuario.getDireccion() == null || usuario.getFechaNacimiento() == null || 
        usuario.getNickname() == null || usuario.getPassword() == null || usuario.getPassword().length() < 8
        || usuario.getSexo() == null 
        ||usuario.getRoles() == null) {
        	exito = false;
        }
		return exito;
		
	}
	
	public boolean isValid(Reserva reserva) {
		boolean exito = true;
		if(reserva.getFechaCreacion() == null || !isValid(reserva.getMaterial()) 
		|| !isValid(reserva.getUsuario()) || reserva.getUnidades() < 0){
			exito = false;
		}
		return exito;
		
	}
	public Validator() {
		
	}
		
	

}
