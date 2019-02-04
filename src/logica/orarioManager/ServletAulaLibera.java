package logica.orarioManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
		System.out.println("dvr");
	String inizio = request.getParameter("inizio");
	String fine = request.getParameter("fine");

	String giorno = request.getParameter("data");
	String data=giorno.concat(" "+inizio.concat(":00:00"));
    SimpleDateFormat sdf;
    sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date2=new Date(),date1=new Date();	 
    try {
	 date1=sdf.parse(data);	
	 date2=sdf.parse(data);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
    	Timestamp orIn = new  Timestamp(date1.getTime());
    	Timestamp orFine = new  Timestamp(date2.getTime());
			System.out.println(data);
		
	      List<AulaLibera> naule = DAOFactory.getAulaLiberaDAO().doRetrieveAll();
	      List<AulaLibera> aule = new ArrayList<AulaLibera>();

              for (int i=0;i<naule.size();i++) {
            	  
        		  
            	  if(naule.get(i).getOrario().getInizio().getYear() == orIn.getYear() &&
            			  naule.get(i).getOrario().getInizio().getMonth() == orIn.getMonth()&&
            			  naule.get(i).getOrario().getInizio().getDate() == orIn.getDate()&&
            			  naule.get(i).getOrario().getInizio().getHours() <= orIn.getHours()&&
            			  naule.get(i).getOrario().getFine().getHours() >= orFine.getHours()) {
            		
            		  System.out.println(naule.get(i).getOrario().getInizio()+"|"+naule.get(i).getOrario().getFine());
            		  aule.add(naule.get(i));
            		  
            	  }
            	  
            	  
            	  
            	  
            	  
            	  
              }		    
			 //ho ricavato una lista di aule libere a partire dall'orario di inserimento fino alla fine della gioranta scelta
	
         	PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.append("[");	        
	        for(int i=0;i<aule.size();i++) {
	        	out.append("{"
	        			+ "\"aula\":\""+aule.get(i).getAula().getNomeAula()+"\","
	        			+ "\"giorno\":\""+aule.get(i).getGiorno()+"\","
	        			+ "\"id\":\""+i+"\","
    					+ "\"inizio\":\""+(orIn.getHours())+1+"\","
    				    + "\"fine\":\""+(orFine.getHours()-1)+"\""
    					+ "}");
	        	if(i<aule.size()-1) {
	        		out.append(",");
	        	}
	        }
	        out.append("]");
	        //out.flush();
	        //out.close();
	}
	

}
