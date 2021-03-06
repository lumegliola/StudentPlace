package controller.show;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCreaGruppo
 */
@WebServlet("/CreaModificaGruppo")
public class ShowFormGruppo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFormGruppo() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected final void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("operazione");
		if (op.equals("crea")) {
			RequestDispatcher d = request.getRequestDispatcher("/view/GdS/CreaGruppo.jsp");
			d.forward(request, response);
		}
	}



	protected final void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
