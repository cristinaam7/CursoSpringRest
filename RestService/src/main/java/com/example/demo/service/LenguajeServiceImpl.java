package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.LenguajeDao;
import com.example.demo.entity.Lenguaje;

@Service
public class LenguajeServiceImpl implements LenguajeService{
	
	@Autowired
	LenguajeDao lenguajeDao;

	@Override
	@Transactional(readOnly=true)
	public List<Lenguaje> getLenguajes() {
		return (List<Lenguaje>) lenguajeDao.findAll();
	}

	@Override
	public void crearLenguaje(Lenguaje lenguaje) {
		lenguajeDao.save(lenguaje);
	}

	@Override
	public Lenguaje findLenguaje(Lenguaje lenguaje) {
		return lenguajeDao.findById(lenguaje.getId()).orElse(null);
	}
	

}
