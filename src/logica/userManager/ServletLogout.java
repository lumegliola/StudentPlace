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

@WebServlet("/logout")
public class ServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cookie []ck=request.getCookies();
		for(int i=0;i<ck.length;i++) {
			if(ck[i].getName().equals("utente")) {
				ck[i].setValue("");
			}
			if(ck[i].getName().equals("logged")) {
				ck[i].setValue("");
					}
			if(ck[i].getName().equals("admin")) {
				ck[i].setValue("");
				}
			
		}
		session.invalidate();
		request.getRequestDispatcher("/view/homepage/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			
		}

	}



