package com.davidgualberto.es1SpringBoot;

import java.time.LocalTime;
import java.util.List;

public class Ordine {
		int numOrdine;
		statoOrdineEnum statoOrdine;
		List<Prodotti> listaOrdine;
		int NumCoperti;
		CostoCoperti costoCoperti;
		LocalTime orario;
		int ContoTotale;
		
		public Ordine(int numOrdine, statoOrdineEnum statoOrdine, List<Prodotti> listaOrdine, int numCoperti,
				LocalTime orario) {
			this.numOrdine = numOrdine;
			this.statoOrdine = statoOrdine;
			this.listaOrdine = listaOrdine;
			this.NumCoperti = numCoperti;
			this.orario = orario;
		}
		
		public String toString() {
			return "Numero Ordine: " + this.numOrdine +
					"Lista Prodotti: " + this.listaOrdine +
					"Orario Ordine: " + this.orario;
		}
		
		public double setContoTotale() {
			double tot = 0;;
			for (int i = 0; i<listaOrdine.size(); i++) {
				tot += listaOrdine.get(i).prezzo;
			}
			return tot + (costoCoperti.costo * this.NumCoperti);
		}
}
