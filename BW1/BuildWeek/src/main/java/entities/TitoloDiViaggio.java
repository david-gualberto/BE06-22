package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class TitoloDiViaggio {

	@Id
	@SequenceGenerator(name = "titolo_seq", sequenceName = "titolo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "titolo_seq")
    private int id;
	@Column(name = "data_emissione")
    private LocalDate dataEmissione;
	@ManyToOne
	private VenditaBiglietti emissione;
	
	public TitoloDiViaggio(LocalDate dataEmissione, VenditaBiglietti emissione) {
        this.dataEmissione = dataEmissione;
        this.emissione = emissione;
    }
}
