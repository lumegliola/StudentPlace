package logica.orarioManager;

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
import bean.AulaLibera;
import bean.Orario;
import dao.DAOFactory;

/**
 * Servlet implementation class inserisciOrario
 */
@WebServlet("/inserisciOrario")
public class ServletInserisciOrario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInserisciOrario() {
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
		// Prende i parametri in input
		HttpSession session = request.getSession();
		String par_aula= request.getParameter("aula");
		String data=request.getParameter("data");
		
		String inizio=request.getParameter("inizio");
		
	    String fine=request.getParameter("fine");
	    
	    Aula a=new Aula();
	    String nomeaula=par_aula.substring(0, 2);
	    String nomeedificio=par_aula.substring(2, 4);
	    a.setEdificio(nomeedificio);
		a.setNomeAula(nomeaula);
	    System.out.println(inizio+"fine"+fine);
	    String data_inizio=data.concat(" "+inizio);
	    data_inizio.concat(":00:00");
	    
	    String data_fine=data.concat(" "+fine);
	    data_fine.concat(":00:00");
	    System.out.println(data_inizio+"data fine"+data_fine);
	    
		//solo l`amministratore può inserire un orario
		if(session.getAttribute("logged").equals(true)  && session.getAttribute("admin").equals(true)){
			SimpleDateFormat sdf;
		     sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		     Date date2=new Date(),date1=new Date();	 
		     try {
			 date1=sdf.parse(data_inizio);
		     date2=sdf.parse(data_fine);	
			} catch (ParseException e) {
				e.printStackTrace();
			}	 		    		    
			Orario or = new Orario();
			System.out.println(date1 +"la data passata è "+data);
			or.setInizio(new Timestamp(date1.getTime()));
			or.setFine(new Timestamp(date2.getTime()));
			or.getInizio().setYear(119);
			or.getFine().setYear(119);
			
			//controlla che l`orario non sia presente
			Orario controllo = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(or.getInizio(), or.getFine());
			if(controllo.getInizio() != null && controllo.getFine()!=null) {
				System.out.println("Orario già presente!");
				System.out.println("intervallo Orario inserito precedentemente dall`amministratore");
				
				
				
			
				System.out.println(controllo.getIdOrario()+controllo.getGiorno());
				System.out.println(controllo.getInizio()+"l'inizio è");
				 
				 AulaLibera aula=new AulaLibera();
				 System.out.println("l'aula è "+a.getNomeAula()+"l'edificio è"+a.getEdificio());
				 //vostruisce l'aula
				 aula.setOrario(controllo);
				 aula.setAula(a);
				
				 //salva l'aula
				DAOFactory.getAulaLiberaDAO().doSave(aula);
				session.setAttribute("esito", true);
				 request.getRequestDispatcher("GestioneOrario").forward(request, response);
				
			
			}
			
			
			//se non trova l'orario
			else {
				DAOFactory.getOrarioDAO().doSave(or);//se non trova l'orario ne db lo salva e poi salva l'aula
				
				System.out.println("Orario inserito dall`amministratore");
				
				
				Orario controllo2 = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(or.getInizio(),or.getFine());
				if(controllo2!=null) {
				System.out.println(controllo2.getIdOrario()+controllo2.getGiorno());
				System.out.println(controllo2.getInizio()+"l'inizio è");
				 
				 AulaLibera aula=new AulaLibera();
				 System.out.println("l'aula è "+a.getNomeAula()+"l'edificio è"+a.getEdificio());
				
				 
				 //costruisce l'aula
				 aula.setOrario(controllo2);
				 aula.setAula(a);
				//salva l'aula
				 DAOFactory.getAulaLiberaDAO().doSave(aula);
					session.setAttribute("esito", true);
					 request.getRequestDispatcher("GestioneOrario").forward(request, response);
				
			}else {
				session.setAttribute("esito", "errore");
				request.getRequestDispatcher("view/errore/Errore.jsp").forward(request, response);
			}
				
			}
			
		}
		
		//se tutto va male da errore
		else {
			session.setAttribute("esito", "errore");
			request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
		}
	}

}
