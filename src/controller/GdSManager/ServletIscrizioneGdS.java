package controller.GdSManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.*;
import model.dao.DAOFactory;
/**
 * Servlet implementation class IscrizioneGdS
 */
@WebServlet("/IscrizioneGdS")
public class ServletIscrizioneGdS extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public ServletIscrizioneGdS() {
    super();
    // TODO Auto-generated constructor stub
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doPost(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    HttpSession session=request.getSession(false);
    String op = request.getParameter("operazione");
    if(op.equals("cancella")) {
      int idGruppo =Integer.parseInt(request.getParameter("idGruppo"));
      String matricola = request.getParameter("matricola");
      DAOFactory.getIscrizioneDAO().doDeleteByUserAndGroup(matricola, idGruppo);
      request.setAttribute("redirect", "/view/utente/Profilo.jsp");
      request.getRequestDispatcher("/view/OpEffettuata.jsp").forward(request, response);
      
    }else if(op.equals("iscrivi")) {
      int idGds=Integer.parseInt(request.getParameter("idGds"));
      String matricola=(String) request.getParameter("matricola");
      if( session!=null) {
        System.out.println("Inizio if");
        Utente user = DAOFactory.getUserDAO().doRetrieveByKey(matricola);
        GruppoDiStudio gds = DAOFactory.getGdSDAO().doRetrieveById(idGds);
        if (user == null || gds == null) {
          session.setAttribute("esito", "errore");
          request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
          return;  
        }
        Iscrizione iscrizione = new Iscrizione(user,gds);

        DAOFactory.getIscrizioneDAO().doSave(iscrizione);

        session.setAttribute("esito", "ok");
        request.setAttribute("redirect", "/view/utente/Profilo.jsp");
        request.getRequestDispatcher("view/OpEffettuata.jsp").forward(request, response);
        return;

      } else {
        System.out.println("Inizio Else");
        //messagggio: utente non loggato

        session.setAttribute("esito", "errore");
        request.getRequestDispatcher("ProvaOutput.jsp").forward(request, response);
        return;
      }
    }

  }

}
