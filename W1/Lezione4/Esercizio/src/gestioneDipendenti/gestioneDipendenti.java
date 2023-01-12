package gestioneDipendenti;
import dipendenti.Dipartimento;
import dipendenti.Dipendente;
import dipendenti.Livello;


public class gestioneDipendenti {

	public static void main(String[] args) {
		double salariStraordinari = 0;
		double salari = 0;
		//Istanzio 4 Dipendenti
		Dipendente d1 = new Dipendente(1, Dipartimento.PRODUZIONE);
		Dipendente d2 = new Dipendente(2, Dipartimento.PRODUZIONE);
		Dipendente d3 = new Dipendente(3, 2200.50, 45, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente d4 = new Dipendente(4, 3898.30, 55, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		//Creo array dipendenti
		Dipendente[] arrayDip = {d1, d2, d3, d4};
		
		//Promozione Dipendenti
		System.out.println("-----Promozione Dipendente-----");
		Dipendente.promuovi(d1);
		System.out.println("-----Promozione Dipendente-----");
		Dipendente.promuovi(d3);
		System.out.println();
		
		//Ciclo stampa tutti i dipendenti
		System.out.println("-----Stampa stato dipendenti-----");
		for(Dipendente a : arrayDip) {
			a.stampaDipendente();
		}
		//Ciclo somma stipendi dipendenti
		for(Dipendente a : arrayDip) {
			salari += a.calcoloPaga(a);
			salariStraordinari += a.calcoloPaga(a, 5);
		}
		
		System.out.printf("%nMonte salari senza straordinari = " + salari);
		System.out.printf("%nMonte salari comprensivo di 5 ore di straordinari = " + salariStraordinari);
		
	}	
}