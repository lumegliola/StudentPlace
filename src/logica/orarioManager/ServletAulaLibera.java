package logica.orarioManager;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AulaLibera;
import bean.Orario;
import dao.DAOFactory;

/**
 * Servlet implementation class ServletAulaLibera
 */
@WebServlet("/AulaLibera")
public class ServletAulaLibera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAulaLibera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inizio = request.getParameter("inizio");
		String fine = request.getParameter("fine");
		String giorno = request.getParameter("data");
		Timestamp orIn =  Timestamp.valueOf(giorno+" "+inizio+":00:00");
		Timestamp orFin =  Timestamp.valueOf(giorno+" "+fine+":00:00");
		
		Orario or = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(orIn, orFin);
		
	
		
		
		if(or!=null) {
			List<AulaLibera> aule = DAOFactory.getAulaLiberaDAO().doRetrieveByDate(orIn);
		}
		
		
	}

}
