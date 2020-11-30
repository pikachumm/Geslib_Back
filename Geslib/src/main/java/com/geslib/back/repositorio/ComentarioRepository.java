package com.geslib.back.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geslib.back.modelo.Comentario;

/** 
 * Repositorio de Comentario
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Integer>{

}
