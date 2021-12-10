package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Profesor;
import com.example.demo.model.ProfesorModel;

@Component("mapper")
public class ProfesorMapper {
	
	public static List<ProfesorModel> mapearProfesores(List<Profesor> profesores){
		
		List<ProfesorModel> profesoresMapeados = new ArrayList<>();
		for(Profesor profesor: profesores) {
			profesoresMapeados.add(mapearProfesor(profesor));
		}
		return profesoresMapeados;
	}
	
	public static ProfesorModel mapearProfesor(Profesor profesor){
		
		ProfesorModel profesorModel = new ProfesorModel();
		profesorModel.setId(profesor.getId());
		profesorModel.setNombre(profesor.getNombre());
		profesorModel.setEmail(profesor.getEmail());
		profesorModel.setFoto(profesor.getFoto());
		
		return profesorModel;
	}

}
