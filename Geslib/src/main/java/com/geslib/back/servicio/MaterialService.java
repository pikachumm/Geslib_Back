package com.geslib.back.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.geslib.back.modelo.Libro;
import com.geslib.back.modelo.Material;
import com.geslib.back.modelo.Pelicula;
import com.geslib.back.repositorio.MaterialRepository;
@Service
@Transactional
public class MaterialService implements IMaterialService{
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Override
	public List<Material> listarMateriales() {
		return (List<Material>) materialRepository.findAll();
	}

	@Override
	public List<Material> listarPeliculas() {
		List<Material> materiales = (List<Material>) materialRepository.findAll();
		List<Material> peliculas = null; 
		for (Material material : materiales) {
			if(material instanceof Pelicula) {
				peliculas.add(material);
			}
		}
		return peliculas;
	}

	@Override
	public List<Material> listarLibros() {
		// TODO Auto-generated method stub
		List<Material> materiales = (List<Material>) materialRepository.findAll();
		List<Material> libros = null; 
		for (Material material : materiales) {
			if(material instanceof Libro) {
				libros.add(material);
			}
		}
		return libros;
	}

	@Override
	public void add(Material material) {
		// TODO Auto-generated method stub
		materialRepository.save(material);
	}

	@Override
	public boolean update(Material material) {
		// TODO Auto-generated method stub
		if(materialRepository.findById(material.getIdMaterial()) != null) {
			materialRepository.save(material);
			return true;
		}else {
			return true;
		}
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		boolean exito = true;
		try {
			materialRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			exito = false;
		}
		return exito;
	}

}
