package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import entities.enums.StatoMezzo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
public abstract class PeriodicitaMezzo {
	
	@Id
	@GeneratedValue
	private int id;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	@Enumerated(EnumType.STRING)
	private StatoMezzo stato;
	@ManyToOne
	private Mezzo mezzo;
	
	public PeriodicitaMezzo(LocalDate i, LocalDate f) {
		this.dataInizio = i;
		this.dataFine = f;
	}
	
	public String toString() {
		return "Periodo " + String.format("%1$-"+ 2 + "s",getId()) + " di " + getStato() + " dal " + getDataInizio() + " al " + getDataFine();
	}
}
