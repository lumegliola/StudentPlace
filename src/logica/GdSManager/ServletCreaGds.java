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
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);						//
		if(session != null && session.getAttribute("logged") != null) {
			
			String nomeGruppo = request.getParameter("nomeGruppo");
			String materia = request.getParameter("materia");
				if(DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(nomeGruppo, materia) == null){
			
					Utente creatore = DAOFactory.getUserDAO().doRetrieveByKey("0512102865");
			
					@SuppressWarnings("deprecation")
					Timestamp inizio = new Timestamp(124, 11, 16, 15, 00, 00, 00);
					@SuppressWarnings("deprecation")
					Timestamp fine = new Timestamp(124, 11, 16, 15, 01, 00, 00);
					Aula aula = DAOFactory.getAulaDAO().doRetrieveByKey((String)request.getParameter("aula"));
			
			
					DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(request.getParameter("nomegruppo"), request.getParameter(""));
			
					nuovo.setNomeGruppo(nomeGruppo);
					nuovo.setCreatore(creatore);
					nuovo.setMateria(materia);
					//prendi ora inizio
					nuovo.setOrario(inizio, fine);
					nuovo.setGiorno();
					//System.out.println("giorno: "+nuovo.getGiorno());
					nuovo.setAula(aula);
					
					//DAOFactory.getGdSDAO().doSave(nuovo);
					
			
					session.setAttribute("esito", true);
				}
				else {
					session.setAttribute("esito", "errore");
			
				}
				request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
			}
		else {
			//messagggio: utente non loggato
		//	session.setAttribute("esito", "errore");
			request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
		}
		}
		
		
	}

