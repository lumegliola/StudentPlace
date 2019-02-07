package controller.GdSManager;
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
import model.bean.GruppoDiStudio;
import model.bean.Orario;
import model.bean.Utente;
import model.dao.DAOFactory;

/**
 * Servlet implementation class CreaGds
 */
@WebServlet("/ServletCreaGds")
public class ServletCreaGds extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletCreaGds() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected final void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session  =  request.getSession();						//
		if (session.getAttribute("logged").equals(true) && session.getAttribute("logged") !=  null) {

			String nomeGruppo = request.getParameter("nomeGruppo");
			String materia = request.getParameter("materia");
			String parAula = request.getParameter("aula");
			String data = request.getParameter("data");
			String inizio = request.getParameter("inizio");
			String fine = request.getParameter("fine");

			String dataInizio  =  data.concat(" " + inizio + ":00.0");
			String dataFine = data.concat(" " + fine + ":00.0");
			System.out.println(dataInizio);
			if (DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(nomeGruppo,
					materia) == null) {
				GruppoDiStudio nuovo = new GruppoDiStudio();
				Utente creatore = (Utente) session.getAttribute("utente");

				SimpleDateFormat sdf;
				sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date2 = new Date(), date1 = new Date();
				try {
					date1 = sdf.parse(dataInizio);
					date2 = sdf.parse(dataFine);
				} catch (ParseException e) {
					e.printStackTrace();
                }

				Aula aula = DAOFactory.getAulaDAO().doRetrieveByKey(parAula);
				nuovo.setCreatore(creatore);
				nuovo.setNomeGruppo(nomeGruppo);

				nuovo.setMateria(materia);
				nuovo.setOrario(new Timestamp(date1.getTime()), new Timestamp(date2.getTime()));
				nuovo.setGiorno();
				nuovo.setAula(aula);
				DAOFactory.getGdSDAO().doSave(nuovo);
				session.setAttribute("esito", true);
				request.getRequestDispatcher("/view/OpEffettuata.jsp").forward(request, response);

			    } else {
				session.setAttribute("esito", "errore");
				request.getRequestDispatcher("/view/errore/errore.jsp").forward(request, response);


				}
				} else {
			//messagggio: utente non loggato
			session.setAttribute("esito", "errore");
			request.getRequestDispatcher("/view/errore/Errore.jsp").forward(request, response);
		}
	}


}
