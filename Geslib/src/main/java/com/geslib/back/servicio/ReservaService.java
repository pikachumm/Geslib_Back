package com.geslib.back.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geslib.back.modelo.Reserva;
import com.geslib.back.repositorio.ReservaRepository;

@Service
@Transactional
public class ReservaService implements IReservaService{
	@Autowired
	ReservaRepository reservaRepository;

	@Override
	public List<Reserva> listarReservas() {
		// TODO Auto-generated method stub
		return (List<Reserva>) reservaRepository.findAll();
	}

	@Override
	public Optional<Reserva> obtenerReserva(int id) {
		// TODO Auto-generated method stub
		return reservaRepository.findById(id);
	}

	@Override
	public void add(Reserva reserva) {
		// TODO Auto-generated method stub
		reservaRepository.save(reserva);
	}

	@Override
	public boolean update(Reserva reserva) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		reservaRepository.deleteById(id);
	}
	

}
