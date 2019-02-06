package controller.GdSManager;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Aula;
import model.bean.GruppoDiStudio;
import model.bean.Orario;
import model.bean.Utente;
import model.dao.DAOFactory;

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
			HttpSession session = request.getSession();
			//Controllo esistenza sessione 
			
			if(session.getAttribute("logged") != null && (session.getAttribute("logged").equals(true))) {//Se esiste 
				String nomeGruppo = (String)request.getParameter("nomeGruppo");
				String materia = (String) request.getParameter("materia");			        
				GruppoDiStudio gds=DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(nomeGruppo, materia);
						
						if(gds==null) {//inizo if verifica :se l'oggetto gds non è null allora il gruppo di studio non esiste 
							System.out.println("Gruppo di Studio non esiste!");
							request.getRequestDispatcher("/view/errore/Errore.jsp").forward(request, response);
							return;
						}
						 String matricolaCretore=gds.getCreatore().getMatricola();
	                     Utente utente=(Utente)session.getAttribute("utente");
						if(utente.getMatricola().equals(matricolaCretore)) { // se la matricola di chi sta modificando è uguale a creatore elimina
						
							String data_inizio=request.getParameter("inizio");
							String data_fine=request.getParameter("fine");
							String nuova_aula = request.getParameter("aula");
							SimpleDateFormat sdf;
							
						     sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						     Date date2=new Date(),date1=new Date();	 
						     try {
							 date1=sdf.parse(data_inizio);
						     date2=sdf.parse(data_fine);	
							} catch (ParseException e) {
								e.printStackTrace();
							}	 		    
						   request.setAttribute("redirect", "profilo");
						    request.getRequestDispatcher("/view/Opeffettuata.jsp").forward(request, response);
						     return;
						}else {//altrimento no
							request.getRequestDispatcher("/view/errore/Errore.jsp ").forward(request, response);
							return;
							
						}
						
						
					
				}
			else {
				System.out.println("Inizio Else");
				//messagggio: utente non loggato
				session=request.getSession(true);
				session.setAttribute("esito", "errore");
				request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
				return;
			}		
	
	
	}

}
