package security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.example.cursoRest.constants.Constants;
import com.example.cursoRest.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{

	public JwtAuthenticationTokenFilter() {
		super("/api/**"); //Para que autentifique con el token todo lo q esté en la url api
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		//Aqui chequeamos el token que nos llega
		
		//Me traigo lo que hay en la cabecera en el campo Authorization
		//Será algo tal que: Bearer: token
		String header = request.getHeader(Constants.AUTHORIZATION_HEADER);
		
		if(header == null || !header.startsWith(Constants.BEARE_TOKEN)) {
			throw new RuntimeException("Format incorrect JWR");
		}
		
		//Obtenemos lo que es el token en sí
		String token = header.substring(7); //Para omitir el Bearer+espacio
		//Creamos el token con la clase que ya habíamos creado previamente
		JwtAuthenticationToken authenticationToken = new JwtAuthenticationToken(token);
		
		//Comprueba si el token es correcto y devuelve la respuesta
		return getAuthenticationManager().authenticate(authenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
	
	
}
