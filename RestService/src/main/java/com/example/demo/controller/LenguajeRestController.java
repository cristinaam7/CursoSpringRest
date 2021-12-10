package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Lenguaje;
import com.example.demo.service.LenguajeService;

@RestController
@RequestMapping("/api")
public class LenguajeRestController {
	
	@Autowired
	LenguajeService lenguajeService;
	
	@GetMapping("/lenguajes")
	public ResponseEntity<?> getLenguajes(){
		List<Lenguaje> lenguajes = lenguajeService.getLenguajes();
		if(lenguajes != null && lenguajes.size() > 0) {
			return new ResponseEntity<>(lenguajes, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/NuevoLenguaje")
	public ResponseEntity<?> crearLenguaje(@RequestBody Lenguaje lenguaje){
		lenguajeService.crearLenguaje(lenguaje);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
