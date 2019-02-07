package controller.orarioManager;

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

import model.bean.Aula;
import model.bean.AulaLibera;
import model.bean.Orario;
import model.dao.DAOFactory;

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
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Prende i parametri in input e li salva in variabili locali
		HttpSession session = request.getSession();
		String parAula = request.getParameter("aula");
		String data = request.getParameter("data");
		System.out.println("formato orario passato  " + data);
		int settimane = Integer.parseInt(request.getParameter("settimane"));
		String inizio = request.getParameter("inizio");
		String fine = request.getParameter("fine");
		//salva il parametro che regola la ripetizione NELLA settimana dell'orario con l'aula
		String tuttasettimana = request.getParameter("tuttasettimana");
		int tsettimana;
		Aula a = new Aula();
		String nomeaula;
		String nomeedificio;
		//salva sia nome aula che edificio relativo
		nomeaula = parAula.substring(0, parAula.length() - 2);
		nomeedificio = parAula.substring(parAula.length() - 2, parAula.length());
		System.out.println("guarda qui l'aula inserita e substringata" + nomeaula + " " + nomeedificio);
		//salva l'intero relativo al giorno che ogni volta verrà aumentato di 7 (or.getInizio().setDate(or.getInizio().getDate()+7) non funziona
		String giorno = data.substring(8, 10);
		String smese = data.substring(5, 7);
		int mese = Integer.parseInt(smese);
		mese--;
		int giornodaaumentare = Integer.parseInt(giorno);
		//crea l'aula da aggiungere
		a.setEdificio(nomeedificio);
		a.setNomeAula(nomeaula);
		//debug
		System.out.println(inizio + "fine" + fine);
		//crea la stringa da inserire nel timestamp
		String dataInizio = data.concat(" " + inizio);
		//aggiunge 0 mancanti timestamp
		dataInizio.concat(":00:00");
		//stesso sopra
		String dataFine = data.concat(" " + fine);
		dataFine.concat(":00:00");
		//debug
		System.out.println(dataInizio + "data fine" + dataFine);
		tsettimana = 1;
		if (tuttasettimana.equals("si")) {
			tsettimana = 7;
		}

		//solo l`amministratore può inserire un orario
		if (session.getAttribute("logged").equals(true)  && session.getAttribute("admin").equals(true)) {
			SimpleDateFormat sdf;
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date date2 = new Date();
			Date date1 = new Date();
			try {
				date1 = sdf.parse(dataInizio);
				date2 = sdf.parse(dataFine);
			} catch (ParseException e) {
				e.printStackTrace();
			}	 	//fino a qui converte i dati presi in input
			Orario or = new Orario();
			System.out.println(date1 + "la data passata è " + data);
			//vengono usati i dati convertiti prima per creare timestamp
			or.setInizio(new Timestamp(date1.getTime()));
			or.setFine(new Timestamp(date2.getTime()));
			//viene settato  l'anno 119perche nel bean viene autmaticamente aggiunto 1900 per motivi relativi al timestamp
			or.getInizio().setYear(119);
			or.getFine().setYear(119);
			Orario orsett = new Orario();
			orsett.setInizio(or.getInizio());
			orsett.setFine(or.getFine());
			int settimaneiniziali = settimane;
			int giornoiniziale = giornodaaumentare;
			int app2 = giornodaaumentare;
			app2++;
			int giornimassimi;
			if (or.getInizio().getMonth() == 10 || or.getInizio().getMonth() == 3 || or.getInizio().getMonth() == 5 || or.getInizio().getMonth() == 8) {
				giornimassimi = 30;
			} else  if (or.getInizio().getMonth() == 1) {
				giornimassimi = 28;
			} else {
				giornimassimi = 31;
			}
			if (giornimassimi - app2 < settimane) {
				settimane = (giornimassimi - app2) + 2;
				tsettimana = settimane;
			}

			//controlla che l`orario non sia presente
			for (int o = 0; o < tsettimana; o++) {
				or.getInizio().setMonth(mese);
				or.getInizio().setDate(orsett.getInizio().getDate());
				or.getFine().setMonth(mese);
				or.getFine().setDate(orsett.getFine().getDate());



				for (int j = 0; j < settimane; j++) {
					Orario controllo = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(or.getInizio(), or.getFine());
					if (controllo.getInizio() != null && controllo.getFine() != null) {
						System.out.println("Orario gia presente");
					} else {
						or.getInizio().setYear(119);
						or.getFine().setYear(119);
						DAOFactory.getOrarioDAO().doSave(or);
						//se non trova l'orario ne db lo salva e poi salva l'aula
						System.out.println("Orario inserito ");
					}


					Orario controllo2 = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(or.getInizio(),or.getFine());
					if (controllo2 != null) {
					AulaLibera aula = new AulaLibera();

						//costruisce l'aula
						aula.setOrario(controllo2);
						aula.setAula(a);

						if ((giornodaaumentare + 7) <= giornimassimi) {
							giornodaaumentare = giornodaaumentare + 7;
						} else {

							int app = 7;
							app -= giornimassimi - giornodaaumentare;
							giornodaaumentare = app;


							or.getInizio().setMonth(or.getInizio().getMonth() + 1);
							or.getFine().setMonth(or.getFine().getMonth() + 1);
						}
						DAOFactory.getAulaLiberaDAO().doSave(aula);
						session.setAttribute("esito", true);
						or.getInizio().setDate(giornodaaumentare);
						or.getFine().setDate(giornodaaumentare);

					} else {
						session.setAttribute("esito", "errore");
						request.getRequestDispatcher("view/errore/Errore.jsp").forward(request, response);
					}
				}
				giornoiniziale++;
				giornodaaumentare = giornoiniziale;

				orsett.getInizio().setDate(giornodaaumentare);
				orsett.getFine().setDate(giornodaaumentare);


			}
			request.getRequestDispatcher("GestioneOrario").forward(request, response);
		} else { //se tutto va male da errore
			session.setAttribute("esito", "errore");
			request.getRequestDispatcher("view/errore/Errore.jsp").forward(request, response);
		}
	}

}
