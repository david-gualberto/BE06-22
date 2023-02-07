package com.davidgualberto.es1SpringBoot;

public class Drink extends Prodotti {
			int calorie;
	
			public Drink(String nome,int calorie, double prezzo) {
		super(nome, prezzo);
		this.nome = nome;
		this.calorie = calorie;
		this.prezzo = prezzo;
	
	}

}
