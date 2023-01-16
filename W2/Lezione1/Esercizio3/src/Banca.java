
public class Banca {
	
	public static void main(String args[]) {
		ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

		System.out.println("Saldo conto: " + conto1.restituisciSaldo());

		try {
			conto1.preleva(25000);

			System.out.println("Saldo conto: " + conto1.restituisciSaldo());
		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e.getMessage());
			e.printStackTrace();
		}

		ContoOnline conto2 = new ContoOnline("Rossi Luigi", 50350.0, 1500);

		conto2.stampaSaldo();

		try {
			conto2.preleva(1600);

			conto2.stampaSaldo();

		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e.getMessage());	
			e.printStackTrace();
		}
	}
}
