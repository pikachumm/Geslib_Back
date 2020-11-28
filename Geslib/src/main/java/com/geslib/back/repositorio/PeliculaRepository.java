package com.geslib.back.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.geslib.back.modelo.Pelicula;

public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {

}