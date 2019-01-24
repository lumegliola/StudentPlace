package logica.orarioManager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestServletModificaOrario {

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
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {

		when(request.getParameter("id")).thenReturn("4");
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("admin")).thenReturn(true);
		when(request.getParameter("inizio")).thenReturn("2018-11-21 10:00:00.000");
		when(request.getParameter("fine")).thenReturn("2018-11-21 12:00:00.000");
		when(request.getRequestDispatcher("ProvaOutput.jsp")).thenReturn(dispatcher);

		new ServletModificaOrario().doPost(request, response);
		
		verify(dispatcher).forward(request, response);	}

}
