package dao.interfaces;

import java.util.List;
import bean.*;

public interface AulaDAO {
	
	public boolean doSave(Aula aula); //inserisce un'aula nel database
	  
	public boolean doSaveOrUpdate(Aula aula, String nomeAula);//modifica un'aula nel database tramite ricerca
	  
	public boolean doDelete(Aula aula);//cancella un'aula nel database passando oggetto(Aula)
	  
	public boolean doDelete(String nomeAula);//cancella un'aula nel database passando il nome(String)
	
	public Utente doRetrieveByKey(String nomeAula);//ricerca l'aula tramite il nome(String)
	  
	public List<Aula> doRetrieveAll();//ricava tutti gli oggetti Aula 
}
