package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Profesor;
import com.example.demo.mapper.ProfesorMapper;
import com.example.demo.model.ProfesorModel;
import com.example.demo.service.ProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<ProfesorModel> getProfesores() {
		return ProfesorMapper.mapearProfesores(profesorService.findAll());
	}
	
	@GetMapping("/profesorByEmail")
	public ResponseEntity<?> getProfesorByEmail(@RequestBody Profesor profesor) {
		Profesor profesorFound = profesorService.findeByEmail(profesor.getEmail());
		if(profesorFound != null){
			return new ResponseEntity<>(ProfesorMapper.mapearProfesor(profesorFound), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/login")
	public ResponseEntity<Void> login(@RequestBody Profesor profesor) {
		Profesor profesorFound = profesorService.checkProfesorLogin(profesor);
		if(profesorFound != null){
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/crearProfesor")
	public ResponseEntity<Void> crearProfesor(@RequestBody Profesor profesor){
		if(profesorService.findProfesor(profesor) == null ) {
			profesorService.addProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/updateProfesor/{id}")
	public ResponseEntity<?> updateProfesor(@PathVariable(value="id")Long id, @RequestBody Profesor profesor){
		Profesor profesorFound = profesorService.findById(id);
		if(profesorFound != null ) {
			profesorFound.setNombre(profesor.getNombre());
			profesorFound.setEmail(profesor.getEmail());
			profesorService.updateProfesor(profesorFound);
			return new ResponseEntity<>(ProfesorMapper.mapearProfesor(profesorFound), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/updateProfesorSql")
	public ResponseEntity<?> updateProfesorSql(@RequestBody Profesor profesor){
		Profesor profesorFound = profesorService.findProfesorByIdSQL(profesor.getId());
		if(profesorFound != null ) {
			profesorFound.setNombre(profesor.getNombre());
			profesorFound.setEmail(profesor.getEmail());
			profesorService.updateProfesor(profesorFound);
			return new ResponseEntity<>(ProfesorMapper.mapearProfesor(profesorFound), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteProfesor/{id}")
	public ResponseEntity<Void> deleteProfesor(@PathVariable(value="id")Long id){
		if(profesorService.findById(id) != null ) {
			profesorService.deleteProfesorById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/deleteProfesorSql")
	public ResponseEntity<Void> deleteProfesorSql(@RequestBody Profesor profesor){
		if(profesorService.findById(profesor.getId()) != null ) {
			profesorService.deleteProfesorById(profesor.getId());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteProfesor")
	public ResponseEntity<Void> deleteProfesor(){
		profesorService.deleteAllProfesor();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


}
