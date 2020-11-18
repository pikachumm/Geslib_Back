package com.geslib.back.servicio;

import java.util.List;

import com.geslib.back.modelo.Material;

public interface IMaterialService {
	List<Material>listarMateriales();
	List<Material>listarPeliculas();
	List<Material>listarLibros();
	void add (Material material);
	boolean update (Material material);
	void delete (Long id);

}
