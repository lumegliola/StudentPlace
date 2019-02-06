package test.testDAO;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import model.bean.Aula;
import model.dao.DAOFactory;
import model.dao.implementation.AulaDAOimpl;
import model.dao.interfaces.AulaDAO;

public class AulaDAOimplTest  extends DBTestCase{
	private   IDataSet dataSet;
	private  IDatabaseConnection dbconnection;
	private FlatXmlDataSet loadedDataSer;
	private Connection connection;
	@Test
	public void testDoSave() throws SQLException {
		
	    Aula aula=new Aula("F10","F2");
		AulaDAO aulaDao=DAOFactory.getAulaDAO();	
		System.out.println("Start test");
		boolean res=aulaDao.doSave(aula);
		assertTrue(res);
		List<Aula> listaAule = new ArrayList<Aula>();
		PreparedStatement ps=connection.prepareStatement("select * from aula");
		ResultSet result=ps.executeQuery();
		while (result.next()) {
			String nomeAula=result.getString("nome");
			String edificio=result.getString("edificio");
			Aula aulaLista=new Aula(nomeAula, edificio);
			listaAule.add(aulaLista);
		}
		assertFalse(listaAule.isEmpty());
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
		nuovaAula.setEdificio("F3");
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
		aula.setEdificio("F");
		aula.setNomeAula("S1");
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
