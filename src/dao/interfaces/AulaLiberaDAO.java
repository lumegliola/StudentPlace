package dao.interfaces;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

import bean.AulaLibera;
import bean.GruppoDiStudio;
import bean.Orario;

public interface AulaLiberaDAO {

	

		public boolean doSave(AulaLibera aula); //metodo per inserire l'aula nel database
			  
		public boolean doSaveOrUpdate(AulaLibera aula, Orario o);//metodo per modificare un'aula nel database
			  
		public boolean doDelete(AulaLibera aula);//metodo per cancellare un'aula nel database passando oggetto (GruppoDiStudio)
			  
		public boolean doDelete(String nomeAula, String giorno, int idOrario);//metodo per cancellare un'aula nel database passando il nome(String)
			
		public AulaLibera doRetrieveByKey(String nomeAula, String giorno, int idOrario);//ricerca tramite chiave
		
		public List<AulaLibera> doRetrieveByName(String nomeAula);//metodo di ricerca aula tramite nome(String)
			  
		public List<AulaLibera> doRetrieveByDate(Timestamp data);//metodo di ricerca  per data
		
		public List<AulaLibera> doRetrieveAll();//metodo di ricerca per ricavare tutti gli oggetti AulaLibera 
			
	

}
