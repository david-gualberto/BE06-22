package app;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import catalogo.CatalogoBiblioteca;
import catalogo.Libri;
import catalogo.Riviste;
import catalogo.genereLibro;
import catalogo.periodicità;
import dao.DAO;
import utente.Prestito;
import utente.Utente;


public class Main {
	 private static final String persistenceUnit = "Project_Week_3";
     private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
     private static final EntityManager em = emf.createEntityManager();
     private static final EntityTransaction t = em.getTransaction();
	 static boolean startStop = false;
	 private static final Logger logger  = LoggerFactory.getLogger(Main.class);
	 static Scanner scanner = new Scanner(System.in);
	 public static void main(String[] args) {
		 do {
			 try {
			 	System.out.println("-------------------------");
				System.out.println("Catalogo della Biblioteca");
				System.out.println("-------------------------");
				System.out.println("Selezione l'operazione da svolgere: ");
				System.out.println("-------------------------");
				System.out.println("0) Registrazione Utente");
				System.out.println("1) Aggiungi un elemento al catalogo");
				System.out.println("2) Rimuovi prodotto inserendo il codice ISBN");
				System.out.println("3) Ricerca per ISBN");
				System.out.println("4) Ricerca per anno di pubblicazione");
				System.out.println("5) Ricerca per autore");
				System.out.println("6) Ricerca per titolo o parte di esso");
				System.out.println("7) Noleggia prodotto");
				System.out.println("8) Ricerca degli elementi attualmente in prestito dato un numero di tessera utente");
				System.out.println("9) Ricerca di tutti i prestiti scaduti e non ancora restituiti");
				System.out.println("10) STOP PROGRAMMA!");
				int scelta = Integer.parseInt(scanner.nextLine());
				switch (scelta) {
				case 1://Selezione operazione
					System.out.println("---Selezionare tipologia di prodotto---");
					System.out.println("-------------------------");
					System.out.println("1)Libro");
					System.out.println("2)Rivista");
					System.out.println("-------------------------");
					int libroRivista = Integer.parseInt(scanner.nextLine());
							switch (libroRivista) {
								case 1://Creazione Libro
									aggiungiLibro(DAO.creazioneLibro());
									logger.info("LIBRO AGGIUNTO CORRETTAMENTE");
									break;
								case 2://Creazione Rivista
									aggiungiRivista(DAO.creazioneRivista());
									logger.info("RIVISTA AGGIUNTA CORRETTAMENTE");
									break;
								default: 
									System.out.println("------------------------------");
									logger.error("ATTENZIONE!!! Selezione Non Corretta");
									System.out.println("------------------------------");
							} //Chiusura switch interno
					break;
				case 2: //Elimina oggetto
					System.out.println("Inserire il codice ISBN del prodotto da eliminare");
					int pordEliminato = Integer.parseInt(scanner.nextLine());
					deleteElementoByISBN(pordEliminato);
					System.out.println("------------------");
					System.out.println("PRODOTTO ELIMINATO");
					break;
				case 3: //Ricerca per codice ISBN
					System.out.println("Inserire codice ISBN del prodotto da cercare:");
					int ricercaISBN = Integer.parseInt(scanner.nextLine());
					getElementoByISBN(ricercaISBN);	
					break;
				case 4: //Ricerca per anno
					System.out.println("Inserire l'anno del prodotto da cercare:");
					int ricercaAnno = Integer.parseInt(scanner.nextLine());
					getElementoByAnno(ricercaAnno);
					break;
				case 5://Ricerca per autore
			        System.out.println("Inserisci il nome dell'autore del prodotto da cercare:");
			        String autore = scanner.nextLine();
			        getElementByAutore(autore);
					break;
				case 6://Ricerca per titolo o parte di esso
					System.out.println("Inseriro il titolo da cercare:");
					String titolo = scanner.nextLine();
					getByTitolo(titolo);
					break;
				case 7://Noleggia prodotto
					System.out.println("Inserisci il codice ISBN del prodotto da noleggiare:");
					int codice = Integer.parseInt(scanner.nextLine());
					System.out.println("Inserisci il numero della tua tessera");
					int tessera= Integer.parseInt(scanner.nextLine());
					creazionePrestito(codice, tessera);
					break;
				case 8://Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
					System.out.println("Digitare il numero di tessere per vedere i noleggi attivi");
					int numeroTess = Integer.parseInt(scanner.nextLine());
					prestitoByTessera(numeroTess);
					break;
				case 9://Ricerca di tutti i prestiti scaduti e non ancora restituiti
					prestitoScaduto();
				case 0://Registrazione Utente"
					aggiungiUtente(DAO.creazioneUtente());
					System.out.println("Utente creato correttamente");
					break;
				case 10://Registrazione Utente"
					startStop = true;
					System.out.println("Programma Terminato");	
					break;
				default: 
					logger.error("ATTENZIONE!!! Selezione Non Corretta");
							} //Chiusura primo switch
				}
				catch (NumberFormatException e) {
					 logger.error("ERRORE! Formato non accettato");
				 }
			 	catch (InputMismatchException e) {
			 		logger.error("ATTENZIONE!!! Formato non accettato");
			 	}
				
			 } while ( startStop == false); //Condizione chiusura ciclo
			scanner.close();
			em.close();
		 } 
	
