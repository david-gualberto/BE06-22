package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import entities.enums.StatoMezzo;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "periodi_servizio")
@NoArgsConstructor
public class PeriodoServizio extends PeriodicitaMezzo{
	
	public PeriodoServizio (LocalDate i, LocalDate f, Mezzo mezzo ) {
		super(i,f);
		this.setStato(StatoMezzo.SERVIZIO);
		this.setMezzo(mezzo);
	}
}
