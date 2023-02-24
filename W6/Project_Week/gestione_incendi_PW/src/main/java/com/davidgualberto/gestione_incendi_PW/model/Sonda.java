package com.davidgualberto.gestione_incendi_PW.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sonda implements SondaSubject {
	
			int id;
			double latitudine;
			double longitudine;
			int livelloFumo;
			private List<Observer> observers;
			
			public Sonda(int id, double latitudine, double longitudine) {
				this.id = id;
				this.latitudine = latitudine;
				this.longitudine = longitudine;
				this.livelloFumo = 0;
				this.observers = new ArrayList<>();
			}
			
			
			public void setlivelloFumo(int livelloFumo) {
			    this.livelloFumo = livelloFumo;
			    notificaObservers();
			  }


			@Override
			public void aggiungiObserver(Observer o) {
				observers.add(o);
			}


			@Override
			public void rimuoviObserver(Observer o) {
				observers.remove(o);	
			}


			@Override
			public void notificaObservers() {
				 for (Observer o : observers) {
				      o.update(this);
				    }
				
			}
}
