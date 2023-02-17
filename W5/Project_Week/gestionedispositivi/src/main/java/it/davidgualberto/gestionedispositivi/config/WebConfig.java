package it.davidgualberto.gestionedispositivi.config;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import it.davidgualberto.gestionedispositivi.entities.Utente;
import it.davidgualberto.gestionedispositivi.enums.RuoloUtente;
import it.davidgualberto.gestionedispositivi.service.UtenteService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfig  extends WebSecurityConfigurerAdapter {
	@Autowired
	private UtenteService utServ;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/")
				.permitAll()
			.anyRequest()
				.authenticated()
			.and()
			.httpBasic()
			.and()
			.formLogin()
				.successForwardUrl("/utente/login_success")
			.and()
			.logout()
			.and()
			.csrf()
				.disable();
	}
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		List<Utente> authUtenti = utServ.findAll();
		for (Utente u : authUtenti) { 
				auth.inMemoryAuthentication()
				.withUser( u.getUsername() ).password( passwordEncoder().encode( u.getPassword() ) )
				.roles(u.getRuolo().toString());
			}
		}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
