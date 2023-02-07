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
	public Topping toppingHam(PizzaBase pizza) {
		return new Topping(pizza, "Prosciutto", 0.99, 35);
	}
	
	@Bean
	@Scope("prototype")
	public Topping toppingCheese(PizzaBase pizza) {
		return new Topping(pizza,"Formaggio", 0.69, 92);
	}
	@Bean
	@Scope("prototype")
	public Topping toppingOnion(PizzaBase pizza) {
		return new Topping(pizza,"Cipolla", 0.69, 22);
	}
	@Bean
	@Scope("prototype")
	public Topping toppingPineapple(PizzaBase pizza) {
		return new Topping(pizza,"Ananas", 0.79, 24);
	}
	@Bean
	@Scope("prototype")
	public Topping toppingSalami(PizzaBase pizza) {
		return new Topping(pizza,"Salame", 0.99, 86);
	}
	
	@Bean
	@Scope("prototype")
	public PizzaBase pizzaHawaiian() {
		List<String> x = new ArrayList<>(Arrays.asList("Pomodoro", "Mozzarella","Prosciutto", "Ananas"));
		return new PizzaBase("Hawaiian Pizza", 6.49, x , 1024);
	}
	
	@Bean
	@Scope("prototype")
	public PizzaBase pizzaSalami() {
		List<String> x = new ArrayList<>(Arrays.asList("Pomodoro", "Mozzarella","Salame"));
		return new PizzaBase("Pizza Salami", 5.99, x , 1160);
	}
	
	@Bean
	@Scope("prototype")
	public PizzaExtraSize pizzaExtra(PizzaBase pizza) {
		return new PizzaExtraSize(pizza);
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
	public Ordine ordine1(List<Prodotti> lista) {
		return new Ordine(1, statoOrdineEnum.in_corso, lista, 2, LocalTime.now());
	}

}
