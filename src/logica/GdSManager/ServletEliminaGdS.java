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
		HttpSession session = request.getSession(false);
		//Controllo esistenza sessione 
		if(session != null && session.getAttribute("logged") != null) {//Se esiste 
			System.out.println("Inzio if");
					String nomeGruppo = "Gruppo di is";
					String materia = "Ingegneria Del software";
								        
					GruppoDiStudio gds=DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(nomeGruppo, materia);
					if(gds==null) {//inizo if verifica :se l'oggetto gds non è null allora il gruppo di studio non esiste 
						System.out.println("Gruppo di Studio non esiste!");
						session.setAttribute("esito", "errore");
						getServletContext().getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
						return;
					}
					 String matricolaCretore=gds.getCreatore().getMatricola();
                     String matricola=(String)session.getAttribute("matricola");

					if(matricola.equals(matricolaCretore)) { // se la matricola di chi sta eliminando è uguale a creatore elimina
						System.out.println("Gruppo di Studio viene eliminato dal creatore!");

						DAOFactory.getGdSDAO().doDeleteByNameAndSubjet(gds.getNomeGruppo(),gds.getMateria());
						session.setAttribute("esito","ok");
					    getServletContext().getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
					}else {//altrimento no
						session.setAttribute("esito", "errore");
						getServletContext().getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
						
					}
					
					
				
			}
		else {
			System.out.println("Inizio Else");
			//messagggio: utente non loggato
			session=request.getSession(true);
			session.setAttribute("esito", "errore");
			getServletContext().getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
		}
	}

}
