package model.dao.interfaces;

import java.sql.Timestamp;
import java.util.*;

import model.bean.*;

public interface GdSDAO {

	public boolean doSave(GruppoDiStudio gds); //metodo per inserire GdS nel database
		  
	public boolean doSaveOrUpdate(GruppoDiStudio gds, String nomeAula,Timestamp inizio ,Timestamp fine);//metodo per modificare un Gruppo nel database
		  
	public boolean doDelete(GruppoDiStudio gds);//metodo per cancellare un gds nel database passando oggetto (GruppoDiStudio)
		  
	public boolean doDeleteByNameAndSubjet(String nomeGruppo,String materia);//metodo per cancellare un gds nel database passando il nome(String)
			
	public List<GruppoDiStudio> doRetrieveByName(String nomeGruppo);//metodo di ricerca gds tramite nome(String)
		  
	public List<GruppoDiStudio> doRetrieveBySubject(String materia);//metodo di ricerca  per materia (String)
	
	public GruppoDiStudio doRetrieveByNameAndSubject(String nomeGruppo, String materia);//metodo per ricerca  nome e materiua(String,String)
	
	public GruppoDiStudio doRetrieveById(int id);

	public List<GruppoDiStudio> doRetrieveAll();//metodo di ricerca per ricavare tutti gli oggetti gds 

	public List<GruppoDiStudio> doSearch(String subString);//metodo di ricerca(anche substring)
	
	public List<GruppoDiStudio> doRetrieveByCreator(String matricola);//metodo di ricerca per creatore
}
