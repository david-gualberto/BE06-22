package com.davidgualberto.gestione_incendi_PW;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.davidgualberto.gestione_incendi_PW.model.CentroControllo;
import com.davidgualberto.gestione_incendi_PW.model.Sonda;

@SpringBootApplication
public class GestioneIncendiPwApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiPwApplication.class, args);
		allarme();
	}
	
	public static void allarme() {
		CentroControllo CC = new CentroControllo();

	    Sonda s1 = new Sonda(1, 45.4, 9.1);
	    Sonda s2 = new Sonda(2, 37.7, 22.4);
	    Sonda s3 = new Sonda(3, 57.7, 82.4);
	    Sonda s4 = new Sonda(4, 87.7, 12.4);

	    s1.aggiungiObserver(CC);
	    s2.aggiungiObserver(CC);
	    s3.aggiungiObserver(CC);

	    s1.setlivelloFumo(8);
	    s2.setlivelloFumo(4);
	    s3.setlivelloFumo(5);
	    s4.setlivelloFumo(0);
	}
}
