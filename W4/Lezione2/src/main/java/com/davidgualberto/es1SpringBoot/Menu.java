package com.davidgualberto.es1SpringBoot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Menu {
	static List<PizzaBase> pizze = new ArrayList<>();
	static List<Drink> bevande = new ArrayList<>();
	static List<Topping> topping = new ArrayList<>();
	static List<Franchise> franchise = new ArrayList<>();
	static ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuration.class);
	
	public static void menuPizza() {
		PizzaBase p1 = new PizzaBase();
		PizzaBase p2 = (PizzaBase)ctx.getBean("pizzaSalami");
		PizzaBase p3 = (PizzaBase)ctx.getBean("pizzaHawaiian");
		Collections.addAll(pizze, p1,p2,p3);

	}
	public static void menuBevande() {
		Drink d1 = (Drink)ctx.getBean("lemonade");
		Drink d2 = (Drink)ctx.getBean("water");
		Drink d3 = (Drink)ctx.getBean("wine");
		Collections.addAll(bevande, d1,d2,d3);

	}
	public static void menuTopping() {
		Topping t1 = (Topping)ctx.getBean("toppingHam");
		Topping t2 = (Topping)ctx.getBean("toppingCheese");
		Topping t3 = (Topping)ctx.getBean("toppingOnion");
		Topping t4 = (Topping)ctx.getBean("toppingPineapple");
		Topping t5 = (Topping)ctx.getBean("toppingSalami");
		Collections.addAll(topping, t1,t2,t3,t4,t5);

	}
	public static void menuFranchise() {
		Franchise f1 = (Franchise)ctx.getBean("mug");
		Franchise f2 = (Franchise)ctx.getBean("shirt");
		Collections.addAll(franchise, f1,f2);
	}
	
	public static void creaMenu() {
		menuPizza();
		menuBevande();
		menuTopping();
		menuFranchise();
		stampaMenu();
	}
	
	public static void stampaMenu() {
		System.out.println("-----------------PIZZE-----------------");
		System.out.println(String.format("%1$-"+ 20+"s","NOME") + String.format("%1$-"+ 60 + "s","INGREDIENTI")+ String.format("%1$-"+ 10 + "s","CALORIE") + String.format("%1$-"+ 10 + "s","PREZZO"));
		pizze.forEach((p) -> System.out.println(p.toString()));
		System.out.println("-----------------TOPPING---------------");
		System.out.println(String.format("%1$-"+ 20+"s","NOME") + String.format("%1$-"+ 60 + "s"," ")+ String.format("%1$-"+ 10 + "s","CALORIE") + String.format("%1$-"+ 10 + "s","PREZZO"));
		topping.forEach((t) -> System.out.println(t.toString()));
		System.out.println("-----------------BEVANDE---------------");
		System.out.println(String.format("%1$-"+ 20+"s","NOME") + String.format("%1$-"+ 60 + "s"," ")+ String.format("%1$-"+ 10 + "s","CALORIE") + String.format("%1$-"+ 10 + "s","PREZZO"));
		bevande.forEach((b) -> System.out.println(b.toString()));
		System.out.println("-----------------FRANCHISE-------------");
		System.out.println(String.format("%1$-"+ 20+"s","NOME") + String.format("%1$-"+ 60 + "s"," ")+ String.format("%1$-"+ 10 + "s"," ") + String.format("%1$-"+ 10 + "s","PREZZO"));
		franchise.forEach((f) -> System.out.println(f.toString()));
	}
	
	
	
}


