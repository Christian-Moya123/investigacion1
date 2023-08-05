package com.uce.edu.demo.serviice;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.to.DoctorTo;
import com.uce.edu.demo.service.to.PacienteTo;

public interface IDoctorService {
	
	void insertarDoctor(DoctorTo doctor);
	DoctorTo buscarDoctor(Integer id);
	void actualizarDoctor(Doctor doctor);
	void borrarDoctor(Integer id);
	public DoctorTo buscarDoctorPorCedula(String doctor);
}
