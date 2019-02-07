package controller.userManager;

import static org.junit.Assert.*;
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
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controller.userManager.ServletVisualizzaProfilo;
import junit.framework.TestCase;
import model.dao.DAOFactory;

public class TestServletVisualizzaProfilo extends TestCase{

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

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
   }

    @Test
 	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {

    when(request.getSession()).thenReturn(session);

    when(session.getAttribute("utente")).thenReturn(DAOFactory.getUserDAO().doRetrieveByKey("0512102765"));
    when(session.getAttribute("logged")).thenReturn(true);

 	when(request.getRequestDispatcher("/view/utente/Profilo.jsp")).thenReturn(dispatcher);

 	new ServletVisualizzaProfilo().doPost(request, response);

 	verify(dispatcher).forward(request, response);

     }
}
