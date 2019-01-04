package test.testDAO;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;

import bean.Aula;
import dao.DAOFactory;
import dao.implementation.AulaDAOimpl;
import dao.interfaces.AulaDAO;

public class AulaDAOimplTest {
	Aula aula=new Aula("F9","F2");
	AulaDAO aulaDao=DAOFactory.getAulaDAO();
	@Test
	public void testDoSave() {
		
		System.out.println("Start test");
		boolean res=aulaDao.doSave(aula);
		assertTrue(res);
		List<Aula> listaAule=DAOFactory.getAulaDAO().doRetrieveAll();
		
		assertNotNull(listaAule);
		boolean ok=false;
		
		for(Aula al:listaAule) {
			if(aula.equals(al)) {
				ok = true;
			}
		}
       assertTrue(ok);
       System.out.println("End test");
	}

	@Test
	public void testDoSaveOrUpdate() {
		System.out.println("Start test");
		Aula nuovaAula=new Aula();
		nuovaAula.setEdificio("F3");
		nuovaAula.setNomeAula("F35");
		
		boolean res=aulaDao.doSaveOrUpdate(aula, nuovaAula.getNomeAula(),nuovaAula.getEdificio());
		assertTrue(res);
		List<Aula> listaAule=DAOFactory.getAulaDAO().doRetrieveAll();
		assertNotNull(listaAule);
		boolean ok=false;
		for(Aula al:listaAule) {
			if(nuovaAula.equals(al)) {
				ok = true;
			}
		}
       assertTrue(ok);
       System.out.println("End test");
		
	}

	@Test
	public void testDoDeleteAula() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoDeleteString() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoRetrieveByKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoRetrieveAll() {
		fail("Not yet implemented");
	}

}
