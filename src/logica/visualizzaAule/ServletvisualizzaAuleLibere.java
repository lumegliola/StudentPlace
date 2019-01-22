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
		//instanzio stringhe per giorno e fasce orarie
		List <AulaLibera> elenco = new ArrayList<>();
		List <String> lunedi1=  new ArrayList<>();
		List <String> lunedi2=  new ArrayList<>();
		List <String> lunedi3=  new ArrayList<>();
		List <String> lunedi4=  new ArrayList<>();
		List <String> lunedi5=  new ArrayList<>();
		List <String> lunedi6=  new ArrayList<>();
		List <String> lunedi7=  new ArrayList<>();
		List <String> lunedi8=  new ArrayList<>();
		List <String> lunedi9=  new ArrayList<>();
		List <String> lunedi10=  new ArrayList<>();
		List <String> martedi1=  new ArrayList<>();
		List <String> martedi2=  new ArrayList<>();
		List <String> martedi3=  new ArrayList<>();
		List <String> martedi4=  new ArrayList<>();
		List <String> martedi5=  new ArrayList<>();
		List <String> martedi6=  new ArrayList<>();
		List <String> martedi7=  new ArrayList<>();
		List <String> martedi8=  new ArrayList<>();
		List <String> martedi9=  new ArrayList<>();
		List <String> martedi10=  new ArrayList<>();
		List <String> mercoledi1=  new ArrayList<>();
		List <String> mercoledi2=  new ArrayList<>();
		List <String> mercoledi3=  new ArrayList<>();
		List <String> mercoledi4=  new ArrayList<>();
		List <String> mercoledi5=  new ArrayList<>();
		List <String> mercoledi6=  new ArrayList<>();
		List <String> mercoledi7=  new ArrayList<>();
		List <String> mercoledi8=  new ArrayList<>();
		List <String> mercoledi9=  new ArrayList<>();
		List <String> mercoledi10=  new ArrayList<>();
		List <String> venerdi1=  new ArrayList<>();
		List <String> venerdi2=  new ArrayList<>();
		List <String> venerdi3=  new ArrayList<>();
		List <String> venerdi4=  new ArrayList<>();
		List <String> venerdi5=  new ArrayList<>();
		List <String> venerdi6=  new ArrayList<>();
		List <String> venerdi7=  new ArrayList<>();
		List <String> venerdi8=  new ArrayList<>();
		List <String> venerdi9=  new ArrayList<>();
		List <String> venerdi10=  new ArrayList<>();
		List <String> giovedi1=  new ArrayList<>();
		List <String> giovedi2=  new ArrayList<>();
		List <String> giovedi3=  new ArrayList<>();
		List <String> giovedi4=  new ArrayList<>();
		List <String> giovedi5=  new ArrayList<>();
		List <String> giovedi6=  new ArrayList<>();
		List <String> giovedi7=  new ArrayList<>();
		List <String> giovedi8=  new ArrayList<>();
		List <String> giovedi9=  new ArrayList<>();
		List <String> giovedi10=  new ArrayList<>();
