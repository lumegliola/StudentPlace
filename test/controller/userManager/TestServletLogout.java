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
import javax.servlet.http.Cookie;
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

import controller.userManager.ServletLogout;
import junit.framework.TestCase;

public class TestServletLogout extends TestCase {

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
    Cookie []cookies= {new Cookie("utente","qualcosa"),new Cookie("admin","qualcosa"),new Cookie("logged","qualcosa")};

    when(request.getSession()).thenReturn(session);
    when(request.getCookies()).thenReturn(cookies);
 	
 	when(request.getRequestDispatcher("/view/homepage/Home.jsp")).thenReturn(dispatcher);

 	new ServletLogout().doGet(request, response);
 	
 	verify(dispatcher).forward(request, response);
     
     }
}
