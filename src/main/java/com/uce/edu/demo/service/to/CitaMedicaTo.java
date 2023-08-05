package com.uce.edu.demo.service.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CitaMedicaTo extends RepresentationModel<CitaMedicaTo> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer numeroCita;
	
	private LocalDateTime fechaCita;
	
	private BigDecimal valorCita;
	
	private String lugarCita;
	
	private String  diagnostico;
	
	private String receta;
	
	private LocalDateTime fechaProximaCita;

	private Integer idPaciente;
	
	private Integer idDoctor;
	
	private PacienteTo cedulaPaciente;
	
	private DoctorTo cedulaDoctor;

	

	

	public PacienteTo getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(PacienteTo cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}


	public DoctorTo getCedulaDoctor() {
		return cedulaDoctor;
	}

	public void setCedulaDoctor(DoctorTo cedulaDoctor) {
		this.cedulaDoctor = cedulaDoctor;
	}

	public void setIdDoctor(Integer idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroCita() {
		return numeroCita;
	}

	public void setNumeroCita(Integer numeroCita) {
		this.numeroCita = numeroCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getFechaProximaCita() {
		return fechaProximaCita;
	}

	public void setFechaProximaCita(LocalDateTime fechaProximaCita) {
		this.fechaProximaCita = fechaProximaCita;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getIdDoctor() {
		return idDoctor;
	}

	

	

	
	

}