//vengono presi tutte le aule libere nel db
		elenco.addAll(DAOFactory.getAulaLiberaDAO().doRetrieveAll());
		//per ogni metodo sottostante , viene scorso l'elenco delle aule e controllato giorno e ora di inizio/fine
		for(int i =0;i<elenco.size();i++) {
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=10){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
					{
						for(int c=0;c <lunedi1.size() ;c++) {
							if(lunedi1.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
								lunedi1.add(elenco.get(i).getAula().getNomeAula());


							

						}

					}

					
				}
			
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=11){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
					{
						for(int c=0;c <lunedi2.size() ;c++) {
							if(lunedi2.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								lunedi2.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=12){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
					{
						for(int c=0;c <lunedi3.size() ;c++) {
							if(lunedi3.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								lunedi3.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=13){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
					{
						for(int c=0;c <lunedi4.size() ;c++) {
							if(lunedi4.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								lunedi4.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=14){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
					{
						for(int c=0;c <lunedi5.size() ;c++) {
							if(lunedi5.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								lunedi5.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=15){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
					{
						for(int c=0;c <lunedi6.size() ;c++) {
							if(lunedi6.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								lunedi6.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=16){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
					{
						for(int c=0;c <lunedi7.size() ;c++) {
							if(lunedi7.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								lunedi7.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=17){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
					{
						for(int c=0;c <lunedi8.size() ;c++) {
							if(lunedi8.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								lunedi8.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=18){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
					{
						for(int c=0;c <lunedi9.size() ;c++) {
							if(lunedi9.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								lunedi9.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Lunedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=19){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=20)
					{
						for(int c=0;c <lunedi10.size() ;c++) {
							if(lunedi10.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								lunedi10.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
		}
		for(int i =0;i<elenco.size();i++) {
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=10){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
					{
						for(int c=0;c <martedi1.size() ;c++) {
							if(martedi1.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
							
								martedi1.add(elenco.get(i).getAula().getNomeAula());


							}

						}

					}

					
				}
			
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=11){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
					{
						for(int c=0;c <martedi2.size() ;c++) {
							if(martedi2.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								martedi2.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=12){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
					{
						for(int c=0;c <martedi3.size() ;c++) {
							if(martedi3.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								martedi3.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=13){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
					{
						for(int c=0;c <martedi4.size() ;c++) {
							if(martedi4.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								martedi4.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=14){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
					{
						for(int c=0;c <martedi5.size() ;c++) {
							if(martedi5.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								martedi5.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=15){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
					{
						for(int c=0;c <martedi6.size() ;c++) {
							if(martedi6.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								martedi6.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=16){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
					{
						for(int c=0;c <martedi7.size() ;c++) {
							if(martedi7.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								martedi7.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=17){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
					{
						for(int c=0;c <martedi8.size() ;c++) {
							if(martedi8.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								martedi8.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=18){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
					{
						for(int c=0;c <martedi9.size() ;c++) {
							if(martedi9.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								martedi9.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Martedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=19){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=20)
					{
						for(int c=0;c <martedi10.size() ;c++) {
							if(martedi10.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								martedi10.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
		}
		
		
		for(int i =0;i<elenco.size();i++) {
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=10){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
					{
						for(int c=0;c <lunedi1.size() ;c++) {
							if(mercoledi1.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
							
								mercoledi1.add(elenco.get(i).getAula().getNomeAula());


							}

						}

					}

					
				}
			
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=11){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
					{
						for(int c=0;c <mercoledi2.size() ;c++) {
							if(mercoledi2.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								mercoledi2.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=12){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
					{
						for(int c=0;c <mercoledi3.size() ;c++) {
							if(mercoledi3.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								mercoledi3.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=13){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
					{
						for(int c=0;c <mercoledi4.size() ;c++) {
							if(mercoledi4.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								mercoledi4.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=14){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
					{
						for(int c=0;c <mercoledi5.size() ;c++) {
							if(mercoledi5.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								mercoledi5.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=15){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
					{
						for(int c=0;c <mercoledi6.size() ;c++) {
							if(mercoledi6.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								mercoledi6.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=16){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
					{
						for(int c=0;c <mercoledi7.size() ;c++) {
							if(mercoledi7.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								mercoledi7.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=17){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
					{
						for(int c=0;c <mercoledi8.size() ;c++) {
							if(mercoledi8.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								mercoledi8.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=18){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
					{
						for(int c=0;c <mercoledi9.size() ;c++) {
							if(mercoledi9.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								mercoledi9.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Mercoledì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=19){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=20)
					{
						for(int c=0;c <mercoledi10.size() ;c++) {
							if(mercoledi10.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								mercoledi10.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
		}
		
		
		
		
		
		for(int i =0;i<elenco.size();i++) {
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=10){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
					{
						for(int c=0;c <giovedi1.size() ;c++) {
							if(giovedi1.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
							
								giovedi1.add(elenco.get(i).getAula().getNomeAula());


							}

						}

					}

					
				}
			
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=11){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
					{
						for(int c=0;c <giovedi2.size() ;c++) {
							if(giovedi2.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								giovedi2.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=12){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
					{
						for(int c=0;c <giovedi3.size() ;c++) {
							if(giovedi3.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								giovedi3.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=13){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
					{
						for(int c=0;c <giovedi4.size() ;c++) {
							if(giovedi4.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								giovedi4.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=14){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
					{
						for(int c=0;c <giovedi5.size() ;c++) {
							if(giovedi5.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								giovedi5.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=15){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
					{
						for(int c=0;c <giovedi6.size() ;c++) {
							if(giovedi6.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								giovedi6.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=16){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
					{
						for(int c=0;c <giovedi7.size() ;c++) {
							if(giovedi7.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								giovedi7.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=17){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
					{
						for(int c=0;c <giovedi8.size() ;c++) {
							if(giovedi8.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								giovedi8.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=18){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
					{
						for(int c=0;c <giovedi9.size() ;c++) {
							if(giovedi9.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								giovedi9.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Giovedì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=19){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=20)
					{
						for(int c=0;c <giovedi10.size() ;c++) {
							if(giovedi10.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								giovedi10.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
		}
		
		
		
		
		
		for(int i =0;i<elenco.size();i++) {
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=10){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=11)
					{
						for(int c=0;c <venerdi1.size() ;c++) {
							if(venerdi1.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
							
								venerdi1.add(elenco.get(i).getAula().getNomeAula());


							}

						}

					}

					
				}
			
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=11){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=12)
					{
						for(int c=0;c <venerdi2.size() ;c++) {
							if(venerdi2.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								venerdi2.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=12){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=13)
					{
						for(int c=0;c <venerdi3.size() ;c++) {
							if(venerdi3.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								venerdi3.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=13){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=14)
					{
						for(int c=0;c <venerdi4.size() ;c++) {
							if(venerdi4.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								venerdi4.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=14){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=15)
					{
						for(int c=0;c <venerdi5.size() ;c++) {
							if(venerdi5.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								venerdi5.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=15){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=16)
					{
						for(int c=0;c <venerdi6.size() ;c++) {
							if(venerdi6.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								venerdi6.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=16){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=17)
					{
						for(int c=0;c <venerdi7.size() ;c++) {
							if(venerdi7.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								venerdi7.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=17){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=18)
					{
						for(int c=0;c <venerdi8.size() ;c++) {
							if(venerdi8.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								venerdi8.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=18){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=19)
					{
						for(int c=0;c <venerdi9.size() ;c++) {
							if(venerdi9.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								venerdi9.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
			if(elenco.get(i).getOrario().getGiorno().equals("Venerdì")){


				if((int)elenco.get(i).getOrario().getInizio().getHours()<=19){

					if((int)elenco.get(i).getOrario().getFine().getHours()>=20)
					{
						for(int c=0;c <venerdi10.size() ;c++) {
							if(venerdi10.get(c).equals(elenco.get(i).getAula().getNomeAula())	)
							{
								break;
							}
						}
							
								venerdi10.add(elenco.get(i).getAula().getNomeAula());


						

					}

					
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		request.setAttribute("lunedi1",lunedi1);
		request.setAttribute("lunedi2",lunedi2);
		request.setAttribute("lunedi3",lunedi3);
		request.setAttribute("lunedi4",lunedi4);
		request.setAttribute("lunedi5",lunedi5);
		request.setAttribute("lunedi6",lunedi6);
		request.setAttribute("lunedi7",lunedi7);
		request.setAttribute("lunedi8",lunedi8);
		request.setAttribute("lunedi9",lunedi9);
		request.setAttribute("lunedi10",lunedi10);
		request.setAttribute("martedi1",martedi1);
		request.setAttribute("martedi2",martedi2);
		request.setAttribute("martedi3",martedi3);
		request.setAttribute("martedi4",martedi4);
		request.setAttribute("martedi5",martedi5);
		request.setAttribute("martedi6",martedi6);
		request.setAttribute("martedi7",martedi7);
		request.setAttribute("martedi8",martedi8);
		request.setAttribute("martedi9",martedi9);
		request.setAttribute("martedi10",lunedi10);
		request.setAttribute("mercoledi1",mercoledi1);
		request.setAttribute("mercoledi2",mercoledi2);
		request.setAttribute("mercoledi3",mercoledi3);
		request.setAttribute("mercoledi4",mercoledi4);
		request.setAttribute("mercoledi5",mercoledi5);
		request.setAttribute("mercoledi6",mercoledi6);
		request.setAttribute("mercoledi7",mercoledi7);
		request.setAttribute("mercoledi8",mercoledi8);
		request.setAttribute("mercoledi9",mercoledi9);
		request.setAttribute("mercoledi10",mercoledi10);
		request.setAttribute("venerdi1",venerdi1);
		request.setAttribute("venerdi2",venerdi2);
		request.setAttribute("venerdi3",venerdi3);
		request.setAttribute("venerdi4",venerdi4);
		request.setAttribute("venerdi5",venerdi5);
		request.setAttribute("venerdi6",venerdi6);
		request.setAttribute("venerdi7",venerdi7);
		request.setAttribute("venerdi8",venerdi8);
		request.setAttribute("venerdi9",venerdi9);
		request.setAttribute("venerdi10",venerdi10);
		request.setAttribute("giovedi1",giovedi1);
		request.setAttribute("giovedi2",giovedi2);
		request.setAttribute("giovedi3",giovedi3);
		request.setAttribute("giovedi4",giovedi4);
		request.setAttribute("giovedi5",giovedi5);
		request.setAttribute("giovedi6",giovedi6);
		request.setAttribute("giovedi7",giovedi7);
		request.setAttribute("giovedi8",giovedi8);
		request.setAttribute("giovedi9",giovedi9);
		request.setAttribute("giovedi10",giovedi10);
		RequestDispatcher view = request.getRequestDispatcher("view/aulelibere/aulelibere.jsp");
		view.forward(request, response);



	}


}


