package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geslib.back.modelo.Comentario;
import com.geslib.back.repositorio.ComentarioRepository;

@Service
@Transactional
public class ComentarioService implements ICometarioService{
	@Autowired
	private ComentarioRepository comentarioRepository;

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
		if(comentarioRepository.findById(comentario.getIdComentario()) == null) {
			comentarioRepository.save(comentario);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		comentarioRepository.deleteById(id);
	}

	@Override
	public boolean exits(int id) {
		// TODO Auto-generated method stub
		boolean resultado = false;
		if(comentarioRepository.findById(id) != null) {
			resultado = true;
		}
		return resultado;
	} 
}
