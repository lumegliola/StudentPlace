package test.testDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
import org.junit.jupiter.api.Test;


import bean.GruppoDiStudio;
import bean.Iscrizione;
import bean.Utente;
import dao.DAOFactory;

import dao.interfaces.GdSDAO;
import dao.interfaces.IscrizioneDAO;
import dao.interfaces.UserDAO;
import junit.framework.TestCase;

public class IscrizioneDAOImplTest extends TestCase{
	private FlatXmlDataSet loadedDataSer;
	private Connection connection;
	private DatabaseConnection dbconnection;
	private IDataSet dataSet;

  @Test
  public void testDoSave() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      UserDAO utenteDao=DAOFactory.getUserDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
      Utente utente=utenteDao.doRetrieveByKey("0512101769");
      assertNotNull(gruppo);
      assertNotNull(utente);
      Iscrizione iscr=new Iscrizione();
      iscr.setGruppo(gruppo);
      iscr.setIscritto(utente);
      assertNotNull(iscr);
      boolean valore=iscrDao.doSave(iscr);
      assertTrue(valore);
      System.out.println("End test");
  }

  @Test
  public void testDoDelete() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      UserDAO utenteDao=DAOFactory.getUserDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
      Utente utente=utenteDao.doRetrieveByKey("0512103593");
      assertNotNull(gruppo);
      assertNotNull(utente);
      Iscrizione iscr=new Iscrizione();
      iscr.setGruppo(gruppo);
      iscr.setIscritto(utente);
      assertNotNull(iscr);
      boolean valore=iscrDao.doDelete(iscr);
      assertTrue(valore);
      System.out.println("End test");
  }

  @Test
  public void testDoDeleteByUserAndGroup() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      UserDAO utenteDao=DAOFactory.getUserDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di pd", "Programmazione Distribuita");
      Utente utente=utenteDao.doRetrieveByKey("0512102565");
      assertNotNull(gruppo);
      assertNotNull(utente);
      boolean valore=iscrDao.doDeleteByUserAndGroup(utente.getMatricola(), gruppo.getId());
      assertTrue(valore);
      System.out.println("End test");  }

  @Test
  public void testDoRetrieveByUser() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      UserDAO utenteDao=DAOFactory.getUserDAO();
      Utente utente=utenteDao.doRetrieveByKey("0512102855");
      assertNotNull(utente);
     List <Iscrizione> listIscr=null;
      listIscr=iscrDao.doRetrieveByUser(utente.getMatricola());
      assertNotNull(listIscr);
      System.out.println("End test");
  }

  @Test
  public void testDoRetrieveByGroup() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
     
      assertNotNull(gruppo);
      List <Iscrizione> listIscr=null;
      listIscr=iscrDao.doRetrieveByGroup(gruppo.getId());
      assertNotNull(listIscr);
      System.out.println("End test");  
      
  }


@Test
public void testDoRetrieveByUserAndGroup() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      
      UserDAO utenteDao=DAOFactory.getUserDAO();
      Utente utente=utenteDao.doRetrieveByKey("0512102765");
      assertNotNull(utente);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
       assertNotNull(gruppo);
     
      Iscrizione iscr=null;
      iscr=iscrDao.doRetrieveByUserAndGroup(utente.getMatricola(),gruppo.getId());
      assertNotNull(iscr);
      System.out.println("End test");
     }

  @Test
  public void testDoRetrieveAll() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      List <Iscrizione> listIscr=null;
    listIscr=iscrDao.doRetrieveAll();
    assertNotNull(listIscr);
      System.out.println("End test");
     
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
      		 DatabaseOperation.CLEAN_INSERT.execute(dbconnection, dataSet);
          }
 }
  