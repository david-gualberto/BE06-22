import java.util.ArrayList;
import java.util.List;


public class arrayNumbers extends Thread  {
		int start;
		int stop;
		int tot;
		
		arrayNumbers(int start, int stop) {
			this.start = start;
			this.stop = stop;
		}
		
	static List<Integer> numbers = new ArrayList<>();
	
	public static void genArray() {
		
		for (int i = 0; i <= 3000; i++) {
			int numRandom = (int) (Math.random() * 100);
			numbers.add(i, numRandom);
			}
		
			int arrayTot = numbers.stream().mapToInt(Integer::intValue).sum();
			System.out.println("Numeri generati: " + numbers);
			System.out.println("Somma totale dell'array: " + arrayTot);
	}
	
	public int shortArray() {
		int sum = 0;
		for (int i = start; i<=stop;i++ ) {
			sum += numbers.get(i);
		}
		return this.tot = sum;
	}
	
	public void run() {
		this.shortArray();
	}
	
}
