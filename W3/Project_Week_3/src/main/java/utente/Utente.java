package utente;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "utenti")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Utente {
	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "utente_id_seq")
		@SequenceGenerator(name = "utente_id_seq")
		int numTessera;
		String nome;
		String cognome;
		LocalDate dataDiNascita;
	
		
		public Utente(String nome, String cognome, LocalDate dataDiNascita) {
			super();
			this.nome = nome;
			this.cognome = cognome;
			this.dataDiNascita = dataDiNascita;
		}
		
		
}
