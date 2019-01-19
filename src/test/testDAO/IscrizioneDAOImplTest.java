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

class IscrizioneDAOImplTest extends DBTestCase{
	private FlatXmlDataSet loadedDataSer;

  @Test
  void testDoSave() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      UserDAO utenteDao=DAOFactory.getUserDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
      Utente utente=utenteDao.doRetrieveByKey("0512103457");
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
  void testDoDelete() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      UserDAO utenteDao=DAOFactory.getUserDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
      Utente utente=utenteDao.doRetrieveByKey("0512103333");
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
  void testDoDeleteByUserAndGroup() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      UserDAO utenteDao=DAOFactory.getUserDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
      Utente utente=utenteDao.doRetrieveByKey("0512103336");
      assertNotNull(gruppo);
      assertNotNull(utente);
      boolean valore=iscrDao.doDeleteByUserAndGroup(utente.getMatricola(), gruppo.getId());
      assertTrue(valore);
      System.out.println("End test");  }

  @Test
  void testDoRetrieveByUser() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      UserDAO utenteDao=DAOFactory.getUserDAO();
      Utente utente=utenteDao.doRetrieveByKey("0512102865");
      assertNotNull(utente);
     List <Iscrizione> listIscr=null;
      listIscr=iscrDao.doRetrieveByUser(utente.getMatricola());
      assertNotNull(listIscr);
      System.out.println("End test");
  }

  @Test
  void testDoRetrieveByGroup() {
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
  void testDoRetrieveByUserAndGroup() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      
      UserDAO utenteDao=DAOFactory.getUserDAO();
      Utente utente=utenteDao.doRetrieveByKey("0512102865");
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
  void testDoRetrieveAll() {
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
	        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentplacedb?serverTimezone = EST5EDT", "root", "root");
	        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

	        // initialize your dataset here
	        IDataSet dataSet = getDataSet();
	        // ...

	        try
	        {
	            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
	        }
	        finally
	        {
	            connection.close();
	        }
	        

	    }
  	@After
  	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		  loadedDataSer.endDataSet();	
  	}


}