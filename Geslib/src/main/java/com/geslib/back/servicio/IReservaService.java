package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import com.geslib.back.modelo.Reserva;

/** 
 * Interfaz de ReservaService con todas las funciones
 *  necesarias para la gestion de controladores
 *  Rest
 * 
 * @author Miguel del Pozo y Rafael Sacristan
 * @version 1.0
*/
public interface IReservaService {
	List<Reserva> listarReservas();
	Optional<Reserva> obtenerReserva(int id);
	void add(Reserva reserva);
	boolean update(Reserva reserva);
	void delete(int id);
	boolean exits(int id);
}
