package com.davidgualberto.es1SpringBoot;

public class Franchise extends Prodotti {

	public Franchise(String nome, double prezzo) {
		super(nome, prezzo);
		this.nota = null;
	}
	
	public String toString() {
		return String.format("%1$-"+ 20+"s",this.nome) + String.format("%1$-"+ 70 + "s"," ")+ String.format("%1$-"+ 10 + "s"," "+this.prezzo+ "€");
	}

}
