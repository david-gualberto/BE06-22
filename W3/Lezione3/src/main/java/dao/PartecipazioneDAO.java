package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import evento.Evento;
import evento.Location;
import evento.Partecipazione;
import evento.Persona;
import evento.stato;
import utils.JpaUtil;

public class PartecipazioneDAO {
	private static final EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t = em.getTransaction();

		public static void savePartecipazione(Persona persona, Evento evento) {
		
		try {
			Partecipazione part = new Partecipazione();
			part.setPersona(persona);
			part.setEvento(evento);
			part.setStato(stato.Confermato);
	

			t.begin();
			em.persist(part);
			t.commit();
			System.out.println("Partecipazione inserita correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento della Partecipazione");
			System.out.println(e.getMessage());
		}
}
}
