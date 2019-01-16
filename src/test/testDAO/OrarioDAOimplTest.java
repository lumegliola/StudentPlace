package test.testDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;


import bean.Orario;
import dao.DAOFactory;
import dao.interfaces.OrarioDAO;

class OrarioDAOimplTest {

  @Test
  void testDoSave() {
    
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,2,12,0,0,0));
      orario.setFine(new Timestamp(2019,11,2,14,0,0,0));
      boolean valore=orarioDao.doSave(orario);
      assertTrue(valore);
      System.out.println("End test");
  }

  @Test
  void testDoSaveOrUpdate() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,02,11,00,00, 0));
      orario.setFine(new Timestamp(2019,11,02, 13,00,00, 0));
      orario.setIdOrario(1);
      
      boolean valore=orarioDao.doSaveOrUpdate(orario, new Timestamp(2019,11,03,13,00,00, 0), new Timestamp(2019,11,03 ,15,00,00, 0));
      assertTrue(valore);

      System.out.println("End test");

  }

  @Test
  void testDoDeleteOrario() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,02,11,00,00, 0));
      orario.setFine(new Timestamp(2019,11,02, 13,00,00, 0));
      orario.setIdOrario(7);
      boolean valore=orarioDao.doDelete(orario);
      assertTrue(valore);

      System.out.println("End test");
      }

  @Test
  void testDoDeleteInt() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=new Orario();
      orario.setInizio(new Timestamp(2019,11,02,11,00,00, 0));
      orario.setFine(new Timestamp(2019,11,02, 13,00,00, 0));
      orario.setIdOrario(8);
      boolean valore=orarioDao.doDelete(orario.getIdOrario());
      assertTrue(valore);

      System.out.println("End test");  }

  @Test
  void testDoRetrieveByKey() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=null;
      orario=orarioDao.doRetrieveByKey(6);
      assertNotNull(orario);
      System.out.println("End test");
      }

  @Test
  void testDoRetrieveByStart() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      List<Orario> listOrario=null;
      listOrario=orarioDao.doRetrieveByStart(new Timestamp(2019,11,02,11,00,00, 0));
      assertNotNull(listOrario);
      for (Orario or :listOrario) {
        System.out.println("Start"+or.getInizio()+"Fine"+or.getFine());
         }
      System.out.println("End test");
  
  }

  @Test
  void testDoRetrieveByStartAndFinish() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      Orario orario=null;
      orario=orarioDao.doRetrieveByStartAndFinish(new Timestamp(2019,11,02,11,00,00, 0),new Timestamp(2019,11,02,13,00,00, 0));
      assertNotNull(orario);
     
      System.out.println("End test");
  
  }

  @Test
  void testDoRetrieveAll() {
    System.out.println("Start test");
      OrarioDAO orarioDao=DAOFactory.getOrarioDAO();
      assertNotNull(orarioDao);
      List<Orario> listOrario=null;
      listOrario=orarioDao.doRetrieveAll();
      assertNotNull(listOrario);
      for (Orario or :listOrario) {
        System.out.println("Start"+or.getInizio()+"Fine"+or.getFine());
         }
      System.out.println("End test");  }

}