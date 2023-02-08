package com.davidgualberto.es1SpringBoot;

public class Drink extends Prodotti {
			int calorie;
	
			public Drink(String nome,int calorie, double prezzo) {
		super(nome, prezzo);
		this.nota = null;
		this.nome = nome;
		this.calorie = calorie;
		this.prezzo = prezzo;
	
	}
			
	public String toString() {
		return String.format("%1$-"+ 20+"s",this.nome) + String.format("%1$-"+ 60 + "s"," ")+ String.format("%1$-"+ 10 + "s",this.calorie) + String.format("%1$-"+ 10 + "s"," "+this.prezzo+ "€");
		}

}
