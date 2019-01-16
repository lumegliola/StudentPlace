package test.testDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


import bean.Utente;
import dao.DAOFactory;

class UserDAOimplTest {

	@Test
	void testDoSave() {
		System.out.println("Test metodo 1");
		Utente user = new Utente("0512103322", "Silvio", "Berlusconi", "menomalechesilviocè1@studenti.unisa.it", "miconsenta");
		
		boolean res = DAOFactory.getUserDAO().doSave(user);
			
		assertTrue(res);
		//ricavo l'inserimento dal DB
		Utente risultato = DAOFactory.getUserDAO().doRetrieveByKey(user.getMatricola());
	
		//confronto
		assertTrue(user.equals(risultato));
		System.out.println("successo");
		
	}

	@Test
	void testDoSaveOrUpdate() {
		System.out.println("Test metodo 2");
		Utente user = new Utente("miconsenta", "Filippo", "Megliola", "f.megliola1@studenti.unisa.it",  "123456");
		
		boolean res = DAOFactory.getUserDAO().doSaveOrUpdate(user, "ciaoMondo");
			
		assertTrue(res);
		//ricavo l'inserimento dal DB
		Utente risultato = DAOFactory.getUserDAO().doRetrieveByKey("0512102865");
		//confronto
		
		assertTrue(risultato.getPassword().equals("ciaoMondo"));
		System.out.println("successo");	}

	@Test
	void testDoDeleteUtente() {
		System.out.println("Test metodo 3");
		Utente user = new Utente("051201010", "Marco", "Rossi", "m.rossi@studenti.unisa.it", "123456");
		boolean res = DAOFactory.getUserDAO().doDelete(user);
		assertTrue(res);
		//ricavo l'inserimento dal DB
		System.out.println("successo");	
		}

	@Test
	void testDoDeleteString() {
		System.out.println("Test metodo 4");
		Utente user = new Utente("051201010", "Marco", "Rossi", "m.rossi@studenti.unisa.it", "123456");
		boolean res = DAOFactory.getUserDAO().doDelete(user);
		assertTrue(res);
		//ricavo l'inserimento dal DB
		System.out.println("successo");	

	}

	@Test
	void testDoRetrieveByKey() {
		System.out.println("Test metodo 5");
		
		Utente user = null;
		user= DAOFactory.getUserDAO().doRetrieveByKey("0512103593");
		assertNotNull(user);
		System.out.println("successo");		

		}

	@Test
	void testDoRetrieveAll() {
		 System.out.println("Test metodo 7");
			List<Utente> user = null;
			user= DAOFactory.getUserDAO().doRetrieveAll();
			assertNotNull(user);
			//ricavo l'inserimento dal DB
			System.out.println("successo");				}

}
