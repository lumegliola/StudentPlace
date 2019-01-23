package logica.GdSManager;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		if(session != null && session.getAttribute("logged") != null) {
			String input = request.getParameter("inputGruppo");

			GdSDAO dao = DAOFactory.getGdSDAO();
			List<GruppoDiStudio> listNom = new ArrayList<>();
			List<GruppoDiStudio> listMat = new ArrayList<>();
			listNom = dao.doRetrieveByName(input);
			listMat = dao.doRetrieveBySubject(input);
			listNom.addAll(listMat);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			int i=0;

			for (GruppoDiStudio p : listNom) {
				out.print("	<div class=\"row gds_row\">\r\n" + 
						"			<div class=\"col-sm-2\">\r\n" + 
						"				<img class=\"async_nome\" alt=\"GruppoDIStudio\"  style=\"max-height: 5em;\" src="+p.getNomeGruppo()+">\r\n" + 
						"			</div>\r\n" + 
						"\r\n" + 
						"			<div class=\"col-sm-8\">\r\n" + 
						"				<a class=\"async_orario\" href=\"gdsinfo.jsp?idGruppo="+p.getId()+"\"></a><br />\r\n" + 
						"				<span>inizio:"+p.getOrario().getInizio().toGMTString()+"</span>\r\n" + 
						"			</div>\r\n" + 
						"\r\n" + 
						"			<div class=\"col-sm-2\">\r\n" + 
						"				<span class=\"async_aula\">"+p.getAula().getNomeAula()+" &#8364;</span>\r\n" + 
						"			</div>\r\n" + 
						"		</div>");
				i++;
				if(i==3)
					break;
				request.setAttribute("gruppi", listNom);
				request.getRequestDispatcher("/view/GdS/ListaGruppi.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

		/*	
			List<GruppoDiStudio> elenco = new ArrayList<>();
			elenco = DAOFactory.getGdSDAO().doRetrieveBySubject(input);
			elenco.addAll(DAOFactory.getGdSDAO().doRetrieveByName(input));

			session.setAttribute("elencoGruppi", elenco);
			request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
		 */



	}

}
