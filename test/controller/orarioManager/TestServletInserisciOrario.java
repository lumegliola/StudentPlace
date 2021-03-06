
package controller.orarioManager;

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

import controller.orarioManager.ServletInserisciOrario;
import junit.framework.TestCase;

public class TestServletInserisciOrario extends TestCase{

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
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("admin")).thenReturn(true);
		when(session.getAttribute("logged")).thenReturn(true);
		when(request.getParameter("data")).thenReturn("2019-02-01");
		when(request.getParameter("inizio")).thenReturn("09:00");
		when(request.getParameter("fine")).thenReturn("19:00");
		when(request.getParameter("settimane")).thenReturn("2");
		when(request.getParameter("aula")).thenReturn("P1F3");
		when(request.getParameter("tuttasettimana")).thenReturn("si");
		when(request.getRequestDispatcher("GestioneOrario")).thenReturn(dispatcher);

		new ServletInserisciOrario().doPost(request, response);

		verify(dispatcher).forward(request, response);		}

}
