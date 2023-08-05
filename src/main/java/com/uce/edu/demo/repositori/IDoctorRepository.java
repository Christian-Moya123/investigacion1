package com.uce.edu.demo.repositori;

import com.uce.edu.demo.repository.modelo.Doctor;

public interface IDoctorRepository {
	
	void insertarDoctor(Doctor doctor);
	Doctor buscarDoctor(Integer id);
	void actualizarDoctor(Doctor doctor);
	void borrarDoctor(Integer id);
    Doctor buscarDoctorPorCedula(String cedula);

}
