package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import com.geslib.back.modelo.Comentario;



public interface ICometarioService {
	List<Comentario>listarComentario();
	Optional<Comentario> get(int id);
	void add (Comentario comentario);
	boolean update (Comentario comentario);
	void delete (int id);
	boolean exits(int id);

}
