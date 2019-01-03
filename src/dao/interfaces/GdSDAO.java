package dao.interfaces;

import bean.*;
import java.util.*;

public interface GdSDAO {

	public boolean doSave(GruppoDiStudio gds); //metodo per inserire GdS nel database
		  
	public boolean doSaveOrUpdate(GruppoDiStudio gds, String nomeGruppo, String nomeAula, GregorianCalendar fine);//metodo per modificare un Gruppo nel database
		  
	public boolean doDelete(GruppoDiStudio gds);//metodo per cancellare un gds nel database passando oggetto (GruppoDiStudio)
		  
	public boolean doDeleteByNameAndSubjet(String nomeGruppo,String materia);//metodo per cancellare un gds nel database passando il nome(String)
			
	public GruppoDiStudio doRetrieveByName(String nomeGruppo);//metodo di ricerca gds tramite nome(String)
		  
	public GruppoDiStudio doRetrieveBySubject(String materia);//metodo di ricerca  per materia (String)
	
	public GruppoDiStudio doRetrieveByNameAndSubject(String nomeGruppo, String materia);//metodo per ricerca  nome e materiua(String,String)

	public List<GruppoDiStudio> doRetrieveAll();//metodo di ricerca per ricavare tutti gli oggetti gds 
		
}
