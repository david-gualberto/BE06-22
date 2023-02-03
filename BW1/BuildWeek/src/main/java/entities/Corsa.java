package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "corse")
@Getter
@Setter
@NoArgsConstructor
public class Corsa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Mezzo mezzo;
	@OneToOne
	private Tratta tratta;
	private int tempoEffettivo;
	
	public Corsa(Mezzo m, Tratta t, int tE) {
        setMezzo(m);
        setTratta(t);
        setTempoEffettivo(tE);
    }
	
	@Override
	public String toString() {
		return "Corsa: " + String.format("%1$-"+ 5 + "s",getId()) + "Mezzo: " 
			 + String.format("%1$-"+ 8 + "s",getMezzo().getClass().getName().replace("entities.","")) 
			 + getMezzo().getId() + "  " + getMezzo().getTratta() + " Tempo Effettivo: " + getTempoEffettivo();
		
	}
}
