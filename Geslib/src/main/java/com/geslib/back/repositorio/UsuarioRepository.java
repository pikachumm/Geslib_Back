package com.geslib.back.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geslib.back.modelo.Usuario;

/** 
 * Repositorio de Usuario
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
