package test.testDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.Iterator;
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


import bean.Orario;
import dao.DAOFactory;
import dao.interfaces.OrarioDAO;

class OrarioDAOimplTest extends DBTestCase{

  @Test
  void testDoSave() {
    
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,2,15,0,0,0));
      orario.setFine(new Timestamp(2019,11,2,16,0,0,0));
      boolean valore=orarioDao.doSave(orario);
      assertTrue(valore);
      System.out.println("End test");
  }

  @Test
  void testDoSaveOrUpdate() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,02,12,00,00, 0));
      orario.setFine(new Timestamp(2019,11,02, 14,00,00, 0));
      orario.setIdOrario(1);
      
      boolean valore=orarioDao.doSaveOrUpdate(orario, new Timestamp(2019,11,03,15,00,00, 0), new Timestamp(2019,11,03 ,16,00,00, 0));
      assertTrue(valore);

      System.out.println("End test");

  }

  @Test
  void testDoDeleteOrario() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,02,11,00,00, 0));
      orario.setFine(new Timestamp(2019,11,02, 13,00,00, 0));
      orario.setIdOrario(7);
      boolean valore=orarioDao.doDelete(orario);
      assertTrue(valore);

      System.out.println("End test");
      }

  @Test
  void testDoDeleteInt() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,02,12,00,00, 0));
      orario.setFine(new Timestamp(2019,11,02, 14,00,00, 0));
      orario.setIdOrario(8);
      boolean valore=orarioDao.doDelete(orario.getIdOrario());
      assertTrue(valore);

      System.out.println("End test");  }

  @Test
  void testDoRetrieveByKey() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=null;
      orario=orarioDao.doRetrieveByKey(6);
      assertNotNull(orario);
      System.out.println("End test");
      }

  @Test
  void testDoRetrieveByStart() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      List<Orario> listOrario=null;
      listOrario=orarioDao.doRetrieveByStart(new Timestamp(2019,11,02,11,00,00, 0));
      assertNotNull(listOrario);
      for (Orario or :listOrario) {
        System.out.println("Start"+or.getInizio()+"Fine"+or.getFine());
         }
      System.out.println("End test");
  
  }

  @Test
  void testDoRetrieveByStartAndFinish() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=null;
      orario=orarioDao.doRetrieveByStartAndFinish(new Timestamp(2019,11,02,11,00,00, 0),new Timestamp(2019,11,02,13,00,00, 0));
      assertNotNull(orario);
     
      System.out.println("End test");
  
  }

  @Test
  void testDoRetrieveAll() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      List<Orario> listOrario=null;
      listOrario=orarioDao.doRetrieveAll();
      assertNotNull(listOrario);
      for (Orario or :listOrario) {
        System.out.println("Start"+or.getInizio()+"Fine"+or.getFine());
         }
      System.out.println("End test");  }
	private FlatXmlDataSet loadedDataSer;
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