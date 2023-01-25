package evento;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="partecipazioni")
@ToString
@Getter
@Setter
public class Partecipazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Persona persona;
	
	@ManyToOne
	private Evento evento;
	
	@Enumerated(EnumType.STRING)
	private stato stato;
}
