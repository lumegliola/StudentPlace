package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.GruppoDiStudio;
import bean.Iscrizione;
import bean.Utente;
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
			ps.setInt(2, iscrizione.getGruppo().getId());

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
		return doDeleteByUserAndGroup(iscrizione.getIscritto().getMatricola(), iscrizione.getGruppo().getId());
	}

	
	
	@Override
	public boolean doDeleteByGroup( int idGruppo) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("delete from iscrizione where gruppo = ?;");
			ps.setInt(1, idGruppo);

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
	public boolean doDeleteByUserAndGroup(String matricola, int idGruppo) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("delete from iscrizione where utente = ? and gruppo = ?;");
			ps.setString(1, matricola);
			ps.setInt(2, idGruppo);

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
			b.setIscritto(DAOFactory.getUserDAO().doRetrieveByKey(matricola));

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from iscrizione where utente = ?;");
			ps.setString(1, matricola);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while(result.next()) {
				
				b.setGruppo(DAOFactory.getGdSDAO().doRetrieveById(result.getInt("gruppo")));
				res.add(b);
				
			}
			

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
		return res;
	}

	@Override
	public List<Iscrizione> doRetrieveByGroup(int idGruppo) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Iscrizione> res = new ArrayList<>();

		try {
			Iscrizione b = new Iscrizione();
			b.setGruppo(DAOFactory.getGdSDAO().doRetrieveById(idGruppo));

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from iscrizione where gruppo = ?;");
			ps.setInt(1, idGruppo);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while(result.next()) {
			
				b.setIscritto(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("utente")));
				res.add(b);
	
			}
			

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
		return res;
	}

	@Override
	public Iscrizione doRetrieveByUserAndGroup(String matricola, int idGruppo) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			Iscrizione b = new Iscrizione();
			Utente s = DAOFactory.getUserDAO().doRetrieveByKey(matricola);
			GruppoDiStudio g = DAOFactory.getGdSDAO().doRetrieveById(idGruppo);
			

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from iscrizione where utente = ? and gruppo = ?;");

			ps.setString(1, s.getMatricola());
			ps.setInt(2, g.getId());

			//esegue lo statement
			ResultSet result = ps.executeQuery();
			//ricava i risultati
			if(result.next()) {
				
				b.setIscritto(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("utente")));
				b.setGruppo(DAOFactory.getGdSDAO().doRetrieveById(result.getInt("gruppo")));
				return b;
		
			}

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
	public List<Iscrizione> doRetrieveAll() {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Iscrizione> res = new ArrayList<>();

		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from iscrizione;");

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				Iscrizione b = new Iscrizione();
				b.setIscritto(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("utente")));
				b.setGruppo(DAOFactory.getGdSDAO().doRetrieveById(result.getInt("gruppo")));
				
				// aggiunge l'oggetto alla lista
				res.add(b);
			}

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
		return res;
	}

}
