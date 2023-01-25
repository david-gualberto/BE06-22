package dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import evento.Location;
import evento.Persona;
import utils.JpaUtil;

public class PersonaDAO {
	private static final EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	public static void savePersona(String nome, String cognome, String email, String sesso, LocalDate compleanno) {
		
		try {
			Persona p = new Persona();
			p.setNome(nome);
			p.setCognome(cognome);
			p.setEmail(email);
			p.setSesso(sesso);
			p.setCompleanno(compleanno);

			t.begin();
			em.persist(p);
			t.commit();
			System.out.println("Persona inserita correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento della persona");
			System.out.println(e.getMessage());
		}
	}
	
	public static Persona getPersonaById(int id) {
		Persona p = em.find(Persona.class, id);
		
		if( p == null ) {
			System.out.println( "Persona non trovata!" );
			
		}
		
		System.out.println( "Dati Persona: ");
		System.out.printf(  
			"Nome: %s | Cognome: %s%n",
			p.getNome(), p.getCognome() 
		);
		return p;
	}
}
