package dao.interfaces;

import bean.*;
import java.util.*;

public interface CredenzialiDAO {
   
	public boolean doSave(Credenziali cred);//metodo inserire credenziali
	
	public boolean doSaveOrUpdate(String mail,String password);//metodo modificare Credenziali e salvare

	public boolean doDelete(Credenziali cred);//metodo cancellazione in base alla mail

	public boolean doDelete(String mail);//metodo cancellazione in base alla mail
	
	public boolean isAdmin(Credenziali cred);//metodo per controllare se un utente è amministratore passando oggetto(Utente)
	  
	public boolean isAdmin(String email);//metodo per controllare se un utente è amministratore passando la mail(String)
	
	public Credenziali doRetrieveByKey(String email);//metodo per ricerca Credenziali tramite mail(String)
	  
	public Credenziali doRetrieveByEmailAndPassword(String email, String password);//metodo per ricerca  mail e password (String,String)

	public List<Credenziali> doRetriveAll();//metodo restituisce la lista delle credenziali

}
