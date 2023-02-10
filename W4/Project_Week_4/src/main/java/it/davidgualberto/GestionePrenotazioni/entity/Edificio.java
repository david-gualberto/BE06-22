package it.davidgualberto.GestionePrenotazioni.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="edifici")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String indirizzo;
	private String citta;
	
	
	@Override
	public String toString() {
		return"ID: " + this.id+ " | Nome: " + this.nome + " | " + "Indirizzo: " + this.indirizzo + " | " + "Città: " + this.citta;
	}
}
