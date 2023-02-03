package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "biglietti")
@Getter
@Setter
@NoArgsConstructor
public class Biglietto extends TitoloDiViaggio{
    
    @Column(name = "data_vidimazione")
    private LocalDate dataVidimazione;
    @OneToOne
    private Corsa corsa;
    
    public Biglietto(LocalDate dataEmissione, VenditaBiglietti emissione) {
        super(dataEmissione, emissione);
    }
    
    @Override
    public String toString() {
    	return "Biglietto " + String.format("%1$-"+ 3 + "s",getId()) + "Data Vidimazione: " + getDataVidimazione() + " " + getCorsa();
    }
}
