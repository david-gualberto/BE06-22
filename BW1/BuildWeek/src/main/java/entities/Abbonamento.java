package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import entities.enums.TipologiaAbbonamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "abbonamenti")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name="CheckAbbonamento", query="SELECT a FROM Abbonamento a WHERE a.tessera = :t")
public class Abbonamento extends TitoloDiViaggio{

    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;
    @Column(name = "tipologia_abbonamento")
    @Enumerated(EnumType.STRING)
    private TipologiaAbbonamento tipologiaAbbonamento;
    @OneToOne
    @JoinColumn(name = "codice_tessera")
    private Tessera tessera;

    public Abbonamento(LocalDate dataEmissione, VenditaBiglietti emissione, TipologiaAbbonamento tipologiaAbbonamento,
			Tessera tessera) {
		super(dataEmissione, emissione);
		this.tipologiaAbbonamento = tipologiaAbbonamento;
		this.tessera = tessera;
		calcolaDataScadenza(tipologiaAbbonamento, dataEmissione);
	}
    
 
    public LocalDate calcolaDataScadenza(TipologiaAbbonamento tipo, LocalDate dataEmissione) {
        if (tipo == TipologiaAbbonamento.SETTIMANALE) {
            dataScadenza = dataEmissione.plusDays(7);
        }else {dataScadenza = dataEmissione.plusDays(30);
            }return dataScadenza;
    }
    
    @Override
    public String toString() {
    	return "Abbonamento " + String.format("%1$-"+ 3 + "s",getId()) + "Data Emissione: " + getDataEmissione() + " Data Scadenza: " + getDataScadenza() + " Tipologia: " + getTipologiaAbbonamento();
    }

}
