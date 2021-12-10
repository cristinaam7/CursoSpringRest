package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Profesor;

public interface ProfesorDao extends CrudRepository<Profesor, Long>{
	
	public Profesor findByEmail(String email);
	
	public Profesor findByEmailAndPassword(String email, String password);
	
	@Query("SELECT p FROM Profesor p WHERE p.id = ?1")
	public Optional<Profesor> findByIdSQL(Long id);
}
