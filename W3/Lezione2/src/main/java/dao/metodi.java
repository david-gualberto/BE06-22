package dao;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import evento.Evento;
import evento.tipo;
import utils.JpaUtil;

public class metodi {
	
	private static final EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
	
	
	public static void save(String nome, LocalDate dataEvento, String descrizione, tipo tipoEvento, int numMax  ) {
		
		try {
			Evento e = new Evento();
			e.setTitolo(nome);
			e.setDataEvento(dataEvento);
			e.setDescrizione(descrizione);
			e.setTipoEvento(tipoEvento);
			e.setNumeroMassimoPaartecipanti(numMax);

			t.begin();
			em.persist(e);
			t.commit();
			System.out.println("Evento inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dell'Evento");
			System.out.println(e.getMessage());
		}
		}
	
	public static void getById(int id) {
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "L'Evento non è stato trovato!" );
			return;
		}
		
		System.out.println( "Dati Evento: ");
		System.out.printf(  
			"Nome: %s | Data Evento: %s | Descrizione: %s | Tipologia: %s | Num. Max Partecipanti: %d%n",
			e.getTitolo(), e.getDataEvento(), e.getDescrizione(), e.getTipoEvento(), e.getNumeroMassimoPaartecipanti() 
		);
	}
	
	public static void delete(int id) {
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "L'Evento non è stato trovato!" );
			return;
		}
		
		t.begin();
		em.remove(e);
		t.commit();
		
		System.out.println( "L'Evento è stato eliminato!" );
		}
}
