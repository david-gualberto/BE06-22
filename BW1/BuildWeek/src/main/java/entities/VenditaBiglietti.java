package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import entities.enums.StatoBiglietteria;
import entities.enums.TipologiaRivenditore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "emissione_biglietti")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class VenditaBiglietti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private StatoBiglietteria stato;
	@Enumerated(EnumType.STRING)
	private TipologiaRivenditore rivenditore;
	@OneToMany(mappedBy = "emissione")
	private List<TitoloDiViaggio> listaTitoli;
	
	public VenditaBiglietti(TipologiaRivenditore rivenditore) {
		this.rivenditore = rivenditore;
		this.stato = StatoBiglietteria.ATTIVO;
	}
	
}
