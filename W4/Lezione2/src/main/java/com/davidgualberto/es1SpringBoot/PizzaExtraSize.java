package com.davidgualberto.es1SpringBoot;


public class PizzaExtraSize extends PizzaBase {
		PizzaBase pizza;
		double calorie = 1.95;
		double prezzo = 4.15;
		
		public PizzaExtraSize(PizzaBase pizza) {
			this.pizza = pizza;
			setPrezzo();
			setCalorie();
		}
		
		public void setPrezzo() {
			pizza.prezzo = pizza.prezzo + this.prezzo;
		}
		
		public void setCalorie() {
			pizza.calorie = pizza.calorie * this.calorie;
		}
		
		public String toString() {
			return pizza.nome + " Extra Size " + pizza.ingredienti + " Calorie: " + pizza.calorie + " Prezzo: " + pizza.prezzo;
		}
}
