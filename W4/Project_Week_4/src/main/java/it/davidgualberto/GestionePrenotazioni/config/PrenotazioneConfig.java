package it.davidgualberto.GestionePrenotazioni.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.davidgualberto.GestionePrenotazioni.entity.Postazione;
import it.davidgualberto.GestionePrenotazioni.entity.Prenotazione;
import it.davidgualberto.GestionePrenotazioni.entity.Utente;

@Configuration
public class PrenotazioneConfig {
	@Bean
	@Scope("prototype")
	public Prenotazione pren(Utente a, Postazione b, LocalDate c) {
		return Prenotazione.builder()
				.utente(a)
				.postazione(b)
				.data(c)
				.build();
	}
}
