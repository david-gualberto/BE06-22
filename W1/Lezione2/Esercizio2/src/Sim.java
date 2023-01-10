import java.util.Arrays;

public class Sim {
		String number;
		double credit;
		Chiamata[] call;
		
		public Sim(String number) {
			this.number = number;
			this.credit = 0;
			this.call = new Chiamata[5];
		}
		
		void stampSim() {
			System.out.println("Numero: " + this.number);
			System.out.println("Credito: " + this.credit);
			System.out.println("Lista chiamate: " + Arrays.toString(this.call));
		}
}
