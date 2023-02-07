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
		creaPizza();
	}

	
	public static void creaPizza() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuration.class);
		
		PizzaBase b1 = new PizzaBase();
		PizzaBase b2 = (PizzaBase)ctx.getBean("pizzaSalami");
		PizzaExtraSize b3 = new PizzaExtraSize(b2);
		List<Prodotti> listaPizza = new ArrayList<>();
		listaPizza.add(b1);
		listaPizza.add(b2);
		listaPizza.add(b3);
		
		Ordine or1 = (Ordine)ctx.getBean("ordine1", listaPizza );
		System.out.println(or1);
	
		System.out.println(or1.setContoTotale());
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
}
