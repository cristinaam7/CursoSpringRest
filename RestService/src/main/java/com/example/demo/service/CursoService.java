package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Curso;

public interface CursoService {
	
	public List<Curso> getCursos();
	
	public Curso crearCurso(Curso curso);
	
	public Curso modificarCurso(Curso curso);
	
	public void eliminarCurso(Long id);
	
	public Curso findCurso(Long id);
	
	public List<Curso> findCursosByProfesor(Long profesorId);
}
