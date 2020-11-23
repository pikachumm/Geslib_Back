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

import com.geslib.back.modelo.Comentario;
import com.geslib.back.servicio.ComentarioService;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
	@Autowired
	ComentarioService comentarioService;
	
	@GetMapping("/listarComentarios")
    public ResponseEntity<List<Comentario>> listarComentarios(){
		List<Comentario> list = comentarioService.listarComentario();
		 return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PostMapping("/addComentario")
	public ResponseEntity<?> addComentario(@RequestBody Comentario comentario){
		comentarioService.add(comentario);
		 return new ResponseEntity(HttpStatus.OK);
	}
	@PostMapping("/updateComentario")
	public ResponseEntity<?> updateComentario(@RequestBody Comentario comentario){
		comentarioService.update(comentario);
		 return new ResponseEntity(HttpStatus.OK);
	}
	@PostMapping("/getComentario")
	public ResponseEntity<?> updateComentario(@RequestBody int id){
		 return new ResponseEntity(comentarioService.get(id),HttpStatus.OK);
	}
	@PostMapping("/deleteComentario")
	public ResponseEntity<?> deleteComentario(@RequestBody int id){
		comentarioService.delete(id);
		 return new ResponseEntity(HttpStatus.OK);
	}
	
	
	
}
