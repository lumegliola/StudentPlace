package test.testDAO;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.*;
import bean.AulaLibera;
import dao.DAOFactory;
import dao.interfaces.AulaLiberaDAO;

public class AulaLiberaDAOimplTest {

	AulaLiberaDAO a = DAOFactory.getAulaLiberaDAO();
	Aula aula = new Aula("P4", "F2");
	Timestamp inizio = new Timestamp(119, 0, 15, 0, 0, 0, 0);
	Timestamp fine = new Timestamp(119, 0, 15, 0, 100, 0, 0);
	Orario or = new Orario(inizio, fine);
	AulaLibera al = new AulaLibera(aula, or);
	boolean ok = false;

	@Test
	public void testDoSave() {
		Boolean res = a.doSave(al);
		assertTrue(res);
		List<AulaLibera> aRes = a.doRetrieveByName(al.getAula().getNomeAula());
		for( AulaLibera b : aRes) {
			if(al.equals(b))
				ok = true;
		}
		assertTrue(ok);
		
	}

	@Test
	public void testDoSaveOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoDeleteAulaLibera() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoDeleteStringStringInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoRetrieveByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoRetrieveByDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

}
