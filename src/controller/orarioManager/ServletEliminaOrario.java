package controller.orarioManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Orario;
import model.dao.DAOFactory;

/**
 * Servlet implementation class EliminaOrario
 */
@WebServlet("/EliminaOrario")
public class ServletEliminaOrario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEliminaOrario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		// solo l'amministratore può cancellare un orario
		if(session.getAttribute("logged").equals(true)  && session.getAttribute("admin").equals((true) )) {
			System.out.println("inizio if");
			int idOrario = Integer.parseInt(request.getParameter("idOrario"));
			Orario or = DAOFactory.getOrarioDAO().doRetrieveByKey(idOrario);
			//orario non trovato
			if (or == null) {
				request.getRequestDispatcher("showGestioneOrario").forward(request, response);
			}
			else {
				DAOFactory.getAulaLiberaDAO().doDeleteByOrario(or.getIdOrario());
				DAOFactory.getOrarioDAO().doDelete(or);
				System.out.println("l`orario viene eliminato dall`amministratore");
				session.setAttribute("esito", "ok");
				request.getRequestDispatcher("/GestioneOrario").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("view/errore/Errore.jsp").forward(request, response);
		}
	}

}
