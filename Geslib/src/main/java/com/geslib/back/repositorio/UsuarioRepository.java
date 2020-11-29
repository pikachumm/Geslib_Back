package com.geslib.back.repositorio;



import org.springframework.data.repository.CrudRepository;


import com.geslib.back.modelo.Usuario;
 
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	Usuario findByEmail(String email);
	
}
