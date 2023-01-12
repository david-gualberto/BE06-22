package dipendenti;

    public class Dipendente {
		public static double stipendioBase = 1000;
		private int matricola;
		private double stipendio;
		private double importoOrarioStraordinario;
		private Livello livello;
		private Dipartimento dipartimento;
	
		//Primo costruttore
	public Dipendente(int matricola, Dipartimento dipartimento) {
				this.matricola = matricola;
				this.stipendio = stipendioBase;
				this.importoOrarioStraordinario = 30;
				this.livello = Livello.OPERAIO;
				this.dipartimento = dipartimento;
			};
		//Secondo costruttore
	public Dipendente(int matricola, double stipendio, double importoOrarioStraordinario,
						Livello livello, Dipartimento dipartimento) {
				this.matricola = matricola;
				this.stipendio = stipendio;
				this.importoOrarioStraordinario = importoOrarioStraordinario;
				this.livello = livello;
				this.dipartimento = dipartimento;
			}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public double getStipendioBase() {
		return stipendioBase;
	}

	public int getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public Livello getLivello() {
		return livello;
	}
	
	public void stampaDipendente() {
		System.out.printf("%nMatricola: %d%nStipendio: %.2f%nLivello: %s%nDipartimento: %s%n", getMatricola(), getStipendio(), getLivello(), getDipartimento());
		System.out.printf("-------------------------");
	}
	
	public static void promuovi(Dipendente d) {
		switch (d.livello) {
		
		case OPERAIO:
			d.stipendio = d.stipendio*1.2;
			d.livello= Livello.IMPIEGATO;
			System.out.println("Stipendio aggiornato: "+ d.stipendio );
			System.out.println("Nuovo ruolo: "+ d.livello );
			break;
		case IMPIEGATO:
			d.stipendio = d.stipendio*1.5;
			d.livello= Livello.QUADRO;
			System.out.println("Stipendio aggiornato: "+ d.stipendio );
			System.out.println("Nuovo ruolo: "+ d.livello );
			break;
		case QUADRO:
			d.stipendio = d.stipendio*2;
			d.livello= Livello.DIRIGENTE;
			System.out.println("Stipendio aggiornato: "+ d.stipendio );
			System.out.println("Nuovo ruolo: "+ d.livello );
			break;
		default:
			System.out.println("Sei già un Dirigente");
			d.livello = Livello.DIRIGENTE;
		}	
	}
	
	public static double calcoloPaga(Dipendente d) {
		return d.stipendio;
	}
	
	public static double calcoloPaga(Dipendente d, int ore) {
		return d.stipendio = (ore * d.importoOrarioStraordinario) + d.stipendio;
	}
}
