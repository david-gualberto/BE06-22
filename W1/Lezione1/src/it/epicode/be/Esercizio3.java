package it.epicode.be;
import java.util.Scanner;

public class Esercizio3 {

	public static void main(String[] args) {
				
				// apertura scanner
				Scanner in = new Scanner(System.in);
				//Nome
				System.out.println( "Inserisci nome:" );
				String nome = in.nextLine();
				//Cognome
				System.out.println( "Inserisci il cognome:" );
				String cognome = in.nextLine();
				//Città
				System.out.println( "Città di nascita" );
				String citta = in.nextLine();;
				//Array dei dati
				String[] datiInseriti = new String[3];
				datiInseriti[0] = nome;
				datiInseriti[1] = cognome;
				datiInseriti[2] = citta;
				//Output
				System.out.println( "Ordine di inserimento = " + nome + " " + cognome + " " + citta );
				System.out.println( "Ordine Inverso = " + datiInseriti[2] + " " + datiInseriti[1] + " " + datiInseriti[0] );

				// chiusura scanner
				in.close();

	}

	

	
}
