package logica.GdSManager;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.interfaces.GdSDAO;
import bean.GruppoDiStudio;

@WebServlet("/RicercaGds")
public class ServletRicercaGds extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRicercaGds() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("logged") != null  && (session.getAttribute("logged").equals(true))) {
			String input = request.getParameter("inputGruppo");

			GdSDAO dao = DAOFactory.getGdSDAO();
			List<GruppoDiStudio> list = new ArrayList<>();

			list = dao.doSearch(input);

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			int i=0;

			for (GruppoDiStudio p : list) {
				out.print("	<div class=\"row gds_row\">\r\n" + 
						"			<div class=\"col-lg-2\">\r\n" + 
						"				<span>"+p.getId()+"\r\n" + 
						"			</div>\r\n" + 
						"\r\n" + 
						"			<div class=\"col-lg-4\">\r\n" + 
						"				<a class=\"async_orario\" href=\"ShowGdS?idGruppo="+p.getId()+"\">"+p.getNomeGruppo()+"</a><br />\r\n" + 
						"				<span>inizio:"+p.getOrario().getInizio().toGMTString()+"</span>\r\n" + 
						"			</div>\r\n" + 
						"\r\n" + 
						"			<div class=\"col-lg-4\">\r\n" + 
						"			<span></span>\r\n"+
						"				<span>Materia: \t"+p.getMateria()+"</span>\r\n" + 
						"			</div>\r\n" + 
						"\r\n" + 
						"			<div class=\"col-lg-2\">\r\n" + 
						"				<span class=\"async_aula\">"+p.getAula().getNomeAula()+"</span>\r\n" + 
						"			</div>\r\n" + 
						"		</div>");
				i++;
				if(i==3)
					break;

			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		if( session.getAttribute("logged") != null && (session.getAttribute("logged").equals(true))) {
			String input = request.getParameter("inputGruppo");

			GdSDAO dao = DAOFactory.getGdSDAO();
			List<GruppoDiStudio> list = new ArrayList<>();

			list = dao.doSearch(input);		

			request.setAttribute("gruppi", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/GdS/ListaGruppi.jsp");
			dispatcher.forward(request, response);

		}

	}
}
