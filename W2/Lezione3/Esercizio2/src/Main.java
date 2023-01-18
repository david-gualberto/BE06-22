
public class Main {

	public static void main(String[] args) {
		
			arrayNumbers.genArray();
			
			arrayNumbers c1 = new arrayNumbers(0,1000);
			arrayNumbers c2 = new arrayNumbers(1001,2000);
			arrayNumbers c3 = new arrayNumbers(2001,3000);
				
			c1.start();
			c2.start();
			c3.start();
			
			try {
				c1.join();
				c2.join();
				c3.join();
			} catch (InterruptedException e) {
				System.out.println("ERRORE! Processo Interrotto!");
			}
			
			
			int arraySum = c1.tot + c2.tot + c3.tot;
			System.out.printf("La somma del totale dell' array con i numeri da %d a %d è: %d%n", c1.start, c1.stop, c1.tot);
			System.out.printf("La somma del totale dell' array con i numeri da %d a %d è: %d%n", c2.start, c2.stop, c2.tot);
			System.out.printf("La somma del totale dell' array con i numeri da %d a %d è: %d%n", c3.start, c3.stop, c3.tot);
			System.out.println("La somma totale dei 3 array è: " + arraySum);
	}

}
