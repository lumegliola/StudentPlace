package logica.orarioManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;

import bean.AulaLibera;
import bean.Orario;
import dao.DAOFactory;

/**
 * Servlet implementation class ServletAulaLibera
 */
@WebServlet("/AulaLibera")
public class ServletAulaLibera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAulaLibera() {
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
		String inizio = request.getParameter("inizio");
		String giorno = request.getParameter("data");
		Timestamp orIn =  Timestamp.valueOf(giorno+" "+inizio+":00:00");
		
	
		
		List<AulaLibera> aule = null;
			 aule = DAOFactory.getAulaLiberaDAO().doRetrieveByDate(orIn);
		
			 //ho ricavato una lista di aule libere a partire dall'orario di inserimento fino alla fine della gioranta scelta
			 
			 //non ho la piu' pallida idea di cosa hai scritto qua sotto
			 //quindi per adesso lascio stare e mi spieghi domani mattina
			 JsonArray arrayObj=new JsonArray();
         arrayObj.addAll((Collection<? extends JsonValue>) aule);
		//response con json
         	PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(arrayObj);
	        out.flush();   
	}

}
