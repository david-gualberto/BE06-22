package com.davidgualberto.es1SpringBoot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.NoArgsConstructor;
import lombok.ToString;

public class PizzaBase extends Prodotti {
	
			List<String> ingredienti; 
			double calorie;
			
			public PizzaBase(String nome, double prezzo, List<String> ingredienti, int calorie ) {
			super(nome, prezzo);
			
			this.nome = nome;
			this.prezzo = prezzo;
			this.ingredienti = ingredienti;
			this.calorie = calorie;
				}
			
			public PizzaBase() {
				super();
				
				this.nome = "Pizza Margherita";
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
				return this.nome + " " + this.ingredienti + " Calorie: " + this.calorie + " Prezzo: " + this.prezzo;
			}
				
			
}
