package entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
public abstract class Mezzo {
	
	@Id
	@SequenceGenerator(name = "mezzo_seq", sequenceName = "mezzo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mezzo_seq")
	private int id;
	private int capienza;
	@OneToMany(mappedBy = "mezzo", cascade = CascadeType.REMOVE)
	private List<PeriodicitaMezzo> stato;
	@ManyToOne
	private Tratta tratta;
	
	public Mezzo(Tratta tratta) {
		setStato(stato);
		setTratta(tratta);
	}
	
	@Override
	public String toString() {
		return String.format("%1$-"+ 8 + "s", getClass().getName().replace("entities.","")) 
			 + String.format("%1$-"+ 5 + "s",getId()) + "Capienza: " + String.format("%1$-"+ 5 + "s",getCapienza()) + getTratta();
	}
}
