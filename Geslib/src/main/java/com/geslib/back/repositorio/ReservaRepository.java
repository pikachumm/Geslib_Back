package com.geslib.back.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geslib.back.modelo.Reserva;

/** 
 * Repositorio de Reserva
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer>{

}
