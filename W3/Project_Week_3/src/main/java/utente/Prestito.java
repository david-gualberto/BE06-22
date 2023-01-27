package utente;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import catalogo.CatalogoBiblioteca;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade= CascadeType.REMOVE)
	Utente utente;
	
	@OneToOne(cascade= CascadeType.REMOVE)
	CatalogoBiblioteca elementoPrestato;
	
	@Column(name="data_inizio_prestito")
	LocalDate inizioPrestito = LocalDate.now();;
	
	@Column(name="previsione_fine_prestito")
	LocalDate prevFinePrestito;
	
	@Column(name="data_fine_prestito")
	LocalDate finePrestitoEff;

	public Prestito(Utente utente, CatalogoBiblioteca elementoPrestato, LocalDate inizioPrestito,
			LocalDate prevFinePrestito) {
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.inizioPrestito = inizioPrestito;
		this.prevFinePrestito = prevFinePrestito;
	}
}
