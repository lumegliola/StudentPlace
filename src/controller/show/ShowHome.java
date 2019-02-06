package controller.show;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Utente;
import model.dao.DAOFactory;

/**
 * Servlet implementation class ShowHome
 */
@WebServlet("/ShowHome")
public class ShowHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Cookie []cookie=request.getCookies();
		
		if(cookie!=null ) {
			String mail="",logged="",admin="";
			for(int i=0;i<cookie.length;i++) {
				if(cookie[i].getName().equals("utente")) {
					mail=cookie[i].getValue();
			
				}
				if(cookie[i].getName().equals("logged")) {
				logged=cookie[i].getValue();				
				}
				if(cookie[i].getName().equals("admin")) {
					admin=cookie[i].getValue();				
					}
				
			}
			
			System.out.println(" "+mail+" "+logged+" "+admin);
			Utente utente=DAOFactory.getUserDAO().doRetrieveByMail(mail);
			session.setAttribute("utente",utente);
			if(logged.equals("true")) {
				session.setAttribute("logged", true);
				System.out.println("setta true");
			}else {
				session.setAttribute("logged", false);
				System.out.println("setta false");
			}
			if(admin.equals("true")) {
				session.setAttribute("admin", true);
				System.out.println("setta true");
			}else {
				session.setAttribute("admin", false);
				System.out.println("setta false");
			}
		}
		if(session.getAttribute("logged") == null) {
			session.setAttribute("logged", false);
		}
	
		 getServletContext().getRequestDispatcher("/view/homepage/Home.jsp").forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
