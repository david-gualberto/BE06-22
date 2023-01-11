package lezione3.esercizio2;

import java.util.Scanner;

public class Main {
	static int number;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserire un numero:");
		number = in.nextInt();
		in.close();
		numberToString(number);
	}

	//switch
	static void numberToString(int number) {
		switch(number) {
			case 0:
			System.out.println("zero");
			break;
			case 1:
			System.out.println("uno");
			break;
			case 2:
			System.out.println("due");
			break;
			case 3:
			System.out.println("tre");
			break;
			default:
			System.out.println("errore");
			break;		
			}
	}
	
}
