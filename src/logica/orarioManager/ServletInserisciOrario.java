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
		int settimane=Integer.parseInt(request.getParameter("settimane"));
		String inizio=request.getParameter("inizio");
		
	    String fine=request.getParameter("fine");
	    String tuttasettimana=request.getParameter("tuttasettimana");
	    int tsettimana;
	    Aula a=new Aula();
	    //salva sia nome aula che edificio relativo
	    String nomeaula=par_aula.substring(0, par_aula.length()/2);
	    String nomeedificio=par_aula.substring(par_aula.length()/2, par_aula.length());
	    
	    String giorno =data.substring(8, 10);
	    System.out.println("leggi qui cazzo guarda come � fatto"+data);
	    System.out.println("leggi qui cazzo guarda come � fatto"+giorno);
	    int giornodaaumentare=Integer.parseInt(giorno);
	    System.out.println("leggi qui cazzo guarda come � fatto"+giornodaaumentare);
	
	    //crea l'aula da aggiungere
	    a.setEdificio(nomeedificio);
		a.setNomeAula(nomeaula);
		//debug
	    System.out.println(inizio+"fine"+fine);
	    //crea la stringa da inserire nel timestamp
	    String data_inizio=data.concat(" "+inizio);
	    //aggiunge 0 mancanti timestamp
	    data_inizio.concat(":00:00");
	    //stesso sopra
	    String data_fine=data.concat(" "+fine);
	    data_fine.concat(":00:00");
	    //debug
	    System.out.println(data_inizio+"data fine"+data_fine);
	    if(tuttasettimana.equals("si")) {
	    	tsettimana=7;
	    }
	    else {
	    	tsettimana=1;
	    }
		//solo l`amministratore pu� inserire un orario
		if(session.getAttribute("logged").equals(true)  && session.getAttribute("admin").equals(true)){
			SimpleDateFormat sdf;
		     sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		     Date date2=new Date(),date1=new Date();	 
		     try {
			 date1=sdf.parse(data_inizio);
		     date2=sdf.parse(data_fine);	
			} catch (ParseException e) {
				e.printStackTrace();
			}	 	//fino a qui converte i dati presi in input	    		    
			Orario or = new Orario();
			System.out.println(date1 +"la data passata � "+data);
			//vengono usati i dati convertiti prima per creare timestamp
			or.setInizio(new Timestamp(date1.getTime()));
			or.setFine(new Timestamp(date2.getTime()));
			//viene settato  l'anno 119perche nel bean viene autmaticamente aggiunto 1900 per motivi relativi al timestamp
			or.getInizio().setYear(119);
			or.getFine().setYear(119);
			Orario orsett=new Orario();
			orsett.setInizio(or.getInizio());
			orsett.setFine(or.getFine());
			int settimaneiniziali=settimane;
			int giornoiniziale=giornodaaumentare;
			
		
			//controlla che l`orario non sia presente
			for(int o=0;o<tsettimana;o++) {
			for(int j =0;j<settimane;j++) {
			Orario controllo = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(or.getInizio(), or.getFine());
			 int giornimassimi;
			 if(or.getInizio().getMonth()==10||or.getInizio().getMonth()==3||or.getInizio().getMonth()==5||or.getInizio().getMonth()==8) {
				 giornimassimi=30;
			 }
			 else  if(or.getInizio().getMonth()==1) {
				 giornimassimi=28;
			 }
			 else {
				 giornimassimi=31;
			 }
		
				if(controllo.getInizio() != null && controllo.getFine()!=null) {
					System.out.println("Orario gia presente");
					
					
				}
				else {
					or.getInizio().setYear(119);
					or.getFine().setYear(119);
				DAOFactory.getOrarioDAO().doSave(or);//se non trova l'orario ne db lo salva e poi salva l'aula
				System.out.println("Orario inserito ");
				
				}
				
				
				Orario controllo2 = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(or.getInizio(),or.getFine());
				if(controllo2!=null) {
				System.out.println(controllo2.getIdOrario()+controllo2.getGiorno());
				System.out.println(controllo2.getInizio()+"l'inizio �");
				 
				 AulaLibera aula=new AulaLibera();
				 System.out.println("l'aula � "+a.getNomeAula()+"l'edificio �"+a.getEdificio());
				
				 
				 //costruisce l'aula
				 aula.setOrario(controllo2);
				 aula.setAula(a);
				//salva l'aulai
				
				 System.out.println("   ");
				 System.out.println("   ");
				 System.out.println("   ");
				 System.out.println("giornimassimi  il mese � "+giornimassimi+controllo2.getInizio().getMonth());
				 System.out.println("   ");
				 System.out.println("   ");
				 System.out.println("   ");
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 if((giornodaaumentare+7)<=giornimassimi) {
					 giornodaaumentare=giornodaaumentare+7;
				 }
				 else {
					
					 int app=7;
					 app-=giornimassimi-giornodaaumentare;
					 giornodaaumentare=app;
					
					 
					 or.getInizio().setMonth(or.getInizio().getMonth()+1);
					 or.getFine().setMonth(or.getFine().getMonth()+1);
				 }
				 DAOFactory.getAulaLiberaDAO().doSave(aula);
					session.setAttribute("esito", true);
					or.getInizio().setDate(giornodaaumentare);
					or.getFine().setDate(giornodaaumentare);
					System.out.println("");
					System.out.println("nuova data inizio"+or.getInizio());
					System.out.println("nuova data fine "+ or.getFine());
			}else {
				session.setAttribute("esito", "errore");
				request.getRequestDispatcher("view/errore/Errore.jsp").forward(request, response);
			}
				
			
			
		} 
			giornoiniziale++;
			giornodaaumentare=giornoiniziale;
			settimane=settimaneiniziali;
			orsett.getInizio().setDate(giornodaaumentare);
			orsett.getFine().setDate(giornodaaumentare);
			or.setInizio(orsett.getInizio());
			or.setFine(orsett.getFine());
			
			
			}
			request.getRequestDispatcher("GestioneOrario").forward(request, response);
		}
		
		//se tutto va male da errore
		else {
			session.setAttribute("esito", "errore");
			request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
		}
	}

}
