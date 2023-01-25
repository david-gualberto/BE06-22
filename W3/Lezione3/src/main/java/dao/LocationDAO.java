package dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import evento.Location;
import utils.JpaUtil;

public class LocationDAO {
	
	private static final EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	private static final EntityTransaction t = em.getTransaction();
	
		public static void saveLocation(String nome, String citta) {
		
		try {
			Location l = new Location();
			l.setNome(nome);
			l.setCitta(citta);
	

			t.begin();
			em.persist(l);
			t.commit();
			System.out.println("Location inserita correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento della Location");
			System.out.println(e.getMessage());
		}
		}
		
		public static Location getLocationById(int id) {
			Location l = em.find(Location.class, id);
			
			if( l == null ) {
				System.out.println( "Location non trovata!" );
				return l;
			}
			
			System.out.println( "Dati Location: ");
			System.out.printf(  
				"Nome: %s | Città: %s%n",
				l.getNome(), l.getCitta() 
			);
			return l;
		}
		
		public static void deleteLocation(int id) {
			Location l = em.find(Location.class, id);
			
			if( l == null ) {
				System.out.println( "L'Evento non è stato trovato!" );
				return;
			}
			
			t.begin();
			em.remove(l);
			t.commit();
			
			System.out.println( "Location eliminata!" );
			}
}
