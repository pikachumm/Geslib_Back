package com.geslib.back.controladorrest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geslib.back.modelo.Formato;
import com.geslib.back.modelo.Genero;
import com.geslib.back.modelo.Libro;
import com.geslib.back.modelo.Material;
import com.geslib.back.modelo.Pelicula;
import com.geslib.back.servicio.MaterialService;

@RestController
@RequestMapping("/materiales")
public class MaterialController {
	@Autowired
	MaterialService materialService;
	
    @GetMapping("/listarMateriales")
    public ResponseEntity<List<Material>> list(){
    	
        List<Material> list = materialService.listarMateriales();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    //Metodo para añadir pelicula y libro borrar luego
    @GetMapping("/borrarLuego")
    public ResponseEntity<List<Material>> added(){

    	Date d = new java.sql.Date(1899, 4, 5);
        Pelicula p = new Pelicula(d, Genero.Comedia, "titulo 0", "descripcion", "/", 3, 5, Formato.VHS);
        Libro l = new Libro(d, Genero.Accion, "libro", "DES", "/", 5, "454543", "A", 7);
        materialService.add(p);
        materialService.add(l);
    
        return new ResponseEntity("ok", HttpStatus.OK);
    }
    @PostMapping("/addPelicula")
    public ResponseEntity<?> create(@RequestBody Pelicula pelicula){
     materialService.add(pelicula);
     return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/addLibro")
    public ResponseEntity<?> create(@RequestBody Libro libro){
     materialService.add(libro);
     return new ResponseEntity(HttpStatus.OK);
    }
    // de momento sin funcionar
    @PostMapping("/delete")
    public ResponseEntity<?> deleted(@RequestBody String id){
    	
        if(materialService.delete(Long.parseLong(id))) {
        	return new ResponseEntity(HttpStatus.CONFLICT);
        }else {
        	return new ResponseEntity(HttpStatus.OK);
        }
        
       }

}
