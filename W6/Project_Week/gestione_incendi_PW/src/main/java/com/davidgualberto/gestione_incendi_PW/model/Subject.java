package com.davidgualberto.gestione_incendi_PW.model;

interface Subject {
	  void aggiungiObserver(Observer o);
	  void rimuoviObserver(Observer o);
	  void notificaObservers();
	}