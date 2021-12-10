package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CursoDao;
import com.example.demo.entity.Curso;

@Service
public class CursoServiceImpl implements CursoService{
	
	@Autowired
	private CursoDao cursoDao;

	@Override
	@Transactional(readOnly=true)
	public List<Curso> getCursos() {
		return (List<Curso>) cursoDao.findAll();
	}

	@Override
	@Transactional
	public Curso crearCurso(Curso curso) {
		return cursoDao.save(curso);
	}

	@Override
	@Transactional
	public Curso modificarCurso(Curso curso) {
		return cursoDao.save(curso);
	}

	@Override
	@Transactional
	public void eliminarCurso(Long id) {
		cursoDao.deleteById(id);;
	}

	@Override
	@Transactional(readOnly=true)
	public Curso findCurso(Long id) {
		return cursoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Curso> findCursosByProfesor(Long profesorId) {
		return cursoDao.findByProfesorId(profesorId);
	}

}