		public static void aggiungiUtente(Utente e) {
			t.begin();
			em.persist(e);
			t.commit();
		}
		public static void aggiungiLibro(Libri l) {
			t.begin();
			em.persist(l);
			t.commit();
		}
		public static void aggiungiRivista(Riviste r) {
			t.begin();
			em.persist(r);
			t.commit();
		}
		
		public static void prestito(Prestito p) {
			t.begin();
			em.persist(p);
			t.commit();
		}
		
		
		public static void creazionePrestito(int isbn, int numTess) {
			CatalogoBiblioteca p = em.find(CatalogoBiblioteca.class, isbn);
			
			if( p == null ) {
				System.out.println( "Elemento non trovato!" );
				
			}
			System.out.println("----------------------------");
			System.out.println("Vuoi prendere in prestito " + p.getTitolo() + "?");
			System.out.println("----------------------------");
			System.out.println("Selezionare 1 per Sì e 2 per No");
			System.out.println("----------------------------");
			int risposta = Integer.parseInt(scanner.nextLine());
			switch(risposta) {
			case 1:
				LocalDate inizio = LocalDate.now();
				LocalDate prevFine = inizio.plusDays(30);
				Prestito p1 = new Prestito(getUtenteByTessera(numTess), p, inizio, prevFine);
				prestito(p1);
				System.out.println("Prodotto noleggiato!");
				break;
			case 2:
				break;
			default:
				System.out.println("Selezione errata");
			}
		}
		
		public static void getElementoByISBN(int isbn){
			CatalogoBiblioteca p = em.find(CatalogoBiblioteca.class, isbn);;
			if( p == null ) {
				System.out.println( "Elemento non trovato!" );
			}
			System.out.println("Risultato ricerca");
			System.out.println("-----------------------");
			System.out.println(p);

		}
		
		public static void deleteElementoByISBN(int isbn){
			CatalogoBiblioteca p = em.find(CatalogoBiblioteca.class, isbn);;
			if( p == null ) {
				System.out.println( "Elemento non trovato!" );
			}
			System.out.println(p.getTitolo() + " è stato ELIMINATO!");
			t.begin();
			em.remove(p);
			t.commit();

		}
		
		public static void getElementoByAnno(int anno){
			Query q = em.createQuery("SELECT p FROM CatalogoBiblioteca p WHERE anno_pubblicazione = :n");
			q.setParameter("n", anno);
			List<CatalogoBiblioteca> result = q.getResultList();
			for(CatalogoBiblioteca p : result) { 
				System.out.println(p);}
		}
		
		public static void getElementByAutore(String name){
			Query q = em.createNamedQuery("getBookByAuthor");
			q.setParameter("n", name);
			List<Object[]> result = q.getResultList();
			for(Object[] res : result) { 
				System.out.printf("Titolo: %s || Autore: %s%n", res[0], res[1]);}
		}
		
		public static void getByTitolo(String titolo){
			Query q = em.createNamedQuery("getByTitolo");
			q.setParameter("n", "%" + titolo + "%");
			List<Object> result = q.getResultList();
			for(Object p : result) { 
				System.out.println(p);}
		}
		
		public static Utente getUtenteByTessera(int numTess){
			Query q = em.createQuery("SELECT p FROM Utente p WHERE numtessera = :n");
			q.setParameter("n", numTess);
			List<Utente> result = q.getResultList();
			return result.get(0);
		}
		
		public static void prestitoByTessera(int numTess) {
			Query q = em.createQuery("SELECT p FROM Prestito p WHERE utente_numtessera = :n");
			q.setParameter("n", numTess);
			List<Prestito> result = q.getResultList();
			for(Prestito res : result) { 
				System.out.println("Prodotto noleggiato:");
				System.out.println(res.getElementoPrestato());}
		}
		
		public static void prestitoScaduto() {
			Query q = em.createQuery("SELECT p FROM Prestito p WHERE data_fine_prestito IS = NULL AND data_fine_prestito > :n");
			q.setParameter("n", LocalDate.now());
			List<Prestito> result = q.getResultList();
			for(Prestito res : result) { 
				System.out.println("Noleggi Scaduti:");
				System.out.println(res.getElementoPrestato());}
		}
		
		
		
		
}
	 


