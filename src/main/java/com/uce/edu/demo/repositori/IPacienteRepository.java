package com.uce.edu.demo.repositori;

import com.uce.edu.demo.repository.modelo.Paciente;

public interface IPacienteRepository {
	
	void insertarPaciente(Paciente paciente);
	Paciente buscarPaciente(Integer id);
	void actualizarPaciente(Paciente paciente);
	void borrarPaciente(Integer id);
    Paciente buscarPacientePorCedula(String cedula);
    
    Paciente insertarPacienteNuevoH(Paciente paciente);

}
