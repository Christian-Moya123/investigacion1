package com.uce.edu.demo.repositori;

import java.util.List;

import com.uce.edu.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaRepository {
	
	void insertarCitaMedica(CitaMedica citaMedica);
	CitaMedica buscarCitaMedica(Integer id);
	void actualizarCitaMedica(CitaMedica citaMedica);
	void borrarCitaMedica(Integer id);
    CitaMedica buscarCitaMedicaPorNumeroDeCita(Integer numero);
    List<CitaMedica> citasMedicasPendientes(String cedula);

}
