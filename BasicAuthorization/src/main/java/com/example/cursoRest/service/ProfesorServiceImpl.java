package com.example.cursoRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cursoRest.dao.ProfesorDao;
import com.example.cursoRest.domain.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	ProfesorDao profesorDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Profesor> findAllProfesors() {
		return (List<Profesor>) profesorDao.findAll();
	}

}
