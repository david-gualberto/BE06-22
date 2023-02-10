package it.davidgualberto.GestionePrenotazioni.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.internal.build.AllowSysOut;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="prenotazioni")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Utente utente;
	
	@OneToOne
	private Postazione postazione;
	private LocalDate data;
	
	@Override
	public String toString() {
		return "Prenotazione con id: " + this.id + " | Postazione prenotata: " + postazione.getId() + " | Prenotazione a nome dell'Utente: " + utente.getNomeCompleto() + " | Tipologia Postazione: " + postazione.getTipo();
	}
	
}
