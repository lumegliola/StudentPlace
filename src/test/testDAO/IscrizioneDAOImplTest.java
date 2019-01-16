package test.testDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


import bean.GruppoDiStudio;
import bean.Iscrizione;
import bean.Utente;
import dao.DAOFactory;

import dao.interfaces.GdSDAO;
import dao.interfaces.IscrizioneDAO;
import dao.interfaces.UserDAO;

class IscrizioneDAOImplTest {

  @Test
  void testDoSave() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      UserDAO utenteDao=DAOFactory.getUserDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
      Utente utente=utenteDao.doRetrieveByKey("0512103457");
      assertNotNull(gruppo);
      assertNotNull(utente);
      Iscrizione iscr=new Iscrizione();
      iscr.setGruppo(gruppo);
      iscr.setIscritto(utente);
      assertNotNull(iscr);
      boolean valore=iscrDao.doSave(iscr);
      assertTrue(valore);
      System.out.println("End test");
  }

  @Test
  void testDoDelete() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      UserDAO utenteDao=DAOFactory.getUserDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
      Utente utente=utenteDao.doRetrieveByKey("0512103333");
      assertNotNull(gruppo);
      assertNotNull(utente);
      Iscrizione iscr=new Iscrizione();
      iscr.setGruppo(gruppo);
      iscr.setIscritto(utente);
      assertNotNull(iscr);
      boolean valore=iscrDao.doDelete(iscr);
      assertTrue(valore);
      System.out.println("End test");
  }

  @Test
  void testDoDeleteByUserAndGroup() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      UserDAO utenteDao=DAOFactory.getUserDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
      Utente utente=utenteDao.doRetrieveByKey("0512103336");
      assertNotNull(gruppo);
      assertNotNull(utente);
      boolean valore=iscrDao.doDeleteByUserAndGroup(utente.getMatricola(), gruppo.getId());
      assertTrue(valore);
      System.out.println("End test");  }

  @Test
  void testDoRetrieveByUser() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      UserDAO utenteDao=DAOFactory.getUserDAO();
      Utente utente=utenteDao.doRetrieveByKey("0512102865");
      assertNotNull(utente);
     List <Iscrizione> listIscr=null;
      listIscr=iscrDao.doRetrieveByUser(utente.getMatricola());
      assertNotNull(listIscr);
      System.out.println("End test");
  }

  @Test
  void testDoRetrieveByGroup() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
     
      assertNotNull(gruppo);
      List <Iscrizione> listIscr=null;
      listIscr=iscrDao.doRetrieveByGroup(gruppo.getId());
      assertNotNull(listIscr);
      System.out.println("End test");  
      
  }


@Test
  void testDoRetrieveByUserAndGroup() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      
      UserDAO utenteDao=DAOFactory.getUserDAO();
      Utente utente=utenteDao.doRetrieveByKey("0512102865");
      assertNotNull(utente);
      GdSDAO gdsDao=DAOFactory.getGdSDAO();
      GruppoDiStudio gruppo=gdsDao.doRetrieveByNameAndSubject("Gruppo di is", "Ingegneria Del software");
       assertNotNull(gruppo);
     
      Iscrizione iscr=null;
      iscr=iscrDao.doRetrieveByUserAndGroup(utente.getMatricola(),gruppo.getId());
      assertNotNull(iscr);
      System.out.println("End test");
     }

  @Test
  void testDoRetrieveAll() {
    System.out.println("Start test");
      IscrizioneDAO iscrDao=DAOFactory.getIscrizioneDAO();
      assertNotNull(iscrDao);
      List <Iscrizione> listIscr=null;
    listIscr=iscrDao.doRetrieveAll();
    assertNotNull(listIscr);
      System.out.println("End test");
     
  }

}