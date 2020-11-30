package com.geslib.back.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geslib.back.modelo.Rol;

/** 
 * Repositorio de Rol
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Repository
public interface RolRepository extends CrudRepository<Rol,Integer>{

}
