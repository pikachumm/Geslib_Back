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

import com.geslib.back.modelo.Reserva;
import com.geslib.back.servicio.ReservaService;

/** 
 * Controlador Rest para servicios de comentarios
 * Se encarga de las peticiones post y get 
 * consta de las siguientes funciones:
 * {@link listarReservas},
 * {@link addReserva},
 * {@link updateReserva},
 * {@link get},
 * {@link delete}
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
@RestController
@RequestMapping("/reservas")
public class ReservaController {
	@Autowired
	ReservaService reservaService;
	
	private Validator validator;
	
	/** 
	* Devuelve una lista con todos los materiales sean peliculas o libros
	* @param none
	* @return list<Reserva>
	*/
	@GetMapping("/list")
    public ResponseEntity<List<Reserva>> listarReservas(){
		List<Reserva> list = reservaService.listarReservas();
		 return new ResponseEntity(list, HttpStatus.OK);
	}
	
    /** 
	* Dado una Reserva este lo valida y añade a bbddd si procede
	* 
	* @param reserva
	* @return {@link HttpStatus}}
	*/
	@PostMapping("/add")
	public ResponseEntity<?> addReserva(@RequestBody Reserva reserva){
		if(validator.isValid(reserva)) {
			reservaService.add(reserva);
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		 
	}


	/** 
	* Si existe un comentario en la bbdd con el id este se actualizara
	* @param {@link Reserva}}
	* @return {@link HttpStatus}
	*/
	@PostMapping("/update")
	public ResponseEntity<?> updateReserva(@RequestBody Reserva reserva){
		if(validator.isValid(reserva)) {
			if(reservaService.update(reserva)) {
				
			}else {
				
			}
		}
		reservaService.update(reserva);
		 return new ResponseEntity(HttpStatus.OK);
	}
	
	/** 
	* Si existe una Reserva en la bbdd con el id este se actualizara
	* @param {@link int}}
	* @return {@link Reserva}
	*/
	@GetMapping("/get{id}")
	public ResponseEntity<?> get(@RequestBody int id){
		if(reservaService.exits(id)) {
			return new ResponseEntity(reservaService.obtenerReserva(id),HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		 
	}
	
	/** 
	* Si existe un comentario en la bbdd con el id este sera eliminado
	* @param {@link Comentario}}
	* @return {@link HttpStatus}
	*/
	@GetMapping("/delete{id}")
	public ResponseEntity<?> delete(@RequestBody int id){
		if(reservaService.exits(id)) {
			reservaService.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		 
	}

}
