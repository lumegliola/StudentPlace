package logica.GdSManager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ServletCreaGdsTest {
  
		@Mock
	    HttpServletRequest request;

	 
	    @Mock
	    HttpServletResponse response;
	 
	    @Before
	    public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	    }
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
  
	when(request.getParameter("nomeGruppo")).thenReturn("Gds Is");	
    
	when(request.getParameter("materia")).thenReturn("Ingegneria del software");
	
	new ServletCreaGds().doPost(request, response);
	
	}

}
