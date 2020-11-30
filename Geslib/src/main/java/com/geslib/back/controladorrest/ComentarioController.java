package com.geslib.back.controladorrest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.geslib.back.Validators.Validator;
import com.geslib.back.modelo.Comentario;

import com.geslib.back.servicio.ComentarioService;
/** 
 * Controlador Rest para servicios de comentarios
 * Se encarga de las peticiones post y get 
 * consta de las siguientes funciones:
 * {@link listarComentario},
 * {@link addComentario},
 * {@link updatecomentario},
 * {@link getComentario},
 * {@link deleteComentario}
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@RestController
@RequestMapping("/comentario")
public class ComentarioController {
	@Autowired
	ComentarioService comentarioService;
	private Validator validator;
	/** 
	* Devuelve una lista con todos los comentarios
	* @param none
	* @return list<Comentario>
	*/
	@GetMapping("/list")
    public ResponseEntity<List<Comentario>> listarComentarios(){
		List<Comentario> list = comentarioService.listarComentario();
		 return new ResponseEntity(list, HttpStatus.OK);
	}
	
	/** 
	* introduce en bbdd un comentario siempre y cuando este sea valido
	* @param {@link Comentario}}
	* @return {@link HttpStatus}
	*/
	@PostMapping("/add")
	public ResponseEntity<?> addComentario(@RequestBody Comentario comentario){
		if(validator.isValid(comentario)) {
			comentarioService.add(comentario);
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.OK);
		}
	}
	
	/** 
	* Si existe un comentario en la bbdd con el id este se actualizara
	* @param {@link Comentario}}
	* @return {@link HttpStatus}
	*/
	@PostMapping("/update")
	public ResponseEntity<?> updateComentario(@RequestBody Comentario comentario){
		
		if(comentarioService.update(comentario)) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity(HttpStatus.OK);
		}
	}
	
	
	/** 
	* Pasado el id de un comentario este dara una respuesta si este existe
	* @param id{@link int}
	* @return {@link Comentario}
	*/
	@GetMapping("/get{id}")
	public ResponseEntity<?> getComentario(@RequestBody int id){
		if(comentarioService.exits(id)) {
			return new ResponseEntity(comentarioService.get(id),HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
			 
		}
		
	/** 
	* Pasado un id de un comentario si este existe en bbdd sera eliminado del mismo
	* @param {@link int}
	* @return {@link HttpStatus}
	*/
	@GetMapping("/delete{id}")
	public ResponseEntity<?> deleteComentario(@RequestBody int id){
		if(comentarioService.delete(id)) {
			
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	
}
