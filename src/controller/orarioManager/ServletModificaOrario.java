package controller.orarioManager;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.CalendarConversion;

import model.bean.Orario;
import model.dao.DAOFactory;

/**
 * Servlet implementation class ModificaOrario
 */
@WebServlet("/ModificaOrario")
public class ServletModificaOrario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificaOrario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//solo l`amministratore può inserire un orario
		if (session.getAttribute("logged").equals(true) && session.getAttribute("admin").equals(true)) {
			Orario modOr = DAOFactory.getOrarioDAO().doRetrieveByKey(Integer.parseInt(request.getParameter("id")));
			Orario or = new Orario();
			SimpleDateFormat sdf;
		     sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		     Date date2 = new Date();
		     Date date1 = new Date();
		     try {
			 date1 = sdf.parse(request.getParameter("inizio"));
		     date2 = sdf.parse(request.getParameter("fine"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			or.setInizio(new Timestamp(date1.getTime()));
			or.setFine(new Timestamp(date2.getTime()));
		    DAOFactory.getOrarioDAO().doSaveOrUpdate(modOr, or.getInizio(), or.getFine());
			request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
			} else {
			request.getRequestDispatcher("ProvaOutput.jsp");
			}
		}
}
