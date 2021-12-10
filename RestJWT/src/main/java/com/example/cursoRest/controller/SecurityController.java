package com.example.cursoRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecurityController {

	@GetMapping("/datosBancarios")
	public ResponseEntity<?> GetInfoBancaria() {
		List<String> movs = obtenerMovBancarios();
		if(movs.size() > 0) {
			return new ResponseEntity<>(movs, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Esto deberia ser una llamada a la base de datos
	private List<String> obtenerMovBancarios(){
		List<String> movs = new ArrayList<>();
		movs.add("Vacaciones: 2000");
		movs.add("Coche: 200");
		movs.add("Hipoteca: 200");
		movs.add("Super: 100");
		return movs;
	}
}
