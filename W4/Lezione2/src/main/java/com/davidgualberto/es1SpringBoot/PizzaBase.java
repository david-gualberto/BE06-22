package com.davidgualberto.es1SpringBoot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.NoArgsConstructor;
import lombok.ToString;

public class PizzaBase extends Prodotti {
	
			List<String> ingredienti; 
			List<String> topping;
			double calorie;
			
			public PizzaBase(String nome, double prezzo, List<String> ingredienti, int calorie) {
			super(nome, prezzo);
			this.nota = null;
			this.topping = new ArrayList<>();
			this.nome = nome;
			this.prezzo = prezzo;
			this.ingredienti = ingredienti;
			this.calorie = calorie;
				}
			
			public PizzaBase() {
				super();
				
				this.nome = "Margherita";
				this.prezzo = 4.99;
				this.ingredienti = new ArrayList<>( Arrays.asList("Pomodoro", "Mozzarella") );
				this.calorie = 1104;
			}

			public List<String> getIngredienti() {
				return ingredienti;
			}

			public double getCalorie() {
				return this.calorie;
			}

			public void setCalorie(int calorie) {
				this.calorie = calorie;
			}
			
			public String toString() {
				return String.format("%1$-"+ 20+"s",this.nome) + String.format("%1$-"+ 60 + "s",this.ingredienti) + String.format("%1$-"+ 10 + "s",this.calorie) + String.format("%1$-"+ 10 + "s"," "+this.prezzo+ "€");
			}
				
			
}
