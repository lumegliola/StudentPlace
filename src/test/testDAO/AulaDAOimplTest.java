package test.testDAO;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.dbunit.DBTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.CachedDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

import bean.Aula;
import dao.DAOFactory;
import dao.implementation.AulaDAOimpl;
import dao.interfaces.AulaDAO;

public class AulaDAOimplTest  extends DBTestCase{
	
	private FlatXmlDataSet loadedDataSer;
	@Test
	public void testDoSave() {
		
	    Aula aula=new Aula("F6","F2");
		AulaDAO aulaDao=DAOFactory.getAulaDAO();	
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
		Aula aula=new Aula();
		aula.setEdificio("F2");
		aula.setNomeAula("F1");
		AulaDAO aulaDao=DAOFactory.getAulaDAO();
		Aula nuovaAula=new Aula();
		nuovaAula.setEdificio("F2");
		nuovaAula.setNomeAula("F1");
		assertNotNull(aulaDao);
		assertNotNull(aula);
		assertNotNull(nuovaAula);
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
		System.out.println("Start test");
		Aula aula=new Aula();
		aula.setEdificio("F2");
		aula.setNomeAula("F5");
		AulaDAO aulaDao=DAOFactory.getAulaDAO();
		assertNotNull(aulaDao);
		assertNotNull(aula);
  	    boolean res=aulaDao.doDelete(aula);
  	    assertTrue(res);
	    System.out.println("End test");
	}

	@Test
	public void testDoDeleteString() {
		System.out.println("Start test");
		Aula aula=new Aula();
		aula.setEdificio("F2");
		aula.setNomeAula("F2");
		AulaDAO aulaDao=DAOFactory.getAulaDAO();
		assertNotNull(aulaDao);
		assertNotNull(aula);
		String nomeAula=aula.getNomeAula();
  	    boolean res=aulaDao.doDelete(nomeAula);
  	    assertTrue(res);
	    System.out.println("End test");
	
	}

	@Test
	public void testDoRetrieveByKey() {
		System.out.println("Start test");
		Aula aula=new Aula();
		aula.setEdificio("F2");
		aula.setNomeAula("F3");
		AulaDAO aulaDao=DAOFactory.getAulaDAO();
		assertNotNull(aulaDao);
		assertNotNull(aula);
		String nomeAula=aula.getNomeAula();
		
  	    Aula res=aulaDao.doRetrieveByKey(nomeAula);
  	    assertEquals(res, aula);
  	    System.out.println("End test");
	
	
	}

	@Test
	public void testDoRetrieveAll() {
		System.out.println("Start test");
		
		AulaDAO aulaDao=DAOFactory.getAulaDAO();
		assertNotNull(aulaDao);
		List<Aula> lista=aulaDao.doRetrieveAll();
		assertNotNull(lista);
		for(Aula aula: lista) {
			System.out.println("Aula:"+aula.getNomeAula()+",Edificio:"+aula.getEdificio());
		}
		 
		
		System.out.println("End test");
		
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
     loadedDataSer =   new FlatXmlDataSetBuilder().build(new FileInputStream("aula.xml"));
	loadedDataSer.endDataSet ();
     return loadedDataSer;
	}
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
	  @Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		  loadedDataSer.endDataSet();	}


}
