package logica.userManager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.*;
import dao.DAOFactory;




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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String email = request.getParameter("email").toLowerCase();
		//String password = request.getParameter("password");
		String password= request.getParameter("password") ;
		String email=request.getParameter("email");
		Utente user = DAOFactory.getUserDAO().doRetrieveByMailAndPass(email, password);
        System.out.println(user.getNome());
		if(user == null) { // Utente Non trovato, credenziali errate.
			//System.out.println("null");
			request.setAttribute("is_error", true);
			request.setAttribute("title", "Login Fallita");
			request.setAttribute("message", "Controlla di aver inserito i dati di accesso correttamente.");
			RequestDispatcher d = request.getRequestDispatcher("/view/errore/Errore.jsp");
			d.forward(request, response);
			return;

		} else { // Utente trovato, le credenziali sono giuste!
			HttpSession session = request.getSession();
			//System.out.println("ok");
			//Setto i cookie per i prossimi accessi al sito.
			System.out.println("Tutt appost");
			if(session != null){ //L'utente che si è appena loggato ha già una sessione.
				session.setAttribute("utente", user);
				session.setAttribute("logged", true);	
			} 

			//Reindiriziamo alla home.
			getServletContext().getRequestDispatcher("/view/homepage/Home.jsp").forward(request, response);
			
		}

	}

}

