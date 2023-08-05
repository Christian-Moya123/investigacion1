package com.uce.edu.demo.serviice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repositori.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.to.PacienteTo;

@Service
public class PacienteServiceImpl implements IPacienteService {
	
	  @Autowired
	  private IPacienteRepository pacienteRepository;

	@Override
	public void insertarPaciente(PacienteTo paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepository.insertarPaciente(this.convertir(paciente));
		
	}
	
	public void insertarPacienteNuevo(PacienteTo paciente) {
		 this.pacienteRepository.insertarPaciente(this.convertir(paciente));
	}

	@Override
	public PacienteTo buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		return this.convertiTor(this.pacienteRepository.buscarPaciente(id));
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepository.actualizarPaciente(paciente);
		
	}

	@Override
	public void borrarPaciente(Integer id) {
		// TODO Auto-generated method stub
		this.pacienteRepository.borrarPaciente(id);
		
	}
	
	@Override
    public PacienteTo insertarPacienteNuevoH(PacienteTo pacienteTo) {
        Paciente pacienteInsertado = pacienteRepository.insertarPacienteNuevoH(convertir(pacienteTo));

        return convertiTor(pacienteInsertado);
    }

	@Override
	public PacienteTo buscarPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.convertiTor(this.pacienteRepository.buscarPacientePorCedula(cedula));
	}
	
	private Paciente convertir(PacienteTo pacienteTo) {
		Paciente paciente = new Paciente();
		paciente.setApellido(pacienteTo.getApellido());
		paciente.setCedula(pacienteTo.getCedula());
		paciente.setCodigoSeguro(pacienteTo.getCodigoSeguro());
		paciente.setEstatura(pacienteTo.getEstatura());
		paciente.setFechaNacimiento(pacienteTo.getFechaNacimiento());
		paciente.setGenero(pacienteTo.getGenero());
		paciente.setId(pacienteTo.getId());
		paciente.setNombre(pacienteTo.getNombre());
		paciente.setPeso(pacienteTo.getPeso());
		
		return paciente;
		
	}
	
	private PacienteTo convertiTor(Paciente paciente) {
		PacienteTo pacienteTo = new PacienteTo();
		pacienteTo.setApellido(paciente.getApellido());
		pacienteTo.setCedula(paciente.getCedula());
		pacienteTo.setCodigoSeguro(paciente.getCodigoSeguro());
		pacienteTo.setEstatura(paciente.getEstatura());
		pacienteTo.setFechaNacimiento(paciente.getFechaNacimiento());
		pacienteTo.setGenero(paciente.getGenero());
		pacienteTo.setId(paciente.getId());
		pacienteTo.setNombre(paciente.getNombre());
		pacienteTo.setPeso(paciente.getPeso());
		
		return pacienteTo;
		
	}

}
