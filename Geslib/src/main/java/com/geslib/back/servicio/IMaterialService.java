package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import com.geslib.back.modelo.Libro;
import com.geslib.back.modelo.Material;
import com.geslib.back.modelo.Pelicula;

public interface IMaterialService {
	List<Material>listarMateriales();
	List<Pelicula> listarPeliculas();
	List<Libro>listarLibros();
	Optional<Material> obtenerRecurso(int id);
	void addPelicula(Pelicula pelicula);
	void addLibro(Libro libro);
	boolean update (Material material);
	void delete (int id);

}
