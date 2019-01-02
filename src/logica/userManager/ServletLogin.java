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

import bean.Credenziali;
import bean.Utente;
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
		String email = "";
		String password = "";
		Credenziali b = DAOFactory.getCredenzialiDAO().doRetrieveByEmailAndPassword(email, password);
		
		if(b == null) { // Utente Non trovato, credenziali errate.
			System.out.println("null");
			request.setAttribute("is_error", true);
			request.setAttribute("title", "Login Fallita");
			request.setAttribute("message", "Controlla di aver inserito i dati di accesso correttamente.");
			RequestDispatcher d = request.getRequestDispatcher("/view/results/Message.jsp");
			d.forward(request, response);
			return;
		
		} else { // Utente trovato, le credenziali sono giuste!
			HttpSession session = request.getSession(false);
			
			System.out.println("ok");
			//Setto i cookie per i prossimi accessi al sito.
			Cookie emailCookie = new Cookie("email", email);
			Cookie passwordCookie = new Cookie("password", password);
			Utente usr =DAOFactory.getUserDAO().doRetrieveByKey(b.getMatricola());
			//Setto la durata massima dei cookies, un mese
			emailCookie.setMaxAge(60 * 60 * 24 * 30);
			passwordCookie.setMaxAge(60 * 60 * 24 * 30);

			response.addCookie(emailCookie);
			response.addCookie(passwordCookie);
			System.out.println("Tutt appost");
			
			if(session != null) { //L'utente che si è appena loggato ha già una sessione.
			session.setAttribute("email", b.getMail());
			session.setAttribute("nome", usr.getNome());
			session.setAttribute("logged", true);
			
			} else { //L'Utente che si è appena loggato non ha ancora una sessione, quindi dobbiamo creargliela.
				session = request.getSession(true); 
				session.setAttribute("email", b.getMail());
				session.setAttribute("name", usr.getNome());
				session.setAttribute("logged", true);	
			}
			
			/* Reindiriziamo alla home.
			RequestDispatcher d = request.getRequestDispatcher("index.html");
			d.forward(request, response);
		*/
		}
		
	}

}

