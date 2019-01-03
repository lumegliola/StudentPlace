package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.GruppoDiStudio;
import bean.Iscrizione;
import dao.DAOFactory;
import dao.interfaces.IscrizioneDAO;
import db_connection.DriverManagerConnectionPool;

public class IscrizioneDAOImpl implements IscrizioneDAO{

	@Override
	public boolean doSave(Iscrizione iscrizione) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("insert into iscrizione values (?, ?);");

			//inserisce i campi
			ps.setString(1, iscrizione.getIscritto().getMatricola());
			ps.setObject(2, iscrizione.getGruppo().getNomeGruppo());

			//esegue lo statement
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(connection);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (result == 1);
	}

	@Override
	public boolean doDelete(Iscrizione iscrizione) {
		return doDeleteByUserAndGroup(iscrizione.getIscritto().getMatricola(), iscrizione.getGruppo().getNomeGruppo());
	}

	@Override
	public boolean doDeleteByUserAndGroup(String matricola, String nomeGruppo) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("delete from iscrizione where studente = ? and gruppo = ?;");
			ps.setString(1, matricola);
			ps.setString(2, nomeGruppo);

			//esegue lo statement
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(connection);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (result == 1);
	}

	@Override
	public List<Iscrizione> doRetrieveByUser(String matricola) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Iscrizione> res = new ArrayList<>();

		try {
			Iscrizione b = new Iscrizione();
			b.setIscritto(DAOFactory.getUserDAO().doRetrieveStudentByKey(matricola));

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from iscrizione join gds where iscrizione.studente = ?;");
			ps.setString(1, matricola);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while(result.next()) {
				
				b.setGruppo(DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(result.getString("nome"), result.getString("materia")));
				res.add(b);
				
			}
			return res;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(connection);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public List<Iscrizione> doRetrieveByGroup(String nomeGruppo) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Iscrizione> res = new ArrayList<>();

		try {
			Iscrizione b = new Iscrizione();
			b.setGruppo(DAOFactory.getGdSDAO().doRetrieveByName(nomeGruppo).get(0));

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from iscrizione join studente where  = ?;");
			ps.setString(1, nomeGruppo);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while(result.next()) {
				b.setIscritto(DAOFactory.getUserDAO().doRetrieveStudentByKey(result.getString("creatore")));
				b.setMateria(result.getString("materia"));

				b.setGiorno();
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				res.add(b);
			}
			return res;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					ps.close();
					DriverManagerConnectionPool.releaseConnection(connection);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public Iscrizione doRetrieveByUserAndGroup(String matricola, String nomeGruppo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Iscrizione> doRetrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
