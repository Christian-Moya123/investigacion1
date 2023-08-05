package com.uce.edu.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.service.to.DoctorTo;
import com.uce.edu.demo.serviice.IDoctorService;

@RestController
@RequestMapping("/doctores")
public class DoctorControllerRestFull {
	
	@Autowired
    private IDoctorService doctorService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertarDoctor(@RequestBody DoctorTo doctor) {
		this.doctorService.insertarDoctor(doctor);
	}
	
	 @GetMapping("/{id}")
	    public DoctorTo buscarDoctor(@PathVariable Integer id) {
	        return this.doctorService.buscarDoctor(id);
	    }

}
