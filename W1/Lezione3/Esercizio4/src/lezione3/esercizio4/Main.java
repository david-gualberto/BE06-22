package lezione3.esercizio4;

import java.util.Scanner;

public class Main {
	static int anno;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println( "Inserire un numero:" );
		anno = in.nextInt();
		
		for (int i = anno; i>=0; i--) {
			System.out.println(i);
		}
	}

}
