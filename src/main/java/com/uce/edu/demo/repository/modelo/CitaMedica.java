package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="cita_medica")
public class CitaMedica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cita_medica")
	@SequenceGenerator(name="seq_cita_medica", sequenceName = "seq_cita_medica", allocationSize = 1)
	@Column(name = "cime_id")
	private Integer id;
	
	@Column(name = "cime_numero_cita")
	private Integer numeroCita;
	
	@Column(name = "cime_fecha_cita")
	private LocalDateTime fechaCita;
	
	@Column(name = "cime_valor_cita")
	private BigDecimal valorCita;
	
	@Column(name = "cime_lugar_cita")
	private String lugarCita;
	
	@Column(name = "cime_diagnostico")
	private String  diagnostico;
	
	@Column(name = "cime_receta")
	private String receta;
	
	@Column(name = "cime_fecha_proxima_cita")
	private LocalDateTime fechaProximaCita;
	
	@ManyToOne
	@JoinColumn(name = "paci_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "doct_id")
	private Doctor doctor;
	
	// set y get

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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	

}
