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

import com.geslib.back.Temporals.Id;
import com.geslib.back.modelo.Comentario;

import com.geslib.back.modelo.Reserva;
import com.geslib.back.servicio.ComentarioService;
import com.geslib.back.servicio.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
	@Autowired
	ReservaService reservaService;
	
	@GetMapping("/list")
    public ResponseEntity<List<Comentario>> listarComentarios(){
		List<Reserva> list = reservaService.listarReservas();
		 return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addComentario(@RequestBody Reserva reserva){
		reservaService.add(reserva);
		 return new ResponseEntity(HttpStatus.OK);
	}
	@PostMapping("/update")
	public ResponseEntity<?> updateComentario(@RequestBody Reserva reserva){
		reservaService.update(reserva);
		 return new ResponseEntity(HttpStatus.OK);
	}
	@PostMapping("/get")
	public ResponseEntity<?> get(@RequestBody Id id){
		 return new ResponseEntity(reservaService.obtenerReserva(id.getId()),HttpStatus.OK);
	}
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Id id){
		reservaService.delete(id.getId());
		 return new ResponseEntity(HttpStatus.OK);
	}

}
