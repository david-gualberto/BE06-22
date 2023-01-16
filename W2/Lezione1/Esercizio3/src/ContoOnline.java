

public class ContoOnline extends ContoCorrente {
	double maxPrelievo;

	ContoOnline(String titolare, double saldo, double maxP) {
		super(titolare, saldo);
		this.maxPrelievo = maxP;
	}

	void stampaSaldo() {

		System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
				+ " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	}

	void preleva(double x) {
		if (x <= maxPrelievo) {
			super.preleva(x);
		}
		else if (x < 0) {
			throw new BancaException("Inserire un importo valido da prelevare");
		} 
		else if (x > saldo) {
			throw new BancaException("Fondi insufficienti");
		} else if (x> maxPrelievo) {
			throw new BancaException("Puoi prelevare massimo 1500 €");
		}
	}
}

