package it.davidgualberto.GestionePrenotazioni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.davidgualberto.GestionePrenotazioni.entity.Edificio;

@Configuration
public class EdificioConfig {

	@Bean
	@Scope("prototype")
	public Edificio edi(String a, String b, String c) {
		return Edificio.builder()
				.nome(a)
				.indirizzo(b)
				.citta(c)
				.build();
	}
	
}
