package com.davidgualberto.es1SpringBoot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ordine {
		static Scanner scanner = new Scanner(System.in);
		static List<Prodotti> listaProdotti = new ArrayList<>();
		static ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuration.class);
		
		int numOrdine;
		statoOrdineEnum statoOrdine;
		static List<Prodotti> listaOrdine;
		static int NumCoperti;
		@Autowired
		static CostoCoperti costoCoperti;
		LocalTime orario;
		int ContoTotale;
		
		public Ordine(int numOrdine, statoOrdineEnum statoOrdine, List<Prodotti> listaOrdine, int numCoperti,
				LocalTime orario) {
			this.numOrdine = numOrdine;
			this.statoOrdine = statoOrdine;
			this.listaOrdine = listaOrdine;
			this.NumCoperti = numCoperti;
			this.orario = orario;
		}
		
		public String toString() {
			return "Numero Ordine: " + this.numOrdine +
					" Lista Prodotti: " + this.listaOrdine +
					" Orario Ordine: " + this.orario;
		}
		
		public static double setContoTotale() {
			double tot = 0;;
			for (int i = 0; i<listaOrdine.size(); i++) {
				tot += listaOrdine.get(i).prezzo;
			}
			return tot + (Integer.parseInt(costoCoperti.costo) * NumCoperti);
		}
		
		public static void ordinaPizza() {
			PizzaBase p1;
			System.out.println("-----------------PIZZE-----------------");
			System.out.println(String.format("%1$-"+ 20+"s","NOME") + String.format("%1$-"+ 60 + "s","INGREDIENTI")+ String.format("%1$-"+ 10 + "s","CALORIE") + String.format("%1$-"+ 10 + "s","PREZZO"));
			Menu.menuPizza();
			Menu.pizze.forEach((p) -> System.out.println(p.toString()));
			System.out.println("Quale pizza vuoi ordinare?");
			String pizzaOrdinata = scanner.nextLine();
			String x = pizzaOrdinata.substring(0,1).toUpperCase()+pizzaOrdinata.substring(1);
			if ( x.equals("Margherita")) {
				p1 = new PizzaBase();
				aggiungiTopping(p1);
			} else if ( x.equals("Salami")) {
				p1 = (PizzaBase)ctx.getBean("pizzaSalami");
				aggiungiTopping(p1);
			} else if ( x.equals("Hawaiian")) {
				p1 = (PizzaBase)ctx.getBean("pizzaHawaiian");
				aggiungiTopping(p1);
			} else {
				System.out.println("Selezione non corretta!!! Ordine INTERROTTO");
			}

		}
		
		public static void ordinaDrink() {
			Menu.menuBevande();
			System.out.println("-----------------BEVANDE---------------");
			System.out.println(String.format("%1$-"+ 20+"s","NOME") + String.format("%1$-"+ 60 + "s"," ")+ String.format("%1$-"+ 10 + "s","CALORIE") + String.format("%1$-"+ 10 + "s","PREZZO"));
			Menu.bevande.forEach((b) -> System.out.println(b.toString()));
			System.out.println("Cosa vuoi bere?");
			String bevandaOrdinata = scanner.nextLine();
			String x = bevandaOrdinata.substring(0,1).toUpperCase()+bevandaOrdinata.substring(1);
			if ( x.equals("Limonata")) {
				Drink d1 = (Drink)ctx.getBean("lemonade");
				listaProdotti.add(d1);
				
			} else if ( x.equals("Acqua")) {
				Drink d2 = (Drink)ctx.getBean("water");
				listaProdotti.add(d2);
			
			} else if ( x.equals("Vino")) {
				Drink d3 = (Drink)ctx.getBean("wine");
				listaProdotti.add(d3);
				
			} else {
				System.out.println("Selezione non corretta!!! Ordine INTERROTTO");
			}
		}
		
		public static void aggiungiTopping(PizzaBase pizza) {
			System.out.println("Vuoi aggiungere un ingrediente alla pizza selezionata?");
			System.out.println("1) SI");
			System.out.println("2) NO");
			int scelta = Integer.parseInt(scanner.nextLine());
			switch (scelta) {
			case 1: Menu.menuTopping();
					System.out.println("-----------------TOPPING---------------");
					System.out.println(String.format("%1$-"+ 20+"s","NOME") + String.format("%1$-"+ 60 + "s"," ")+ String.format("%1$-"+ 10 + "s","CALORIE") + String.format("%1$-"+ 10 + "s","PREZZO"));
					Menu.topping.forEach((t) -> System.out.println(t.toString()));
					System.out.println("Quale ingrediente vuoi aggiungere?");
					String toppingAgg = scanner.nextLine();
					String x = toppingAgg.substring(0,1).toUpperCase()+toppingAgg.substring(1);
					if ( x.equals("Prosciutto")) {
						Topping t1 = (Topping)ctx.getBean("toppingHam");
						t1.addTopping(pizza);
						listaProdotti.add(pizza);
						ordinaDrink();
					} else if ( x.equals("Formaggio")) {
						Topping t2 = (Topping)ctx.getBean("toppingCheese");
						t2.addTopping(pizza);
						listaProdotti.add(pizza);
						ordinaDrink();
					} else if ( x.equals("Cipolla")) {
						Topping t3 = (Topping)ctx.getBean("toppingOnion()");
						t3.addTopping(pizza);
						listaProdotti.add(pizza);
						ordinaDrink();
					} else if ( x.equals("Ananas")) {
						Topping t4 = (Topping)ctx.getBean("toppingPineapple()");
						t4.addTopping(pizza);
						listaProdotti.add(pizza);
						ordinaDrink();
					} else if ( x.equals("Salami")) {
						Topping t5 = (Topping)ctx.getBean("toppingSalami()");
						t5.addTopping(pizza);
						listaProdotti.add(pizza);;
						ordinaDrink();
					} else {
						System.out.println("Selezione non corretta!!! Ordine INTERROTTO");
					}
					break;
			case 2:
					ordinaDrink();
					break;
			default:
				System.out.println("Selezione Errata!");
			}
		}
		
}
