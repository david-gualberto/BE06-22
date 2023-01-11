package lezione3.esercizio1;

import java.util.Scanner;

public class Main {

	static String word = "";
	static int anno = 0;

	public static void main(String[] args) {
		//inserimento input
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci una parola: ");
		word = in.nextLine();
		System.out.println( "Inserire un anno:" );
		anno = in.nextInt();
		in.close();
		//Output
		System.out.println("------------------------");
		System.out.println(stringaPariDispari(word));
		System.out.println("------------------------");
		System.out.println(annoBisestile(anno));
		}

	static boolean stringaPariDispari(String word) {
		if (word.length() % 2 == 0) {
			System.out.println("Il numero di caratteri è pari");
			return true;
			} else {
			System.out.println("Il numero di caratteri è dispari");
			return false;
			}

		}
	
	static boolean annoBisestile(int anno) {
		if (anno%400== 0 || (anno%4==0 && !(anno%100==0))) {
			System.out.println("Hai inserito un anno bisestile");
			return true;
			} else {
			System.out.println("L'anno inserito non è bisestile");
			return false;
			}
		}

}
