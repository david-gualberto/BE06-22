package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import entities.enums.StatoMezzo;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "periodi_manutenzione")
@NoArgsConstructor
public class PeriodoManutenzione extends PeriodicitaMezzo{
	
	public PeriodoManutenzione (LocalDate i, LocalDate f, Mezzo mezzo ) {
		super(i,f);
		this.setStato(StatoMezzo.MANUTENZIONE);
		this.setMezzo(mezzo);
	}
}
