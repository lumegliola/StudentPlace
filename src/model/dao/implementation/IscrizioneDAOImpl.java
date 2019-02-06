package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Aula;
import model.bean.GruppoDiStudio;
import model.bean.Iscrizione;
import model.bean.Utente;
import model.dao.DAOFactory;
import model.dao.interfaces.IscrizioneDAO;
import model.db_connection.DriverManagerConnectionPool;

/**
 * 
 * IscrizioneDAOimpl.java
 * Gestisce la persistenza degli oggetti di tipo Iscrizione 
 * tramite interazioni con il database
 * 
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 * 
 * */

public class IscrizioneDAOImpl implements IscrizioneDAO{

	/**
	 * Effettua il salvataggio nel database dell'oggetto iscrizione,
	 * ritorna un boolean
	 * @param iscrizione l'oggetto da salvare (della classe iscrizione)
	 * @return  Boolean
	 * @see Iscrizione
	 * */
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

	/**
	 * Effettua la cancellazione dal database dell'oggetto iscrizione, 
	 * ritorna l'esito dell'operazione
	 * @param 	iscrizione l'oggetto da eliminare(della classe Iscrizione)
	 * @return  Boolean
	 * @see 	Iscrizione
	 * */
	@Override
	public boolean doDelete(Iscrizione iscrizione) {
		return doDeleteByUserAndGroup(iscrizione.getIscritto().getMatricola(), iscrizione.getGruppo().getId());
	}

	
	/**
	 * Effettua la cancellazione dal database dell'oggetto iscrizione, 
	 * ritorna l'esito dell'operazione
	 * @param 	idGruppo l'attributo gruppo dell'oggetto da eliminare(della classe Iscrizione)
	 * @return  Boolean
	 * @see 	Iscrizione
	 * */
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

	
	/**
	 * Effettua la cancellazione dal database dell'oggetto iscrizione, 
	 * ritorna l'esito dell'operazione
	 * @param 	matricola l'attributo matricola dell'oggetto da eliminare(della classe Iscrizione)
	 * @param 	idGruppo l'attributo gruppo dell'oggetto da eliminare(della classe Iscrizione)
	 * @return  Boolean
	 * @see 	Iscrizione
	 * */
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

	/**
	 * Interroga il database per trovare una lista di oggetti Iscrizione 
	 * in base ai paramentri inseriti, ritorna la lista, se trova oggetti
	 * @param 	matricola l'attributo matricola dell'oggetto(della classe Iscrizione)
	 * @return 	List<Iscrizione>
	 * @see 	Iscrizione
	 * */
	@Override
	public List<Iscrizione> doRetrieveByUser(String matricola) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Iscrizione> res = new ArrayList<>();

		try {
			

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from iscrizione where utente = ?;");
			ps.setString(1, matricola);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while(result.next()) {
				Iscrizione b = new Iscrizione();
				b.setIscritto(DAOFactory.getUserDAO().doRetrieveByKey(matricola));
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

	/**
	 * Interroga il database per trovare una lista di oggetti Iscrizione 
	 * in base ai paramentri inseriti, ritorna la lista, se trova oggetti
	 * @param 	idGruppo l'attributo id dell'oggetto(della classe GruppoDiStudio) che è attributo di Iscrizione
	 * @return 	List<Iscrizione>
	 * @see 	Iscrizione
	 * @see		GruppoDiStudio
	 * */
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

	/**
	 * Interroga il database per trovare una lista di oggetti Iscrizione 
	 * in base ai paramentri inseriti, ritorna la lista, se trova oggetti
	 * @param 	matricola l'attributo matricola dell'oggetto(della classe Utente) che è attributo di Iscrizione 
	 * @param 	idGruppo l'attributo id dell'oggetto(della classe GruppoDiStudio) che è attributo di Iscrizione
	 * @return 	List<Iscrizione>
	 * @see 	Iscrizione
	 * @see		Utente
	 * */
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

	/**
	 * Interroga il database per trovare una lista di tutti gli oggetti Iscrizione
	 * ritorna la lista, se trova oggetti
	 * @return 	List<Iscrizione>
	 * @see 	Iscrizione
	 * */
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
