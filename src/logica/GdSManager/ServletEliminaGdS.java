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
 * Servlet implementation class EliminaGdS
 */
@WebServlet("/EliminaGdS")
public class ServletEliminaGdS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminaGdS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//Controllo esistenza sessione 
		if(session.getAttribute("logged") != null && session.getAttribute("logged").equals(true)) {//Se esiste 
			System.out.println("Inzio if");
					String nomeGruppo = (String) request.getParameter("nomeGruppo");
					String materia = (String) request.getParameter("materia");			        
					GruppoDiStudio gds=DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(nomeGruppo, materia);
					if(gds==null) {//inizo if verifica :se l'oggetto gds non è null allora il gruppo di studio non esiste 
						System.out.println("Gruppo di Studio non esiste!");
						session.setAttribute("esito", "errore");
						request.getRequestDispatcher("/view/errore/Errore.jsp").forward(request, response);
						return;
					}
					
					 String matricolaCreatore=gds.getCreatore().getMatricola();
                     Utente utente=(Utente)session.getAttribute("utente");

					if(utente.getMatricola().equals(matricolaCreatore)) { // se la matricola di chi sta eliminando è uguale a creatore elimina
						System.out.println("Gruppo di Studio viene eliminato dal creatore!");
						boolean deleteIscr=DAOFactory.getIscrizioneDAO().doDeleteByGroup(gds.getId());
						boolean deleteGds=DAOFactory.getGdSDAO().doDeleteByNameAndSubjet(gds.getNomeGruppo(),gds.getMateria());
						if(deleteIscr==false && deleteGds==true) {
							System.out.println("Eliminazione ok");	
						}
						request.getRequestDispatcher("/view/OpEffettuata.jsp").forward(request, response);
					
					}else {//altrimento no
						request.getRequestDispatcher("/view/errore/Errore.jsp").forward(request, response);
					}
					
			}
		else {
			request.getRequestDispatcher("/view/errore/Errore.jsp").forward(request, response);
	}
	}

}
