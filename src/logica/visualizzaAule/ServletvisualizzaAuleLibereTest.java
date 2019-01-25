package logica.visualizzaAule;

import static org.junit.jupiter.api.Assertions.*;
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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import junit.framework.TestCase;

class ServletvisualizzaAuleLibereTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

	}
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

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
	    ServletvisualizzaAuleLibere serv=new ServletvisualizzaAuleLibere();
	    when(request.getSession()).thenReturn(session);
		when(request.getSession().getServletContext().getRequestDispatcher("aulelibere/aulelibere.jsp")).thenReturn(dispatcher);

		serv.doPost(request, response);

		verify(dispatcher).forward(request, response);

		
	}

}
