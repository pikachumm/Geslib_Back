package com.geslib.back.controladorrest;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geslib.back.Validators.Validator;
import com.geslib.back.modelo.Direccion;
import com.geslib.back.modelo.Provincia;
import com.geslib.back.modelo.Rol;
import com.geslib.back.modelo.Sexo;
import com.geslib.back.modelo.Usuario;
import com.geslib.back.servicio.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	private Validator validator;
	@GetMapping("/list")
    public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> list = usuarioService.listar();
		 return new ResponseEntity(list, HttpStatus.OK);
	}
	@GetMapping("/test")
    public ResponseEntity<?> test(){
		Set<Rol> roles = new HashSet<Rol>();
		roles.add(new Rol("ADMIN"));
		Direccion direccion = new Direccion(Provincia.Madrid, "madrid", "28030", "san cipriano", 7, 7,(char) 0);
		Date d = new Date(2020, 8, 8, 8, 8);
		Usuario user = new Usuario("05306244Y", "test@test.com", "passwords", "prueba", d, Sexo.Hombre, "Miguel", "pozo", direccion, roles);
		 return new ResponseEntity(HttpStatus.OK);
	}
	/** 
	* Si existe un comentario en la bbdd con el id este sera eliminado	
	* @param int
	* @return {@link HttpStatus}
	* 
	*/
	@PostMapping("/add")
	public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario){
		if(validator.isValid(usuario)) {
			usuarioService.Add(usuario);
			 return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	/** 
	* Si existe un comentario en la bbdd con el id este sera eliminado	
	* @param int
	* @return {@link HttpStatus}
	* 
	*/
	@PostMapping("/update")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario){
		if(usuarioService.exits(usuario.getIdUsuario())) {
			usuarioService.update(usuario);
			 return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}
	/** 
	* Si existe un comentario en la bbdd con el id este sera eliminado	
	* @param int
	* @return {@link Usuario}
	* 
	*/
	@GetMapping("/get{id}")
	public ResponseEntity<?> getUsuario(@RequestBody int id){
		if(usuarioService.exits(id)){
			return new ResponseEntity(usuarioService.get(id),HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
					}
		}
		
			 
		
	/** 
	* Si existe un comentario en la bbdd con el id este sera eliminado	
	* @param int
	* @return {@link HttpStatus}
	* 
	*/
	@GetMapping("/delete{id}")
	public ResponseEntity<?> deleteUsuario(@RequestBody int id){
		if(usuarioService.exits(id)){
			return new ResponseEntity(usuarioService.delete(id),HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
}
