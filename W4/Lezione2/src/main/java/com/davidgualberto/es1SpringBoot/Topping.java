package com.davidgualberto.es1SpringBoot;


import lombok.Getter;
@Getter
public class Topping {
	
			String nome;
			double prezzo;
			int calorie;
			
			public Topping(String nome, double prezzo, int calorie) {
				this.nome = nome;
				this.prezzo = prezzo;
				this.calorie = calorie;
			}
			
		public void setPrice(PizzaBase pizza) {
			pizza.prezzo = pizza.prezzo + this.prezzo;
			}
		
		public String toString() {
			return String.format("%1$-"+ 20+"s",this.nome) + String.format("%1$-"+ 60 + "s"," ")+ String.format("%1$-"+ 10 + "s",this.calorie) + String.format("%1$-"+ 10 + "s"," "+this.prezzo+ "€");
		}
		public void addTopping(PizzaBase pizza) {
			setPrice(pizza);
			setCalorie(pizza);
			pizza.topping.add(this.nome);
		}
		
		public void setCalorie(PizzaBase pizza) {
			pizza.calorie = pizza.calorie + this.calorie;
		}
		
		
}
