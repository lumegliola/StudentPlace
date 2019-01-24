package logica.orarioManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import logica.GdSManager.ServletRicercaGds;

class ServletModificaOrarioTest {

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
	void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {

		when(request.getParameter("id")).thenReturn("4");

		when(request.getSession()).thenReturn(session);
	    
		when(session.getAttribute("admin")).thenReturn(true);

		when(request.getParameter("inizio")).thenReturn("2018,12,21,10,00,00,0,0");
		when(request.getParameter("fine")).thenReturn("2018,12,21,10,00,00,0");


		
		
		when(request.getRequestDispatcher("ProvaOutput.jsp")).thenReturn(dispatcher);

		new ServletModificaOrario().doPost(request, response);
		
		verify(dispatcher).forward(request, response);	}

}
