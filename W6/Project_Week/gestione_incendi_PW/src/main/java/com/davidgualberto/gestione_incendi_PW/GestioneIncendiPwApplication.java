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
		CentroControllo CC = CentroControllo.getInstance();

	    Sonda s1 = new Sonda(1, 45.4, 9.1);
	    Sonda s2 = new Sonda(2, 37.7, 22.4);
	    Sonda s3 = new Sonda(3, 57.7, 82.4);
	    Sonda s4 = new Sonda(4, 87.7, 12.4);
	    Sonda s5 = new Sonda(5, 17.7, 42.4);

	    s1.aggiungiObserver(CC);
	    s2.aggiungiObserver(CC);
	    s3.aggiungiObserver(CC);
	    s4.aggiungiObserver(CC);
	    s5.aggiungiObserver(CC);
	    System.out.println("---------------------");
	    s1.setlivelloFumo(8);
	    System.out.println("---------------------");
	    s2.setlivelloFumo(4);
	    System.out.println("---------------------");
	    s3.setlivelloFumo(5);
	    System.out.println("---------------------");
	    s4.setlivelloFumo(0);
	    System.out.println("---------------------");
	    s5.setlivelloFumo(6);
	}
}
