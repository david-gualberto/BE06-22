import java.util.Arrays;
import java.util.Scanner;

public class Array {
	
	static int[] arrayNum = new int[5];

		//Creazione Array Randomico
		public static void genArray() {
			
			for (int i = 0; i < arrayNum.length; i++) {
				int x = (int) (Math.random() * 10);
				arrayNum[i] = x;		
			}
			System.out.println("-----Array di Partenza:-----");
			System.out.println(Arrays.toString(arrayNum));
			System.out.println("---------------------------");
		};
		
		//Sostituzione numero da parte dell'Utente
		public static void addNumber(){	
			
			int newNum;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("-----Scrivi un Numero da 1 a 10 oppure digita 0 per interrompere il programma-----");
			newNum = Integer.parseInt(scanner.nextLine());
				if ( (newNum < 1 && !(newNum == 0)) || newNum >10) {
					throw new NumberError("Numero errato");
					}
				if (!(newNum == 0)) {
				System.out.println("-----Scrive la posizione in cui vuoi posizionarlo (da 1 a 5)-----");
				int numIndex = scanner.nextInt() - 1;
				arrayNum[numIndex] = newNum;
				System.out.println("-----Array Aggiornato:-----");
				System.out.println(Arrays.toString(arrayNum));
				}
		} while (!(newNum == 0));
		
	}
		
}
