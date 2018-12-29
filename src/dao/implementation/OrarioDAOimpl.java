package dao.implementation;

import java.util.GregorianCalendar;
import java.util.List;

import bean.Orario;
import dao.interfaces.OrarioDAO;

public class OrarioDAOimpl implements OrarioDAO {

	@Override
	public boolean doSave(Orario or) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doSaveOrUpdate(Orario or, GregorianCalendar start, GregorianCalendar end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(Orario or) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Orario doRetrieve(GregorianCalendar start, GregorianCalendar end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orario> doRetrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
