package dao.interfaces;

import bean.*;
import java.util.*;

public interface UserDAO {

	public boolean doSave(Utente user);
	  
	public boolean doSaveOrUpdate(Utente user, String emailToFind);
	  
	public boolean doDelete(Utente user);
	  
	public boolean doDelete(String email);
	  
	public Utente doRetrieveByKey(String email);
	  
	public Utente doRetrieveByEmailAndPassword(String email, String password);
	  
	public List<Utente> doRetrieveAll();
	
}
