package dao;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import entities.Tessera;
import entities.Utente;
import utils.JpaUtils;

public class UtenteDAO {

	private static final Logger logger = LoggerFactory.getLogger(UtenteDAO.class);
	
	//METODI SAVE
	public void save(Utente object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try{
			EntityTransaction t = em.getTransaction();
			
			t.begin();
			em.persist(object);
			t.commit();
		}catch (Exception e){
			em.getTransaction().rollback();
			logger.error("L'utente non è stato inserito! c'è stato un errore!" + e.getMessage());
		}finally {
			em.close();
		}
	}
	
	public void save(Tessera object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try{
			EntityTransaction t = em.getTransaction();
			
			t.begin();
			em.persist(object);
			t.commit();
		}catch (Exception e){
			em.getTransaction().rollback();
			logger.error("La tessera non è stata inserita! c'è stato un errore!" + e.getMessage());
		}finally {
			em.close();
		}
	}
	  
	//CREAZIONE UTENTE
	public void creaUtenteConTessera(String nome, String cognome) {
	    	EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
	        try {
	        Tessera tessera = new Tessera(LocalDate.now());
	        save(tessera);
	        Utente utente = new Utente(nome, cognome, tessera);
	        save(utente);
	        logger.info("Utente " + utente.getNome() + " " + utente.getCognome() + " tesserato con successo \nNumero tessera: " + tessera.getCodice());
	        }catch (Exception e) {
				em.getTransaction().rollback();
				logger.error("L'utente non è stato inserito! c'è stato un errore!" + e.getMessage());
	        }
	    }
}
