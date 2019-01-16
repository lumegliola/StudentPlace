package test.testDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import bean.Credenziali;
import bean.Utente;
import dao.DAOFactory;

class UserDAOimplTest {

	@Test
	void testDoSave() {
		System.out.println("Test metodo 1");
		Credenziali c = new Credenziali("menomalechesilviocè1@studenti.unisa.it", "miconsenta", "0512103322", false);
		Utente user = new Utente("Silvio", "Berlusconi", c);
		
		boolean res = DAOFactory.getUserDAO().doSave(user);
			
		assertTrue(res);
		//ricavo l'inserimento dal DB
		Utente risultato = DAOFactory.getUserDAO().doRetrieveStudentByKey(user.getCredenziali().getMatricola());
	
		//confronto
		assertTrue(user.equals(risultato));
		System.out.println("successo");
		
	}

	@Test
	void testDoSaveOrUpdate() {
		System.out.println("Test metodo 2");
		Credenziali c = new Credenziali("f.megliola1@studenti.unisa.it", "0512102865", "123456", false);
		Utente user = new Utente("Filippo", "Megliola", c);
		
		boolean res = DAOFactory.getUserDAO().doSaveOrUpdate(user, "ciaoMondo");
			
		assertTrue(res);
		//ricavo l'inserimento dal DB
		Utente risultato = DAOFactory.getUserDAO().doRetrieveStudentByKey("0512102865");
		//confronto
		
		assertTrue(risultato.getCredenziali().getPassword().equals("ciaoMondo"));
		System.out.println("successo");	}

	@Test
	void testDoDeleteUtente() {
		System.out.println("Test metodo 3");
		Credenziali c = new Credenziali("m.rossi@studenti.unisa.it", "051201010", "123456", false);
		Utente user = new Utente("Marco", "Rossi", c);
		boolean res = DAOFactory.getUserDAO().doDelete(user);
		assertTrue(res);
		//ricavo l'inserimento dal DB
		System.out.println("successo");	
		}

	@Test
	void testDoDeleteString() {
		System.out.println("Test metodo 4");
		Credenziali c = new Credenziali("m.rossi2@studenti.unisa.it", "051201011", "123456", false);
		Utente user = new Utente("Marco", "Rossi", c);
		boolean res = DAOFactory.getUserDAO().doDelete(user);
		assertTrue(res);
		//ricavo l'inserimento dal DB
		System.out.println("successo");	

	}

	@Test
	void testDoRetrieveAdminByKey() {
		System.out.println("Test metodo 5");
		
		Utente user = null;
		user= DAOFactory.getUserDAO().doRetrieveAdminByKey("0512103593");
		assertNotNull(user);
		System.out.println("successo");		}

	@Test
	void testDoRetrieveStudentByKey() {
       System.out.println("Test metodo 6");
		Utente user = null;
		user= DAOFactory.getUserDAO().doRetrieveAdminByKey("0512102865");
		assertNotNull(user);
		System.out.println("successo");			}

	@Test
	void testDoRetrieveAll() {
		 System.out.println("Test metodo 7");
			List<Utente> user = null;
			user= DAOFactory.getUserDAO().doRetrieveAll();
			assertNotNull(user);
			//ricavo l'inserimento dal DB
			System.out.println("successo");				}

}
