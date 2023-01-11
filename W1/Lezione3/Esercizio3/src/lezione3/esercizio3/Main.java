package lezione3.esercizio3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//instanzio variabili
		String stringa = "";
		Scanner in = new Scanner(System.in);
		String stopCiclo = ":q";

		//Ciclo while
		while (!(stringa.equals(stopCiclo))) {

			System.out.println("Inserisci una parola: ");
			stringa = in.nextLine();
			//condizione di controllo se non si vuole nemmeno entrare nel cilo
			//if (!(stringa.equals(stopCiclo))) {
			String[] arrayStringa = stringa.split("");
			System.out.println(Arrays.toString(arrayStringa));
			//}
			}
		in.close();
		System.out.println("Programma interrotto");
	}

}
