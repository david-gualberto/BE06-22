package com.davidgualberto.gestione_incendi_PW;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.davidgualberto.gestione_incendi_PW.model.Sonda;

@SpringBootTest
class GestioneIncendiPwApplicationTests {
	
	Sonda s1 = new Sonda(1, 10.8, -22.7);
	

	@Test
	public void testGetId() {
		assertEquals(1, s1.getId());
	}

	@Test
	public void testGetLatitudine() {
		assertEquals(10.8, s1.getLatitudine(),0.001);
	}
	

	@Test
	public void testGetLongitudine() {
		assertEquals(-22.7, s1.getLongitudine(), 0.001);
	}
    
    @Test
    public void testGetLivelloFumo() {
        assertEquals(0, s1.getLivelloFumo());
    }
    
    @Test
    public void testSetLivelloFumo() {
    	int nuovoLivello = 3;
    	s1.setlivelloFumo(nuovoLivello);
        assertEquals(nuovoLivello, s1.getLivelloFumo());
    }


}
