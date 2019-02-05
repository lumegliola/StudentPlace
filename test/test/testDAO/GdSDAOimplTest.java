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
import junit.framework.TestCase;

public class GdSDAOimplTest extends TestCase {
	
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
    		 DatabaseOperation.CLEAN_INSERT.execute(dbconnection, dataSet);
        }

	GdSDAO dao = DAOFactory.getGdSDAO();
	GruppoDiStudio gruppo=new GruppoDiStudio();
	Aula aula = new Aula("P4", "F3");
	Utente creatore= new Utente("0512102865", "Filippo", "Megliola", "f.megliola1@studenti.unisa.it", "123456");
	Timestamp inizio = new Timestamp(119, 0, 15, 0, 0, 0, 0);
	Timestamp fine = new Timestamp(119, 0, 15, 0, 10, 0, 0);
	boolean ok;

	@Test
	public void testDoSave() {
		
	
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno("mercoledi");
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		
		System.out.println("test metodo 1");
		ok = false;
		Boolean res = dao.doSave(gruppo);
		assertTrue(res);
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());	
		assertTrue(risultato.equals(gruppo));//problema creatore	
	}

	@Test
	public void testDoSaveOrUpdate() {
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
		
		
		assertTrue(gruppo.getNomeGruppo().equals(risultato.getNomeGruppo()));
		
	}
	

	@Test
	public void testDoDelete() {
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
	public void testDoDeleteByNameAndSubjet() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante");
		dao.doDeleteByNameAndSubjet(gruppo.getNomeGruppo(),gruppo.getMateria());
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());
		boolean val=false;
		if(risultato==null) {
			val=true;
		}
		assertTrue(val);
		System.out.println("eliminazione completata");
	}

	@Test
	public void testDoRetrieveByName() {
	//'2', 'Gruppo di pd', '0512103647', 'Programmazione Distribuita', '2018-12-21 15:00:00', '2018-12-21 17:30:00', 'lunedì', 'F8'
        GruppoDiStudio grupp=new GruppoDiStudio();
		grupp.setAula(new Aula("F8","F2"));
		grupp.setCreatore(new Utente("0512103647", "Antonio", "Panico", "a.panico19@studenti.unisa.it", "123456"));
		grupp.setOrario( new Timestamp(118, 11, 21, 12, 30, 0, 0), new Timestamp(118, 11, 21, 12, 30, 0, 0));
		grupp.setGiorno();
		grupp.setMateria("Programmazione Distribuita");
		grupp.setNomeGruppo("Gruppo di pd");
		grupp.setId(2);
		grupp.getCreatore().setAdmin(true);
		
		List<GruppoDiStudio> risultato = dao.doRetrieveByName(grupp.getNomeGruppo());
		GruppoDiStudio res2 = risultato.get(0);
		System.out.println(" "+ grupp.getOrario().getIdOrario()+" "+grupp.getOrario().getInizio()+" "+ grupp.getOrario().getFine()+" "+grupp.getCreatore().getMatricola()+" "+ grupp.getCreatore().getPassword()+" "+grupp.getCreatore().isAdmin());
		System.out.println(" "+ res2.getOrario().getIdOrario()+" "+res2.getOrario().getInizio()+" "+ res2.getOrario().getFine()+" "+res2.getCreatore().getMatricola()+" "+ res2.getCreatore().getPassword()+" "+res2.getCreatore().isAdmin());
		Utente usr2 = DAOFactory.getUserDAO().doRetrieveByKey(res2.getCreatore().getMatricola());
		
		assertTrue(grupp.equals(res2));
		/*
		List<GruppoDiStudio> risultato = dao.doRetrieveByName(grupp.getNomeGruppo());
	    boolean ris=false;
		for (GruppoDiStudio gds:risultato) {
			if(gds.equals(grupp)) {
				ris=true;
			}
		}
		assertTrue(ris);
		*/
		System.out.println("funziona");
	}

	

	@Test
	public void testDoRetrieveBySubject() {
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
	public void testDoRetrieveByNameAndSubject() {
	
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
	public void testDoRetrieveAll() {
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
	public void testDoRetrieveById() {
		gruppo.setAula(aula);
		gruppo.setCreatore(creatore);
		gruppo.setOrario(inizio, fine);
		gruppo.setGiorno();
		
		gruppo.setMateria("matematica");
		gruppo.setNomeGruppo("gruppo performante1");
		dao.doSave(gruppo);
		
		GruppoDiStudio risultato = dao.doRetrieveByNameAndSubject(gruppo.getNomeGruppo(),gruppo.getMateria());

		GruppoDiStudio risultato2 = dao.doRetrieveById(risultato.getId());
		
		assertTrue(risultato.getId()==risultato2.getId());
		
		System.out.println("funziona");
	}
	
	@Test
	public void testDoSearch() {
		List<GruppoDiStudio>controllo = DAOFactory.getGdSDAO().doRetrieveBySubject("analisi");
		List<GruppoDiStudio> test = DAOFactory.getGdSDAO().doSearch("lisi");
		
		assertTrue(test.containsAll(controllo));
		
	}
	
	private   IDataSet dataSet;
	private  IDatabaseConnection dbconnection;
	private FlatXmlDataSet loadedDataSer;
	private Connection connection;
	

}
