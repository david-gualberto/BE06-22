package catalogo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Libri extends CatalogoBiblioteca {
	

			private static final Logger logger  = LoggerFactory.getLogger(Libri.class);
			
			String autore;
			static genereLibro genere;
			
			public Libri(int codiceISBN, String title, int anno, int numPag, String autore, genereLibro genere) {
				super(codiceISBN, title, anno, numPag);
				
			this.autore= autore;
			this.genere = genere;
			}
			
			public String getAutore() {
				return this.autore;
			}

			public void setAutore(String autore) {
				this.autore = autore;
			}

			public genereLibro getGenere() {
				return genere;
			}

			public void setGenere(genereLibro genere) {
				this.genere = genere;
			}
			
			public  static Libri creazioneLibro(int codice) throws InputMismatchException {
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
					
					nuovoLibro = new Libri(codice, titolo, anno, numPag, autore, genere);
					stampaProdotto(codice, titolo, anno, numPag, autore, genere);
					return nuovoLibro;
			}
			
			public static void stampaProdotto(int codice, String titolo, int anno, int numPag, String autore, genereLibro genere) {
				System.out.println("--------------------------------");
				System.out.println("---Dettagli prodotto aggiunto---");
				System.out.printf("Codice ISBN: %d%nTitolo: %s%nAnno: %d%nNumero di Pagine: %d%nAutore: %s%nGenere: %s%n", codice, titolo, anno, numPag, autore,genere);
				System.out.println("--------------------------------");
			}			

			@Override
			public String toString() { 
			    return "Codice ISBN: " + this.codiceISBN + " " + "Titolo: " + this.titolo + " " + "Anno: " + this.anno + " " + "Numero di pagine: " + this.numPag + " " + "Autore: " + this.autore + " " + "Genere: " + this.genere;
			} 
			
			public static List<CatalogoBiblioteca> filtroAutore(ArrayList<CatalogoBiblioteca> catalogo, String author) {
		        return catalogo.stream().filter(libro -> ((Libri) libro).getAutore().equalsIgnoreCase(author)).collect(Collectors.toList());
		    }
					
			
}
