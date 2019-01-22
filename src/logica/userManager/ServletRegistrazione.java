package logica.userManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Utente;
import dao.DAOFactory;
  
/**
 * Servlet implementation class ServletRegistrazione
 */
@WebServlet("/ServletRegistrazione")
public class ServletRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String password= request.getParameter("password") ;
		String email=request.getParameter("email");
	    String nome= request.getParameter("nome") ;
		String cognome=request.getParameter("cognome");
		String matricola=request.getParameter("matricola");
		if(nome!=null && cognome!=null && email!=null && password!=null && matricola!=null) {
			System.out.println("Parametri non null");
		Utente utente=new Utente(matricola, nome, cognome, email, password);
		utente.setAdmin(false);
		boolean valore=false;
		valore=DAOFactory.getUserDAO().doSave(utente);
		if(valore) {
			System.out.println("Salvato");

			HttpSession session=request.getSession();
			session.setAttribute("utente",utente);
			session.setAttribute("logged", true);
       		request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
       		return;
		}else {
			System.out.println("Non salvato");

			request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
       		return;
		}
		}else {
			System.out.println("Parametri null");

			request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
       		return;		
		}
	}

}
