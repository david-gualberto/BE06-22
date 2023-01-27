package dao;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.Main;
import catalogo.Libri;
import catalogo.Riviste;
import catalogo.genereLibro;
import catalogo.periodicità;
import utente.Utente;

public class DAO {
	 private static final Logger logger  = LoggerFactory.getLogger(Main.class);
	 
	public static  Riviste creazioneRivista() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Titolo:");
		String titolo = scanner.nextLine();
		System.out.println("Anno:");
		int anno = Integer.parseInt(scanner.nextLine());
		System.out.println("Numero di pagine:");
		int numPag = Integer.parseInt(scanner.nextLine());
		System.out.println("Periodicità di uscita:");
		System.out.println("1)Settimanale");
		System.out.println("2)Mensile");
		System.out.println("3)Semestrale");
		int scelta = scanner.nextInt();
		periodicità periodicita = null;
		switch (scelta) {
			case 1:
				periodicita = periodicità.Settimanale;
				break;
			case 2:
				periodicita = periodicità.Mensile;
				break;
			case 3:
				periodicita = periodicità.Semestrale;
				break;
		} 
		Riviste nuovaRivista = new Riviste( titolo, anno, numPag, periodicita);
		return nuovaRivista;
	}
	
	public  static Libri creazioneLibro() throws InputMismatchException {
		Scanner scanner = new Scanner(System.in);
		Libri nuovoLibro ;
		
			System.out.println("Titolo:");
			String titolo = scanner.nextLine();
			System.out.println("Anno:");
			int anno = Integer.parseInt(scanner.nextLine());
			System.out.println("Numero di pagine:");
			int numPag = Integer.parseInt(scanner.nextLine());
			System.out.println("Autore:");
			String autore = scanner.nextLine();
			System.out.println("Selezionare il genere in base all'indice:");
			System.out.println("1)Romanzo Storico");
			System.out.println("2)Biografia");
			System.out.println("3)Giallo");
			System.out.println("4)Thriller");
			System.out.println("5)Avventura");
			System.out.println("6)Fantasy");
			System.out.println("7)Horror");
			System.out.println("8)Libro Di Formazione");
			int scelta = Integer.parseInt(scanner.nextLine());
			genereLibro genere = null;
			switch (scelta) {
				case 1:
					genere = genereLibro.RomanzoStorico;
					break;
				case 2:
					genere = genereLibro.Biografia;
					break;
				case 3:
					genere = genereLibro.Giallo;
					break;
				case 4:
					genere = genereLibro.Thriller;
					break;
				case 5:
					genere = genereLibro.Avventura;
					break;
				case 6:
					genere = genereLibro.Fantasy;
					break;
				case 7:
					genere = genereLibro.Horror;
					break;
				case 8:
					genere = genereLibro.LibroDiFormazione;
					break;
				default:
					logger.error("Selezione non corretta");
			}
			
			nuovoLibro = new Libri( titolo, anno, numPag, autore, genere);
			return nuovoLibro;
	}
	
	public static Utente creazioneUtente() {
		Scanner scanner = new Scanner(System.in);
		Utente nuovoUtente ;
		
			System.out.println("Inserire nome:");
			String nome = scanner.nextLine();
			System.out.println("Inserire cognome:");
			String cognome = scanner.nextLine();
			System.out.println("Inserire data di nascita in formato (YYYY-MM-DD):");
			LocalDate dataNascita = LocalDate.parse(scanner.nextLine());
			nuovoUtente = new Utente( nome, cognome, dataNascita);
			return nuovoUtente;
	}
}
