package com.davidgualberto.es1SpringBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Esercizio1SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio1SpringBootApplication.class, args);
		//creaOrdine();
		//Menu.creaMenu();
		//creaOrdine();
		Ordine.ordinaPizza();
	}

	public static void creaOrdine() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuration.class);
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
		ctx2.scan("com.davidgualberto.es1SpringBoot");
		ctx2.refresh();
		PizzaBase b2 = (PizzaBase)ctx.getBean("pizzaSalami");
		System.out.println(b2);
		Topping t2 = (Topping)ctx.getBean("toppingOnion");
		t2.addTopping(b2);
		t2.addTopping(b2);
		System.out.println(b2.topping);
		PizzaExtraSize.addExtraSize(b2);
		System.out.println(b2.nome + b2.topping);
		//List<Prodotti> listaPizza = new ArrayList<>();
		//listaPizza.add(b1);
		//listaPizza.add(b2);
		
		//Ordine or1 = (Ordine)ctx2.getBean("ordine1", listaPizza );
		//System.out.println(or1);
		//System.out.println(or1.setContoTotale());
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
}
