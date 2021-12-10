package com.example.demo.model;

import com.example.demo.entity.Lenguaje;
import com.example.demo.entity.Profesor;

import lombok.Data;

@Data
public class ProfesorLenguaje {
	private Profesor profesor;
	private Lenguaje lenguaje;
}
