package it.davidgualberto.GestionePrenotazioni.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.davidgualberto.GestionePrenotazioni.enums.TipoPostazione;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="postazioni")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	
	@Column(name="numero_max_occupanti")
	private int numMaxOccupanti;
	
	@ManyToOne
	@JoinColumn(name = "edificio_id", referencedColumnName = "id")
	private Edificio edificio;
	@Override
	public String toString() {
		return"ID: " + this.id +  " | Tipologia: " + this.tipo + " | Edificio: " + edificio.getNome() + " | Via: " + edificio.getIndirizzo() + " | Città: " + edificio.getCitta();
		
	}	
}
