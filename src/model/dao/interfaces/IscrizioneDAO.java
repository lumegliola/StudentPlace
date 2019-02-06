package model.dao.interfaces;

import java.sql.Timestamp;
import java.util.List;

import model.bean.Iscrizione;

public interface IscrizioneDAO {

	public boolean doSave(Iscrizione iscrizione); //metodo per inserire un'iscrizione nel database
	   
	public boolean doDelete(Iscrizione iscrizione);//metodo per cancellare un'iscrizione nel database passando oggetto (Iscrizione)
		  
	public boolean doDeleteByUserAndGroup(String matricola,int idGruppo);//metodo per cancellare un'iscrizione nel database passando il nome(String)
	
	public boolean doDeleteByGroup(int idGruppo);//metodo per cancellare un'iscrizione nel database passando il gruppo(int)
			
	public List<Iscrizione> doRetrieveByUser(String matricola);//metodo di ricerca iscrizione tramite matricola
	
	public List<Iscrizione> doRetrieveByGroup(int idGruppo);//metodo di ricerca iscrizione per gruppo
	
	public Iscrizione doRetrieveByUserAndGroup(String matricola, int idGruppo);//metodo di ricerca per matricola e gruppo

	public List<Iscrizione> doRetrieveAll();//metodo di ricerca per ricavare tutti gli oggetti iscrizione 
}
