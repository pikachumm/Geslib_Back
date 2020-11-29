package com.geslib.back.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;


import com.geslib.back.modelo.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	Usuario findByEmail(String email);
}
