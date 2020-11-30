package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import com.geslib.back.modelo.Comentario;


/** 
 * Interfaz de ComentarioService con todas las funciones
 *  necesarias para la gestion de controladores
 *  Rest
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
public interface ICometarioService {
	List<Comentario>listarComentario();
	Optional<Comentario> get(int id);
	void add (Comentario comentario);
	boolean update (Comentario comentario);
	boolean delete (int id);
	boolean exits(int id);

}
