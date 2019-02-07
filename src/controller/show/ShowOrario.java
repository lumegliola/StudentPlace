package controller.show;

import java.io.IOException;
import java.security.AlgorithmConstraints;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Aula;
import model.bean.AulaLibera;
import model.bean.Orario;
import model.dao.DAOFactory;

/**
 * Servlet implementation class ShowOrario
 */
@WebServlet("/ShowOrario")
public class ShowOrario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrario() {
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
		HttpSession session = request.getSession(true);
		String aula = request.getParameter("aula");
		String giorno = request.getParameter("giorno");
		int idOrario = Integer.parseInt(request.getParameter("orario"));
		giorno.replace('i', 'ì');

		AulaLibera al = DAOFactory.getAulaLiberaDAO().doRetrieveByKey(aula, giorno, idOrario);
		Orario or = DAOFactory.getOrarioDAO().doRetrieveByKey(idOrario);
		Aula a = DAOFactory.getAulaDAO().doRetrieveByKey(aula);
		session.setAttribute("aulaLibera", al);
		session.setAttribute("orario", or);
		session.setAttribute("aula", a);
		System.out.println(giorno);
		request.getRequestDispatcher("/view/orari/InfoOrario.jsp").forward(request, response);
	}

}
