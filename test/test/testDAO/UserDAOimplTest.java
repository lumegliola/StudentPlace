package test.testDAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.dbunit.DBTestCase;
import org.dbunit.assertion.DbUnitAssert;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.*;

import junit.framework.TestCase;
import model.bean.Utente;
import model.dao.DAOFactory;

public class UserDAOimplTest extends TestCase{
	public  UserDAOimplTest() {
		super();
	}
	 private DatabaseConnection dbconnection;

	@Before protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		 FlatXmlDataSet loadedDataSer;
     loadedDataSer =   new FlatXmlDataSetBuilder().build(new FileInputStream("database.xml"));
     return loadedDataSer;
	}
    @Before protected void setUp() throws Exception
	    {	 Connection connection;

		 IDataSet dataSet;
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
	@Test
	public void testDoSave() {
		System.out.println("Test metodo 1");
		Utente user = new Utente("0512103322", "Silvio", "Berlusconi", "menomalechesilviocè1@studenti.unisa.it", "miconsenta");

		boolean res = DAOFactory.getUserDAO().doSave(user);

		assertTrue(res);
		//ricavo l'inserimento dal DB
		Utente risultato = DAOFactory.getUserDAO().doRetrieveByKey(user.getMatricola());

		//confronto
		assertTrue(user.equals(risultato));
		System.out.println("successo");

	}

	@Test
	public void testDoSaveOrUpdate() {
		System.out.println("Test metodo 2");
		Utente user = new Utente("miconsenta", "Filippo", "Megliola", "f.megliola1@studenti.unisa.it",  "123456");

		boolean res = DAOFactory.getUserDAO().doSaveOrUpdate(user, "ciaoMondo");

		assertTrue(res);
		//ricavo l'inserimento dal DB
		Utente risultato = DAOFactory.getUserDAO().doRetrieveByKey("0512102865");
		//confronto

		assertTrue(risultato.getPassword().equals("ciaoMondo"));
		System.out.println("successo");	}

	@Test
	public void testDoDeleteUtente() {
		System.out.println("Test metodo 3");
	//	'0512101769', 'Luigi', 'Califano', 'l.califano22@studenti.unisa.it', '123456', '0'

		Utente user = new Utente("0512101769", "Luigi", "Califano", "l.califano22@studenti.unisa.it", "123456");
		boolean res = DAOFactory.getUserDAO().doDelete(user);
		assertTrue(res);
		//ricavo l'inserimento dal DB
		System.out.println("successo");
		}

	@Test
	public void testDoDeleteString() {
		System.out.println("Test metodo 4");
		//'0512102565', 'Antonio', 'Lino', 'a.lino@studenti.unisa.it', '123456', '0'
		//  "0512102565" "Antonio" "Lino" "a.lino@studenti.unisa.it" "123456" "0"/>

		Utente user = new Utente("0512102565", "Antonio", "Lino", "a.lino@studenti.unisa.it", "123456");
		boolean res = DAOFactory.getUserDAO().doDelete(user.getMail());
		assertTrue(res);
		//ricavo l'inserimento dal DB
		System.out.println("successo");

	}

	@Test
	public void testDoRetrieveByKey() {
		System.out.println("Test metodo 5");

		Utente user = null;
		user= DAOFactory.getUserDAO().doRetrieveByKey("0512103593");
		assertNotNull(user);
		System.out.println("successo");

		}

	@Test
	public void testDoRetrieveAll() {
		 System.out.println("Test metodo 7");
			List<Utente> user = null;
			user= DAOFactory.getUserDAO().doRetrieveAll();
			assertNotNull(user);
			//ricavo l'inserimento dal DB
			System.out.println("successo");
	}



}
