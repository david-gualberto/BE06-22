package it.davidgualberto.GestionePrenotazioni;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.davidgualberto.GestionePrenotazioni.config.EdificioConfig;
import it.davidgualberto.GestionePrenotazioni.config.PostazioneConfig;
import it.davidgualberto.GestionePrenotazioni.config.PrenotazioneConfig;
import it.davidgualberto.GestionePrenotazioni.config.UtenteConfig;
import it.davidgualberto.GestionePrenotazioni.entity.Edificio;
import it.davidgualberto.GestionePrenotazioni.entity.Postazione;
import it.davidgualberto.GestionePrenotazioni.entity.Prenotazione;
import it.davidgualberto.GestionePrenotazioni.entity.Utente;
import it.davidgualberto.GestionePrenotazioni.enums.TipoPostazione;
import it.davidgualberto.GestionePrenotazioni.service.EdificioService;
import it.davidgualberto.GestionePrenotazioni.service.PostazioneService;
import it.davidgualberto.GestionePrenotazioni.service.PrenotazioneService;
import it.davidgualberto.GestionePrenotazioni.service.UtenteService;

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner {
	
		Scanner scanner = new Scanner(System.in);
		boolean startStop = false;
		
		@Autowired
		PostazioneService posServ;
		@Autowired
		EdificioService edServ;
		@Autowired
		UtenteService utServ;
		@Autowired
		PrenotazioneService prServ;
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(EdificioConfig.class,PostazioneConfig.class, PrenotazioneConfig.class, UtenteConfig.class);
	
		public static void main(String[] args) {
			SpringApplication.run(GestionePrenotazioniApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			
			do {
				gestioneMenu();
			}
			while ( startStop == false);
		}
		
		
		
	//METODI PER CREAZIONE E RICERCA DEGLI ELEMENTI
	
	//EDIFICIO TRAMITE ID
	public void trovaEdificioByID(int id) {
		Optional<Edificio> edi = edServ.getById(id);
		if( edi.isPresent() ) {
			Edificio edificio = edi.get();
			System.out.println("Info dell'edificio con id #" + id + ":");
			System.out.println( edificio );
		}
		else {
			System.out.println("Edificio non trovato con id #" + id);
		}
	}
	
	//POSTAZIONE TRAMITE CITTA E TIPOLOGIA
	public void trovaByCittàETipo(String tipo, String citta) {
		List<Postazione> x = posServ.trovaByTipoeCitta(tipo, citta);
		if (x.size()> 0) {
			x.stream().forEach((post)-> {
				System.out.println(post);
			});
		}
		else {
			System.out.println("Non esiste la tipologia: " + tipo + " nella città di " +  citta);
		}
	}
	
	//AGGIUNTA EDIFICIO
	public void inserisciEdificio(String nome, String indirizzo, String citta) {
		Edificio ed = (Edificio)ctx.getBean("edi", nome, indirizzo, citta);
		edServ.insert(ed);
	}
	//AGGIUNTA UTENTE
	public void inserisciUtente(String username, String nomeCompleto, String email) {
		Utente u = (Utente)ctx.getBean("utente", username, nomeCompleto, email);
		utServ.insert(u);
	}
	//PRENOTAZIONE POSTAZIONE TRAMITE ID UTENTE E ID POSTAZIONE CON VERIFICA TRAMITE LA DATA
	public void prenotarePost(int id, int idPost, LocalDate data) {
		Optional<Utente> utente = utServ.getById(id);
		Utente ut = utente.get();
		Optional<Postazione> post = posServ.getById(idPost);
		Postazione p = post.get();
		Prenotazione p1 = (Prenotazione) ctx.getBean("pren", ut, p, data);
		prServ.insert(p1);
	}
	//INSERIMENTO POSTAZIONE NUOVA IN EDIFICIO SPECIFICO TRAMITE ID EDIFICIO
	public void inserisciPostazione(int idEdif, String nome, TipoPostazione tipo, int numMax) {
		Optional<Edificio> edi = edServ.getById(idEdif);
		
		if (edi.isPresent()) {
			Edificio e = edi.get();
			Postazione p = (Postazione)ctx.getBean("pos", nome, tipo,numMax,e);
			posServ.insert(p);
			System.out.println("La Postazione è stata aggiunta con successo all' edificio: " + e.getNome());
		} else {
			System.out.println("Edificio non esistente");
		}
	}
	//STAMPA LISTA EDIFICI
	public void stampaEdifici() {
		List<Edificio> lista = edServ.findAll();
		lista.stream().forEach((edif)-> {
			System.out.println(edif);
		});
	}
	//STAMPA LISTA POSTAZIONI
	public void stampaPostazioni() {
		List<Postazione> lista = posServ.findAll();
		lista.stream().forEach((pos)-> {
			System.out.println(pos);
		});
	}
	
	//FINE METODI
	
	
	//POPOLO DB CON ISTANZE MANUALI
	public void popolaDB() {
		
		Edificio ed = (Edificio)ctx.getBean("edi", "Edificio Alpha", "Via del corso, 10", "Roma");
		Edificio ed1 = (Edificio)ctx.getBean("edi", "Edificio Omega", "Via aurelia, 212", "Milano");
		Edificio ed2 = (Edificio)ctx.getBean("edi", "Edificio Beta", "Via carlo magno, 128", "Firenze");
		Edificio ed3 = (Edificio)ctx.getBean("edi", "Edificio DAO", "Via java, 3457", "Torino");
		Edificio ed4 = (Edificio)ctx.getBean("edi", "Edificio Pacifico", "Via mario 32", "Roma");
		edServ.insert(ed);
		edServ.insert(ed1);
		edServ.insert(ed2);
		edServ.insert(ed3);
		edServ.insert(ed4);
		Postazione p = (Postazione)ctx.getBean("pos", "Aula Magna", TipoPostazione.SALA_RIUNIONI,150,ed);
		Postazione p1 = (Postazione)ctx.getBean("pos", "Salotto", TipoPostazione.OPENSPACE,50,ed1);
		Postazione p2 = (Postazione)ctx.getBean("pos", "Ufficio", TipoPostazione.PRIVATO,10,ed2);
		Postazione p3 = (Postazione)ctx.getBean("pos", "Ufficio", TipoPostazione.SALA_RIUNIONI,150,ed4);
		Postazione p4 = (Postazione)ctx.getBean("pos", "Aula", TipoPostazione.PRIVATO,30,ed3);
		Postazione p5 = (Postazione)ctx.getBean("pos", "Ufficio", TipoPostazione.SALA_RIUNIONI,10,ed);
		Postazione p6 = (Postazione)ctx.getBean("pos", "Aula con proiettore", TipoPostazione.SALA_RIUNIONI,25,ed);
		Postazione p7 = (Postazione)ctx.getBean("pos", "Loft", TipoPostazione.OPENSPACE,30,ed1);
		Postazione p8 = (Postazione)ctx.getBean("pos", "Loft", TipoPostazione.OPENSPACE,12,ed2);
		Postazione p9 = (Postazione)ctx.getBean("pos", "Ufficio Privato", TipoPostazione.PRIVATO,5,ed2);
		Postazione p10 = (Postazione)ctx.getBean("pos", "Aula Magna", TipoPostazione.PRIVATO,45,ed3);
		posServ.insert(p);
		posServ.insert(p1);
		posServ.insert(p2);
		posServ.insert(p3);
		posServ.insert(p4);
		posServ.insert(p5);
		posServ.insert(p6);
		posServ.insert(p7);
		posServ.insert(p8);
		posServ.insert(p9);
		posServ.insert(p10);
		Utente u = (Utente)ctx.getBean("utente", "mr81", "Mario Rossi", "mariorossi@gmail.com");
		Utente u1 = (Utente)ctx.getBean("utente", "hg43", "Carlo Bianchi", "carlo@gmail.com");
		Utente u2 = (Utente)ctx.getBean("utente", "ut33", "Al Pacino", "al@gmail.com");
		Utente u3 = (Utente)ctx.getBean("utente", "dg87", "Paulo Dybala", "dybala@gmail.com");
		Utente u4 = (Utente)ctx.getBean("utente", "fl456", "Fabio Neri", "neri@gmail.com");
		Utente u5 = (Utente)ctx.getBean("utente", "totti10", "Francesco Totti", "totti@asroma.com");
		Utente u6 = (Utente)ctx.getBean("utente", "pd56", "Paolo de Paoli", "paolo@gmail.com");
		Utente u7 = (Utente)ctx.getBean("utente", "gg54", "Gianluca Mancini", "mancio@gmail.com");
		Utente u8 = (Utente)ctx.getBean("utente", "ert542", "Fabio Capello", "fabio@gmail.com");
		Utente u9 = (Utente)ctx.getBean("utente", "efs45", "Gabierl Batistuta", "gb@gmail.com");
		utServ.insert(u);
		utServ.insert(u1);
		utServ.insert(u2);
		utServ.insert(u3);
		utServ.insert(u4);
		utServ.insert(u5);
		utServ.insert(u6);
		utServ.insert(u7);
		utServ.insert(u8);
		utServ.insert(u9);
	}
	//GESTIONE DEL MENU TRAMITE SCANNER
	public void gestioneMenu() {
		System.out.println("-------------------------------");
		System.out.println("Quale operazione vuoi svolgere?");
		System.out.println("-------------------------------");
		System.out.println("1) Registrare un utente");
		System.out.println("2) Aggiungere un nuovo Edificio");
		System.out.println("3) Aggiungere una nuova postazione");
		System.out.println("4) Prenotare una postazione");
		System.out.println("5) Cerca la postazione inserendo tipologia e Città");
		System.out.println("6) Termina Programma");
		int scelta = Integer.parseInt(scanner.nextLine());
		
				switch(scelta) {
				case 1:
					System.out.println("Inserisci un username:");
					String a= scanner.nextLine();
					System.out.println("Inserisci il tuo nome e cognome:");
					String b= scanner.nextLine();
					System.out.println("Inserisci la tua email");
					String c= scanner.nextLine();
					inserisciUtente(a,b,c);
					break;
				case 2:
					System.out.println("Inserisci il nome dell'Edificio:");
					String nomeEdif= scanner.nextLine();
					System.out.println("Inserisci l'indirizzo:");
					String indirizzo= scanner.nextLine();
					System.out.println("Inserire la città");
					String citta= scanner.nextLine();
					inserisciEdificio(nomeEdif, indirizzo, citta);
					break;
				case 3:
					System.out.println("Inserisci una piccola descrizione della postazione: ");
					String descr= scanner.nextLine();
					System.out.println("----------------------------------------------");
					System.out.println("Inserire l'ID dell edificio dove si vuole aggiungere la postazione:");
					System.out.println("----------------------------------------------");
					stampaEdifici();
					int idEdif = Integer.parseInt(scanner.nextLine());
					System.out.println("Numero massimo di partecipanti possibili: ");
					int numMax = Integer.parseInt(scanner.nextLine());
					System.out.println("Scegli la tipologia: ");
					System.out.println("1)Openspace");
					System.out.println("2)Sala Riunioni");
					System.out.println("3)Privato");
					int scelta2 = Integer.parseInt(scanner.nextLine());
							switch (scelta2) {
							case 1:
								TipoPostazione t1= TipoPostazione.OPENSPACE;
								inserisciPostazione(idEdif, descr, t1, numMax);
								break;
							case 2:
								TipoPostazione t2= TipoPostazione.SALA_RIUNIONI;
								inserisciPostazione(idEdif, descr, t2, numMax);
								break;
							case 3:
								TipoPostazione t3= TipoPostazione.PRIVATO;
								inserisciPostazione(idEdif, descr, t3, numMax);
								break;
							default: 
								System.out.println("Selezione errata");
							}
					break;
				case 4: 	
					System.out.println("Inserire il tuo ID utente: ");
					int id = Integer.parseInt(scanner.nextLine());
					System.out.println("Digitare l'ID della postazione da prenotare: ");
					stampaPostazioni();
					int idPost = Integer.parseInt(scanner.nextLine());
					System.out.println("Inserire la data di prenotazione in formato YYYY-MM-GG");
					String data= scanner.nextLine();
					if (LocalDate.parse(data).isBefore(LocalDate.now())) {
						System.out.println("Non è possibile inserire una data antecedente ad oggi");
					} else { prenotarePost(id, idPost, LocalDate.parse(data));}
					break;
				case 5:
					System.out.println("Quale città ti interessa?");
					String x = scanner.nextLine();
					String cit = x.substring(0,1).toUpperCase()+x.substring(1);
					System.out.println("Che tipologia vuoi cercare: ");
					System.out.println("1)Openspace");
					System.out.println("2)Sala Riunioni");
					System.out.println("3)Privato");
					int scelta3 = Integer.parseInt(scanner.nextLine());
							switch (scelta3) {
							case 1:
								String t1= "OPENSPACE";
								trovaByCittàETipo(t1, cit);
								break;
							case 2:
								String t2= "SALA_RIUNIONI";
								trovaByCittàETipo(t2, cit);
								break;
							case 3:
								String t3 = "PRIVATO";
								trovaByCittàETipo(t3, cit);
								break;
							default: 
								System.out.println("Selezione errata");
							}
					break;
				case 6: 
					startStop = true;
					System.out.println("Programma terminato");
					scanner.close();
					((AnnotationConfigApplicationContext)ctx).close();
					break;
				default:
					System.out.println("Selezione errata");
					break;
				}
	}
}
