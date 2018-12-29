package dao.implementation;

import java.util.List;

import bean.Credenziali;
import dao.interfaces.CredenzialiDAO;

public class CredenzialiDAOimpl implements CredenzialiDAO {

	@Override
	public boolean doSave(Credenziali cred) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doSaveOrUpdate(String mail, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(Credenziali cred) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(String mail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdmin(Credenziali cred) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdmin(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Credenziali doRetrieveByKey(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credenziali doRetrieveByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credenziali> doRetriveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
