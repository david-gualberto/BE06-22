
public class ContoCorrente {
	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	void preleva(double x) {
		if (x > saldo) {
			throw new BancaException("Saldo insufficiente");
		}
		else if (x<0){
			throw new BancaException("Inserire un importo superiore a 0");
		}
		else if  (nMovimenti < maxMovimenti) {
			saldo = saldo - x;}
		else {
			saldo = saldo - x - 0.50;
		nMovimenti++;}
	}

	double restituisciSaldo() {
		return saldo;
	}
}