package main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dao.TitoloDiViaggioDAO;
import dao.VenditaBigliettiDAO;
import dao.TrasportoDAO;
import dao.UtenteDAO;
import entities.Autobus;
import entities.Biglietto;
import entities.Corsa;
import entities.Mezzo;
import entities.Tram;
import entities.Tratta;
import entities.VenditaBiglietti;
import entities.enums.StatoBiglietteria;
import entities.enums.TipologiaAbbonamento;
import entities.enums.TipologiaRivenditore;

public class GestioneTrasportoPubblico {

	private static TrasportoDAO td = new TrasportoDAO();
	private static UtenteDAO ud = new UtenteDAO();
	private static TitoloDiViaggioDAO tvd = new TitoloDiViaggioDAO();
	private static VenditaBigliettiDAO vd = new VenditaBigliettiDAO();
	private static Scanner scanner = new Scanner(System.in);
	private static final Logger logger = LoggerFactory.getLogger(GestioneTrasportoPubblico.class);

	public static void main(String[] args) {
		
//		popolaDatabase();
		
		gestionale: 
		while (true) {
			logger.info("""
					-------------------------------------------------
					Sistema Gestione Trasporto Pubblico
					-------------------------------------------------
					1) Menu Crea
					2) Carica o Aggiorna Abbonamento 
					3) Emetti Biglietto
					4) Vidima Biglietto
					5) Stampa Liste
					6) Rinnova Tessera
					7) Verifica la Validità di un Abbonamento
					8) Gestione Parco Mezzi
					9) Lista Corse per Mezzo
					0) Chiudi Gestionale""" );

			try {
				int scelta = Integer.parseInt(scanner.nextLine());
			menu:
			switch (scelta) {
			case 1: 
				menuCrea();
				int scelta2 = Integer.parseInt(scanner.nextLine());
				switch (scelta2) {
				
				case 1: 
					logger.info("Inserisci nome");
					String nome = scanner.nextLine();
					logger.info("Inserisci cognome");
					String cognome = scanner.nextLine();
					if (nome.length() < 2 | cognome.length() < 2) {
						throw new Exception("Nome e cognome devono essere lunghi almeno due caratteri");
					}
					ud.creaUtenteConTessera(nome, cognome);
					break;
				case 2:
					logger.info("""
							1) Tram
							2) Autobus
							3) Torna al Menu Principale
							4) Chiudi Gestionale
							""");
					int scelta3 = Integer.parseInt(scanner.nextLine());
					switch (scelta3){
					
						case 1:
							logger.info("Scegli la tratta tramite id");
							td.printListTratta(td.listaTratte());
							int tram = Integer.parseInt(scanner.nextLine());
							if (td.getTrattaById(tram) == null) logger.info("La tratta inserita è inesistente.");
							else td.save(new Tram(td.getTrattaById(tram)));							
							break;
						case 2: 
							logger.info("Scegli la tratta tramite id");
							td.printListTratta(td.listaTratte());
							int bus = Integer.parseInt(scanner.nextLine());
							if (td.getTrattaById(bus) == null) logger.info("La tratta inserita è inesistente.");
							else td.save(new Autobus(td.getTrattaById(bus)));
							break;
						case 3: 
							break menu;
						case 4: 
							break gestionale;
						default:
							logger.info("Scelta non valida, riprovare.");
							break;	
					}
					break;
				case 3:
					logger.info("Inserisci Luogo di Partenza");
					String luogo = scanner.nextLine();
					logger.info("Inserisci Luogo di Arrivo");
					String arrivo = scanner.nextLine();
					if (luogo.length() < 5 | arrivo.length() < 5) {
						throw new Exception("Occorre specificare i luoghi richiesti con almeno 5 caratteri");
					}
					logger.info("Inserisci Durata Media Stimata");
					int durata = Integer.parseInt(scanner.nextLine());
					if (durata <= 5) logger.info("Una Tratta da percorrere deve essere di almeno 5 minuti.");
					else td.save(new Tratta(luogo, arrivo,durata));
					break;
				case 4:
					logger.info("Scegli un Mezzo Tramite Id");
					td.printListMezzi(td.listaMezzi());
					int mezzo = Integer.parseInt(scanner.nextLine());
					if (td.getMezzoById(mezzo) == null) logger.info("Non esiste un Mezzo con l'Id specificato");
					else {
						logger.info("Scegli la tratta tramite id");
						td.printListTratta(td.listaTratte());						
						int tratta = Integer.parseInt(scanner.nextLine());
						if (td.getTrattaById(tratta) == null) logger.info("Non esiste una Tratta con l'Id specificato");
						else {
							logger.info("Inserisci Durata Effettiva Della Corsa");
							int tempo = Integer.parseInt(scanner.nextLine());
							if (tempo < 5) logger.info("Una Tratta da percorrere deve essere di almeno 5 minuti.");
							else td.save(new Corsa(td.getMezzoById(mezzo), td.getTrattaById(tratta), tempo));
						}						
					}					
					break;
				case 5:
					logger.info("""
							1) Distributore Automatico
							2) Rivenditore Autorizzato
							3) Torna al Menu Principale
							4) Chiudi Gestionale
							""");
					int scelta4 = Integer.parseInt(scanner.nextLine());
					switch (scelta4){
						case 1: vd.save(new VenditaBiglietti(TipologiaRivenditore.DISTRIBUTORE_AUTOMATICO));
							break;
						case 2: vd.save(new VenditaBiglietti(TipologiaRivenditore.RIVENDITORE_AUTORIZZATO));
							break;
						case 3:
							break;
						case 4:
							break gestionale;
						default:
							logger.info("Scelta non valida, riprovare.");
							break;	
					}
					break;
				case 6:
					break;
				case 7:
					scanner.close();
					break gestionale;
				default:
					logger.info("Scelta non valida, riprovare.");
					break;
				}
				break;				
			case 2:
				logger.info("Inserisci Numero Tessera.");
				int tessera = Integer.parseInt(scanner.nextLine());
				if (tvd.getTesseraByID(tessera) == null) logger.info("Non esiste una Tessera con l'Id inserito.");
				else {
					logger.info("Scegli il tipo di Abbonamento: SETTIMANALE o MENSILE");
					try {
						TipologiaAbbonamento abb = TipologiaAbbonamento.valueOf(scanner.nextLine().toUpperCase());
						logger.info("Scegli l' Id della Biglietteria");
						vd.printListaRivenditori(vd.listaRivenditori());
						int sceltaId = Integer.parseInt(scanner.nextLine());
						if (vd.getVenditoreById(sceltaId) == null) logger.info("Non esiste una Biglietteria con l'Id inserito.");
						else tvd.creaNuovoAbbonamento(tessera, sceltaId,abb);
					} catch (Exception e) {
						logger.info("L'opzione scelta non è accettabile.");
					}	
				}							
				break;
			case 3:
				logger.info("Scegli l'Id della Biglietteria");
				vd.printListaRivenditori(vd.listaRivenditori());
				int biglietteria = Integer.parseInt(scanner.nextLine());
				if ( vd.getVenditoreById(biglietteria).getStato() == StatoBiglietteria.FUORI_SERVIZIO) logger.info("Impossibile emettere il biglietto");
				else {
				tvd.save(new Biglietto(LocalDate.now(),vd.getVenditoreById(biglietteria)));
				}
				break;
			case 4:
				logger.info("Inserisci l' Id del Biglietto");
				int bigliettoId = Integer.parseInt(scanner.nextLine());
				logger.info("Scegli una Corsa tramite Id");
				td.printListCorsa(td.corse());
				int mez = Integer.parseInt(scanner.nextLine());					
				tvd.vidimaBiglietto(bigliettoId, mez);
				break;				
			case 5:
				logger.info("""
						1) Lista Biglietterie
						2) Lista Biglietti Vidimati per Mezzo
						3) Lista Biglietti Vidimati per Periodo di Tempo
						4) Lista Biglietti Emessi per Periodo e Punto di Emissione
						5) Lista Abbonamenti Emessi per Periodo e Punto di Emissione
						6) Torna al Menu Principale
						7) Chiudi Gestionale
						""");
				int scelta4 = Integer.parseInt(scanner.nextLine());
				switch (scelta4){
				case 1:
					vd.printListaRivenditori(vd.listaRivenditori());
					break;				
				case 2:
					logger.info("Inserisci l'Id del mezzo su cui sono stati vidimati i biglietti.");
					int tickets1 = Integer.parseInt(scanner.nextLine());
					tvd.printListBiglietto(tvd.listaVidimazione(td.getMezzoById(tickets1)));				
					break;
				case 3:
					logger.info("Inserisci la data d'inizio.");
					LocalDate dataA = LocalDate.parse(scanner.nextLine());
					logger.info("Inserisci la data di fine.");
					LocalDate dataB = LocalDate.parse(scanner.nextLine());
					tvd.printListBiglietto(tvd.listaVidimazionePerData(dataA, dataB));
				    break;
				case 4:
					logger.info("Inserisci data di inizio:");
					LocalDate dataC = LocalDate.parse(scanner.nextLine());
					logger.info("Inserisci la data di fine:");
					LocalDate dataD = LocalDate.parse(scanner.nextLine());
					logger.info("Insersci l'id del punto di emissione:");
					vd.printListaRivenditori(vd.listaRivenditori());
					int id = Integer.parseInt(scanner.nextLine());
					if ( vd.getVenditoreById(id) == null ) logger.info("Il rivenditore con id " + id + " non esiste.");
					else tvd.printListBiglietto(tvd.listaBigliettiEmessi(dataC, dataD, id));		
					break;
				case 5:
					logger.info("Inserisci data di inizio:");
					LocalDate dataE = LocalDate.parse(scanner.nextLine());
					logger.info("Inserisci la data di fine:");
					LocalDate dataF = LocalDate.parse(scanner.nextLine());
					logger.info("Insersci l'id del punto di emissione:");
					vd.printListaRivenditori(vd.listaRivenditori());
					int idA = Integer.parseInt(scanner.nextLine());
					if ( vd.getVenditoreById(idA) == null ) logger.info("Il rivenditore con id " + idA + " non esiste.");
					else tvd.printListAbbonamento(tvd.listaAbbonamentiEmessi(dataE, dataF, idA));
					break;
				case 6:
					break;
				case 7:
					break gestionale;
				}
				break;
			case 6:
				logger.info("Inserisci il numero della Tessera da rinnovare.");
				int tes = Integer.parseInt(scanner.nextLine());
				tvd.rinnovaTessera(tes);
				logger.info("La Tessera sarà valida fino al " + tvd.getTesseraByID(tes).getDataScadenza());
				break;
			case 7:
				logger.info("Inserisci il numero della Tessera associata all'Abbonamento da verificare.");
				int tes2 = Integer.parseInt(scanner.nextLine());
				if (tvd.getTesseraByID(tes2) == null) logger.info("La Tessera cercata non esiste");
				else if (tvd.getTesseraByID(tes2).getDataScadenza().isBefore(LocalDate.now())) logger.info("La Tessera è scaduta");
				else {
					if (tvd.abbonamentoByTess(tes2) == null) logger.info("Questa Tessera non ha Abbonamenti Associati!");
					else if (tvd.abbonamentoByTess(tes2).getDataScadenza().isBefore(LocalDate.now())) logger.info("L'Abbonamento è scaduto");
					else logger.info("L'Abbonamento associato alla Tessera inserita è Valido!");
				}	
				break;
			case 8:
				logger.info("""
						1) Lista Mezzi
						2) Manda un Mezzo in Manutenzione
						3) Lista dei turni di un mezzo
						4) Assegna un Mezzo a una nuova Tratta						
						5) Torna al Menu Principale
						6) Chiudi Gestionale
						""");
				int scelta5 = Integer.parseInt(scanner.nextLine());
				switch (scelta5) {
				case 1:
					td.printListMezzi(td.listaMezzi());
					break;
				case 2:
					logger.info("Inserisci la data d'inizio del periodo di manutenzione.");
					LocalDate manA = LocalDate.parse(scanner.nextLine());
					logger.info("Inserisci la data di fine del periodo di manutenzione.");
					LocalDate manB = LocalDate.parse(scanner.nextLine());
					logger.info("Inserisci l' Id del Mezzo da mettere in manutenzione.");
					int mezId = Integer.parseInt(scanner.nextLine());
					td.manutenzione(manA, manB, mezId);
					logger.info("Un nuovo autobus coprirà il turno del Mezzo in manutenzione.");
					td.save(new Autobus(td.getMezzoById(mezId).getTratta()));
					break;
				case 3:
					logger.info("Inserisci l'Id del Mezzo di cui si vuole sapere i turni");
					int turn = Integer.parseInt(scanner.nextLine());
					td.printListMezzo(td.listaPeriodicita(turn));					
					break;
				case 4:
					logger.info("Inserisci l'Id del Mezzo di cui vuoi cambiare la tratta");
					int mex = Integer.parseInt(scanner.nextLine());
					if (td.getMezzoById(mex) == null) logger.info("L'Id inserito risulta inesistente");
					else {
						logger.info("Scegli la tratta tramite id");
						td.printListTratta(td.listaTratte());
						int percorso = Integer.parseInt(scanner.nextLine());
						if (td.getTrattaById(percorso) == null) logger.info("La Tratta impostata risulta inesistente");
						else {
							Mezzo mUp = td.getMezzoById(mex);
							mUp.setTratta(td.getTrattaById(percorso));
							td.update(mUp);
						}						
					}					
					break;				
				case 5:
					break;
				case 6:
					break gestionale;
				}				
				break;			
			case 9: 
				logger.info("Inserisci l'Id del Mezzo di cui si vuole avere una lista corse");
				int mezC = Integer.parseInt(scanner.nextLine());
				if (td.getMezzoById(mezC) == null) logger.info("L'Id inserito è inesistente");
				else td.printListCorsa(td.corsePerMezzo(td.getMezzoById(mezC), td.getMezzoById(mezC).getTratta()));
				break;
			case 0:
				scanner.close();
				break gestionale;
				default:
				logger.info("Scelta non valida, riprovare.");
				break;
			}	
		}catch(NumberFormatException e) {
			logger.info("Inserisci una selezione valida!");
		}catch(DateTimeParseException e) {
			logger.info("La data inserita non è in un formato riconoscibile!");
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	
	}
}
	
	public static void popolaDatabase() {
		
		Tratta t = new Tratta("Via Tiburtina", "Via Salaria", 20);
		Tratta t2 = new Tratta("Via Flaminia", "Isola Tiberina", 60);
		Tratta t3 = new Tratta("Via Nomentana", "Roma Termini",30);
		Tratta t4 = new Tratta("Via Casilina", "Largo Preneste",45);
		Tratta t5 = new Tratta("Via Prenestina", "Pzz.le Verano",50);
		Tratta t6 = new Tratta("Via Cassia", "Ponte Milvio",40);
		td.save(t);
		td.save(t2);
		td.save(t3);
		td.save(t4);
		td.save(t5);
		td.save(t6);
		td.save(new Autobus(t));
		td.save(new Autobus(t2));
		td.save(new Autobus(t4));
		td.save(new Autobus(t5));
		td.save(new Tram(t2));
		td.save(new Tram(t3));
		td.save(new Tram(t6));
		td.save(new Tram(t3));
		
		for(int i = 0; i < 10; i++) {
			vd.save(new VenditaBiglietti (TipologiaRivenditore.DISTRIBUTORE_AUTOMATICO));
			vd.save(new VenditaBiglietti (TipologiaRivenditore.RIVENDITORE_AUTORIZZATO));
		}
		
		Random randomCorse = new Random();
		int random = randomCorse.nextInt(10)+20;
		for(int i = 0; i < random; i++) {
			td.save(td.getMezzoById(1), td.getTrattaById(1), randomCorse.nextInt(10)+25);
			td.save(td.getMezzoById(5), td.getTrattaById(2), randomCorse.nextInt(10)+45);
			td.save(td.getMezzoById(3), td.getTrattaById(4), randomCorse.nextInt(20)+35);
			td.save(td.getMezzoById(4), td.getTrattaById(5), randomCorse.nextInt(10)+15);
			td.save(td.getMezzoById(6), td.getTrattaById(3), randomCorse.nextInt(15)+20);
			td.save(td.getMezzoById(7), td.getTrattaById(6), randomCorse.nextInt(20)+30);
			tvd.save(new Biglietto (LocalDate.now(), vd.getVenditoreById(2)));
		}	
		
		td.manutenzione(LocalDate.now(), LocalDate.now().plusDays(10), 2);
		td.manutenzione(LocalDate.now(), LocalDate.now().plusDays(8), 8);
		
		ud.creaUtenteConTessera("Bruno", "Pizzul");
		ud.creaUtenteConTessera("Mario", "Biondi");
		ud.creaUtenteConTessera("Paola", "Barale");
		ud.creaUtenteConTessera("Elisabetta", "Canalis");
		ud.creaUtenteConTessera("Antonello", "Venditti");
		ud.creaUtenteConTessera("Maurizio", "Costanzo");
		
		tvd.creaNuovoAbbonamento(1000, 1, TipologiaAbbonamento.MENSILE);
		tvd.creaNuovoAbbonamento(1001, 2, TipologiaAbbonamento.SETTIMANALE);
		tvd.creaNuovoAbbonamento(1002, 1, TipologiaAbbonamento.SETTIMANALE);
		tvd.creaNuovoAbbonamento(1003, 2, TipologiaAbbonamento.MENSILE);						
		tvd.vidimaBiglietto(1, 2);
		tvd.vidimaBiglietto(2, 3);
		tvd.vidimaBiglietto(3, 5);
		tvd.vidimaBiglietto(4, 22);
		tvd.vidimaBiglietto(5, 6);
		tvd.vidimaBiglietto(6, 3);
		tvd.vidimaBiglietto(7, 10);
		tvd.vidimaBiglietto(8, 21);	
		vd.fuoriServizio(vd.getVenditoreById(3));	
		vd.fuoriServizio(vd.getVenditoreById(13));
		vd.fuoriServizio(vd.getVenditoreById(19));
	}

	public static void menuCrea() {
		
		logger.info("""
				-------------------------------------------
				Menu di Creazione Entità
				-------------------------------------------
				1) Crea Utente con Tessera Associata
				2) Crea Mezzo
				3) Crea Tratta
				4) Crea Corse
				5) Crea Distributore o Rivenditore
				6) Torna al Menu Principale
				7) Chiudi il Gestionale""" );
	}
}
