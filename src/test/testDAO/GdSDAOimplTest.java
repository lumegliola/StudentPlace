package test.testDAO;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import bean.*;
import dao.DAOFactory;
import dao.implementation.GdSDAOimpl;

import dao.interfaces.GdSDAO;

class GdSDAOimplTest {
	GdSDAO dao = DAOFactory.getGdSDAO();
	GruppoDiStudio gruppo=new GruppoDiStudio();
	Aula aula = new Aula("P4", "F2");
	Credenziali c= new Credenziali("kitemmuort1995@studenti.unisa,it", "123456", "0512104592", false);
	Utente creatore= new Utente("filippo","lumegliola",c);
	Timestamp inizio = new Timestamp(119, 0, 15, 0, 0, 0, 0);
	Timestamp fine = new Timestamp(119, 0, 15, 0, 10, 0, 0);
	boolean ok;
	@Test
	void testDoSave() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		
		System.out.println(gruppo.getCreatore().getCredenziali().getMatricola());
		System.out.println("test metodo 1");
		ok = false;
		Boolean res = dao.doSave(gruppo);
		assertTrue(res);
		List<GruppoDiStudio> aRes = dao.doRetrieveByName(gruppo.getNomeGruppo());
		for( GruppoDiStudio b : aRes) {
			if(gruppo.equals(b))
				ok = true; System.out.println("successo");
		}
		assertTrue(ok);
		
	}

	@Test
	void testDoSaveOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDoDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testDoDeleteByNameAndSubjet() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveByName() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveBySubject() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveByNameAndSubject() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

	@Test
	void testDoRetrieveById() {
		fail("Not yet implemented");
	}

}
