package test.testDAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bean.Utente;
import dao.DAOFactory;

class UserDAOimplTest {

	@Test
	void testDoSave() {
		System.out.println("Test metodo 1");
		Utente user = new Utente("0512103322", "Silvio", "Berlusconi","menomalechesilviocè1@studenti.unisa.it", "miconsenta");
		boolean res = DAOFactory.getUserDAO().doSave(user);
			
		assertTrue(res);
		//ricavo l'inserimento dal DB
		Utente risultato = DAOFactory.getUserDAO().doRetrieveByKey(user.getMatricola());
		System.out.println(user.getCognome());
		System.out.println(user.getMatricola());
		
		System.out.println(risultato.getNome());
		System.out.println(risultato.getCognome());
		System.out.println(risultato.getMatricola());
		System.out.println(risultato.getMail());
		System.out.println(risultato.getPassword());
		
		
		//confronto
		
		assertTrue(user.equals(risultato));
		System.out.println("successo");
		
	}

	@Test
	void testDoSaveOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDoDeleteUtente() {
		fail("Not yet implemented");
	}

	@Test
	void testDoDeleteString() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveAdminByKey() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveStudentByKey() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

}
