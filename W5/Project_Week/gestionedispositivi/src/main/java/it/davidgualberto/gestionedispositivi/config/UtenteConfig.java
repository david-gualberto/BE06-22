package it.davidgualberto.gestionedispositivi.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import it.davidgualberto.gestionedispositivi.entities.Utente;
import it.davidgualberto.gestionedispositivi.enums.RuoloUtente;

@Configuration
public class UtenteConfig {
		
	@Bean
	@Scope("prototype")
	public Utente utente(String nome, String cognome, String username, String password, String email, RuoloUtente ruolo) {
		return Utente.builder()
				.nome(nome)
				.cognome(cognome)
				.username(username)
				.password(password)
				.email(email)
				.ruolo(ruolo)
				.build();
	}
}
