package catalogo;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name= "libri")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "getBookByAuthor", query="SELECT p.titolo, p.autore FROM Libri p WHERE p.autore = :n")
public class Libri extends CatalogoBiblioteca {
	

			private static final Logger logger  = LoggerFactory.getLogger(Libri.class);
			
			String autore;
			@Enumerated(EnumType.STRING)
			static genereLibro genere;
			
			public Libri( String title, int anno, int numPag, String autore, genereLibro genere) {
				super(title, anno, numPag);
				
			this.autore= autore;
			this.genere = genere;
			}


			@Override
			public String toString() { 
			    return "Codice ISBN: " + this.codiceISBN + " || " + "Titolo: " + this.titolo + " || " + "Anno: " + this.anno + " || " + "Numero di pagine: " + this.numPag + " || " + "Autore: " + this.autore + " || " + "Genere: " + this.genere;
			} 
			
					
			
}
