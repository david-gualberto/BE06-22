package it.davidgualberto.GestionePrenotazioni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.davidgualberto.GestionePrenotazioni.entity.Utente;

@Configuration
public class UtenteConfig {
	@Bean
	@Scope("prototype")
	public Utente utente(String a, String b, String c) {
		return Utente.builder()
				.username(a)
				.nomeCompleto(b)
				.email(c)
				.build();
	}
}
