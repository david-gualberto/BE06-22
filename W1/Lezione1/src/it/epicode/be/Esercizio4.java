package it.epicode.be;

import java.util.Scanner;

public class Esercizio4 {

	public static void main(String[] args) {
		System.out.println("Il perimetro del tuo rettangolo è: " + perimetroRettangolo());
		System.out.println("----------------------------------");
		pariDispari();
		System.out.println("----------------------------------");
		System.out.println("L'area del tuo traingolo è: " + areaTriangolo());
	}
	
	static //Apertura Scanner
	Scanner in = new Scanner(System.in);
	
	static double perimetroRettangolo() {
		//Primo Lato
		System.out.println( "Inserisci il lato 1 del tuo rettangolo" );
		double lato1 = in.nextDouble();
		//Secondo lato
		System.out.println( "Inserisci il lato 2 del tuo rettangolo" );
		double lato2 = in.nextDouble();
		//Output
		return (lato1 * 2) + (lato2 * 2);
		}
	
	static void pariDispari() {
		System.out.println( "Inserisci un numero intero" );
		int x = in.nextInt();
		//Condizione pari o dispari in base al resto dell'operazione x/2
			if( x%2 == 0) {
				 x = 1;
				 System.out.println("Il tuo numero è pari");
				} else {
				 x = 0;
				 System.out.println("Il tuo numero è dispari");
				}
			 System.out.println(x);
		}
	
	static double areaTriangolo() {
		//Primo lato
		System.out.println( "Inserisci il lato 1 del triangolo" );
		double lato1 = in.nextDouble();
		//Secondo lato
		System.out.println( "Inserisci il lato 2 del triangolo" );
		double lato2 = in.nextDouble();
		//Terzo lato
		System.out.println( "Inserisci il lato 3 del triangolo" );
		double lato3 = in.nextDouble();
		in.close();
		// chiusura scanner
		double sP = (lato1 + lato2 + lato3)/2;
		return Math.sqrt(sP*((sP-lato1)*(sP-lato2)*(sP-lato3)));
		}
		
	}
