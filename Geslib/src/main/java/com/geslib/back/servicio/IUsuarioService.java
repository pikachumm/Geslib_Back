package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import com.geslib.back.modelo.Usuario;

/** 
 * Interfaz de UsuarioService con todas las funciones
 *  necesarias para la gestion de controladores
 *  Rest
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
public interface IUsuarioService {
	List<Usuario> listar();
	void Add(Usuario usuario);
	Optional<Usuario> get(int id);
	boolean update(Usuario usuario);
	boolean delete(int id);
	boolean exits(int id);
}
