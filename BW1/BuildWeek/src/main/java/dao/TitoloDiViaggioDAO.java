package dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Abbonamento;
import entities.Biglietto;
import entities.Mezzo;
import entities.PeriodicitaMezzo;
import entities.Tessera;
import entities.TitoloDiViaggio;
import entities.enums.TipologiaAbbonamento;
import utils.JpaUtils;

public class TitoloDiViaggioDAO {

	private static final Logger logger = LoggerFactory.getLogger(TitoloDiViaggioDAO.class);
	private VenditaBigliettiDAO vb = new VenditaBigliettiDAO();
	private TrasportoDAO td = new TrasportoDAO();
	
	//METODI SAVE - UPDATE
	public void save(Abbonamento nuovoAbbonamento) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(nuovoAbbonamento);
		t.commit();
	}
	
	public void save(TitoloDiViaggio biglietto) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(biglietto);
		t.commit();
		logger.info("Il Biglietto è stato emesso.");
	}

	public Abbonamento creaNuovoAbbonamento(int numTess, int riv, TipologiaAbbonamento tipo) {

		Tessera x = recuperaTesseraDaDB(numTess);
		if (x == null) {
			logger.info("Tessera non trovata");
			return null;
		} else if (x.getDataScadenza().isBefore(LocalDate.now())) {
			logger.info("Tessera Scaduta");	
			return null;
		} else {
			Abbonamento nuovoAbbonamento;
			if (abbonamentoByTess(numTess) != null) {
				Abbonamento abb = abbonamentoByTess(numTess);
				if (abb.getDataScadenza().isBefore(LocalDate.now())) {
					nuovoAbbonamento = new Abbonamento(LocalDate.now(), vb.getVenditoreById(riv), tipo, x);
					logger.info("Abbonamento creato!");

				} else {
					nuovoAbbonamento = new Abbonamento(abb.getDataScadenza().plusDays(1), vb.getVenditoreById(riv), tipo,
							x);
					nuovoAbbonamento.setDataEmissione(LocalDate.now());
					logger.info("Abbonamento aggiornato!");
				}
			} else {

				nuovoAbbonamento = new Abbonamento(LocalDate.now(), vb.getVenditoreById(riv), tipo, x);
				logger.info("Nuovo abbonamento creato!");

			}
			save(nuovoAbbonamento);
			return nuovoAbbonamento;
		}		
	}

	public void update(Tessera object) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.merge(object);
			t.commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.error("La Tessera non è stata aggiornata! C'è stato un errore!");
		} finally {
			em.close();
		}
	}

	//METODI GET
	public static Tessera recuperaTesseraDaDB(int codice) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Tessera tess = em.find(Tessera.class, codice);
		return tess;
	}

	public Abbonamento abbonamentoByTess(int numTess) {
		try {
			EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
			Query q = em.createNamedQuery("CheckAbbonamento");
			q.setParameter("t", getTesseraByID(numTess));
			List<Abbonamento> result = q.getResultList();
			return result.get(result.size() - 1);
		} catch (Exception e) {
			logger.info("L' utente non ha un abbonamento attivo.");
		}
		return null;
	}

	public Tessera getTesseraByID(int id) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Tessera.class, id);
		} finally {
			em.close();
		}
	}

	public Biglietto getBigliettoByID(int id) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Biglietto.class, id);
		} finally {
			em.close();
		}
	}

	//LISTE
	public List<Biglietto> listaVidimazione(Mezzo mezzo) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT b FROM Biglietto b WHERE b.corsa.mezzo = :n");
		q.setParameter("n", mezzo);
		if (mezzo == null) logger.info("Il mezzo indicato è inesistente");
		List<Biglietto> listaVidimazione = q.getResultList();
		logger.info("Il numero di biglietti vidimati sul Mezzo n°" + mezzo.getId() + " è " + listaVidimazione.size());
		return listaVidimazione;
	}
	
	public List<Biglietto> listaVidimazionePerData(LocalDate date1, LocalDate date2) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT b FROM Biglietto b WHERE b.dataVidimazione >= :n AND b.dataVidimazione <= :c");
		q.setParameter("n", date1);
		q.setParameter("c", date2);
		List<Biglietto> listaVidimazione = q.getResultList();
		logger.info("Il numero di biglietti vidimati dal giorno " + date1.toString() + " al giorno " + date2.toString()
				+ " è " + listaVidimazione.size());
		return listaVidimazione;
	}
	
	public List<Biglietto> listaBigliettiEmessi(LocalDate date1, LocalDate date2, int venditore) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT b FROM Biglietto b WHERE b.dataEmissione >= :n AND b.dataEmissione <= :c AND emissione.id = :a");
		q.setParameter("n", date1);
		q.setParameter("c", date2);
		q.setParameter("a", venditore);
		List<Biglietto> listaEmissione = q.getResultList();
		logger.info("Il numero di biglietti emessi dal giorno " + date1.toString() + " al giorno " + date2.toString()
				+ " è " + listaEmissione.size());
		return listaEmissione;
	}
	
	public List<Abbonamento> listaAbbonamentiEmessi(LocalDate date1, LocalDate date2, int venditore) {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT a FROM Abbonamento a WHERE a.dataEmissione >= :n AND a.dataEmissione <= :c AND emissione.id = :x");
		q.setParameter("n", date1);
		q.setParameter("c", date2);
		q.setParameter("x", venditore);
		List<Abbonamento> listaEmissione = q.getResultList();
		logger.info("Il numero di abbonamenti emessi dal giorno " + date1.toString() + " al giorno " + date2.toString()
				+ " è " + listaEmissione.size());
		return listaEmissione;
	}
	
	//STAMPA LISTE
	public void printListBiglietto(List<Biglietto> list) {
		for (Biglietto b : list)
			logger.info(b.toString());
	}
	
	public void printListAbbonamento(List<Abbonamento> list) {
		for (Abbonamento b : list)
			logger.info(b.toString());
	}

	//METODI GENERICI
	public void vidimaBiglietto(int titoloId, int corsaId) {
		if (getBigliettoByID(titoloId).getDataVidimazione() != null) logger.info("Il Biglietto è già stato vidimato!");
		else {
			EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
			EntityTransaction t = em.getTransaction();
			Query query = em.createQuery("UPDATE Biglietto SET dataVidimazione = :n, corsa = :c  WHERE id = :i");
			query.setParameter("n", LocalDate.now());
			query.setParameter("c", td.getCorsaById(corsaId));
			query.setParameter("i", titoloId);
			logger.info("Biglietto vidimato");
			t.begin();
			query.executeUpdate();
			t.commit();
		}
	}

	public boolean validoPerCorsa(Biglietto biglietto) {
		if (biglietto.getDataVidimazione() != null)
			return true;
		return false;
	}

	public void rinnovaTessera(int id) {
		Tessera t = recuperaTesseraDaDB(id);
		if (t.getDataScadenza().isBefore(LocalDate.now())) t.setDataScadenza(LocalDate.now().plusYears(1));
		else t.setDataScadenza(t.getDataScadenza().plusYears(1));
		update(t);
	}
	

}