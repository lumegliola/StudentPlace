package logica.visualizzaAule;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AulaLibera;
import dao.DAOFactory;


@WebServlet("/visualizzaAuleLibere")
public class ServletvisualizzaAuleLibere extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletvisualizzaAuleLibere() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		List <AulaLibera> elenco = new ArrayList<>();
		
		elenco.addAll(DAOFactory.getAulaLiberaDAO().doRetrieveAll());
		
		session.setAttribute("elencoAule", elenco);
		getServletContext().getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			
			
		
			
		}
		
	
	}

}
