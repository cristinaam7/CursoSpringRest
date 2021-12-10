package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Profesor;

public interface ProfesorService {
	public List<Profesor> findAll();
	
	public Profesor findProfesor(Profesor profesor);
	
	public Profesor checkProfesorLogin(Profesor profesor);
	
	public Profesor findById(Long id);
	
	public Profesor findProfesorByIdSQL(Long id);
	
	public Profesor findeByEmail(String email);
	
	public Profesor addProfesor(Profesor profesor);
	
	public Profesor updateProfesor(Profesor profesor);
	
	public void deleteProfesorById(Long id);
	
	public void deleteProfesor(Profesor profesor);
	
	public void deleteAllProfesor();
	
}
