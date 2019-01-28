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
	String inizio = request.getParameter("inizio");
	String giorno = request.getParameter("data");
	String data=giorno.concat(" "+inizio.concat(":00:00"));
    SimpleDateFormat sdf;
    sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date2=new Date(),date1=new Date();	 
    try {
	 date1=sdf.parse(data);	
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
    Timestamp orIn = new  Timestamp(date1.getTime());
	
	System.out.println(data);
		
	      List<AulaLibera> aule = DAOFactory.getAulaLiberaDAO().doRetrieveByDate(orIn);
		
			 //ho ricavato una lista di aule libere a partire dall'orario di inserimento fino alla fine della gioranta scelta
			 
			 //non ho la piu' pallida idea di cosa hai scritto qua sotto
			 //quindi per adesso lascio stare e mi spieghi domani mattina
			
		//response con json String objectToReturn = "{ key1: 'value1', key2: 'value2' }";
           String objectReturn="[{\"nome\":\"Alessandro\",\"cognome\":\"Capodanno\"},"
           		+ "{\"nome\":\"Pasquale\",\"cognome\":\"O'pegg\"}]";
            
         	PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.append("[");
		      List<AulaLibera> naule = new ArrayList<AulaLibera>();
              List<Integer> listaIndice=new ArrayList<Integer>();
              List<Integer> listaIncrementi=new ArrayList<Integer>();
	        //Capire orario se è consecutivo
	       for(int i=0;i<aule.size();i++) {
	    	   int j=0,k=0;
              if(i+1>=aule.size()) {
            	  break;
              }
	    	  if(aule.get(i).getAula().getNomeAula().equals(aule.get(i+1).getAula().getNomeAula())){
	    		  System.out.println("Entro primo controllo");
	    		 if( aule.get(i).getOrario().getFine().getHours()==aule.get(i+1).getOrario().getInizio().getHours()){
	    			 System.out.println(aule.get(i).getOrario().getInizio());
	    			 System.out.println(aule.get(i+1).getOrario().getInizio());
	    			 listaIndice.add(i+1);
		               j=j+1;
	    		 }else {
	    			 j=0;
	    		 }
	    	  }
	    	   
	       }
	        
	        System.out.println(aule.size());
	     for(int i=0;i<listaIndice.size();i++) {
	    	aule.remove(listaIndice.get(i));
	    	
	     }
	     for(int i=0;i<aule.size();i++) {
		    	System.out.println(aule.get(i));
		     }
	        
	        for(int i=0;i<aule.size();i++) {
	        	out.append("{"
	        			+ "\"aula\":\""+aule.get(i).getAula().getNomeAula()+"\","
	        			+ "\"giorno\":\""+aule.get(i).getGiorno()+"\","
	        			+ "\"id\":\""+i+"\","
    					+ "\"inizio\":\""+(aule.get(i).getOrario().getInizio().getHours()-1)+"\","
    				    + "\"fine\":\""+(aule.get(i).getOrario().getFine().getHours()-1)+"\""
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
