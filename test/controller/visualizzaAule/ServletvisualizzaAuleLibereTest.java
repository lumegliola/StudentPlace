package controller.visualizzaAule;

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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import controller.visualizzaAule.ServletvisualizzaAuleLibere;
import junit.framework.TestCase;

class ServletvisualizzaAuleLibereTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

	}
	 @Mock
	 	ServletContext context;

	 	@Mock
	 	RequestDispatcher dispatcher= Mockito.mock(RequestDispatcher.class);;

	 	@Mock
	    HttpServletRequest request;

	    @Mock
	    HttpServletResponse response;

	    @Mock
	    HttpSession session;

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		  ServletContext context = Mockito.mock(ServletContext.class);
	    when(request.getRequestDispatcher("/view/auleliber/aulelibere.jsp")).thenReturn(dispatcher);
	    when(request.getSession()).thenReturn(session);

		new ServletvisualizzaAuleLibere().doPost(request, response);
		verify(dispatcher).forward(request, response);


	}

}
