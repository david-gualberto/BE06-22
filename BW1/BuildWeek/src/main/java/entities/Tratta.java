package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tratte")
@Getter
@Setter
@NoArgsConstructor
public class Tratta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "partenza")
	private String zonaDiPartenza;
	private String capolinea;
	@Column(name = "durata_media")
	private int tempoMedioDiPercorrenza;
	
	public Tratta(String a, String b, int t){
		this.zonaDiPartenza = a;
		this.capolinea = b;
		this.tempoMedioDiPercorrenza = t;
	}
	
	@Override
	public String toString() {
		return "Tratta: " + String.format("%1$-"+ 3 + "s",getId()) + "Partenza: " + String.format("%1$-"+ 16 + "s",getZonaDiPartenza()) 
			 + "Capolinea: " + String.format("%1$-"+ 17 + "s",getCapolinea()) + "Tempo Stimato: " + getTempoMedioDiPercorrenza();
	}
}
