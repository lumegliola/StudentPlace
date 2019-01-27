
package show;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowCreaGruppo
 */
@WebServlet("/ShowModificaGruppo")
public class ShowModificaGruppo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowModificaGruppo() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//Controllo esistenza sessione 
		if(session.getAttribute("logged") != null && session.getAttribute("logged").equals(true)) {//Se esiste 
			System.out.println("Inzio if");
					String nomeGruppov = (String) request.getParameter("nomeGruppo");
					String materiav = (String) request.getParameter("materia");	
					String matricola = (String) request.getParameter("matricola");	
					System.out.println("sono in show mod e nome e gruppo sono"+nomeGruppov+" "+materiav+" "+matricola);
					session.setAttribute(nomeGruppov, "nomeGruppov");
					session.setAttribute(materiav, "materiav");
					session.setAttribute(matricola, matricola);
					request.getRequestDispatcher("/view/GdS/ModificaGruppo.jsp").forward(request, response);
			
			request.getRequestDispatcher("/view/errore/Errore.jsp").forward(request, response);
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
