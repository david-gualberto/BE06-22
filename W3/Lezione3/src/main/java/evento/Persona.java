package evento;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="persone")
@ToString
@Getter
@Setter
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String Nome;
	private String Cognome;
	private LocalDate Compleanno;
	private String Email;
	private String sesso;
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
	@OrderBy(value="dataEvento")
	private List<Partecipazione> ListaPartecipazioni;
}
