package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.List;

import bean.GruppoDiStudio;
import bean.Orario;
import dao.DAOFactory;
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
			ps.setString(7, gds.getAula().getNomeAula());
			

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
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("update category set nome = ?, aula = ?, oraFine = ? where name ="+ gds.getNomeGruppo()+" ;");
			if(nomeGruppo != "")
				ps.setString(1, nomeGruppo);
			else
				ps.setString(1, gds.getNomeGruppo());
			
			if(nomeAula != "")
				ps.setString(2, nomeAula);
			else
				ps.setString(2, gds.getAula().getNomeAula());

			if(Orario.class.equals(null)) {
					ps.setTime(3, gds.getOrario().getFineDB());
			}
			else
				ps.setTime(3, new java.sql.Time(fine.getTimeInMillis()));

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

		if (result == 1) {
			return true;
		} else return doSave(gds);
	}

	@Override
	public boolean doDelete(GruppoDiStudio gds) {
		return doDelete(gds.getNomeGruppo());
	}

	@Override
	public boolean doDelete(String nomeGruppo) {
		
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("delete from gds where name = ?;");
			ps.setString(1, nomeGruppo);

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
	public GruppoDiStudio doRetrieveByName(String nomeGruppo) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			GruppoDiStudio b = new GruppoDiStudio();
			b.setNomeGruppo(nomeGruppo);

			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("select * from gds where name = ?;");
			ps.setString(1, nomeGruppo);

			ResultSet result = ps.executeQuery();

			if(result.next()) {
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("creatore")));
				b.setMateria(result.getString("materia"));
				
				GregorianCalendar oraIn = new GregorianCalendar(result.getTime("oraInizio").getYear(), result.getTime("oraInizio").getMonth(), result.getTime("oraInizio").getDay(), result.getTime("oraInizio").getHours(), result.getTime("oraInizio").getMinutes());
				GregorianCalendar oraFin = new GregorianCalendar(result.getTime("oraFine").getYear(), result.getTime("oraFine").getMonth(), result.getTime("oraFine").getDay(), result.getTime("oraFine").getHours(), result.getTime("oraFine").getMinutes());
				b.setOrario(oraIn, oraFin);
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				return b;
			}

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
		return null;
	}

	@Override
	public GruppoDiStudio doRetrieveBySubject(String materia) {
		
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			GruppoDiStudio b = new GruppoDiStudio();
			b.setMateria(materia);

			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("select * from gds where materia = ?;");
			ps.setString(1, materia);

			ResultSet result = ps.executeQuery();

			if(result.next()) {
				b.setNomeGruppo(result.getString("nome"));
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("creatore")));
				
				GregorianCalendar oraIn = new GregorianCalendar(result.getTime("oraInizio").getYear(), result.getTime("oraInizio").getMonth(), result.getTime("oraInizio").getDay(), result.getTime("oraInizio").getHours(), result.getTime("oraInizio").getMinutes());
				GregorianCalendar oraFin = new GregorianCalendar(result.getTime("oraFine").getYear(), result.getTime("oraFine").getMonth(), result.getTime("oraFine").getDay(), result.getTime("oraFine").getHours(), result.getTime("oraFine").getMinutes());
				b.setOrario(oraIn, oraFin);
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				return b;
			}

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
		return null;
	}

	@Override
	public GruppoDiStudio doRetrieveByNameAndSubject(String nomeGruppo, String materia) {
		
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			GruppoDiStudio b = new GruppoDiStudio();
			b.setNomeGruppo(nomeGruppo);
			b.setMateria(materia);

			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("select * from gds where nome = ? and materia = ?;");

			ps.setString(1, nomeGruppo);
			ps.setString(2, materia);

			ResultSet result = ps.executeQuery();

			if(result.next()) {
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("creatore")));
				b.setMateria(materia);
				
				GregorianCalendar oraIn = new GregorianCalendar(result.getTime("oraInizio").getYear(), result.getTime("oraInizio").getMonth(), result.getTime("oraInizio").getDay(), result.getTime("oraInizio").getHours(), result.getTime("oraInizio").getMinutes());
				GregorianCalendar oraFin = new GregorianCalendar(result.getTime("oraFine").getYear(), result.getTime("oraFine").getMonth(), result.getTime("oraFine").getDay(), result.getTime("oraFine").getHours(), result.getTime("oraFine").getMinutes());
				b.setOrario(oraIn, oraFin);
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				return b;
			}

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
		return null;
		
	}

	@Override
	public List<GruppoDiStudio> doRetrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
