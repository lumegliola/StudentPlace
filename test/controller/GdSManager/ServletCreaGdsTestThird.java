package controller.GdSManager;

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

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import junit.framework.TestCase;
import model.dao.DAOFactory;

public class ServletCreaGdsTestThird extends TestCase{

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

		
	when(request.getSession()).thenReturn(session);
	when(session.getAttribute("logged")).thenReturn(false);
	when(request.getRequestDispatcher("/view/errore/Errore.jsp")).thenReturn(dispatcher);
	new ServletCreaGds().doPost(request, response);
	verify(dispatcher).forward(request, response);


}

}
