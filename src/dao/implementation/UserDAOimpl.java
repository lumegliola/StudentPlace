package dao.implementation;

import java.util.List;

import bean.Utente;
import dao.interfaces.UserDAO;

public class UserDAOimpl implements UserDAO {

	@Override
	public boolean doSave(Utente user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doSaveOrUpdate(Utente user, String emailToFind) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(Utente user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utente doRetrieveByKey(String matricola) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> doRetrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
