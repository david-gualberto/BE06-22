package com.davidgualberto.es1SpringBoot;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
abstract public class Prodotti {
		String nome;
		double prezzo;
		String nota;
		public Prodotti(String nome, double prezzo) {
			this.nota=nota;
			this.nome = nome;
			this.prezzo = prezzo;
		}
		
}
