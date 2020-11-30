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
import com.geslib.back.Validators.Validator;
import com.geslib.back.modelo.Formato;
import com.geslib.back.modelo.Genero;
import com.geslib.back.modelo.Libro;
import com.geslib.back.modelo.Material;
import com.geslib.back.modelo.Pelicula;
import com.geslib.back.servicio.MaterialService;
/** 
 * Controlador Rest para servicios de comentarios
 * Se encarga de las peticiones post y get 
 * consta de las siguientes funciones:
 * {@link listarMateriales},
 * {@link listarPeliculas},
 * {@link listarLibros},
 * {@link addPelicula},
 * {@link addLibro},
 * {@link updateLibro}
 * {@link updatePelicula}
 * {@link delete}
 * {@link get}
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@RestController
@RequestMapping("/materiales")
public class MaterialController {
	@Autowired
	MaterialService materialService;
	
	private Validator validator = new Validator();
	
	//ruta en la que se almacenaran las imagenes
	private static String UPLOADED_FOLDER = "C://temp//";
	
	/** 
	* Devuelve una lista con todos los materiales sean peliculas o libros
	* @param none
	* @return list<Materiales>
	*/
    @GetMapping("/list")
    public ResponseEntity<List<Material>> listarMateriales(){
    	
        List<Material> list = materialService.listarMateriales();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    /** 
	* Devuelve una lista con todos los materiales que sean peliculas
	* @param none
	* @return list<Pelicula>
	*/
    @GetMapping("/listarPeliculas")
    public ResponseEntity<List<Pelicula>> listarPeliculas(){
    	
        List<Pelicula> list = materialService.listarPeliculas();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    /** 
	* Devuelve una lista con todos los materiales que sean libros
	* @param none
	* @return list<Libro>
	*/
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
    
    /** 
	* Dado un material de tipo Pelicula este lo valida y añade a bbddd si procede
	* ademas comprobara si recibe una imagen, en caso de ser valida esta se almacenara en la
	* carpeta especificada y guardara la direccion del mismo en bbddd
	* 
	* @param Pelicula file
	* @return {@link HttpStatus}}
	*/
    @PostMapping("/addPelicula")
    public ResponseEntity<?> addPelicula(@RequestBody Pelicula pelicula,@RequestBody(required = false) MultipartFile file){
    	if(validator.isValid(pelicula)) {
    		
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
    	 }else {
    		
    	}
    	return new ResponseEntity(HttpStatus.OK);
    	}
    
    /** 
	* Dado un material de tipo Libro este lo valida y añade a bbddd si procede
	* ademas comprobara si recibe una imagen, en caso de ser valida esta se almacenara en la
	* carpeta especificada y guardara la direccion del mismo en bbddd
	* 
	* @param Pelicula file
	* @return {@link HttpStatus}}
	*/
    @PostMapping("/addLibro")
    public ResponseEntity<?> addLibro(@RequestBody Libro libro,@RequestParam(required = false) MultipartFile file){
    	if(validator.isValid(libro)) {
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
   
    	}  return new ResponseEntity(HttpStatus.OK);
    	
    }
    
    /** 
	* Dado un material de tipo Libro este lo valida y si existe en 
	* bbdd un material con dicho id este sera actualizado en bbdd
	* 
	* @param Libro file
	* @return {@link HttpStatus}}
	*/
    @PostMapping("/updateLibro")
    public ResponseEntity<?> updateLibro(@RequestBody Libro libro){
    	if(validator.isValid(libro)) {
    		materialService.update(libro);
    	}
    
     return new ResponseEntity(HttpStatus.OK);
    }
    
    /** 
	* Dado un material de tipo Libro este lo valida y si existe en 
	* bbdd un material con dicho id este sera actualizado en bbdd
	* 
	* @param Pelicula file
	* @return {@link HttpStatus}}
	*/
    @PostMapping("/updatePelicula")
    public ResponseEntity<?> updatePelicula(@RequestBody Pelicula pelicula){
    	if(validator.isValid(pelicula)) {
    		materialService.update(pelicula);
    	}
    	return new ResponseEntity(HttpStatus.OK);
    }

    
    /** 
	* Dado un id de material este lo buscara y en caso de ser existir en bbdd sera borrado
	* 
	* @param int
	* @return {@link HttpStatus}
	*/
    @GetMapping("/delete{id}")
    public ResponseEntity<?> delete(@RequestBody int id){
    	if(materialService.exits(id)) {
        materialService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    
    /** 
	* Dado un id de material este lo buscara y en caso de ser existir en bbdd
	* sera enviado 
	* 
	* 
	* @param int
	* @return {@link HttpStatus}
	*/
    @GetMapping("/get{id}")
    public ResponseEntity<?> get(@RequestBody int id){
        if(materialService.obtenerRecurso(id) != null) {
        	return new ResponseEntity(materialService.obtenerRecurso(1),HttpStatus.OK);
        }else {
        	return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
  
       }
    

}
