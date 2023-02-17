package it.davidgualberto.gestionedispositivi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import it.davidgualberto.gestionedispositivi.config.DispositivoConfig;
import it.davidgualberto.gestionedispositivi.config.UtenteConfig;
import it.davidgualberto.gestionedispositivi.entities.Dispositivo;
import it.davidgualberto.gestionedispositivi.entities.Utente;
import it.davidgualberto.gestionedispositivi.enums.RuoloUtente;
import it.davidgualberto.gestionedispositivi.enums.StatoDispositivo;
import it.davidgualberto.gestionedispositivi.enums.TipologiaDispositivo;
import it.davidgualberto.gestionedispositivi.service.DispositivoService;
import it.davidgualberto.gestionedispositivi.service.UtenteService;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class GestionedispositiviApplication implements CommandLineRunner {
	
	@Autowired
	UtenteService utServ;
	@Autowired
	DispositivoService disServ;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionedispositiviApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// popolaDB();
	}

	
	public void popolaDB() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(UtenteConfig.class, DispositivoConfig.class);
		
		Utente u1 = (Utente) ctx.getBean("utente", "David", "Gualberto", "david", "david", "david@gmail.com", RuoloUtente.USER);
		Utente u2 = (Utente) ctx.getBean("utente", "Francesco", "Totti", "francesco", "francesco", "francesco@gmail.com", RuoloUtente.ADMIN);
		Utente u3 = (Utente) ctx.getBean("utente", "Daniele", "De Rossi", "daniele", "daniele", "daniele@gmail.com", RuoloUtente.ADMIN);
		Utente u4 = (Utente) ctx.getBean("utente", "Paulo", "Dybala", "paulo", "paulo", "paulo@gmail.com", RuoloUtente.USER);
		
		utServ.salva(u1);
		utServ.salva(u2);
		utServ.salva(u3);
		utServ.salva(u4);
		
		Dispositivo d1 = (Dispositivo) ctx.getBean("dispositivo", TipologiaDispositivo.Cellulare, StatoDispositivo.Disponibile);
		Dispositivo d2 = (Dispositivo) ctx.getBean("dispositivo", TipologiaDispositivo.Computer, StatoDispositivo.Disponibile);
		Dispositivo d3 = (Dispositivo) ctx.getBean("dispositivo", TipologiaDispositivo.Tablet, StatoDispositivo.Disponibile);
		Dispositivo d4 = (Dispositivo) ctx.getBean("dispositivo", TipologiaDispositivo.Cellulare, StatoDispositivo.Disponibile);
		Dispositivo d5 = (Dispositivo) ctx.getBean("dispositivo", TipologiaDispositivo.Computer, StatoDispositivo.Disponibile);
		Dispositivo d6 = (Dispositivo) ctx.getBean("dispositivo", TipologiaDispositivo.Tablet, StatoDispositivo.Disponibile);
		
		disServ.salva(d2);
		disServ.salva(d3);
		disServ.salva(d1);
		disServ.salva(d4);
		disServ.salva(d5);
		disServ.salva(d6);
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
}
