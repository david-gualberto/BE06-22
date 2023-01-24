package evento;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="evento")
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
		
	}



