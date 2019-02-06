package controller.GdSManager;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controller.GdSManager.ServletRicercaGds;
import model.dao.DAOFactory;

public class TestServletRicercaGdS {
	
	@Mock
 	ServletContext context= mock(ServletContext.class);
 	
 	@Mock
 	RequestDispatcher dispatcher;

 	@Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;
 
    @Mock
    HttpSession session=mock(HttpSession.class);
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);        
   }

    
    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
    	
    	when(request.getSession()).thenReturn(session);
    	
    	when(session.getAttribute("logged")).thenReturn(true);
    	
    	when(request.getParameter("inputGruppo")).thenReturn("prog");
    	when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));
    	
    	new ServletRicercaGds().doGet(request, response);
    	
    }
    
    @Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
  
	
	when(request.getSession()).thenReturn(session);
    
	when(session.getAttribute("logged")).thenReturn(true);
	
	when(request.getParameter("inputGruppo")).thenReturn("prog");

	when(session.getAttribute("matricola")).thenReturn("0512102865");
	
	when(request.getRequestDispatcher("/view/GdS/ListaGruppi.jsp")).thenReturn(dispatcher);

	new ServletRicercaGds().doPost(request, response);
	
	verify(dispatcher).forward(request, response);
    
    }

}
