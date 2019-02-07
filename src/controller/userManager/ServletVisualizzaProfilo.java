package controller.userManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Utente;
import model.dao.DAOFactory;

/**
 * Servlet implementation class SrevletVisualizzaProfilo
 */
@WebServlet("/ServletVisualizzaProfilo")
public class ServletVisualizzaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVisualizzaProfilo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected final void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession ssn = request.getSession();
        if (ssn.getAttribute("logged") != null && ssn.getAttribute("logged").equals(true)) {
        Utente	utente = (Utente) ssn.getAttribute("utente");
        request.setAttribute("utente", utente);
        request.getRequestDispatcher("/view/utente/Profilo.jsp").forward(request, response);

        } else {
        	 request.getRequestDispatcher("/view/homepage/Home.jsp").forward(request, response);
        }
	}

}
