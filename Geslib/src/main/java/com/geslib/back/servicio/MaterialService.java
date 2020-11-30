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
import com.geslib.back.repositorio.LibroRepository;
import com.geslib.back.repositorio.MaterialRepository;
import com.geslib.back.repositorio.PeliculaRepository;

/** 
 * Aqui se aplicaran todas las funciones de los
 * controladores Rest referentes a Material que
 * incluyen Pelicula y Libro
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@Service
@Transactional
public class MaterialService implements IMaterialService{
	
	

	@Autowired
	private PeliculaRepository peliculaRepository;
	@Autowired
	private LibroRepository libroRepository;
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
	public void addPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculaRepository.save(pelicula);
	}
	@Override
	public void addLibro(Libro libro) {
		// TODO Auto-generated method stub
		libroRepository.save(libro);
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

	@Override
	public boolean exits(int id) {
		// TODO Auto-generated method stub
		boolean exits  = false;
		if(materialRepository.findById(id) != null) {
			exits = true;
		}
		return exits;
	}

	@Override
	public boolean hacerReserva(int id, int unidades) {
		// TODO Auto-generated method stub
		if(exits(id)) {
			Optional<Material> mat = obtenerRecurso(id);
			
			
		}
		return false;
	}

	@Override
	public Optional<Material> get(int id) {
		// TODO Auto-generated method stub
		return materialRepository.findById(id);
	}



}
