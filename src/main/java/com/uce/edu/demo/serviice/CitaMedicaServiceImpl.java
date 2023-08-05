package com.uce.edu.demo.serviice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repositori.ICitaMedicaRepository;
import com.uce.edu.demo.repositori.IDoctorRepository;
import com.uce.edu.demo.repositori.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.service.to.CitaMedicaTo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {
	
	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;
	@Autowired
	private IPacienteRepository pacienteRepository;
	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Override
	public void insertarCitaMedica(CitaMedicaTo citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.insertarCitaMedica(this.convertir(citaMedica));
		
	}
	@Override
	public CitaMedicaTo buscarCitaMedica(Integer id) {
		// TODO Auto-generated method stub
		return this.convertirTo(this.citaMedicaRepository.buscarCitaMedica(id));
	}
	@Override
	public void actualizarCitaMedica(CitaMedicaTo citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.actualizarCitaMedica(this.convertir(citaMedica));
		
	}
	@Override
	public void borrarCitaMedica(Integer id) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.borrarCitaMedica(id);
		
	}
	@Override
	public CitaMedicaTo buscarCitaMedicaPorNumeroDeCita(Integer numero) {
		// TODO Auto-generated method stub
		return this.convertirTo(this.citaMedicaRepository.buscarCitaMedicaPorNumeroDeCita(numero));
	}
	@Override
	public List<CitaMedicaTo> citasMedicasPendientes(String cedula) {
		// TODO Auto-generated method stub
		 List<CitaMedica> citasMedicas = this.citaMedicaRepository.citasMedicasPendientes(cedula);
		    List<CitaMedicaTo> citasMedicasTo = new ArrayList<>();

		    for (CitaMedica cita : citasMedicas) {
		        citasMedicasTo.add(convertirTo(cita));
		    }

		    return citasMedicasTo;
	}
	
	private CitaMedicaTo convertirTo(CitaMedica citaMedica) {
		CitaMedicaTo citaMedicaTo = new CitaMedicaTo();
		citaMedicaTo.setId(citaMedica.getId());
		citaMedicaTo.setNumeroCita(citaMedica.getNumeroCita());
		citaMedicaTo.setFechaCita(citaMedica.getFechaCita());
		citaMedicaTo.setValorCita(citaMedica.getValorCita());
		citaMedicaTo.setLugarCita(citaMedica.getLugarCita());
		citaMedicaTo.setDiagnostico(citaMedica.getDiagnostico());
		citaMedicaTo.setReceta(citaMedica.getReceta());
		citaMedicaTo.setFechaProximaCita(citaMedica.getFechaProximaCita());

		citaMedicaTo.setIdPaciente(citaMedica.getPaciente().getId());
		citaMedicaTo.setIdDoctor(citaMedica.getDoctor().getId());

		return citaMedicaTo;
	}
	
	private CitaMedica convertir(CitaMedicaTo citaMedicaTo) {
		CitaMedica citaMedica = new CitaMedica();
		citaMedica.setId(citaMedicaTo.getId());
		citaMedica.setNumeroCita(citaMedicaTo.getNumeroCita());
		citaMedica.setFechaCita(citaMedicaTo.getFechaCita());
		citaMedica.setValorCita(citaMedicaTo.getValorCita());
		citaMedica.setLugarCita(citaMedicaTo.getLugarCita());
		citaMedica.setDiagnostico(citaMedicaTo.getDiagnostico());
		citaMedica.setReceta(citaMedicaTo.getReceta());
		citaMedica.setFechaProximaCita(citaMedicaTo.getFechaProximaCita());

		citaMedica.setPaciente(this.pacienteRepository.buscarPaciente(citaMedicaTo.getIdPaciente()));
		citaMedica.setDoctor(this.doctorRepository.buscarDoctor(citaMedicaTo.getIdDoctor()));

		return citaMedica;
	}
	
	

}
