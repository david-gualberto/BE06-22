package catalogo;

import java.util.Scanner;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name= "riviste")
@Getter
@Setter
@NoArgsConstructor
public class Riviste extends CatalogoBiblioteca {
			static periodicità periodicita;
			
	public Riviste(String title, int anno, int numPag, periodicità periodicita) {
		super(title, anno, numPag);
		this.periodicita = periodicita;
		
	}
	@Enumerated(EnumType.STRING)
	public periodicità getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(periodicità periodicita) {
		this.periodicita = periodicita;
	}
	
	
	@Override
	public String toString() { 
	    return "Codice ISBN: " + this.codiceISBN + " || " + "Titolo: " + this.titolo + " || " + "Anno: " + this.anno + " || " + "Numero di pagine: " + this.numPag + " || " + "Periodicità: " + this.periodicita;
	}

}
