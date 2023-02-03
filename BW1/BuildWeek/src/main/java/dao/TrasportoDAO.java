package dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import entities.Corsa;
import entities.Mezzo;
import entities.PeriodicitaMezzo;
import entities.PeriodoManutenzione;
import entities.PeriodoServizio;
import entities.Tratta;
import utils.JpaUtils;

public class TrasportoDAO {

	private static final Logger logger = LoggerFactory.getLogger(TrasportoDAO.class);

	//METODI SAVE - UPDATE - DELETE
	public void save(Mezzo object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(object);
			t.commit();
			save(new PeriodoServizio(LocalDate.now(), LocalDate.now().plusDays(30), object));
			logger.info("Il mezzo è stato inserito nel database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("Il mezzo non è stato inserito! c'è stato un errore!" + e.getMessage());
		} finally {
			em.close();
		}
	}

	public void save(Mezzo object, LocalDate inizio, LocalDate fine) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(object);
			t.commit();
			save(new PeriodoServizio(inizio, fine, object));
			logger.info("Il mezzo è stato inserito nel database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("Il mezzo non è stato inserito! c'è stato un errore!" + e.getMessage());
		} finally {
			em.close();
		}
	}

	public void save(Tratta object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(object);
			t.commit();
			logger.info("La tratta è stata inserita nel database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("la tratta non è stata inserita! c'è stato un errore!" + e.getMessage());
		} finally {
			em.close();
		}
	}

	public void save(PeriodicitaMezzo object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(object);
			t.commit();
			logger.info("Il turno del mezzo è stato inserito in database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("Il turno del mezzo non è stato inserito! c'è stato un errore!" + e.getMessage());
		} finally {
			em.close();
		}
	}

	public void save(Corsa object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(object);
			t.commit();
			logger.info("La corsa è stata inserita nel database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("La corsa non è stata inserita! c'è stato un errore!" + e.getMessage());
		} finally {
			em.close();
		}
	}

	public void save(Mezzo mezzo, Tratta tratta, int tempo) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(new Corsa(mezzo, tratta, tempo));
			t.commit();
			logger.info("La corsa è stata inserita nel database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("La corsa non è stata inserita! c'è stato un errore!" + e.getMessage());
		} finally {
			em.close();
		}
	}

	public void update(PeriodicitaMezzo object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.merge(object);
			t.commit();
			logger.info("I turni sono stati aggiornati.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("I turni del Mezzo non sono stati aggiornati! C'è stato un errore!");
		} finally {
			em.close();
		}
	}
	
	public void update(Mezzo object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.merge(object);
			t.commit();
			logger.info("La tratta è stata aggiornata.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("La Tratta non è stata cambiata! C'è stato un errore!");
		} finally {
			em.close();
		}
	}

	public void delete(Mezzo object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(em.contains(object) ? object : em.merge(object));
			t.commit();
			logger.info("Il mezzo è stato rimosso dal database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("Il mezzo non è stato rimosso ! c'è stato un errore!");
		} finally {
			em.close();
		}
	}

	public void delete(PeriodicitaMezzo object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(em.contains(object) ? object : em.merge(object));
			t.commit();
			logger.info("La periodicita mezzo è stata rimossa dal database!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("La periodicita mezzo non è stata rimossa ! c'è stato un errore!");
		} finally {
			em.close();
		}
	}

	//METODI GET
	public Mezzo getMezzoById(int id) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Mezzo.class, id);
		} finally {
			em.close();
		}
	}

	public Tratta getTrattaById(int id) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Tratta.class, id);
		} finally {
			em.close();
		}
	}

	public Corsa getCorsaById(int id) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Corsa.class, id);
		} finally {
			em.close();
		}
	}

	//LISTE
	public List<PeriodicitaMezzo> listaPeriodicita(int id) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT pm FROM PeriodicitaMezzo pm WHERE mezzo_id = :n");
		q.setParameter("n", id);
		List<PeriodicitaMezzo> listaPeriodicita = q.getResultList();
		return listaPeriodicita;
	}	

	public List<PeriodicitaMezzo> listaPeriodicita(Mezzo mezzo) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT pm FROM PeriodicitaMezzo pm WHERE mezzo_id = :n");
		q.setParameter("n", mezzo.getId());
		List<PeriodicitaMezzo> listaPeriodicita = q.getResultList();
		return listaPeriodicita;
	}

	public List<Corsa> corsePerMezzo(Mezzo mezzo, Tratta tratta) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT c FROM Corsa c WHERE mezzo = :m AND tratta = :t");
		q.setParameter("m", mezzo);
		q.setParameter("t", tratta);
		List<Corsa> corse = q.getResultList();
		return corse;
	}
	
	public List<Corsa> corse() {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT c FROM Corsa c");
		List<Corsa> corse = q.getResultList();
		return corse;
	}

	public List<Tratta> listaTratte(){
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT t FROM Tratta t");
		List<Tratta> tratte = q.getResultList();
		return tratte;
	}
	
	public List<Mezzo> listaMezzi(){
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT m FROM Mezzo m");
		List<Mezzo> mezzi = q.getResultList();
		return mezzi;
	}
	
	//PRINT LISTE
	public void printListMezzo(List<PeriodicitaMezzo> list) {
		for (PeriodicitaMezzo p : list)
			logger.info(p.toString());
	}

	public void printListCorsa(List<Corsa> list) {
		for (Corsa c : list)
			logger.info(c.toString());
	}

	public void corseEffettuate(List<Corsa> corse) {
		int i = 0;
		for (Corsa corsa : corse) {
			i += corsa.getTempoEffettivo();
		}
		int media = i / corse.size();
		logger.info("Il mezzo ha effettuato " + corse.size() + " corse per la tratta selezionata."
				+ "\nIl tempo medio effettivo di percorrenza è di " + media + " minuti.");
	}
	
	public void printListTratta(List<Tratta> tratta) {
		for (Tratta c : tratta)
			logger.info(c.toString());
	}
	
	public void printListMezzi(List<Mezzo> mezzo) {
		for (Mezzo c : mezzo)
			logger.info(c.toString());
	}
	
	public Corsa printUltimaCorsa(List<Corsa> list) {
		return list.get(0);
	}

	//MANUTENZIONE
	public PeriodoManutenzione manutenzione(LocalDate inizio, LocalDate fine, int id) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT pm FROM PeriodicitaMezzo pm WHERE mezzo_id = :n AND dataFine > :i");
		q.setParameter("n", id);
		q.setParameter("i", inizio);
		List<PeriodicitaMezzo> periodiMezzo = q.getResultList();
		for (PeriodicitaMezzo pm : periodiMezzo) {
			//logger.info(pm.toString());
			if (inizio.isBefore(pm.getDataInizio()) | inizio == pm.getDataInizio()) {
				delete(pm);
			} else {
				pm.setDataFine(inizio);
				update(pm);
			}
		}
		try {
			EntityTransaction t = em.getTransaction();
			PeriodoManutenzione pm = new PeriodoManutenzione(inizio, fine, getMezzoById(id));
			t.begin();
			em.persist(pm);
			t.commit();
			logger.info("Il periodo di manutenzione è stato inserito nel database!");
			return pm;
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("Il periodo di manutenzione non è stato inserito, c'è stato un errore!" + e.getMessage());
			return null;
		} finally {
			em.close();
		}
	}

	
}
