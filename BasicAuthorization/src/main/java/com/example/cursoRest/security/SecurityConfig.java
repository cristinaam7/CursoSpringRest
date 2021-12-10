package com.example.cursoRest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*@Autowired
    private UserDetailsService userDetailsService;*/
	
	/*@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		//Configuramos los usuarios directamente en memoria
		auth.inMemoryAuthentication().withUser("cris").password("cris").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("eliz").password("eliz").roles("USER");
		
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		//antMatcher indico los endpoints con los que va a comprobar
		//Y luego quien tiene acceso a esos endpoings
		.antMatchers("/api/profesores").permitAll() //todos
		.antMatchers("/api/profesores_admin").hasRole("ADMIN") //solo admin
		.antMatchers("/api/profesores_users").hasRole("USER") //solo users
		.and()
		.httpBasic(); //Tipo de autorizacion basica
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	
}
