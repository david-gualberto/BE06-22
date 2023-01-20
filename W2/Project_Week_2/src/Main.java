
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import catalogo.CatalogoBiblioteca;
import catalogo.Libri;
import catalogo.Riviste;

public class Main {
	 static boolean startStop = false;
	 static File fileInfo= new File("archivio.txt");
	 private static final Logger logger  = LoggerFactory.getLogger(Main.class);
	 static Scanner scanner = new Scanner(System.in);
	 static ArrayList<CatalogoBiblioteca> biblioteca = new ArrayList<>();
	 public static void main(String[] args) {
		 
		 do {
			 try {
			 	System.out.println("-------------------------");
				System.out.println("Catalogo della Biblioteca");
				System.out.println("-------------------------");
				System.out.println("Selezione l'operazione da svolgere: ");
				System.out.println("-------------------------");
				System.out.println("1) Aggiungi prodotto");
				System.out.println("2) Rimuovi prodotto inserendo il codice ISBN");
				System.out.println("3) Ricerca per ISBN");
				System.out.println("4) Ricerca per anno");
				System.out.println("5) Ricerca per autore");
				System.out.println("6) Salva sull'archivio");
				System.out.println("7) Carica l'archivio");
				System.out.println("8) STOP PROGRAMMA");
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
									System.out.println("---Inserire codice ISBN---");
									int codiceLibro = Integer.parseInt(scanner.nextLine());
									if (CatalogoBiblioteca.checkNumber(codiceLibro, biblioteca) == true) {
										logger.error("ATTENZIONE!!! Codice già esistente nell'archivio");;
										break;
										}
									biblioteca.add(Libri.creazioneLibro(codiceLibro));
									logger.info("PRODOTTO AGGIUNTO CORRETTAMENTE");
									System.out.println(biblioteca);
									break;
								case 2://Creazione Rivista
									System.out.println("Inserire codice ISBN");
									int codiceRivista = Integer.parseInt(scanner.nextLine());
									if (CatalogoBiblioteca.checkNumber(codiceRivista, biblioteca) == true) {
										logger.error("ATTENZIONE!!! Codice già esistente nell'archivio");;
										break;
										}
									biblioteca.add(Riviste.creazioneRivista(codiceRivista));
									logger.info("PRODOTTO AGGIUNTO CORRETTAMENTE");
									System.out.println(biblioteca);
									break;
								default: 
									System.out.println("------------------------------");
									logger.error("ATTENZIONE!!! Selezione Non Corretta");
									System.out.println("------------------------------");
							} //Chiusura switch interno
					break;
				case 2: //Elimina oggetto
					System.out.println("Inserire il codice del prodotto da eliminare");
					int pordEliminato = Integer.parseInt(scanner.nextLine());
					CatalogoBiblioteca.eliminaProdotto(biblioteca, pordEliminato);
					System.out.println("------------------");
					System.out.println("PRODOTTO ELIMINATO");
					break;
				case 3: //Ricerca per codice ISBN
					System.out.println("Inserire codice ISBN del prodotto da cercare:");
					int ricercaISBN = Integer.parseInt(scanner.nextLine());
					CatalogoBiblioteca.filtro(biblioteca, ricercaISBN);
					break;
				case 4: //Ricerca per anno
					System.out.println("Inserire l'anno del prodotto da cercare:");
					int ricercaAnno = Integer.parseInt(scanner.nextLine());
					CatalogoBiblioteca.filtroAnno(biblioteca, ricercaAnno);
					break;
				case 5://Ricerca per autore
			            System.out.println("Inserisci il nome dell'autore del prodotto da cercare:");
			            String autore = scanner.nextLine();
			            List<CatalogoBiblioteca> ricerca = Libri.filtroAutore(biblioteca, autore);
			            if (ricerca.isEmpty()) {
			                System.out.println("Nessun elemento trovato per l'autore specificato.");
			            } else {
			                for (CatalogoBiblioteca prodotto : ricerca) {
			                    System.out.println(prodotto);
			                }
			            }
					break;
				case 6://Aggiungi file ad archivio
					String prodotti = biblioteca.toString();
					try {
						CatalogoBiblioteca.aggiungiAlFile(fileInfo, prodotti);
					} catch (Exception e1) {
						System.out.println("File non trovato");
					}
				case 7://Leggi archivio
					try {
						CatalogoBiblioteca.caricaArchivio(fileInfo);
					} catch (Exception e1) {
						System.out.println("File non trovato");
					}
					break;
				case 8:
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
			
		 } 
	
	 }


