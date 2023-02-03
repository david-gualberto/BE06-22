package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static final EntityManagerFactory entityManagerFactory;
	

	static {
		try {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("BuildWeek");
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed."
					+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
