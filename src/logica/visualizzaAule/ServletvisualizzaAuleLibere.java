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
		
		ArrayList <listaAuleLibere> lista=new ArrayList<>();
		List <AulaLibera> elenco = new ArrayList<>();
		List <String> giorni= new ArrayList<>();
		giorni.add("Lunedì");
		giorni.add("Martedì");
		giorni.add("Mercoledì");
		giorni.add("Giovedì");
		giorni.add("Venerdì");
		elenco.addAll(DAOFactory.getAulaLiberaDAO().doRetrieveAll());
		
		if(session.getAttribute("logged")==null) {
			System.out.println("setta attribute");
			session.setAttribute("logged",false);
		}
		
		
		for(int g=0;g<5;g++) {
			for(int o =10;o<20;o++) {
		for(int i =0;i<elenco.size();i++) {
			if(elenco.get(i).getOrario().getGiorno().equals(giorni.get(g))){
				if((int)elenco.get(i).getOrario().getInizio().getHours()<=o){
					if((int)elenco.get(i).getOrario().getFine().getHours()>=o+1)
					{
						if(lista.size()!=0) {
						for(int c=0;c <lista.size() ;c++) {
							if(lista.get(c).getNomeaula().equals(elenco.get(i).getAula().getNomeAula()) && lista.get(c).getGiorno().equals(giorni.get(g))	&&lista.get(c).getFasciaoraria()==o-9)
							{
								break;
							}
						}
						}
						listaAuleLibere l= new listaAuleLibere((elenco.get(i).getAula().getNomeAula()),giorni.get(g),(o-9));
								lista.add(l);	
						}

					}
			}
			}
			}
		}
		session.setAttribute("lista",lista);

		System.out.println(session.getAttribute("lista"));
		System.out.println(session.getAttribute("logged"));
		
		request.getRequestDispatcher("/view/auleliber/aulelibere.jsp").forward(request, response);
	
	
	}


}


