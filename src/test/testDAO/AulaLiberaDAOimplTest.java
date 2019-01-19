package test.testDAO;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.dbunit.DBTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import bean.*;
import bean.AulaLibera;
import dao.DAOFactory;
import dao.interfaces.AulaLiberaDAO;

public class AulaLiberaDAOimplTest extends DBTestCase{
	private   IDataSet dataSet;
	private  IDatabaseConnection dbconnection;
	private FlatXmlDataSet loadedDataSer;
	private Connection connection;
	@Test
	public void testDoSave() {
		System.out.println("test metodo 1");
		Aula aula = new Aula("P4", "F3");
		Timestamp inizio = new Timestamp(119, 0, 21, 0, 0, 0, 0);
		Timestamp fine = new Timestamp(119, 0, 21, 0, 10, 0, 0);
		Orario or = new Orario(inizio, fine);
		DAOFactory.getOrarioDAO().doSave(or);

		AulaLibera al = new AulaLibera(aula, or,or.getGiorno());

		Boolean res = DAOFactory.getAulaLiberaDAO().doSave(al);
		assertTrue(res);

		AulaLibera risultato = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al.getAula().getNomeAula(), al.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());
		al.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());

		//genero l'oracolo
		AulaLibera oracolo = new AulaLibera(aula, or,or.getGiorno());
		oracolo.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());

		//confronto il risultato della query con l'oracolo	
		assertTrue(risultato.equals(oracolo));

		System.out.println("successo");	

	}

	@Test
	public void testDoSaveOrUpdate() {
		System.out.println("test metodo 2");
		//aula
		Aula aula = new Aula("P21", "F3");

		//orario1
		Timestamp inizio = new Timestamp(119, 0, 21, 0, 0, 0, 0);
		Timestamp fine = new Timestamp(119, 0, 21, 0, 10, 0, 0);
		Orario or = new Orario(inizio, fine);
		DAOFactory.getOrarioDAO().doSave(or);

		//orario2
		Timestamp inizio1 = new Timestamp(119, 0, 7, 15, 14, 0, 0);
		Timestamp fine1 = new Timestamp(119, 0, 17, 15, 30, 0, 0);
		Orario or2 = new Orario(inizio1, fine1);
		DAOFactory.getOrarioDAO().doSave(or2);

		//salva l'aula nel db per ricavere l'idOrario dall'auto increment
		AulaLibera al = new AulaLibera(aula, or,or.getGiorno());
		DAOFactory.getAulaLiberaDAO().doSave(al);
		DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al.getAula().getNomeAula(), al.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(al.getOrario().getInizio(), al.getOrario().getFine()).getIdOrario());
		al.getOrario().setIdOrario( DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(al.getOrario().getInizio(), al.getOrario().getFine()).getIdOrario());

		//modifica l'aula libera con un nuovo orario
		boolean res = DAOFactory.getAulaLiberaDAO().doSaveOrUpdate(al, or2);
		assertTrue(res);
		//Richiedo al DB l'aula appena modificata
		AulaLibera risultato = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al.getAula().getNomeAula(), al.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio1, fine1).getIdOrario());

		//genero l'oracolo
		AulaLibera oracolo = new AulaLibera(aula, or2,or2.getGiorno());
		oracolo.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio1, fine1).getIdOrario());

		//confronto il risultato della query con l'oracolo	
		assertTrue(risultato.equals(oracolo));
		System.out.println("successo");	
	}

	@Test
	public void testDoDeleteAulaLibera() {
		System.out.println("test metodo 3");
		//settaggi iniziali
		Aula aula = new Aula("P2", "F3");
		Timestamp inizio = new Timestamp(119, 0, 21, 0, 0, 0, 0);
		Timestamp fine = new Timestamp(119, 0, 21, 0, 10, 0, 0);
		Orario or = new Orario(inizio, fine);
		DAOFactory.getOrarioDAO().doSave(or);
		AulaLibera al = new AulaLibera(aula, or,or.getGiorno());
		//salva l'aula nel db per ricavere l'idOrario dall'auto increment
		Boolean res = DAOFactory.getAulaLiberaDAO().doSave(al);
		assertTrue(res);
		AulaLibera inserimento= DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al.getAula().getNomeAula(), al.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());
		al.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());

		//elimina
		assertTrue(DAOFactory.getAulaLiberaDAO().doDelete(al));

		AulaLibera controllo = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(inserimento.getAula().getNomeAula(), inserimento.getGiorno(), inserimento.getOrario().getIdOrario());

		//genero l'oracolo vuoto
		AulaLibera oracolo = new AulaLibera();

		//confronto il risultato della query con l'oracolo	
		assertTrue(oracolo.equals(controllo));
		System.out.println("successo");

	}

	@Test
	public void testDoDeleteStringStringInt() {
		System.out.println("test metodo 4");

		//settaggi iniziali
		Aula aula = new Aula("P5", "F3");
		Timestamp inizio = new Timestamp(119, 0, 21, 0, 0, 0, 0);
		Timestamp fine = new Timestamp(119, 0, 21, 0, 10, 0, 0);
		Orario or = new Orario(inizio, fine);
		DAOFactory.getOrarioDAO().doSave(or);
		AulaLibera al = new AulaLibera(aula, or,or.getGiorno());

		//salva l'aula nel db per ricavere l'idOrario dall'auto increment
		Boolean res = DAOFactory.getAulaLiberaDAO().doSave(al);
		assertTrue(res);
		AulaLibera inserimento= DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al.getAula().getNomeAula(), al.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());
		al.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());
		//elimina
		assertTrue(DAOFactory.getAulaLiberaDAO().doDelete(al.getAula().getNomeAula(), al.getGiorno(), al.getOrario().getIdOrario()));

		AulaLibera controllo = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(inserimento.getAula().getNomeAula(), inserimento.getGiorno(), inserimento.getOrario().getIdOrario());

		//genero l'oracolo vuoto
		AulaLibera oracolo = new AulaLibera();

		assertTrue(oracolo.equals(controllo));
		System.out.println("successo");

	}

	@Test
	public void testDoRetrieveByName() {
		System.out.println("test metodo 5");
		//settaggi iniziali 1
		Aula aula = new Aula("P2", "F3");
		Timestamp inizio = new Timestamp(119, 0, 2, 0, 0, 0, 0);
		Timestamp fine = new Timestamp(119, 0, 2, 0, 10, 0, 0);
		Orario or = new Orario(inizio, fine);
		DAOFactory.getOrarioDAO().doSave(or);
		AulaLibera al = new AulaLibera(aula, or,or.getGiorno());

		//salva l'aula nel db per ricavere l'idOrario dall'auto increment
		Boolean res = DAOFactory.getAulaLiberaDAO().doSave(al);
		assertTrue(res);
		AulaLibera inserimento= DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al.getAula().getNomeAula(), al.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());
		al.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());

		//controllo 1
		AulaLibera controllo = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(inserimento.getAula().getNomeAula(), inserimento.getGiorno(), inserimento.getOrario().getIdOrario());

		//genero l'oracolo
		AulaLibera oracolo = new AulaLibera(aula, or,or.getGiorno());
		oracolo.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());

		//settaggi iniziali 2
		Aula aula2 = new Aula("P2", "F3");
		Timestamp inizio2 = new Timestamp(119, 0, 22, 0, 0, 0, 0);
		Timestamp fine2 = new Timestamp(119, 0, 22, 0, 10, 0, 0);
		Orario or2 = new Orario(inizio2, fine2);
		DAOFactory.getOrarioDAO().doSave(or2);
		AulaLibera al2 = new AulaLibera(aula2, or2,or2.getGiorno());

		//salva l'aula nel db per ricavere l'idOrario dall'auto increment
		Boolean res2 = DAOFactory.getAulaLiberaDAO().doSave(al2);
		assertTrue(res2);
		AulaLibera inserimento2= DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al2.getAula().getNomeAula(), al2.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio2, fine2).getIdOrario());
		al2.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio2, fine2).getIdOrario());

		//controllo 2
		AulaLibera controllo2 = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(inserimento2.getAula().getNomeAula(), inserimento2.getGiorno(), inserimento2.getOrario().getIdOrario());

		//genero l'oracolo 2
		AulaLibera oracolo2 = new AulaLibera(aula2, or2,or2.getGiorno());
		oracolo2.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio2, fine2).getIdOrario());

		//settaggi iniziali 3
		Aula aula3 = new Aula("P2", "F3");
		Timestamp inizio3= new Timestamp(119, 0, 4, 0, 0, 0, 0);
		Timestamp fine3 = new Timestamp(119, 0, 4, 0, 10, 0, 0);
		Orario or3 = new Orario(inizio3, fine3);
		DAOFactory.getOrarioDAO().doSave(or3);
		AulaLibera al3 = new AulaLibera(aula3, or3,or3.getGiorno());

		//salva l'aula nel db per ricavere l'idOrario dall'auto increment
		Boolean res3 = DAOFactory.getAulaLiberaDAO().doSave(al3);
		assertTrue(res3);
		AulaLibera inserimento3= DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al3.getAula().getNomeAula(), al3.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio3, fine3).getIdOrario());
		al3.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio3, fine3).getIdOrario());

		//controllo 3
		AulaLibera controllo3 = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(inserimento3.getAula().getNomeAula(), inserimento3.getGiorno(), inserimento3.getOrario().getIdOrario());

		//genero l'oracolo 3
		AulaLibera oracolo3 = new AulaLibera(aula3, or3,or3.getGiorno());
		oracolo3.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio3, fine3).getIdOrario());
		
		//lista risultati
		List<AulaLibera> listaRisultati = DAOFactory.getAulaLiberaDAO().doRetrieveByName("P2");
		
		//genero la lista oracolo
		List<AulaLibera> listaOracolo = new ArrayList<>();
		listaOracolo.add(oracolo);
		listaOracolo.add(oracolo2);
		listaOracolo.add(oracolo3);
		
		//confronto
		assertTrue(listaOracolo.containsAll(listaRisultati));
		System.out.println("successo");
	}

	@Test
	public void testDoRetrieveByDate() {
		System.out.println("test metodo 6");
		//settaggi iniziali 1
		Aula aula = new Aula("P2", "F3");
		Timestamp inizio = new Timestamp(119, 0, 1, 0, 0, 0, 0);
		Timestamp fine = new Timestamp(119, 0, 1, 0, 10, 0, 0);
		Orario or = new Orario(inizio, fine);
		DAOFactory.getOrarioDAO().doSave(or);
		AulaLibera al = new AulaLibera(aula, or,or.getGiorno());

		//salva l'aula nel db per ricavere l'idOrario dall'auto increment
		Boolean res = DAOFactory.getAulaLiberaDAO().doSave(al);
		assertTrue(res);
		AulaLibera inserimento= DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al.getAula().getNomeAula(), al.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());
		al.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());

		//controllo 1
		AulaLibera controllo = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(inserimento.getAula().getNomeAula(), inserimento.getGiorno(), inserimento.getOrario().getIdOrario());

		//genero l'oracolo
		AulaLibera oracolo = new AulaLibera(aula, or,or.getGiorno());
		oracolo.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio, fine).getIdOrario());

		//settaggi iniziali 2
		Aula aula2 = new Aula("P2", "F3");
		Timestamp inizio2 = new Timestamp(119, 0, 22, 0, 0, 0, 0);
		Timestamp fine2 = new Timestamp(119, 0, 22, 0, 10, 0, 0);
		Orario or2 = new Orario(inizio2, fine2);
		DAOFactory.getOrarioDAO().doSave(or2);
		AulaLibera al2 = new AulaLibera(aula2, or2,or2.getGiorno());

		//salva l'aula nel db per ricavere l'idOrario dall'auto increment
		Boolean res2 = DAOFactory.getAulaLiberaDAO().doSave(al2);
		assertTrue(res2);
		AulaLibera inserimento2= DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al2.getAula().getNomeAula(), al2.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio2, fine2).getIdOrario());
		al2.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio2, fine2).getIdOrario());

		//controllo 2
		AulaLibera controllo2 = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(inserimento2.getAula().getNomeAula(), inserimento2.getGiorno(), inserimento2.getOrario().getIdOrario());

		//genero l'oracolo 2
		AulaLibera oracolo2 = new AulaLibera(aula2, or2,or2.getGiorno());
		oracolo2.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio2, fine2).getIdOrario());

		//settaggi iniziali 3
		Aula aula3 = new Aula("P2", "F3");
		Timestamp inizio3= new Timestamp(119, 0, 4, 0, 0, 0, 0);
		Timestamp fine3 = new Timestamp(119, 0, 4, 0, 10, 0, 0);
		Orario or3 = new Orario(inizio3, fine3);
		DAOFactory.getOrarioDAO().doSave(or3);
		AulaLibera al3 = new AulaLibera(aula3, or3,or3.getGiorno());

		//salva l'aula nel db per ricavere l'idOrario dall'auto increment
		Boolean res3 = DAOFactory.getAulaLiberaDAO().doSave(al3);
		assertTrue(res3);
		AulaLibera inserimento3= DAOFactory.getAulaLiberaDAO().doRetrieveByKey(al3.getAula().getNomeAula(), al3.getGiorno(), DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio3, fine3).getIdOrario());
		al3.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio3, fine3).getIdOrario());

		//controllo 3
		AulaLibera controllo3 = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(inserimento3.getAula().getNomeAula(), inserimento3.getGiorno(), inserimento3.getOrario().getIdOrario());

		//genero l'oracolo 3
		AulaLibera oracolo3 = new AulaLibera(aula3, or3,or3.getGiorno());
		oracolo3.getOrario().setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(inizio3, fine3).getIdOrario());
		
		//lista risultati
		List<AulaLibera> listaRisultati = DAOFactory.getAulaLiberaDAO().doRetrieveByDate(inizio);
		
		//genero la lista oracolo
		List<AulaLibera> listaOracolo = new ArrayList<>();
		listaOracolo.add(oracolo);
		listaOracolo.add(oracolo2);
		listaOracolo.add(oracolo3);
		
		//confronto
		assertTrue(listaOracolo.containsAll(listaRisultati));
		System.out.println("successo");
	}
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

	   
}
