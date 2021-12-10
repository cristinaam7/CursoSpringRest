package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Curso;

public interface CursoDao extends CrudRepository<Curso, Long>{
	
	public List<Curso> findByProfesorId(Long profesorId);
	
}
