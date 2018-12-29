package dao.implementation;

import java.util.GregorianCalendar;
import java.util.List;

import bean.GruppoDiStudio;
import dao.interfaces.GdSDAO;

public class GdSDAOimpl implements GdSDAO {

	@Override
	public boolean doSave(GruppoDiStudio gds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doSaveOrUpdate(GruppoDiStudio gds, String nomeGruppo, String nomeAula, GregorianCalendar fine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(GruppoDiStudio gds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(String nomeGruppo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GruppoDiStudio doRetrieveByName(String nomeGruppo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GruppoDiStudio doRetrieveBySubject(String materia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GruppoDiStudio doRetrieveByNameAndSubject(String nomeGruppo, String materia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GruppoDiStudio> doRetrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
