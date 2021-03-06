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

import junit.framework.TestCase;
import model.bean.Orario;
import model.dao.DAOFactory;
import model.dao.interfaces.OrarioDAO;

public class OrarioDAOimplTest extends TestCase{

  @Test
  public void testDoSave() {

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
  public void testDoRetrieveByKey() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=orarioDao.doRetrieveByKey(4);
      Orario controllo = new Orario(new Timestamp(118, 11, 21, 11, 0, 0, 0), new Timestamp(118, 11, 21, 12, 0, 0, 0));
      controllo.setIdOrario(4);
      assertTrue(orario.equals(controllo));
      System.out.println("End test");
      }

@Test
 public void testDoSaveOrUpdate() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,2,12,0,0,0));
      orario.setFine(new Timestamp(2019,11,2, 14,0,0,0));

      DAOFactory.getOrarioDAO().doSave(orario);
      orario = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(orario.getInizio(), orario.getFine());

      boolean valore=orarioDao.doSaveOrUpdate(orario, new Timestamp(119,11,3,15,0,0,0), new Timestamp(119,11,3 ,16,0,0,0));
      assertTrue(valore);

      System.out.println("End test");

  }

  @Test
 public  void testDoDeleteOrario() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,02,11,00,00, 0));
      orario.setFine(new Timestamp(2019,11,02, 13,00,00, 0));
      DAOFactory.getOrarioDAO().doSave(orario);
      Orario or2 = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(orario.getInizio(), orario.getFine());

      boolean valore=orarioDao.doDelete(or2);
      assertTrue(valore);

      System.out.println("End test");
      }

  @Test
  public void testDoDeleteInt() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,02,12,00,00, 0));
      orario.setFine(new Timestamp(2019,11,02, 14,00,00, 0));
      DAOFactory.getOrarioDAO().doSave(orario);
      Orario or2 = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(orario.getInizio(), orario.getFine());

      boolean valore=orarioDao.doDelete(or2.getIdOrario());
      assertTrue(valore);

      System.out.println("End test");  }



  @Test
 public  void testDoRetrieveByStart() {
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
 public  void testDoRetrieveByStartAndFinish() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=null;
      orario=orarioDao.doRetrieveByStartAndFinish(new Timestamp(2019,11,02,11,00,00, 0),new Timestamp(2019,11,02,13,00,00, 0));
      assertNotNull(orario);

      System.out.println("End test");

  }

  @Test
 public  void testDoRetrieveAll() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      List<Orario> listOrario=null;
      listOrario=orarioDao.doRetrieveAll();
      assertNotNull(listOrario);
      for (Orario or :listOrario) {
        System.out.println("Start"+or.getInizio()+"Fine"+or.getFine());
         }
      System.out.println("End test");
      }
	private FlatXmlDataSet loadedDataSer;
	private Connection connection;
	private DatabaseConnection dbconnection;
	private IDataSet dataSet;
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
