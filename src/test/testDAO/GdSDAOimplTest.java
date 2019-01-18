package test.testDAO;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.dbunit.DBTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.statement.IStatementFactory;
import org.dbunit.dataset.CachedDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import bean.*;
import dao.DAOFactory;
import dao.implementation.GdSDAOimpl;

import dao.interfaces.GdSDAO;

class GdSDAOimplTest extends DBTestCase {
	
	@Before
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
     loadedDataSer =   new FlatXmlDataSetBuilder().build(new FileInputStream("database.xml"));
     return loadedDataSer;
	}
    @Before
	protected void setUp() throws Exception
	    {
	       Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentplacedb?serverTimezone = EST5EDT", "root", "root");
	       dbconnection = new DatabaseConnection(connection);
	       
	       dataSet = getDataSet();
	    }
    	@After
    	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
    		 DatabaseOperation.CLEAN_INSERT.execute(dbconnection, getDataSet());
        }

	GdSDAO dao = DAOFactory.getGdSDAO();
	GruppoDiStudio gruppo=new GruppoDiStudio();
	Aula aula = new Aula("P4", "F3");
	Utente creatore= new Utente("0512102865", "Filippo", "Lumegliola", "f.megliola1@studenti.unisa.it", "123456");
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
		
		System.out.println(gruppo.getCreatore().getMatricola());
		System.out.println("test metodo 1");
		ok = false;
		Boolean res = dao.doSave(gruppo);
		assertTrue(res);
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());

		System.out.println(gruppo.getNomeGruppo()+""+ gruppo.getMateria()+ ""+gruppo.getGiorno()+gruppo.getAula().getEdificio()+gruppo.getCreatore().getMatricola()+gruppo.getOrario().getInizio()+gruppo.getOrario().getFine()+gruppo.getCreatore().getMail());
		
		System.out.println(risultato.getNomeGruppo()+""+ risultato.getMateria()+ ""+risultato.getGiorno()+risultato.getAula().getEdificio()+risultato.getCreatore().getMatricola()+risultato.getOrario().getInizio()+risultato.getOrario().getFine()+risultato.getCreatore().getMail());
		
		
		
		assertTrue(risultato.equals(gruppo));
		
	}

	@Test
	void testDoSaveOrUpdate() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno("mercoledi"); 
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		
		System.out.println(gruppo.getCreatore().getMatricola());
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
	private   IDataSet dataSet;
	private  IDatabaseConnection dbconnection;
	private FlatXmlDataSet loadedDataSer;
	private Connection connection;
	

}
