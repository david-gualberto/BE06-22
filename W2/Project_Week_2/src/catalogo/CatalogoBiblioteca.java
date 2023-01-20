package catalogo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Predicate;

import org.apache.commons.io.FileUtils;

public abstract class CatalogoBiblioteca {
		
		private static final String ENCODING = "utf-8";
		
		int codiceISBN;
		String titolo;
		int anno;
		int numPag;
		public CatalogoBiblioteca(int codiceISBN, String titolo, int anno, int numPag) {
			this.codiceISBN = codiceISBN;
			this.titolo = titolo;
			this.anno = anno;
			this.numPag = numPag;
		}
		
		
		public int getCodiceISBN() {
			return codiceISBN;
		}
		
		public int setCodiceISBN(int codiceISBN) {
			return this.codiceISBN = codiceISBN;
		}

		public String getTitolo() {
			return this.titolo;
		}

		public void setTitle(String title) {
			this.titolo = title;
		}


		public int getAnno() {
			return anno;
		}


		public int setAnno(int anno) {
			return this.anno = anno;
		}


		public int getNumPag() {
			return numPag;
		}


		public void setNumPag(int numPag) {
			this.numPag = numPag;
		}
		
		public static boolean checkNumber(int codice, ArrayList<CatalogoBiblioteca> catalogo) {
			return catalogo.stream().anyMatch(product -> product.getCodiceISBN() == codice);
		}
		
		public static void eliminaProdotto(ArrayList<CatalogoBiblioteca> catalogo, int codice) {
			catalogo.removeIf(prodotto -> prodotto.getCodiceISBN() == codice);
		}
		
		public static void filtro(ArrayList<CatalogoBiblioteca> catalogo, int codice){
			Predicate<CatalogoBiblioteca> filtroISBN = prodotto -> prodotto.getCodiceISBN() == codice;
			catalogo.stream()
			.filter(filtroISBN)
			.forEach(p -> System.out.println(p));
		}
		
		public static void filtroAnno(ArrayList<CatalogoBiblioteca> catalogo, int anno){
			Predicate<CatalogoBiblioteca> filtroAnno = prodotto -> prodotto.getAnno() == anno;
			catalogo.stream()
			.filter(filtroAnno)
			.forEach(p -> System.out.println(p));
		}
		
		
		public static void aggiungiAlFile(File fileInfo, String catalogo) {
			try {
				FileUtils.writeStringToFile(fileInfo, catalogo, ENCODING, true);
			} catch (IOException e) {
				System.out.println("ERRORE! File non trovato");
			}
		}
		
		static public void caricaArchivio(File fileinfo)throws IOException {
			try {
				String content = FileUtils.readFileToString(fileinfo, ENCODING);
				System.out.println(content);
			} catch (IOException e) {
				System.out.println("Errore nella lettura del file");
			}
		}	
		
}
