package dao.interfaces;

import bean.*;
import java.util.*;

public interface UserDAO {

	public boolean doSave(Utente user); //metodo per inserire utente nel database
	  
	public boolean doSaveOrUpdate(Utente user, String emailToFind);//metodo per modificare un utente nel database tramite ricerca
	  
	public boolean doDelete(Utente user);//metodo per cancellare un utente nel database passando oggetto (Utente)
	  
	public boolean doDelete(String email);//metodo per cancellare un utente nel database passando la mail(String)
	
	public boolean isAdmin(Utente user);//metodo per controllare se un utente � amministratore passando oggetto(Utente)
	  
	public boolean isAdmin(String email);//metodo per controllare se un utente � amministratore passando la mail(String)
	
	public Utente doRetrieveByKey(String email);//metodo per ricerca Utente tramite mail(String)
	  
	public Utente doRetrieveByEmailAndPassword(String email, String password);//metodo per ricerca  mail e password (String,String)
	  
	public List<Utente> doRetrieveAll();//metodo di ricerca per ricavare tutti gli oggetti Utente 
	
}
