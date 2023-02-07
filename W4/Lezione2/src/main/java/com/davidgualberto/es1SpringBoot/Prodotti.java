package com.davidgualberto.es1SpringBoot;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
abstract public class Prodotti {
		String nome;
		double prezzo;
		public Prodotti(String nome, double prezzo) {
			this.nome = nome;
			this.prezzo = prezzo;
		}
		
}
