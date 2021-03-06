package controller.show;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.AulaLibera;
import model.dao.DAOFactory;

/**
 * Servlet implementation class ShowGestioneOrario
 */
@WebServlet("/GestioneOrario")
public class ShowGestioneOrario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGestioneOrario() {
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
		List<AulaLibera> lista = DAOFactory.getAulaLiberaDAO().doRetrieveAll();
		request.setAttribute("auleLibere", lista);
		request.getRequestDispatcher("/view/orari/GestioneOrario.jsp").forward(request, response);
	}

}
