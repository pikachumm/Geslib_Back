package com.geslib.back.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.geslib.back.modelo.Libro;

public interface LibroRepository extends CrudRepository<Libro, Integer> {

}
