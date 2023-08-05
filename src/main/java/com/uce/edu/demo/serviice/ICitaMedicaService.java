package com.uce.edu.demo.serviice;

import java.util.List;

import com.uce.edu.demo.service.to.CitaMedicaTo;

public interface ICitaMedicaService {

	void insertarCitaMedica(CitaMedicaTo citaMedica);
	CitaMedicaTo buscarCitaMedica(Integer id);
	void actualizarCitaMedica(CitaMedicaTo citaMedica);
	void borrarCitaMedica(Integer id);
    CitaMedicaTo buscarCitaMedicaPorNumeroDeCita(Integer numero);
    List<CitaMedicaTo> citasMedicasPendientes(String cedula);
}
