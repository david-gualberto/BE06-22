package lezione3.esercizio3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String stringa = "";
		Scanner in = new Scanner(System.in);
		String stopCiclo = ":q";

		while (!(stringa.equals(stopCiclo))) {

			System.out.println("Inserisci una parola: ");
			stringa = in.nextLine();
			if (!(stringa.equals(stopCiclo))) {
				String[] arrayStringa = stringa.split("");
				System.out.println(Arrays.toString(arrayStringa));
			}

		}
		in.close();
	}

}
