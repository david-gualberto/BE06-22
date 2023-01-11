package lezione3.esercizio4;

import java.util.Scanner;

public class Main {
	static int numero;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println( "Inserire un numero:" );
		numero = in.nextInt();
		
		for (int i = numero; i>=0; i--) {
			System.out.println(i);
		}
		in.close();
	}

}
