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

import it.unisa.tsw18.smartshop.model.beans.Cart;
import it.unisa.tsw18.smartshop.model.beans.UserBean;
import it.unisa.tsw18.smartshop.model.daos.implementations.DAOFactory;

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
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").toLowerCase();
		String password = request.getParameter("password");
		UserBean b = DAOFactory.getUserDAO().doRetrieveByEmailAndPassword(email, password);
		
		if(b == null) { // Utente Non trovato, credenziali errate.
			request.setAttribute("is_error", true);
			request.setAttribute("title", "Login Fallita");
			request.setAttribute("message", "Controlla di aver inserito i dati di accesso correttamente.");
			RequestDispatcher d = request.getRequestDispatcher("/view/results/Message.jsp");
			d.forward(request, response);
			return;
		
		} else { // Utente trovato, le credenziali sono giuste!
			HttpSession session = request.getSession(false);
			
			//Setto i cookie per i prossimi accessi al sito.
			Cookie emailCookie = new Cookie("email", email);
			Cookie passwordCookie = new Cookie("password", password);

			//Setto la durata massima dei cookies, un mese
			emailCookie.setMaxAge(60 * 60 * 24 * 30);
			passwordCookie.setMaxAge(60 * 60 * 24 * 30);

			response.addCookie(emailCookie);
			response.addCookie(passwordCookie);
			
			if(session != null) { //L'utente che si è appena loggato ha già una sessione.
			session.setAttribute("email", b.getEmail());
			session.setAttribute("name", b.getName());
			session.setAttribute("logged", true);
			
			} else { //L'Utente che si è appena loggato non ha ancora una sessione, quindi dobbiamo creargliela.
				session = request.getSession(true); 
				session.setAttribute("email", b.getEmail());
				session.setAttribute("name", b.getName());
				session.setAttribute("logged", true);
				session.setAttribute("cart", new Cart());	
			}
			
			// Reindiriziamo alla home.
			RequestDispatcher d = request.getRequestDispatcher("index.html");
			d.forward(request, response);
		}
		
	}

}

