package it.davidgualberto.gestionedispositivi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import it.davidgualberto.gestionedispositivi.enums.StatoDispositivo;
import it.davidgualberto.gestionedispositivi.enums.TipologiaDispositivo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="dispositivi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="tipologia")
	@Enumerated(EnumType.STRING)
	TipologiaDispositivo tipo;
	
	@Column(name="stato_dispositivo")
	@Enumerated(EnumType.STRING)
	StatoDispositivo stato;

}
