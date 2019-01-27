package logica.GdSManager;

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

import bean.Aula;
import bean.GruppoDiStudio;
import bean.Orario;
import bean.Utente;
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
			HttpSession session = request.getSession();
			//Controllo esistenza sessione 
			
			if(session.getAttribute("logged") != null && (session.getAttribute("logged").equals(true))) {//Se esiste 
						String nomeGruppo = (String)request.getParameter("name");
						String materia = (String) request.getParameter("materia");	
						System.out.println(nomeGruppo+materia);
						String par_aula= request.getParameter("aula");
						int data_inizio=Integer.parseInt(request.getParameter("inizio"));
						int anno=Integer.parseInt(request.getParameter("anno"))-1900;
						int mese=Integer.parseInt(request.getParameter("mese"));
						int giorno=Integer.parseInt(request.getParameter("giorno"));
						int data_fine=Integer.parseInt(request.getParameter("fine"));
					
						String nomeGruppov = (String)request.getParameter("nomeGruppov");
						String materiav = (String) request.getParameter("materiav");	
						System.out.println(nomeGruppov+materiav);
						GruppoDiStudio gds=DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(nomeGruppov, materiav);
						if(gds==null) {//inizo if verifica :se l'oggetto gds non è null allora il gruppo di studio non esiste 
							System.out.println("Gruppo di Studio non esiste!");
							request.getRequestDispatcher("/view/errore/Errore.jsp").forward(request, response);
							return;
						}
						 String matricolaCretore=gds.getCreatore().getMatricola();
	                     Utente utente=(Utente)session.getAttribute("utente");
						if(utente.getMatricola().equals(matricolaCretore)) { // se la matricola di chi sta modificando è uguale a creatore elimina
						
							Aula aula = DAOFactory.getAulaDAO().doRetrieveByKey(par_aula);
							/*SimpleDateFormat sdf;
						     sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						     Date date2=new Date(),date1=new Date();	 
						     try {
							 date1=sdf.parse(data_inizio);
						     date2=sdf.parse(data_fine);	
							} catch (ParseException e) {
								e.printStackTrace();
							}	 		    
							*/
							Timestamp i=new Timestamp(anno,mese,giorno,data_inizio,0,0,0);
							Timestamp f=new Timestamp(anno,mese,giorno,data_inizio,0,0,0);
							gds.setOrario(i, f);
							System.out.println(i.getYear()+i.getMonth()+i.getDay()+i.getHours()+i.getMinutes()+i.getSeconds()+i.getNanos());
							Orario o=new Orario(i,f);
                            DAOFactory.getGdSDAO().doSaveOrUpdate(gds,aula.getNomeAula(), i,f);
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
