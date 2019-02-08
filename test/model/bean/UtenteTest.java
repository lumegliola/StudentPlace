package model.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtenteTest {
 private Utente utente;
	@Before
	public void setUp() throws Exception {
		utente =new Utente("0512103593", "Alessandro", "Capodanno", "a.capodanno5@gmail.com", "123456");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsAdmin() {
      assertFalse(utente.isAdmin());
	}

	@Test
	public void testSetAdmin() {
		utente.setAdmin(true);
		assertTrue(utente.isAdmin());
	}

}
