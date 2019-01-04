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

	/*AulaLiberaDAO a = DAOFactory.getAulaLiberaDAO();
	Aula aula = new Aula("P12", "F3");
	Timestamp inizio = new Timestamp(119, 0, 21, 0, 0, 0, 0);
	Timestamp fine = new Timestamp(119, 0, 21, 0, 10, 0, 0);
	Orario or = new Orario(inizio, fine);
	Orario or2 = new Orario(new Timestamp(119, 0, 7, 15, 14, 0, 0),new Timestamp(119, 0, 17, 15, 30, 0, 0));
	AulaLibera al = new AulaLibera(aula, or);
	boolean ok;
*/
	@Test
	public void testDoSave() {
		System.out.println("test metodo 1");
		Aula aula = new Aula("P4", "F3");
		Timestamp inizio = new Timestamp(119, 0, 21, 0, 0, 0, 0);
		Timestamp fine = new Timestamp(119, 0, 21, 0, 10, 0, 0);
		Orario or = new Orario(inizio, fine);
		DAOFactory.getOrarioDAO().doSave(or);
		
		AulaLibera al = new AulaLibera(aula, or);
		
		Boolean res = DAOFactory.getAulaLiberaDAO().doSave(al);
		assertTrue(res);
		
		AulaLibera risultato = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al.getAula().getNomeAula(), al.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());
		al.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());
		
		
		System.out.println(risultato.equals(al));
		System.out.println(risultato.getAula().getNomeAula());
		System.out.println(risultato.getGiorno());
		System.out.println(risultato.getOrario().getIdOrario());
		
		
		System.out.println("successo");	
		
	}

	@Test
	public void testDoSaveOrUpdate() {
		System.out.println("test metodo 2");
		
		DAOFactory.getAulaLiberaDAO().doSaveOrUpdate(al, or2);
		
		AulaLibera al2= new AulaLibera(aula, or2);
		
		AulaLibera aRes = a.doRetrieveByKey(al.getAula().getNomeAula(), al.getOrario().getGiorno(), al.getOrario().getIdOrario());
		

		assertTrue(aRes.equals(al));
		System.out.println("successo");	
	}

	@Test
	public void testDoDeleteAulaLibera() {
		System.out.println("test metodo 3");
		
		assertTrue(a.doDelete(al));
		System.out.println("successo");
		
	}

	@Test
	public void testDoDeleteStringStringInt() {
		
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
