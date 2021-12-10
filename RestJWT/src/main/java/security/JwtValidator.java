package security;

import com.example.cursoRest.constants.Constants;
import com.example.cursoRest.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtValidator {

	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		
		try {
			//Extraemos del token los campos
			//Para comprobar que el token es correcto
			Claims body = Jwts.parser()
					.setSigningKey(Constants.YOUR_SECRET)
					.parseClaimsJws(token)
					.getBody();
			
			jwtUser = new JwtUser();
			jwtUser.setUsername(body.getSubject());
			jwtUser.setId(Long.parseLong((String)body.get(Constants.USER_ID)));
			jwtUser.setRole((String)body.get(Constants.ROLE));
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return jwtUser;
	}
}
