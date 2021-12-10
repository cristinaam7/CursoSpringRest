package com.example.cursoRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursoRest.model.JwtUser;
import com.example.cursoRest.model.Login;

import security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenCotroller {

	private JwtGenerator jwtGenerator;
	
	public TokenCotroller(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}
	
	@PostMapping
	public ResponseEntity<?> generate(@RequestBody final Login login){
		JwtUser jwtUser = new JwtUser();
		jwtUser = existUser(login);
		if(jwtUser != null) {
			List<String> lista = new ArrayList<>(); //Creo lista para devolverlo en formato json
			lista.add(jwtGenerator.generate(jwtUser));
			return new ResponseEntity<List<String>>(lista, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	//Esto lo hariamos contra la base de datos
	private JwtUser existUser(Login login) {
		if(login.getUser().equals("alberto") && login.getPassword().equals("1234")) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setUsername(login.getUser());
			jwtUser.setId(new Long(1));
			jwtUser.setRole("Admin");
			return jwtUser;
			
		}else {
			return null;
		}
	}
}
