package com.uce.edu.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.to.PacienteTo;
import com.uce.edu.demo.serviice.IPacienteService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/pacientes")
public class PacienteControllerRestFull {
	
	  @Autowired
	  private IPacienteService pacienteService;
	  
	  @PostMapping(path = "/insertar", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<PacienteTo> insertarPaciente(@RequestBody PacienteTo pacienteTo) {
	        
	       this.pacienteService.insertarPacienteNuevo(pacienteTo);

	       Link link = linkTo(methodOn(PacienteControllerRestFull.class)
	                .buscarPaciente(pacienteTo.getId())).withSelfRel();
	        pacienteTo.add(link);
	        
	       return ResponseEntity.ok(pacienteTo);
	    }

	  
	  @GetMapping(path = "/buscar-por-id/{id}")
	    public PacienteTo buscarPaciente(@PathVariable Integer id) {
	        return this.pacienteService.buscarPaciente(id);
	    }

	  @GetMapping(path = "/buscar-por-cedula")
	    public PacienteTo buscarPacientePorCedula(@RequestParam String cedula) {
	        return this.pacienteService.buscarPacientePorCedula(cedula);
	    }

}
