package com.uce.edu.demo.controler;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.to.CitaMedicaTo;
import com.uce.edu.demo.service.to.DoctorTo;
import com.uce.edu.demo.service.to.PacienteTo;
import com.uce.edu.demo.serviice.ICitaMedicaService;
import com.uce.edu.demo.serviice.IDoctorService;
import com.uce.edu.demo.serviice.IPacienteService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/citasmedicas")
public class CitaMedicaControllerRestFull {
	
	@Autowired
    private ICitaMedicaService citaMedicaService;
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IPacienteService pacienteService;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void agendarCita(@RequestBody CitaMedica citaMedicaRequest) {
        CitaMedicaTo citaMedicaTo = new CitaMedicaTo();
        citaMedicaTo.setNumeroCita(citaMedicaRequest.getNumeroCita());
        citaMedicaTo.setFechaCita(citaMedicaRequest.getFechaCita());
        citaMedicaTo.setValorCita(citaMedicaRequest.getValorCita());
        citaMedicaTo.setLugarCita(citaMedicaRequest.getLugarCita());

        DoctorTo doctor = this.doctorService.buscarDoctorPorCedula(citaMedicaRequest.getDoctor().getCedula());
        PacienteTo paciente = this.pacienteService.buscarPacientePorCedula(citaMedicaRequest.getPaciente().getCedula());

        citaMedicaTo.setCedulaDoctor(doctor);
        citaMedicaTo.setCedulaPaciente(paciente);

        this.citaMedicaService.insertarCitaMedica(citaMedicaTo);
    }
    
    @PutMapping(path = "/actualizar_cita/{numeroCita}")
    public void actualizarCitaMedica(@PathVariable Integer numeroCita, @RequestParam String diagnostico, @RequestParam String receta, @RequestParam LocalDateTime fecha) {
        CitaMedicaTo citaMedica = this.citaMedicaService.buscarCitaMedicaPorNumeroDeCita(numeroCita);
        citaMedica.setDiagnostico(diagnostico);
        citaMedica.setReceta(receta);
        citaMedica.setFechaProximaCita(fecha);

        this.citaMedicaService.actualizarCitaMedica(citaMedica);
    }
    
    

}
