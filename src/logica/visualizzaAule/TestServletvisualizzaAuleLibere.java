package logica.visualizzaAule;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestServletvisualizzaAuleLibere  {
	 	
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
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
  
	
  
	when(request.getSession(false)).thenReturn(session);
    
    when(request.getRequestDispatcher("ProvaOutput.jsp")).thenReturn(dispatcher);

	new ServletvisualizzaAuleLibere().doGet(request, response);
	
	verify(dispatcher).forward(request, response);
  
	
	}

}



