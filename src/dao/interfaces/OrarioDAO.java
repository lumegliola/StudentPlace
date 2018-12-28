package dao.interfaces;
import java.util.*;

import bean.*;
public interface OrarioDAO {

	     public boolean doSave(Orario or);//metodo inserimento orario
	     
	     public boolean doSaveOrUpdate(Orario or,GregorianCalendar start,GregorianCalendar end);//metodo modificaOrario
	     
	     public boolean doDelete(Orario or);//eliminazione orario
	     
	     public Orario doRetrieve(GregorianCalendar start,GregorianCalendar end);//ricerca in base all'orario di inizio
	     
	     public List<Orario> doRetrieveAll();//lista tutti gli orari
	     	   
}
