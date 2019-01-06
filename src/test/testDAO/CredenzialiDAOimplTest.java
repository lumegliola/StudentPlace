package test.testDAO;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import bean.Credenziali;
import dao.DAOFactory;
import dao.interfaces.CredenzialiDAO;

public class CredenzialiDAOimplTest {
	
	
	@Test
	public void testDoSave() {
    System.out.println("Start test");
    CredenzialiDAO credDao=DAOFactory.getCredenzialiDAO();
    assertNotNull(credDao);
    Credenziali cred=new Credenziali();
    cred.setMail("a.capodanno6@studenti.unisa.it");
    cred.setMatricola("0512103457");
    cred.setPassword("123456");
    cred.setAdmin(false);
    assertNotNull(cred);
    boolean valore=credDao.doSave(cred);
    assertTrue(valore);
    System.out.println("End test");
	}

	@Test
	public void testDoSaveOrUpdate() {
			System.out.println("Start test.");
		    CredenzialiDAO credDao=DAOFactory.getCredenzialiDAO();
		    assertNotNull(credDao);
		    Credenziali cred=new Credenziali();
		    cred.setMail("a.panico19@studenti.unisa.it");
		    cred.setMatricola("0512103647");
		    cred.setPassword("123456");
		    cred.setAdmin(false);
		    assertNotNull(cred);
		    String password="777suognicosa";
		    boolean valore=credDao.doSaveOrUpdate(cred, password);
		    assertTrue(valore);
		    System.out.println("End test.");
	}

	@Test
	public void testDoDeleteCredenziali() {
	                 
		System.out.println("Start test.");
	    CredenzialiDAO credDao=DAOFactory.getCredenzialiDAO();
	    assertNotNull(credDao);
	    Credenziali cred=new Credenziali();
	    cred.setMail("a.capodanno5@studenti.unisa.it");
	    cred.setMatricola("0512103593");
	    cred.setPassword("123456");
	    cred.setAdmin(true);
	    assertNotNull(cred);
	    boolean valore=credDao.doDelete(cred);
	    assertTrue(valore);
	    System.out.println("End test.");

	}

	@Test
	public void testDoDeleteString() {
		System.out.println("Start test.");
	    CredenzialiDAO credDao=DAOFactory.getCredenzialiDAO();
	    assertNotNull(credDao);
	    Credenziali cred=new Credenziali();
	    cred.setMail("f.megliola@studenti.unisa.it");
	    cred.setMatricola("0512102855");
	    cred.setPassword("123456");
	    cred.setAdmin(false);
	    assertNotNull(cred);
	    boolean valore=credDao.doDelete(cred);
	    assertTrue(valore);
	    System.out.println("End test.");
	}

	@Test
	public void testDoRetrieveByMatricola() {
		System.out.println("Start test.");
	    CredenzialiDAO credDao=DAOFactory.getCredenzialiDAO();
	    assertNotNull(credDao);
	    Credenziali cred=null;
	    cred=credDao.doRetrieveByMatricola("0512102865");
	    assertNotNull(cred);
	    System.out.println("End test.");
	}

	@Test
	public void testDoRetrieveByEmailAndPassword() {
		System.out.println("Start test.");
	    CredenzialiDAO credDao=DAOFactory.getCredenzialiDAO();
	    assertNotNull(credDao);
	    Credenziali cred=null;
	    cred=credDao.doRetrieveByEmailAndPassword("f.megliola1@studenti.unisa.it", "123456");
	    assertNotNull(cred);
	    System.out.println("End test.");	}

	@Test
	public void testDoRetriveAll() {
		System.out.println("Start test.");
	    CredenzialiDAO credDao=DAOFactory.getCredenzialiDAO();
	    assertNotNull(credDao);
	   List<Credenziali> listCred=null;
	    listCred=credDao.doRetriveAll();
	    assertNotNull(listCred);
	    System.out.println("End test.");
	    
	
	}

	@Test
	public void testDoRetrieveByKey() {
		System.out.println("Start test.");
	    CredenzialiDAO credDao=DAOFactory.getCredenzialiDAO();
	    assertNotNull(credDao);
	    Credenziali cred=null;
	    cred=credDao.doRetrieveByKey("f.megliola1@studenti.unisa.it");
	    assertNotNull(cred);
	    System.out.println("End test.");		}

}
