import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean startStop = true;
		File fileInfo= new File("presenze.txt");
			
				System.out.println("---Registro Presenze---");
				System.out.println("-----------------------");
				while ( startStop == true) {
					
							System.out.println("---Inserire i dati dell'utente da aggiungere oppure digitare 'esci' per interrompere");
							System.out.println("---Nome e Cognome---");
							String nome = scanner.nextLine();
							if (nome.equals("esci")) {
								System.out.println("---------------------------------");
								System.out.println("Sei uscito dal programma");
								System.out.println("---------------------------------");
								scanner.close();
								startStop = false;
							} else if (nome.length()< 3 ) {
								System.out.println("---------------------------------");
								System.out.println("Inserire un nome valido");
								System.out.println("---------------------------------");
							}
							else  {	
								try {	
									System.out.println("---Inserire numero di presenze---");
									int presenze = Integer.parseInt(scanner.nextLine());
									RegistroPresenze nuovoUtente = new RegistroPresenze(nome, presenze);
									nuovoUtente.aggiungiPresenze(fileInfo); }
								catch (NumberFormatException e ) {
									System.out.println("Errore!!! Inserire un numero!!!");
											}
								}	
					}

				//Lettura utenti sul registro
				try {
					System.out.println("---Elenco utenti presenti nel registo---");
					RegistroPresenze.getUsers(fileInfo);
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

}
