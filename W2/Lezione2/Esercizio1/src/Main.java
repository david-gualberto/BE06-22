import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		HashSet<String> words = new HashSet<String>();
		HashSet<String> duplicateWords = new HashSet<String>();
		
		try {	System.out.println("---Inserire il numero di parole che si vuole aggiungere---");
				int numString = Integer.parseInt(scanner.nextLine());
			
				for(int x = 0; x < numString; x++) {
				System.out.println("Aggiungi una parola");
					String newWord = scanner.nextLine();
				
						if(words.contains(newWord)) {
							duplicateWords.add(newWord);
						} else {
							words.add(newWord);
						}
					}
				System.out.println("--------------------------");
				System.out.printf("Il numero di parole inserite è: %d%n", words.size());
				System.out.println("--------------------------");
				System.out.println("Le parole da te inserite sono:");
				for(String word : words) {
					System.out.println( word );
					}
				System.out.println("--------------------------");
				System.out.println("Parole Duplicate: " + duplicateWords);
				
		} catch(NumberFormatException e) {
			System.out.println("--------------------------");
			System.out.println("ERRORE! Inserire un numero");
			System.out.println("--------------------------");
		} 
		System.out.println("--------------------------");
		System.out.println("Applicazione Terminata");
		System.out.println("--------------------------");
		scanner.close();
	}
}
