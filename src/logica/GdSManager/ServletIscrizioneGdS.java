package logica.GdSManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import bean.*;
/**
 * Servlet implementation class IscrizioneGdS
 */
@WebServlet("/IscrizioneGdS")
public class ServletIscrizioneGdS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletIscrizioneGdS() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.println("Funziona");
			HttpSession session=request.getSession(false);
			int idGds=1;
			String matricola="0512101769";
			if(session!=null) {
				System.out.println("Inizio if");
				Utente user=DAOFactory.getUserDAO().doRetrieveByKey(matricola);
				GruppoDiStudio gds=DAOFactory.getGdSDAO().doRetrieveById(idGds);
				if(user==null || gds==null) {
					session.setAttribute("esito", "errore");
					request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
					return;	
				}
				Iscrizione iscrizione=new Iscrizione(user,gds);
				
				DAOFactory.getIscrizioneDAO().doSave(iscrizione);
				
				session.setAttribute("esito", "ok");
				request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
				return;
				
			}else {
				System.out.println("Inizio Else");
				//messagggio: utente non loggato
				session=request.getSession(true);
				session.setAttribute("esito", "errore");
				request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
				return;
			}

	}

}
