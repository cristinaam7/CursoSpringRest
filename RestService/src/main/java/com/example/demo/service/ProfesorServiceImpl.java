package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ProfesorDao;
import com.example.demo.entity.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	private ProfesorDao profesorDao;

	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		return (List<Profesor>) profesorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findProfesor(Profesor profesor) {
		return profesorDao.findByEmail(profesor.getEmail());
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor checkProfesorLogin(Profesor profesor) {
		return profesorDao.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Long id) {
		return (Profesor) profesorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findProfesorByIdSQL(Long id) {
		return profesorDao.findByIdSQL(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Profesor findeByEmail(String email) {
		return profesorDao.findByEmail(email);
	}

	@Override
	@Transactional
	public Profesor updateProfesor(Profesor profesor) {
		return profesorDao.save(profesor);
	}

	@Override
	@Transactional
	public void deleteProfesorById(Long id) {
		profesorDao.deleteById(id);	
	}

	@Override
	@Transactional
	public void deleteProfesor(Profesor profesor) {
		profesorDao.delete(profesor);
	}
	
	@Override
	@Transactional
	public void deleteAllProfesor() {
		profesorDao.deleteAll();
	}

	@Override
	@Transactional
	public Profesor addProfesor(Profesor profesor) {
		return profesorDao.save(profesor);
	}
}
