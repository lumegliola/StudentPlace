package controller.visualizzaAule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DAOFactory;

/**
 * Servlet implementation class ServletModificaAulaLibera
 */
@WebServlet("/ModificaAulaLibera")
public class ServletModificaAulaLibera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificaAulaLibera() {
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
		String op = request.getParameter("operazione");
		String aula = request.getParameter("aula");
		String giorno = request.getParameter("giorno");
		giorno.replace('i', 'ì');
		int idOrario=Integer.parseInt(request.getParameter("idOrario"));
		
		if(op.equals("elimina")) {
			
			if(DAOFactory.getAulaLiberaDAO().doDeleteByKey(aula, giorno, idOrario)==true) {
				request.setAttribute("redirect", "orario");
				request.getRequestDispatcher("GestioneOrario").forward(request, response);
			}else
				request.getRequestDispatcher("/view/errore/Errore.jsp").forward(request, response);
		}
		//funzionalità modifica
		
	}

}
