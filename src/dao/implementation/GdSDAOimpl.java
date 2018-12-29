package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import bean.GruppoDiStudio;
import dao.interfaces.GdSDAO;
import db_connection.DriverManagerConnectionPool;

public class GdSDAOimpl implements GdSDAO {

	@Override
	public boolean doSave(GruppoDiStudio gds) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("insert into gds values (?, ?, ?, ?, ?, ?, ?);");

			ps.setString(1, gds.getNomeGruppo());
			ps.setObject(2, gds.getCreatore());
			ps.setString(3, gds.getMateria());
			ps.setTime(4, gds.getOrario().getInizioDB());
			ps.setTime(5, gds.getOrario().getFineDB());
			ps.setString(6, gds.getGiorno());
			ps.setString(7, gds.getAula());
			

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (result == 1);
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
