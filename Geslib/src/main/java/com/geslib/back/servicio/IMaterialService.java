package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import com.geslib.back.modelo.Libro;
import com.geslib.back.modelo.Material;
import com.geslib.back.modelo.Pelicula;

/** 
 * Interfaz de MaterialService con todas las funciones
 *  necesarias para la gestion de controladores
 *  Rest
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
public interface IMaterialService {
	/** 
	 * Interfaz de MaterialService con todas las funciones
	 *  necesarias para la gestion de controladores
	 *  Rest
	 * 
	*/
	List<Material>listarMateriales();
	List<Pelicula> listarPeliculas();
	List<Libro>listarLibros();
	Optional<Material> obtenerRecurso(int id);
	void addPelicula(Pelicula pelicula);
	void addLibro(Libro libro);
	boolean update (Material material);
	void delete (int id);
	boolean exits(int id);
	Optional<Material> get(int id);
	boolean hacerReserva(int id, int unidades);

}
