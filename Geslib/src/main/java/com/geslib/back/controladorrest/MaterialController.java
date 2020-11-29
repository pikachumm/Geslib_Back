package com.geslib.back.controladorrest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.geslib.back.Temporals.Id;
import com.geslib.back.Temporals.Mensaje;
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
	private static String UPLOADED_FOLDER = "C://temp//";
    @GetMapping("/list")
    public ResponseEntity<List<Material>> listarMateriales(){
    	
        List<Material> list = materialService.listarMateriales();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/listarPeliculas")
    public ResponseEntity<List<Material>> listarPeliculas(){
    	
        List<Pelicula> list = materialService.listarPeliculas();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/listarLibros")
    public ResponseEntity<List<Material>> listarLibros(){
    	
        List<Libro> list = materialService.listarLibros();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //Metodo para añadir pelicula y libro borrar luego
    @GetMapping("/borrarLuego")
    public ResponseEntity<List<Material>> added(){

    	Date d = new java.sql.Date(1899, 4, 5);
        Pelicula p = new Pelicula(d, Genero.Comedia, "titulo 0", "descripcion", "/", 3, 5, Formato.VHS);
        Libro l = new Libro(d, Genero.Accion, "libro", "DES", "/", 5, "454543", "A", 7);
        materialService.addPelicula(p);
        materialService.addLibro(l);
    
        return new ResponseEntity("ok", HttpStatus.OK);
    }
    @PostMapping("/addPelicula")
    public ResponseEntity<?> addPelicula(@RequestBody Pelicula pelicula,@RequestBody(required = false) MultipartFile file){
    	 if (file.isEmpty()) {
             pelicula.setImagen("/");
             try {

                 // Get the file and save it somewhere
                 byte[] bytes = file.getBytes();
                 Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                 Files.write(path, bytes);
                 pelicula.setImagen(path.toString());
             } catch (IOException e) {
                 e.printStackTrace();
                 pelicula.setImagen("/");
             }
     materialService.addPelicula(pelicula);
    }
    	 return new ResponseEntity(HttpStatus.OK);
    	 }
    @PostMapping("/addLibro")
    public ResponseEntity<?> addLibro(@RequestBody Libro libro,@RequestBody(required = false) MultipartFile file){
     if (file == null) {
         libro.setImagen("/");
     }else {
         try {

             // Get the file and save it somewhere
             byte[] bytes = file.getBytes();
             Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
             Files.write(path, bytes);
             libro.setImagen(path.toString());
         } catch (IOException e) {
             libro.setImagen("/");
         }
         materialService.addLibro(libro);

     }
     return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/updateLibro")
    public ResponseEntity<?> updateLibro(@RequestBody Libro libro){
     materialService.update(libro);
     return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/updatePelicula")
    public ResponseEntity<?> updatePelicula(@RequestBody Pelicula pelicula){
     materialService.update(pelicula);
     return new ResponseEntity(HttpStatus.OK);
    }
   

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Id id){
    	if(materialService.exits(id.getId())) {
        materialService.delete(id.getId());
        return new ResponseEntity(new Mensaje("ok"),HttpStatus.OK);
        }
        return new ResponseEntity(new Mensaje("Mal"),HttpStatus.OK);
       }
    @PostMapping("/get")
    public ResponseEntity<?> get(@RequestBody Id id){
        if(materialService.obtenerRecurso(id.getId()) != null) {
        	return new ResponseEntity(materialService.obtenerRecurso(1),HttpStatus.OK);
        }else {
        	return new ResponseEntity(new Mensaje("Error"),HttpStatus.OK);
        }
  
       }

}
