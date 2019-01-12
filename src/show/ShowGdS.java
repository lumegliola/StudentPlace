package show;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GruppoDiStudio;


/**
 * Servlet implementation class ShowGdS
 */
@WebServlet("/ShowGdS")
public class ShowGdS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGdS() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//proviamo a convertire l'id del prodotto da stringa ad intero.
			int id = Integer.parseInt(request.getParameter("id_gruppo"));

			//Cerchiamo il prodotto richiesto.
			GruppoDiStudio b = dao.DAOFactory.getGdSDAO().doRetrieveById(id);

			if (b != null) { 
				//Il prodotto è stato trovato, lo aggiungiamo alla request e deleghiamo la visualizzazione
				//alla jsp nella view.
				request.setAttribute("gruppo", b);
				RequestDispatcher d = request.getRequestDispatcher("/view/GdS/Gruppi.jsp");
				d.forward(request, response);
			} else {
				//l'id è stato inserito correttamente, ma nel database non risulta presente un 
				//prodotto con quel determinato id, quindi mostriamo errore.
				request.setAttribute("is_error", true);
				request.setAttribute("title", "Gruppo non trovato!");
				request.setAttribute("message", "Non è stato possibile trovare il gruppo.");
				RequestDispatcher d = request.getRequestDispatcher("");
				d.forward(request, response);
			}
		} catch (NumberFormatException e) {
			// L'id inserito non è un intero, è stato inserito un parametro errato, mostriamo errore.
			request.setAttribute("is_error", true);
			request.setAttribute("title", "Gruppo non trovato!");
			request.setAttribute("message", "Non è stato possibile trovare il gruppo.");
			RequestDispatcher d = request.getRequestDispatcher("");
			d.forward(request, response);
		}

    }
}
