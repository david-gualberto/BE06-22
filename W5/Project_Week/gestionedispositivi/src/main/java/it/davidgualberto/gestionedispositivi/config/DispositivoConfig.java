package it.davidgualberto.gestionedispositivi.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import it.davidgualberto.gestionedispositivi.entities.Dispositivo;
import it.davidgualberto.gestionedispositivi.enums.StatoDispositivo;
import it.davidgualberto.gestionedispositivi.enums.TipologiaDispositivo;

@Configuration
public class DispositivoConfig {
	
	@Bean
	@Scope("prototype")
	public Dispositivo dispositivo(TipologiaDispositivo tipo, StatoDispositivo stato) {
		return Dispositivo.builder()
				.tipo(tipo)
				.stato(stato)
				.build();
	}

}
