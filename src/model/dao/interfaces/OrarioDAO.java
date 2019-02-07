package model.dao.interfaces;
import java.sql.Timestamp;
import java.util.*;

import model.bean.*;
public interface OrarioDAO  {

	     public boolean doSave(Orario or);//metodo inserimento orario

	     public boolean doSaveOrUpdate(Orario or, Timestamp start, Timestamp end);//metodo modificaOrario

	     public boolean doDelete(Orario or);//eliminazione orario

	     public boolean doDelete(int id);//eliminazione orario

	     public List<Orario> doRetrieveByStart(Timestamp start) ;//ricerca in base all'orario di inizio

	     public Orario doRetrieveByStartAndFinish(Timestamp start, Timestamp finish) ;//ricerca in base all'orario di inizio e fine

	     public Orario doRetrieveByKey(int id);//ricerca in base alla chiave

	     public List<Orario> doRetrieveAll();//lista tutti gli orari

}
