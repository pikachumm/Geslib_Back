package com.geslib.back.repositorio;


import org.springframework.data.repository.CrudRepository;

import com.geslib.back.modelo.Material;

public interface MaterialRepository extends CrudRepository<Material, Integer> {

}
