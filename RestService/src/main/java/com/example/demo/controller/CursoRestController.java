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

import com.example.demo.entity.Curso;
import com.example.demo.entity.Profesor;
import com.example.demo.service.CursoService;

@RestController
@RequestMapping("/api")
public class CursoRestController {
	
	@Autowired
	CursoService cursoService;
	
	@GetMapping("/cursos")
	public ResponseEntity<?> obtenerCursos() {
		List<Curso> cursos = cursoService.getCursos();
		if(cursos != null && cursos.size() > 0) {
			return new ResponseEntity<>(cursos, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/cursosProfesor")
	public ResponseEntity<?> obtenerCursosProfesor(@RequestBody Profesor profesor) {
		List<Curso> cursos = cursoService.findCursosByProfesor(profesor.getId());
		if(cursos != null && cursos.size() > 0) {
			return new ResponseEntity<>(cursos, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/cursoCrear")
	public ResponseEntity<?> crearCurso(@RequestBody Curso curso){
		Curso cursoNuevo = cursoService.crearCurso(curso);
		if(cursoNuevo != null) {
			return new ResponseEntity<>(cursoNuevo, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
