package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geslib.back.modelo.Usuario;
import com.geslib.back.repositorio.RolRepository;
import com.geslib.back.repositorio.UsuarioRepository;

/** 
 * Aqui se aplicaran todas las funciones de los
 * controladores Rest referentes a Usuario
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Service
@Transactional
public class UsuarioService implements IUsuarioService{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
	@Autowired
	RolRepository rolRepository;
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public void Add(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> get(int id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	public boolean update(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if(usuarioRepository.existsById(usuario.getIdUsuario())) {
			usuarioRepository.save(usuario);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if(usuarioRepository.existsById(id)) {
			exito = true;
			usuarioRepository.deleteById(id);
		}
		return exito;
	}

	@Override
	public boolean exits(int id) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsById(id);
	}

}
