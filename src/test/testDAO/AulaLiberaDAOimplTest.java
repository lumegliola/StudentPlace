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
	Aula aula = new Aula("P9", "F2");
	Aula aula2 = new Aula("P11", "F2");
	Timestamp inizio = new Timestamp(119, 0, 16, 0, 0, 0, 0);
	Timestamp fine = new Timestamp(119, 0, 16, 0, 10, 0, 0);
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
		List<AulaLibera> aRes = a.doRetrieveByName(al.getAula().getNomeAula());
		for( AulaLibera b : aRes) {
			if(al.getAula().getNomeAula().equals(b.getAula().getNomeAula()) && al.getGiorno().equals(b.getGiorno()) && al.getOrario().getInizio().equals(b.getOrario().getInizio()) && al.getOrario().getFine().equals(b.getOrario().getFine()))
				ok = true; 
			System.out.println(ok);	
		}
		assertTrue(ok);
		System.out.println("successo");	
		
	}

	@Test
	public void testDoSaveOrUpdate() {
		System.out.println("test metodo 2");
		ok = false;
		
		//a.doSaveOrUpdate(al, or2);
		
		//AulaLibera al2= new AulaLibera(aula, or2);
		
		List<AulaLibera> aRes = a.doRetrieveByName(al.getAula().getNomeAula());
		for( AulaLibera b : aRes) {
			if(al.getAula().getNomeAula().equals(b.getAula().getNomeAula()) && al.getGiorno().equals(b.getGiorno()) && al.getOrario().getInizio().equals(b.getOrario().getInizio()) && al.getOrario().getFine().equals(b.getOrario().getFine()))
				ok = true; 
			System.out.println(ok);	
		}

		assertTrue(ok);
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
