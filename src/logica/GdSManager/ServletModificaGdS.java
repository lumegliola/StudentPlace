package logica.GdSManager;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GruppoDiStudio;
import dao.DAOFactory;

/**
 * Servlet implementation class ModificaGdS
 */
@WebServlet("/ModificaGdS")
public class ServletModificaGdS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificaGdS() {
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
		// TODO Auto-generated method stub
			System.out.println("Funziona");	
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
							request.getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
							return;
						}
						 String matricolaCretore=gds.getCreatore().getMatricola();
	                     String matricola=(String)session.getAttribute("matricola");
                        System.out.println("matricola"+matricola +" & matricola"+matricolaCretore );
						if(matricola.equals(matricolaCretore)) { // se la matricola di chi sta modificando è uguale a creatore elimina
							System.out.println("Gruppo di Studio viene modificato dal creatore!");
                            DAOFactory.getGdSDAO().doSaveOrUpdate(gds, "F8", new Timestamp(118,10,23, 15,0,0,0),new Timestamp (118,10,23, 16,0,0,0));
							
							session.setAttribute("esito","ok");
						    request.getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
						     return;
						}else {//altrimento no
							session.setAttribute("esito", "errore");
							request.getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
							return;
							
						}
						
						
					
				}
			else {
				System.out.println("Inizio Else");
				//messagggio: utente non loggato
				session=request.getSession(true);
				session.setAttribute("esito", "errore");
				request.getRequestDispatcher("/view/ProvaOutput.jsp").forward(request, response);
				return;
			}		
	
	
	}

}
