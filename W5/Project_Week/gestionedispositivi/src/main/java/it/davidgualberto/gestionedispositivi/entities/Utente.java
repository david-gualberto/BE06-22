package it.davidgualberto.gestionedispositivi.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import it.davidgualberto.gestionedispositivi.enums.RuoloUtente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="utenti")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Utente {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String nome;
		private String cognome;
		private String username;
		private String password;
		private String email;
		@Enumerated(EnumType.STRING)
		private RuoloUtente ruolo;
		
		@OneToMany(cascade = CascadeType.ALL)
		private Set<Dispositivo> dispositivi = new HashSet<>();
		
		public void setDisp(Dispositivo x) {
			dispositivi.add(x);
		}
		
}
