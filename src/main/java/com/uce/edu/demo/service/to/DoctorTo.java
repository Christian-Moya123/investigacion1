package com.uce.edu.demo.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.uce.edu.demo.repository.modelo.CitaMedica;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

public class DoctorTo extends RepresentationModel<DoctorTo> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String cedula;
	
	private String nombre;
	
	private String apellido;
	
	private LocalDateTime fechaNacimiento;
	
	private String numeroConsultorio;
	
	private String codigoSenescyt;
	
	private String gernero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(String numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	public String getCodigoSenescyt() {
		return codigoSenescyt;
	}

	public void setCodigoSenescyt(String codigoSenescyt) {
		this.codigoSenescyt = codigoSenescyt;
	}

	public String getGernero() {
		return gernero;
	}

	public void setGernero(String gernero) {
		this.gernero = gernero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
