package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import com.geslib.back.modelo.Reserva;

public interface IReservaService {
	List<Reserva> listarReservas();
	Optional<Reserva> obtenerReserva(int id);
	void add(Reserva reserva);
	boolean update(Reserva reserva);
	void delete(int id);
}
