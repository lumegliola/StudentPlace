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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//solo l`amministratore può inserire un orario
		if(session != null && session.getAttribute("admin").equals(true)){
			SimpleDateFormat sdf;
		     sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     Date date2=new Date(),date1=new Date();	 
		     try {
			 date1=sdf.parse(request.getParameter("inizio"));
		     date2=sdf.parse(request.getParameter("fine"));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 		    
			Orario or = new Orario();
			or.setInizio(new Timestamp(date1.getTime()));
			or.setFine(new Timestamp(date2.getTime()));
			//controlla che l`orario non sia presente
			Orario controllo = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(or.getInizio(), or.getFine());
			if(controllo.getInizio() != null && controllo.getFine()!=null) {
				System.out.println("Orario già presente!");
				session.setAttribute("esito", "errore");
			}
			else {
				DAOFactory.getOrarioDAO().doSave(or);
				System.out.println("Orario inserito dall`amministratore");
				session.setAttribute("esito", "ok");
				request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);;
			}
			
		}else {
			session.setAttribute("esito", "errore");
			request.getRequestDispatcher("ProvaOutput.jsp");
		}
	}

}
