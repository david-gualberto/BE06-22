package catalogo;

import java.util.Scanner;

public class Riviste extends CatalogoBiblioteca {
			static periodicità periodicita;
			
	public Riviste(int codiceISBN, String title, int anno, int numPag, periodicità periodicita) {
		super(codiceISBN, title, anno, numPag);
		this.periodicita = periodicita;
		
	}

	public periodicità getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(periodicità periodicita) {
		this.periodicita = periodicita;
	}
	
	public static  Riviste creazioneRivista(int codice) {
		
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
		Riviste nuovaRivista = new Riviste(codice, titolo, anno, numPag, periodicita);
		stampaProdotto(codice, titolo, anno, numPag, periodicita);
		return nuovaRivista;
	}
	
	public static void stampaProdotto(int codice, String titolo, int anno, int numPag, periodicità periodicita) {
		System.out.println("--------------------------------");
		System.out.println("---Dettagli prodotto aggiunto---");
		System.out.printf("Codice ISBN: %d%nTitolo: %s%nAnno: %d%nNumero di Pagine: %d%nPeriodicità: %s%n", codice, titolo, anno, numPag, periodicita);
		System.out.println("--------------------------------");
	}
	
	@Override
	public String toString() { 
	    return "Codice ISBN: " + this.codiceISBN + " " + "Titolo: " + this.titolo + " " + "Anno: " + this.anno + " " + "Numero di pagine: " + this.numPag + " " + "Periodicità: " + this.periodicita;
	}

}
