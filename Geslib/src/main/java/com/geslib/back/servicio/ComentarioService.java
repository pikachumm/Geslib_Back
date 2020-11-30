package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geslib.back.modelo.Comentario;
import com.geslib.back.repositorio.ComentarioRepository;
import com.geslib.back.repositorio.MaterialRepository;
import com.geslib.back.repositorio.UsuarioRepository;

/** 
 * Aqui se aplicaran todas las funciones de los
 * controladores Rest referentes a Comentario
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Service
@Transactional
public class ComentarioService implements ICometarioService{
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private MaterialRepository materialRepository;

	@Override
	public List<Comentario> listarComentario() {
		// TODO Auto-generated method stub
		return (List<Comentario>) comentarioRepository.findAll();
	}

	@Override
	public Optional<Comentario> get(int id) {
		// TODO Auto-generated method stub
		return comentarioRepository.findById(id);
	}

	@Override
	public void add(Comentario comentario) {
		// TODO Auto-generated method stub
		comentarioRepository.save(comentario);
	}

	@Override
	public boolean update(Comentario comentario) {
		// TODO Auto-generated method stub
		if(exits(comentario.getIdComentario())) {
			comentarioRepository.save(comentario);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean delete(int id) {
		boolean exito= false;
		if(exits(id)) {
			comentarioRepository.deleteById(id);
			exito = true;
		}
			return exito;

	}

	@Override
	public boolean exits(int id) {
		// TODO Auto-generated method stub
		return comentarioRepository.existsById(id);
	}
}
