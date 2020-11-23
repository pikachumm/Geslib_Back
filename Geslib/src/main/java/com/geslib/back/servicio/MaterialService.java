package com.geslib.back.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public List<Pelicula> listarPeliculas() {
		List<Material> materiales = (List<Material>) materialRepository.findAll();
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		for (Material material : materiales) {
			if(material instanceof Pelicula) {
				peliculas.add((Pelicula) material);
			}
		}
		return peliculas;
	}
	@Override
	public List<Libro> listarLibros() {
		List<Material> materiales = (List<Material>) materialRepository.findAll();
		List<Libro> libros = new ArrayList<Libro>();
		for (Material material : materiales) {
			if(material instanceof Libro) {
				libros.add((Libro) material);
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
		if(materialRepository.findById(material.getIdMaterial()) == null) {
			materialRepository.save(material);
			return true;
		}else {
			return false;
		}
	}
	 @Override
	    public void delete(int id) {
	        materialRepository.deleteById(id);
	    }

	@Override
	public Optional<Material> obtenerRecurso(int id) {
		// TODO Auto-generated method stub
		return materialRepository.findById(id);
	}



}
