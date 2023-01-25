package evento;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="eventi")
@ToString
@Getter
@Setter
public class Evento {

			
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String titolo;
		@Column(name = "data")
		private LocalDate dataEvento;
		private String descrizione;
		@Column(name = "tipologia")
		@Enumerated(EnumType.STRING)
		private tipo tipoEvento;
		@Column(name = "partecipanti")
		private int numeroMassimoPaartecipanti;
		
		@OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
		private Set<Partecipazione> setPartecipazioni;
		
		@ManyToOne
		private Location Location;

	}



