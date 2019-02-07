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
 * Servlet implementation class ServletModificaProfilo
 */
@WebServlet("/ServletModificaProfilo")
public class ServletModificaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificaProfilo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected final void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newpassword = request.getParameter("password");

		HttpSession session = request.getSession();
       if (session != null) {
    	   boolean log = (boolean) session.getAttribute("logged");
       		if (!log) {
       		request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
       		System.out.println("non loggato");
       		return;
       		} else {
       		String email = (String) session.getAttribute("email");
       		String password = (String) session.getAttribute("password");
       		Utente utente = DAOFactory.getUserDAO().doRetrieveByMailAndPass(email, password);
       		if (utente != null) {
       		boolean valore = DAOFactory.getUserDAO().doSaveOrUpdate(utente, newpassword);
       		if (valore) {
       			System.out.println("ok");
       		} else {
       		System.out.println("not ok");
       		}
       		request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
       		}
       		}
       	} else {
    	   request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
       }
	}

}
