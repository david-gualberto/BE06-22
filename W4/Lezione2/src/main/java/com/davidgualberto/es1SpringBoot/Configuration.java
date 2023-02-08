package com.davidgualberto.es1SpringBoot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
public class Configuration {
	@Bean
	@Scope("prototype")
	public Topping toppingHam() {
		return new Topping("Prosciutto", 0.99, 35);
	}
	
	@Bean
	@Scope("prototype")
	public Topping toppingCheese() {
		return new Topping("Formaggio", 0.69, 92);
	}
	@Bean
	@Scope("prototype")
	public Topping toppingOnion() {
		return new Topping("Cipolla", 0.69, 22);
	}
	@Bean
	@Scope("prototype")
	public Topping toppingPineapple() {
		return new Topping("Ananas", 0.79, 24);
	}
	@Bean
	@Scope("prototype")
	public Topping toppingSalami() {
		return new Topping("Salame", 0.99, 86);
	}
	
	@Bean
	@Scope("prototype")
	public PizzaBase pizzaHawaiian() {
		List<String> x = new ArrayList<>(Arrays.asList("Pomodoro", "Mozzarella","Prosciutto", "Ananas"));
		return new PizzaBase("Hawaiian", 6.49, x , 1024);
	}
	
	@Bean
	@Scope("prototype")
	public PizzaBase pizzaSalami() {
		List<String> x = new ArrayList<>(Arrays.asList("Pomodoro", "Mozzarella","Salame"));
		return new PizzaBase("Salami", 5.99, x , 1160);
	}
	
	@Bean
	@Scope("prototype")
	public PizzaExtraSize pizzaExtra() {
		return new PizzaExtraSize();
	}
	@Bean
	@Scope("prototype")
	public Drink lemonade() {
		return new Drink("Limonata", 128, 1.29);
	}
	
	@Bean
	@Scope("prototype")
	public Drink water() {
		return new Drink("Acqua", 0, 1.29);
	}
	
	@Bean
	@Scope("prototype")
	public Drink wine() {
		return new Drink("Vino", 607, 7.49);
	}
	
	@Bean
	@Scope("prototype")
	public Franchise mug() {
		return new Franchise("Tazza", 4.99);
	}
	
	@Bean
	@Scope("prototype")
	public Franchise shirt() {
		return new Franchise("Maglietta", 21.99);
	}
	
	@Bean
	@Scope("prototype")
	public Ordine ordine1(int numOrd,statoOrdineEnum stato, List<Prodotti> lista, int numCoperti) {
		return new Ordine(numOrd, stato, lista, numCoperti, LocalTime.now());
	}
	
	
	@Bean
	@Scope("prototype")
	public Tavolo tavolo(int numTav, int maxCoperti,statoTavoloEnum statoTavolo, Ordine ordine) {
		return new Tavolo(numTav,maxCoperti, statoTavolo, ordine);
	}

}
