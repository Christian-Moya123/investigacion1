package com.uce.edu.demo.serviice;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.to.PacienteTo;

public interface IPacienteService {
	
	void insertarPaciente(PacienteTo paciente);
	PacienteTo buscarPaciente(Integer id);
	void actualizarPaciente(Paciente paciente);
	void borrarPaciente(Integer id);
    PacienteTo buscarPacientePorCedula(String cedula);
    public void insertarPacienteNuevo(PacienteTo paciente);
    
    PacienteTo insertarPacienteNuevoH(PacienteTo pacienteTo);

}
