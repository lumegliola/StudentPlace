package test.testDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import bean.Credenziali;
import bean.Orario;
import dao.DAOFactory;
import dao.interfaces.CredenzialiDAO;
import dao.interfaces.OrarioDAO;

class OrarioDAOimplTest {

	@Test
	void testDoSave() {
		
		System.out.println("Start test");
	    OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
	    assertNotNull(orarioDao);
	    Orario orario=new Orario();
	    orario.setInizio(new Timestamp(2019,11,2,12,0,0,0));
	    orario.setFine(new Timestamp(2019,11,2,14,0,0,0));
	    boolean valore=orarioDao.doSave(orario);
	    assertTrue(valore);
	    System.out.println("End test");
	}

	@Test
	void testDoSaveOrUpdate() {
		System.out.println("Start test");
	    OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
	    assertNotNull(orarioDao);
	    Orario orario=new Orario();
	    orario.setInizio(new Timestamp(2019,11,02,11,00,00, 0));
	    orario.setFine(new Timestamp(2019,11,02, 13,00,00, 0));
	    orario.setIdOrario(1);
	    
	    boolean valore=orarioDao.doSaveOrUpdate(orario, new Timestamp(2019,11,02, 12,00,00, 0), new Timestamp(2019,11,02 ,14,00,00, 0));
	    assertTrue(valore);


	}

	@Test
	void testDoDeleteOrario() {
		fail("Not yet implemented");
	}

	@Test
	void testDoDeleteInt() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveByKey() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveByStart() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveByStartAndFinish() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

}
