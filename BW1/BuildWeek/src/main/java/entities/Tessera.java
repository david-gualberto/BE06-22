package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tessera")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Tessera {

    @Id
    @SequenceGenerator(name="seq", sequenceName="tessera_sequence", allocationSize = 1000)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int codice;
    @Column(name = "data_emissione")
    private LocalDate dataEmissione;
    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;
    @OneToOne(mappedBy = "tessera")
    private Utente utente;

    public Tessera( LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataEmissione.plusYears(1);
    }
}
