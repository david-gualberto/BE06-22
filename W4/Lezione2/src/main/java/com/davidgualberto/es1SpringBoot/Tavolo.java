package com.davidgualberto.es1SpringBoot;

public class Tavolo {
	
		int NumTav;
		int MaxCoperti;
		statoTavoloEnum statoTavolo;
		Ordine ordine;
		
		public Tavolo(int numTav, int maxCoperti, statoTavoloEnum statoTavolo, Ordine ordine) {
			this.NumTav = numTav;
			this.MaxCoperti = maxCoperti;
			this.statoTavolo = statoTavolo;
			this.ordine = ordine;
		}
		
		
}
