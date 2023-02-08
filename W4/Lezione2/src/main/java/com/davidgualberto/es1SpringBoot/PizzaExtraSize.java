package com.davidgualberto.es1SpringBoot;


public class PizzaExtraSize extends PizzaBase {
		static double calorie;
		static double prezzo;
		
		public PizzaExtraSize() {
			this.calorie = 1.95;
			this.prezzo = 4.15;
		}
		
		public static void setPrezzo(PizzaBase pizza) {
			pizza.prezzo = pizza.prezzo + prezzo;
		}
		
		public static void setCalorie(PizzaBase pizza) {
			pizza.calorie = pizza.calorie * calorie;
		}
		
		public static void addExtraSize(PizzaBase pizza) {
			setPrezzo(pizza);
			setCalorie(pizza);
			pizza.setNome(pizza.nome + " Extra Size");
		}
		
		public String toString() {
			return String.format("%1$-"+ 20+"s","Pizza Extra Size") + String.format("%1$-"+ 70 + "s"," ") + String.format("%1$-"+ 10 + "s","+"+this.prezzo+ "€");
		}
}
