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

import com.geslib.back.Temporals.Id;
import com.geslib.back.Temporals.Mensaje;
import com.geslib.back.modelo.Comentario;

import com.geslib.back.servicio.ComentarioService;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
	@Autowired
	ComentarioService comentarioService;
	
	@GetMapping("/list")
    public ResponseEntity<List<Comentario>> listarComentarios(){
		List<Comentario> list = comentarioService.listarComentario();
		 return new ResponseEntity(list, HttpStatus.OK);
	}
	@GetMapping("/test")
    public ResponseEntity<List<Comentario>> test(){
		Comentario t = new Comentario("comentario", "texto", new Date(2020, 1, 1, 1, 1), null, null);
		 return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addComentario(@RequestBody Comentario comentario){
		comentarioService.add(comentario);
		 return new ResponseEntity(HttpStatus.OK);
	}
	@PostMapping("/update")
	public ResponseEntity<?> updateComentario(@RequestBody Comentario comentario){
		comentarioService.update(comentario);
		 return new ResponseEntity(HttpStatus.OK);
	}
	@PostMapping("/get")
	public ResponseEntity<?> updateComentario(@RequestBody Id id){
		if(comentarioService.exits(id.getId())) {
			 return new ResponseEntity(comentarioService.get(id.getId()),HttpStatus.OK);
		}else {
			 return new ResponseEntity(new Mensaje("Error"),HttpStatus.BAD_REQUEST);
		}
		
	}
	@PostMapping("/delete")
	public ResponseEntity<?> deleteComentario(@RequestBody Id id){
		if(comentarioService.exits(id.getId())) {
			return new ResponseEntity("borrado",HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.OK);
		}
		
	}
	
	
	
}
