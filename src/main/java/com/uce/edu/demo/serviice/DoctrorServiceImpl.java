package com.uce.edu.demo.serviice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repositori.IDoctorRepository;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.service.to.DoctorTo;


@Service
public class DoctrorServiceImpl implements IDoctorService{

	  @Autowired
		private IDoctorRepository doctorRepository;

	@Override
	public void insertarDoctor(DoctorTo doctor) {
		// TODO Auto-generated method stub
		this.doctorRepository.insertarDoctor(this.convertir(doctor));
		
	}



	@Override
	public DoctorTo buscarDoctor(Integer id) {
		// TODO Auto-generated method stub
		return this.convertirTO(this.doctorRepository.buscarDoctor(id));
	}



	@Override
	public void actualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepository.actualizarDoctor(doctor);
		
	}



	@Override
	public void borrarDoctor(Integer id) {
		// TODO Auto-generated method stub
		this.doctorRepository.borrarDoctor(id);
	}



	@Override
	public DoctorTo buscarDoctorPorCedula(String doctor) {
		// TODO Auto-generated method stub
		return this.convertirTO(this.doctorRepository.buscarDoctorPorCedula(doctor));

	
	}
	

	private DoctorTo convertirTO(Doctor doctor) {
		DoctorTo doctorTo = new DoctorTo();
		doctorTo.setId(doctor.getId());
		doctorTo.setApellido(doctor.getApellido());
		doctorTo.setCedula(doctor.getCedula());
		doctorTo.setCodigoSenescyt(doctor.getCodigoSenescyt());
		doctorTo.setFechaNacimiento(doctor.getFechaNacimiento());
		doctorTo.setGernero(doctor.getGernero());
		doctorTo.setNombre(doctor.getNombre());
		doctorTo.setNumeroConsultorio(doctor.getNumeroConsultorio());
		return doctorTo;
				
	}
	
	private Doctor convertir(DoctorTo doctorTo) {
		Doctor doctor = new Doctor();
		doctor.setId(doctorTo.getId());
		doctor.setApellido(doctorTo.getApellido());
		doctor.setCedula(doctorTo.getCedula());
		doctor.setCodigoSenescyt(doctorTo.getCodigoSenescyt());
		doctor.setFechaNacimiento(doctorTo.getFechaNacimiento());
		doctor.setGernero(doctorTo.getGernero());
		doctor.setNombre(doctorTo.getNombre());
		doctor.setNumeroConsultorio(doctorTo.getNumeroConsultorio());
		return doctor;
				
	}

}
