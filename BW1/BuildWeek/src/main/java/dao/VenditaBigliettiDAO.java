package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Mezzo;
import entities.VenditaBiglietti;
import entities.enums.StatoBiglietteria;
import entities.enums.TipologiaRivenditore;
import utils.JpaUtils;

public class VenditaBigliettiDAO {

	private static final Logger logger = LoggerFactory.getLogger(VenditaBigliettiDAO.class);

	//METODI SAVE - UPDATE
	public void save(VenditaBiglietti object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(object);
			t.commit();
			if (object.getRivenditore() == TipologiaRivenditore.DISTRIBUTORE_AUTOMATICO) logger.info("Distributore Automatico inserito nel database!");
			else logger.info("Rivenditore Autorizzato inserito nel database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("C'è stato un errore! L'operazione non è andata a buon fine" + e.getMessage());
		} finally {
			em.close();
		}
	}

	public void update(VenditaBiglietti object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.merge(object);
			t.commit();
			logger.info("Distributore aggiornato nel database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("Distributore non aggiornato! c'è stato un errore!" + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	//METODI GET
	public VenditaBiglietti getVenditoreById(int id) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(VenditaBiglietti.class, id);
		} finally {
			em.close();
		}
	}

	//LISTE E STAMPA LISTE
	public List<VenditaBiglietti> listaRivenditori(){
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT p FROM VenditaBiglietti p");
		List<VenditaBiglietti> vb = q.getResultList();
		return vb;
	}
	
	public void printListaRivenditori(List<VenditaBiglietti> vb) {
		for (VenditaBiglietti c : vb)
			logger.info("Id: " + String.format("%1$-"+ 4 + "s",c.getId()) + "Tipologia: " 
		              + (c.getRivenditore() == TipologiaRivenditore.DISTRIBUTORE_AUTOMATICO?"Distributore Automatico":"Rivenditore Autorizzato") 
		              + "  Stato: " + String.format("%1$-"+ 15 + "s",c.getStato() == StatoBiglietteria.ATTIVO?"Attivo":"Fuori Servizio"));
		
	}

	public void fuoriServizio(VenditaBiglietti vb) {
		vb.setStato(StatoBiglietteria.FUORI_SERVIZIO);
		update(vb);

	}

}
