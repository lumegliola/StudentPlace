package logica.GdSManager;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Aula;
import bean.GruppoDiStudio;
import bean.Utente;
import dao.DAOFactory;

/**
 * Servlet implementation class CreaGds
 */
@WebServlet("/ServletCreaGds")
public class ServletCreaGds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	GruppoDiStudio nuovo = new GruppoDiStudio();
	
	
    public ServletCreaGds() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("logged") != null) {
			
			String nomeGruppo = (String) request.getParameter("nomegruppo");
			String materia = (String) request.getParameter("materia");
				if(DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(nomeGruppo, materia) != null){
			
					Utente creatore = DAOFactory.getUserDAO().doRetrieveByKey((String)session.getAttribute("matricola"));
			
					Timestamp inizio, fine;
					Aula aula = DAOFactory.getAulaDAO().doRetrieveByKey((String)request.getParameter("aula"));
			
			
					DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(request.getParameter("nomegruppo"), request.getParameter(""));
			
					nuovo.setNomeGruppo(nomeGruppo);
					nuovo.setCreatore(creatore);
					nuovo.setMateria(request.getParameter("materia"));
					//prendi ora inizio
					//prendi ora fine
					nuovo.setGiorno();
					nuovo.setAula(aula);
					
					DAOFactory.getGdSDAO().doSave(nuovo);
					
			
					session.setAttribute("esito", true);
				}
				else {
					session.setAttribute("esito", "errore");
			
				}
				getServletContext().getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
			}
		else {
			//messagggio: utente non loggato
			session.setAttribute("esito", "errore");
			getServletContext().getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
		}
		}
		
		
	}

