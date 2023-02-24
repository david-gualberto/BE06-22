package com.davidgualberto.gestione_incendi_PW.model;



public class CentroControllo implements Observer {
	
	private static CentroControllo instance = null;

	public static CentroControllo getInstance() {
		if (instance == null) {
			instance = new CentroControllo();
		}
		return instance;
	}
	
	  @Override
	  public void update(Sonda s) {
	    if (s.getLivelloFumo() > 5) {
	    	allarmeDipartimento(s);
	    } else if (s.getLivelloFumo() == 5) {
	    	System.out.println("Attenzione Livello di Fumo al Limite!!! per la sonda:");
	    	System.out.printf("ID: %d  |  Latitudine: %.1f  |  Longitudine: %.1f  |  Livello di Fumo: %d%n", s.getId(),s.getLatitudine(), s.getLongitudine(), s.getLivelloFumo() );
	    } else if (s.getLivelloFumo() < 5) {
	    	System.out.println("Livello fumo sotto controllo per la sonda:");
	    	System.out.printf("ID: %d  |  Latitudine: %.1f  |  Longitudine: %.1f  |  Livello di Fumo: %d%n", s.getId(),s.getLatitudine(), s.getLongitudine(), s.getLivelloFumo() );
	    } else if (s.getLivelloFumo() ==0) {
	    	System.out.println("Fumo non presente per la sonda:");
	    	System.out.printf("ID: %d  |  Latitudine: %.1f  |  Longitudine: %.1f  |  Livello di Fumo: %d%n", s.getId(),s.getLatitudine(), s.getLongitudine(), s.getLivelloFumo());
	    }
	  }

	  private void allarmeDipartimento(Sonda s) {
	    String url = "http://host/alarm?idsonda=" + s.getId() + "&lat=" + s.getLatitudine() + "&lon=" + s.getLongitudine() + "&smokelevel=" + s.getLivelloFumo();
	    System.out.printf("Dipartimento Avvertito per la Sonda: %nSonda ID: %d  |  Latitudine: %.1f  |  Longitudine: %.1f  |  Livello di Fumo: %d%n", s.getId(),s.getLatitudine(), s.getLongitudine(), s.getLivelloFumo() );
	    System.out.println("url: " +url);
	  }
}
