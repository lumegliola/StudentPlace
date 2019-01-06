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
		gruppo.setGiorno("mercoledi");
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		
		System.out.println(gruppo.getCreatore().getCredenziali().getMatricola());
		System.out.println("test metodo 1");
		ok = false;
		Boolean res = dao.doSave(gruppo);
		assertTrue(res);
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());
		System.out.println(risultato.getNomeGruppo()+"   "+ risultato.getMateria()+ "   "+risultato.getGiorno());
		
		
		assertTrue(gruppo.getNomeGruppo().equals(risultato.getNomeGruppo()));
		
	}

	@Test
	void testDoSaveOrUpdate() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno("mercoledi");
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		
		System.out.println(gruppo.getCreatore().getCredenziali().getMatricola());
		System.out.println("test metodo 1");
		ok = false;
		Boolean res = dao.doSaveOrUpdate(gruppo, gruppo.getAula().getNomeAula(), gruppo.getOrario().getInizio(), gruppo.getOrario().getFine());
		assertTrue(res);
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());
		System.out.println(risultato.getNomeGruppo()+"   "+ risultato.getMateria()+ "   "+risultato.getGiorno());
		
		
		assertTrue(gruppo.getNomeGruppo().equals(risultato.getNomeGruppo()));
		
	}
	

	@Test
	void testDoDelete() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		dao.doDelete(gruppo);
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());
		
		assertTrue(risultato==null);
		if(risultato==null)
		System.out.println("eliminazione completata");
	}

	@Test
	void testDoDeleteByNameAndSubjet() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		dao.doDeleteByNameAndSubjet(gruppo.getNomeGruppo(),gruppo.getMateria());
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());
		
		assertTrue(risultato==null);
		System.out.println("eliminazione completata");
	}

	@Test
	void testDoRetrieveByName() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		dao.doSave(gruppo);
		List<GruppoDiStudio> risultato = dao.doRetrieveByName(gruppo.getNomeGruppo());
		
		  assertTrue(risultato.get(1).getNomeGruppo().equals(gruppo.getNomeGruppo()));
		
		System.out.println("funziona");
	}

	

	@Test
	void testDoRetrieveBySubject() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		dao.doSave(gruppo);
		List<GruppoDiStudio> risultato = dao.doRetrieveBySubject(gruppo.getMateria());
		assertTrue(risultato.size()>0);
		
		
		System.out.println("funziona");
	
	}

	@Test
	void testDoRetrieveByNameAndSubject() {
	
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		dao.doSave(gruppo);
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());
		
		assertTrue(risultato.getNomeGruppo().equals(gruppo.getNomeGruppo()));
		
		System.out.println("funziona");
	}

	@Test
	void testDoRetrieveAll() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		dao.doSave(gruppo);
	    List<GruppoDiStudio> lista =dao.doRetrieveAll();
	 
	    assertTrue(lista.size()>0);
	}

	@Test
	void testDoRetrieveById() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante1");
		dao.doSave(gruppo);
		
		System.out.println((gruppo.getId())+"l'id è");
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());

		GruppoDiStudio risultato2 = dao.doRetrieveById(risultato.getId());
		System.out.println(risultato.getId()+"l'id è");
		
		assertTrue(risultato.getId()==risultato2.getId());
		
		System.out.println("funziona");
	}

}
