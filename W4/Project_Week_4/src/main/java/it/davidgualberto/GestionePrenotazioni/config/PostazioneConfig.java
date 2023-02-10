package it.davidgualberto.GestionePrenotazioni.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import it.davidgualberto.GestionePrenotazioni.entity.Edificio;
import it.davidgualberto.GestionePrenotazioni.entity.Postazione;
import it.davidgualberto.GestionePrenotazioni.enums.TipoPostazione;

@Configuration
public class PostazioneConfig {
	
	@Bean
	@Scope("prototype")
	public Postazione pos(String a, TipoPostazione b, int c, Edificio e) {
		return Postazione.builder()
				.descrizione(a)
				.tipo(b)
				.numMaxOccupanti(c)
				.edificio(e)
				.build();
	}
}
