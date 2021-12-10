package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Lenguaje;
import com.example.demo.entity.Profesor;
import com.example.demo.model.ProfesorLenguaje;
import com.example.demo.service.LenguajeService;
import com.example.demo.service.ProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorLenguajeRestController {
	
	@Autowired
	LenguajeService lenguajeSevice;
	
	@Autowired
	ProfesorService profesorService;
	
	@PostMapping("/getLenguajesProfesor")
	public ResponseEntity<?> get_lenguajes_profesor(@RequestBody Profesor profesor){
		Profesor profesorBd = profesorService.findById(profesor.getId());
		if(profesorBd != null) {
			Collection<Lenguaje> lenguajes = profesorBd.getLenguajes();
			if(lenguajes != null) {
				return new ResponseEntity<>(lenguajes, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("CrearLenguajeProfesor")
	public ResponseEntity<?> crear_lenguaje_profesor(@RequestBody ProfesorLenguaje profesorLenguage){
		Profesor profesorBd = profesorService.findById(profesorLenguage.getProfesor().getId());
		if(profesorBd != null) {
			
			Lenguaje lenguajeBd = lenguajeSevice.findLenguaje(profesorLenguage.getLenguaje());
			if(lenguajeBd != null) {
				profesorBd.addLenguaje(lenguajeBd);
				profesorService.addProfesor(profesorBd);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	

}
