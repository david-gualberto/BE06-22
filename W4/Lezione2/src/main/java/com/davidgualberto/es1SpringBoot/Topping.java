package com.davidgualberto.es1SpringBoot;


import lombok.Getter;
@Getter
public class Topping {
	
			PizzaBase pizza;
			String nome;
			double prezzo;
			int calorie;
			
			public Topping(PizzaBase pizza, String nome, double prezzo, int calorie) {
				
				this.pizza = pizza;
				this.nome = nome;
				this.prezzo = prezzo;
				this.calorie = calorie;
				setPrice();
				setCalorie();

			}
			
		public void setPrice() {
			pizza.prezzo = pizza.prezzo + this.prezzo;
			}
		
		public String toString() {
			return this.pizza.nome + " " + pizza.ingredienti +  " Extra: " + this.nome + " Calorie: " + pizza.calorie + " Prezzo: " + pizza.prezzo;
		}
		
		public void setCalorie() {
			pizza.calorie = pizza.calorie + this.calorie;
		}
}
