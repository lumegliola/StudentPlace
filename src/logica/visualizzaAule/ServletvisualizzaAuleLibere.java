package logica.visualizzaAule;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AulaLibera;
import bean.listaAuleLibere;
import dao.DAOFactory;


@WebServlet("/visualizzaAuleLibere")
public class ServletvisualizzaAuleLibere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletvisualizzaAuleLibere() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		
		ArrayList <listaAuleLibere> lista=new ArrayList<>();//crea un arraylist vuoto di aule da caricare e tornare alla jsp di visualizza aule
		List <AulaLibera> elenco = new ArrayList<>();//crea l'elenco da caricare con i risultati nel db
		List <String> giorni= new ArrayList<>();//crea un elenco per controllare i giorni con quelli liberi nel db
		giorni.add("Luned�");
		giorni.add("Marted�");
		giorni.add("Mercoled�");
		giorni.add("Gioved�");
		giorni.add("Venerd�");
		elenco.addAll(DAOFactory.getAulaLiberaDAO().doRetrieveAll());//carica l'elenco delle aule libere
		
		if(session.getAttribute("logged")==null) {//controlla sessione e ne setta gli attributi
			System.out.println("setta attribute");
			session.setAttribute("logged",false);
		}
		
		
		for(int g=0;g<5;g++) {//for che scorre nei 5 gg
			for(int o =10;o<20;o++) {// for che scorre le fasce orarie
		for(int i =0;i<elenco.size();i++) {//for che scorre l'elenco dei risultati tante volte quante sono le fasce orarie
			if(elenco.get(i).getOrario().getGiorno().equals(giorni.get(g))){//controlla se il giorno del primo for corrisponde con quelli nell'elenco
				if((int)elenco.get(i).getOrario().getInizio().getHours()<=o){//controlla l'intervallo se � compreso tra o e o+1
					if((int)elenco.get(i).getOrario().getFine().getHours()>=o+1)
					{
						if(lista.size()!=0) {
						for(int c=0;c <lista.size() ;c++) {//controlla se c'� qualche elemento nella lista da mandare alla jsp e vede se ha trovato aule libere uguali quindi nel caso si ferma
							if(lista.get(c).getNomeaula().equals(elenco.get(i).getAula().getNomeAula()) && lista.get(c).getGiorno().equals(giorni.get(g))	&&lista.get(c).getFasciaoraria()==o-9)
							{
								break;
							}
						}
						}
						listaAuleLibere l= new listaAuleLibere((elenco.get(i).getAula().getNomeAula()),giorni.get(g),(o-9));  //se non trova duplicati aggiunge l'aula all'elenco 
								lista.add(l);	
						}

					}
			}
			}
			}
		}
		session.setAttribute("lista",lista);

		System.out.println(session.getAttribute("lista"));//ritorna l'elenco alla jsp
		System.out.println(session.getAttribute("logged"));
		
		request.getRequestDispatcher("/view/auleliber/aulelibere.jsp").forward(request, response);
	
	
	}


}


