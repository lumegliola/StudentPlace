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
 * Servlet implementation class CreaGds
 */
@WebServlet("/ServletCreaGds")
public class ServletCreaGds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	
    public ServletCreaGds() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();						//
		if(session.getAttribute("logged").equals(true) && session.getAttribute("logged") != null) {
			
			String nomeGruppo = request.getParameter("nomeGruppo");
			String materia = request.getParameter("materia");
			String par_aula= request.getParameter("aula");
			String data=request.getParameter("data");
			String inizio=request.getParameter("inizio");
		    String fine=request.getParameter("fine");
		
		    String data_inizio=data.concat(" "+inizio);
		    String data_fine=data.concat(" "+fine);
		    System.out.println(data_inizio);
				if(DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(nomeGruppo, materia) == null){
					GruppoDiStudio nuovo = new GruppoDiStudio();
					Utente creatore =(Utente) session.getAttribute("utente");
					
					
				   
					SimpleDateFormat sdf;
				     sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				     Date date2=new Date(),date1=new Date();	 
				     try {
					 date1=sdf.parse(data_inizio);
				     date2=sdf.parse(data_fine);	
					} catch (ParseException e) {
						e.printStackTrace();
					}	 		    
				     
					Aula aula = DAOFactory.getAulaDAO().doRetrieveByKey(par_aula);
					
					nuovo.setNomeGruppo(nomeGruppo);
					nuovo.setCreatore(creatore);
					nuovo.setMateria(materia);
					nuovo.setOrario(new Timestamp(date1.getTime()), new Timestamp(date2.getTime()));
					nuovo.setGiorno();
					nuovo.setAula(aula);
					DAOFactory.getGdSDAO().doSave(nuovo);
					session.setAttribute("esito", true);
					request.getRequestDispatcher("/view/OpEffettuata.jsp").forward(request, response);

				}
				else {
					session.setAttribute("esito", "errore");
					request.getRequestDispatcher("/view/errore/errore.jsp").forward(request, response);

			
				}
			}
		else {
			//messagggio: utente non loggato
			session.setAttribute("esito", "errore");
			request.getRequestDispatcher("/view/Homepage/home.jsp").forward(request, response);
		}
		}
		
		
	}

