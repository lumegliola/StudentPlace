package controller.userManager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.*;
import model.dao.DAOFactory;




/* *
 * Si occupa della login.
 *
 * Parametri:
 *
 * email = Email dell'utente.
 *
 * password = password dell'utente.
 *
 * */

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	 protected final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	 protected final void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		//String email = request.getParameter("email").toLowerCase();
		//String password = request.getParameter("password");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Utente user = DAOFactory.getUserDAO().doRetrieveByMailAndPass(email, password);

		if (user == null) { // Utente Non trovato, credenziali errate.
			//System.out.println("null");
			request.setAttribute("is_error", true);
			request.setAttribute("title", "Login Fallita");
			request.setAttribute("message", "Controlla di aver inserito i dati di accesso correttamente.");
			RequestDispatcher d = request.getRequestDispatcher("/view/errore/LoginErrata.jsp");
			d.forward(request, response);
			return;

		} else { // Utente trovato, le credenziali sono giuste!
			HttpSession session = request.getSession();
			//System.out.println("ok");
			//Setto i cookie per i prossimi accessi al sito.
			System.out.println("Tutt appost");
			session.setAttribute("utente", user);
		    session.setAttribute("logged", true);
		    session.setAttribute("admin", user.isAdmin());
		    Cookie mail = new Cookie("utente", user.getMail());
            Cookie logged = new Cookie("logged", "true");
            Cookie admin = new Cookie("admin", "");
            if (user.isAdmin()) {
            admin.setValue("true");
            } else {
            admin.setValue("false");

            }
            response.addCookie(mail);
            response.addCookie(logged);
            response.addCookie(admin);
           //Reindiriziamo alla home.
			request.getRequestDispatcher("/view/homepage/Home.jsp").forward(request, response);
			return;
		}

	}

}

