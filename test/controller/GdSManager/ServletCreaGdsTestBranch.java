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

import junit.framework.TestCase;
import model.dao.DAOFactory;

public class ServletCreaGdsTestBranch extends TestCase{

 	
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
		int i=3;
		while(i>0) {
			if(i==3) {
		when(request.getParameter("nomeGruppo")).thenReturn("Gds_Is");
		when(request.getParameter("materia")).thenReturn("Ingegneria_del_software");
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("utente")).thenReturn(DAOFactory.getUserDAO().doRetrieveByMail("b.ello@studenti.unisa.it"));
		when(session.getAttribute("logged")).thenReturn(true);
		when(request.getParameter("data")).thenReturn("2018-11-21");
		when(request.getParameter("inizio")).thenReturn(" 11:00");
		when(request.getParameter("fine")).thenReturn("12:00");
		when(request.getParameter("aula")).thenReturn("P3");
	    when(request.getRequestDispatcher("/view/OpEffettuata.jsp")).thenReturn(dispatcher);
		}else {
			if(i==2) {
				when(session.getAttribute("logged")).thenReturn(false);
			    when(request.getRequestDispatcher("/view/errore/Errore.jsp")).thenReturn(dispatcher);
			
			}else {
				if(i==1) {
					
				}
			}
			
		}
			new ServletCreaGds().doPost(request, response);
		i--;
		}
		
	
	
	}

}
