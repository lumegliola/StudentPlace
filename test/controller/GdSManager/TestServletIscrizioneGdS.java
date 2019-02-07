package controller.GdSManager;

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

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controller.GdSManager.ServletIscrizioneGdS;

public class TestServletIscrizioneGdS {

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

	when(request.getParameter("idGds")).thenReturn("1");

	when(request.getParameter("matricola")).thenReturn("0512101769");
	when(request.getParameter("operazione")).thenReturn("iscrivi");


	when(request.getSession(false)).thenReturn(session);

	when(request.getRequestDispatcher("view/OpEffettuata.jsp")).thenReturn(dispatcher);

	new ServletIscrizioneGdS().doPost(request, response);

	verify(dispatcher).forward(request, response);

    }
}
