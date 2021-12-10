package com.example.cursoRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursoRest.domain.Profesor;
import com.example.cursoRest.service.ProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {
	
	@Autowired
	ProfesorService profesorService;
	
	@GetMapping("/profesores")
	public ResponseEntity<?> getProfesores(){
		List<Profesor> profesores = profesorService.findAllProfesors();
		if(profesores != null) {
			return new ResponseEntity<>(profesores, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/profesores_admin")
	public ResponseEntity<?> getProfesoresAdmin(){
		List<Profesor> profesores = profesorService.findAllProfesors();
		if(profesores != null) {
			return new ResponseEntity<>(profesores, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/profesores_users")
	public ResponseEntity<?> getProfesoresUsers(){
		List<Profesor> profesores = profesorService.findAllProfesors();
		if(profesores != null) {
			return new ResponseEntity<>(profesores, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

}
