package model.dao.interfaces;

import java.util.*;

import model.bean.*;

public interface UserDAO {

	public boolean doSave(Utente user); //metodo per inserire utente nel database
	  
	public boolean doSaveOrUpdate(Utente user, String password);//metodo per modificare un utente nel database tramite ricerca
	  
	public boolean doDelete(Utente user);//metodo per cancellare un utente nel database passando oggetto (Utente)
	  
	public boolean doDelete(String matricola);//metodo per cancellare un utente nel database passando la mail(String)
	
	public Utente doRetrieveByKey(String matricola);//metodo per ricerca Utente tramite matricola(String)
	
	public Utente doRetrieveByMailAndPass(String mail, String password);//ricerca un utente nel db tramite mail e password
	
	public List<Utente> doRetrieveAll();//metodo di ricerca per ricavare tutti gli oggetti Utente 

	Utente doRetrieveByMail(String mail);
	
}
