package logica.orarioManager;

import java.io.IOException;
import java.sql.Time;
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

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.CalendarConversion;

import bean.Orario;
import dao.DAOFactory;

/**
 * Servlet implementation class ModificaOrario
 */
@WebServlet("/ModificaOrario")
public class ServletModificaOrario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificaOrario() {
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//solo l`amministratore pu� inserire un orario
		if(session != null ) {
			if(  ((boolean)session.getAttribute("admin")==true)){
			System.out.println("Amministratore");
			Orario modOr= DAOFactory.getOrarioDAO().doRetrieveByKey(Integer.parseInt(request.getParameter("id")));
			Orario or = new Orario();
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
		     
				 
				 
				 
		//	System.out.println(date1.getTime()+date1.toString());
			or.setInizio(new Timestamp(date1.getTime()));
			or.setFine(new Timestamp(date2.getTime()));

			System.out.println(or.getInizio());
		 // System.out.println(or.getFine());
			Timestamp dat1= new Timestamp(or.getInizio().getYear()+1900, or.getInizio().getMonth(),  or.getInizio().getDay(),  or.getInizio().getHours(),  or.getInizio().getMinutes(),or.getInizio().getSeconds(), or.getInizio().getNanos());
			Timestamp dat2=new Timestamp(or.getFine().getYear()+1900, or.getFine().getMonth(),  or.getFine().getDay(),  or.getFine().getHours(),  or.getFine().getMinutes(),or.getFine().getSeconds(), or.getFine().getNanos());
			System.out.println(dat1.toString() +" "+dat2.toString());
		    DAOFactory.getOrarioDAO().doSaveOrUpdate(modOr, or.getInizio(),or.getFine());
			request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);;

			}else {
			System.out.println("Non Amministratore");
			session.setAttribute("esito", "errore");
			request.getRequestDispatcher("ProvaOutput.jsp");
			}	
		}
	}

}
