package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Lenguaje;

public interface LenguajeService {
	
	public List<Lenguaje> getLenguajes();
	
	public void crearLenguaje(Lenguaje lenguaje);
	
	public Lenguaje findLenguaje(Lenguaje lenguaje);
}
