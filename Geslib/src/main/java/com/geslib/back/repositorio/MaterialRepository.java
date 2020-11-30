package com.geslib.back.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geslib.back.modelo.Material;

/** 
 * Repositorio de Material
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer> {

}
