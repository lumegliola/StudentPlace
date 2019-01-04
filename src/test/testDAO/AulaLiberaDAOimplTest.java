package test.testDAO;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

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
	Aula aula = new Aula("P8", "F3");
	Timestamp inizio = new Timestamp(119, 0, 21, 0, 0, 0, 0);
	Timestamp fine = new Timestamp(119, 0, 21, 0, 10, 0, 0);
	Orario or = new Orario(inizio, fine);
	Orario or2 = new Orario(new Timestamp(119, 0, 7, 15, 14, 0, 0),new Timestamp(119, 0, 17, 15, 30, 0, 0));
	AulaLibera al = new AulaLibera(aula, or);
	boolean ok;

	@Test
	public void testDoSave() {
		System.out.println("test metodo 1");
		ok = false;
		Boolean res = a.doSave(al);
		assertTrue(res);
		AulaLibera risultato = a.doRetrieveByKey(al.getAula().getNomeAula(), al.getGiorno(), al.getOrario().getIdOrario());
		
		
		System.out.println(risultato.equals(al));
		
		System.out.println("successo");	
		
	}

	@Test
	public void testDoSaveOrUpdate() {
		System.out.println("test metodo 2");
		ok = false;
		
		a.doSaveOrUpdate(al, or2);
		
		AulaLibera al2= new AulaLibera(aula, or2);
		
		AulaLibera aRes = a.doRetrieveByKey(al.getAula().getNomeAula(), al.getOrario().getGiorno(), al.getOrario().getIdOrario());
		

		assertTrue(aRes.equals(al));
		System.out.println("successo");	
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
