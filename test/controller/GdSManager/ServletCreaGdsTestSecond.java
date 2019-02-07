package controller.GdSManager;

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

import model.dao.DAOFactory;

public class ServletCreaGdsTestSecond {

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

	when(request.getParameter("nomeGruppo")).thenReturn("Gruppo di is");
	when(request.getParameter("materia")).thenReturn("Ingegneria Del Software");
	when(request.getSession()).thenReturn(session);
	when(session.getAttribute("utente")).thenReturn(DAOFactory.getUserDAO().doRetrieveByMail("b.ello@studenti.unisa.it"));
	when(session.getAttribute("logged")).thenReturn(true);
	when(request.getParameter("data")).thenReturn("2018-11-21");
	when(request.getParameter("inizio")).thenReturn(" 11:00");
	when(request.getParameter("fine")).thenReturn("12:00");
	when(request.getParameter("aula")).thenReturn("P3");
	when(request.getRequestDispatcher("/view/errore/Errore.jsp")).thenReturn(dispatcher);
	new ServletCreaGds().doPost(request, response);
	verify(dispatcher).forward(request, response);


}
}
