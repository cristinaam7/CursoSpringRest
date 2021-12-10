package security;

import org.springframework.stereotype.Component;

import com.example.cursoRest.constants.Constants;
import com.example.cursoRest.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public String generate(JwtUser jwtUser) {
		//Obtenemos los datos que necesitamos para generar el token
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUsername());
		claims.put(Constants.USER_ID, String.valueOf(jwtUser.getId()));
		claims.put(Constants.ROLE, jwtUser.getRole());
		
		//Generamos el token
		return Jwts.builder()
				.setClaims(claims) //datos
				.signWith(SignatureAlgorithm.HS256, Constants.YOUR_SECRET) //firma
				.compact(); //compactar
	}
}
