package logica.GdSManager;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import bean.GruppoDiStudio;

@WebServlet("/RicercaGds")
public class ServletRicercaGds extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletRicercaGds() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("logged") != null) {
			
			String nomeGruppo = "";
			String materia = "";
			
			List<GruppoDiStudio> elenco = new ArrayList<>();
			elenco = DAOFactory.getGdSDAO().doRetrieveBySubject(materia);
			elenco.addAll(DAOFactory.getGdSDAO().doRetrieveByName(nomeGruppo));
			
			session.setAttribute("elencoGruppi", elenco);
			getServletContext().getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
			
		}
		
	
	}

}
