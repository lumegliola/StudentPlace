package controller.GdSManager;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controller.GdSManager.ServletEliminaGdS;
import junit.framework.TestCase;
import model.dao.DAOFactory;

public class TestServletEliminaGds extends TestCase {

    	@Mock
	 	ServletContext context= mock(ServletContext.class);
	 	
	 	@Mock
	 	RequestDispatcher dispatcher;

	 	@Mock
	    HttpServletRequest request;

	    @Mock
	    HttpServletResponse response;
	 
	    @Mock
	    HttpSession session;
	 

		private IDataSet loadedDataSer;

		private Connection connection;

		private DatabaseConnection dbconnection;

		private IDataSet dataSet;
	    
		 
	    @Before
	    public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	        Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentplacedb?serverTimezone = EST5EDT", "root", "root");
		    dbconnection = new DatabaseConnection(connection);
		    dataSet = getDataSet(); 
	   }
		@Before
		protected IDataSet getDataSet() throws Exception {
			// TODO Auto-generated method stub
	     loadedDataSer =   new FlatXmlDataSetBuilder().build(new FileInputStream("database.xml"));
	     return loadedDataSer;
		}
		
	    @After
	    protected void tearDown() throws Exception {
			// TODO Auto-generated method stub
	    		 DatabaseOperation.CLEAN_INSERT.execute(dbconnection, getDataSet());
	        }

	    @Test
		public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
	  
		when(request.getParameter("nomeGruppo")).thenReturn("Gruppo di is");
	    
		when(request.getParameter("materia")).thenReturn("Ingegneria del software");
		
		when(request.getSession()).thenReturn(session);
	    
		when(session.getAttribute("logged")).thenReturn(true);
		
		when(session.getAttribute("utente")).thenReturn(DAOFactory.getUserDAO().doRetrieveByKey("0512102865"));
		
		when(request.getRequestDispatcher("/view/Opeffettuata.jsp")).thenReturn(dispatcher);

		new ServletEliminaGdS().doPost(request, response);
		
		verify(dispatcher).forward(request, response);
	    }
}
