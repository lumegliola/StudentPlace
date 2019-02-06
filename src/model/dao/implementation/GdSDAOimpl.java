package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import model.bean.Aula;
import model.bean.AulaLibera;
import model.bean.GruppoDiStudio;
import model.bean.Orario;
import model.bean.Utente;
import model.dao.DAOFactory;
import model.dao.interfaces.GdSDAO;
import model.db_connection.DriverManagerConnectionPool;

/**
 * 
 * GdSDAOimpl.java
 * Gestisce la persistenza degli oggetti di tipo GruppoDiStudio 
 * tramite interazioni con il database
 * 
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 * 
 * */


public class GdSDAOimpl implements GdSDAO {

	/**
	 * Effettua il salvataggio nel database dell'oggetto gruppo di studio,
	 * ritorna un boolean
	 * @param gds l'oggetto da salvare (della classe GruppoDiStudio)
	 * @return  Boolean
	 * @see GruppoDiStudio
	 * */
	@Override
	public boolean doSave(GruppoDiStudio gds) {		//Inserisce nel DB  l'oggetto gds
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("insert into gds(nome,creatore,materia,oraInizio,oraFine,giorno,aula) values (?, ?, ?, ?, ?, ?, ?);");

			//inserisce i campi
			ps.setString(1, gds.getNomeGruppo());
			ps.setString(2, gds.getCreatore().getMatricola());
			ps.setString(3, gds.getMateria());
			ps.setTimestamp(4, gds.getOrario().getInizio());
			ps.setTimestamp(5, gds.getOrario().getFine());
			ps.setString(6, gds.getGiorno());
			ps.setString(7, gds.getAula().getNomeAula());

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
	 * Effettua il salvataggio nel database dell'oggetto GruppoDiStudio, 
	 * se l'oggetto è già presente, lo modifica con i parametri inseriti, 
	 * ritorna l'esito dell'operazione
	 * @param gds l'oggetto da salvare (della classe GruppoDiStudio)
	 * @param nomeAula il nome della nuova aula(se si modifica)
	 * @param inizio il nuovo orario di inizio dell'evento(se si modifica)
	 * @param fine il nuovo orario di fine dell'evento(se si modifica)
	 * @return  Boolean
	 * @see GruppoDiStudio
	 * */
	@Override
	public boolean doSaveOrUpdate(GruppoDiStudio gds,String nomeAula, Timestamp inizio ,Timestamp fine) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			//dichiara lo statement
			connection = DriverManagerConnectionPool.getConnection();


			//se gruppo è vuota e (Aula no,inizio e fine != null)
			Orario or=new Orario(inizio, fine);

			ps = connection.prepareStatement("update gds set  aula = ? ,oraInizio=? ,oraFine = ?,giorno=? where nome =? and materia=? ;");
			ps.setString(1,nomeAula);
			ps.setTimestamp(2, inizio);
			ps.setTimestamp(3, fine);
			ps.setString(4, or.getGiorno());
			ps.setString(5, gds.getNomeGruppo());
			ps.setString(6, gds.getMateria());

			result = ps.executeUpdate();

			//esegue lo statement


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
			}
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

	/**
	 * Effettua la cancellazione dal database dell'oggetto GruppoDiStudio, 
	 * ritorna l'esito dell'operazione
	 * @param 	gds l'oggetto da eliminare (della classe GruppoDiStudio)
	 * @return  Boolean
	 * @see 	GruppoDiStudio
	 * */
	@Override
	public boolean doDelete(GruppoDiStudio gds) {
		return doDeleteByNameAndSubjet(gds.getNomeGruppo(),gds.getMateria());
	}

	/**
	 * Effettua la cancellazione dal database dell'oggetto GruppoDiStudio, 
	 * ritorna l'esito dell'operazione
	 * @param 	nomeGruppo l'attributo nome dell'oggetto da eliminare(della classe GruppoDiStudio)
	 * @param 	materia l'attributo materia dell'oggetto da eliminare(della classe GruppoDiStudio)
	 * @return  Boolean
	 * @see 	GruppoDiStudio
	 * */
	@Override
	public boolean doDeleteByNameAndSubjet(String nomeGruppo,String materia) {

		//ricava l'id del gruppo e elimina le iscrizioni
		GruppoDiStudio a = DAOFactory.getGdSDAO().doRetrieveByNameAndSubject(nomeGruppo, materia);	

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("delete from gds where nome = ? and materia=?;");
			ps.setString(1, nomeGruppo);
			ps.setString(2,materia);

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
	 * Interroga il database per trovare una lista di oggetti GruppoDiStudio 
	 * in base ai parametri inseriti, ritorna la lista, se trova oggetti
	 * @param	nomeGruppo l'attributo nome dell'oggetto(della classe GruppoDiStudio)
	 * @return 	List<GruppoDiStudio>
	 * @see 	GruppoDiStudio
	 * */
	@Override
	public List<GruppoDiStudio> doRetrieveByName(String nomeGruppo) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<GruppoDiStudio> res = new ArrayList<>();

		try {


			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from gds where nome = ?;");
			ps.setString(1, nomeGruppo);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while(result.next()) {
				GruppoDiStudio b = new GruppoDiStudio();
				Utente a = DAOFactory.getUserDAO().doRetrieveByKey(result.getString("creatore"));
				b.setNomeGruppo(nomeGruppo);
				b.setCreatore(a);
				b.setMateria(result.getString("materia"));
				DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(result.getTimestamp("oraInizio"), result.getTimestamp("oraFine"));
				b.setOrario(result.getTimestamp("oraInizio"), result.getTimestamp("oraFine"));
				b.setId(result.getInt("id"));
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

	/**
	 * Interroga il database per trovare una lista di oggetti GruppoDiStudio 
	 * in base ai parametri inseriti, ritorna la lista, se trova oggetti
	 * @param	matricola l'attributo creatore dell'oggetto(della classe GruppoDiStudio)
	 * @return 	List<GruppoDiStudio>
	 * @see 	GruppoDiStudio
	 * */
	@Override
	public List<GruppoDiStudio> doRetrieveByCreator(String matricola) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<GruppoDiStudio> res = new ArrayList<>();

		try {


			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from gds where creatore = ?;");
			ps.setString(1, matricola);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while(result.next()) {
				GruppoDiStudio b = new GruppoDiStudio();
				Utente a = DAOFactory.getUserDAO().doRetrieveByKey(matricola);
				b.setNomeGruppo(result.getString("nome"));
				b.setCreatore(a);
				b.setMateria(result.getString("materia"));
				DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(result.getTimestamp("oraInizio"), result.getTimestamp("oraFine"));
				b.setOrario(result.getTimestamp("oraInizio"), result.getTimestamp("oraFine"));
				b.setId(result.getInt("id"));
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

	/**
	 * Interroga il database per trovare una lista di oggetti GruppoDiStudio 
	 * in base ai parametri inseriti, ritorna la lista, se trova oggetti
	 * @param	materia l'attributo materia dell'oggetto(della classe GruppoDiStudio)
	 * @return 	List<GruppoDiStudio>
	 * @see 	GruppoDiStudio
	 * */
	@Override
	public List<GruppoDiStudio> doRetrieveBySubject(String materia) {

		Connection connection = null;
		PreparedStatement ps = null;
		List<GruppoDiStudio> res = new ArrayList<>();
		try {
			GruppoDiStudio b = new GruppoDiStudio();
			b.setMateria(materia);

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from gds where materia = ?;");
			ps.setString(1, materia);

			//esegue lo statement
			ResultSet result = ps.executeQuery();
			//ricava i risultati
			while(result.next()) {
				b.setNomeGruppo(result.getString("nome"));
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("creatore")));
				b.setId(result.getInt("id"));
				b.setOrario(result.getTimestamp("orainizio"), result.getTimestamp("oraFine"));
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

	/**
	 * Interroga il database per trovare una lista di oggetti GruppoDiStudio 
	 * in base ai parametri inseriti, ritorna la lista, se trova oggetti
	 * @param	nomeGruppo l'attributo nome dell'oggetto(della classe GruppoDiStudio)
	 * @param	materia l'attributo materia dell'oggetto(della classe GruppoDiStudio)
	 * @return 	List<GruppoDiStudio>
	 * @see 	GruppoDiStudio
	 * */
	@Override
	public GruppoDiStudio doRetrieveByNameAndSubject(String nomeGruppo, String materia) {

		Connection connection = null;
		PreparedStatement ps = null;

		try {
			GruppoDiStudio b = new GruppoDiStudio();
			b.setNomeGruppo(nomeGruppo);
			b.setMateria(materia);

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from gds where nome = ? and materia = ?;");

			ps.setString(1, nomeGruppo);
			ps.setString(2, materia);

			//esegue lo statement
			ResultSet result = ps.executeQuery();
			//ricava i risultati
			if(result.next()) {
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("creatore")));
				b.setMateria(materia);
				b.setNomeGruppo(nomeGruppo);
				b.setGiorno(result.getString("giorno"));
				b.setOrario(result.getTimestamp("orainizio"), result.getTimestamp("oraFine"));
				b.setId(result.getInt("id"));
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
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
	public List<GruppoDiStudio> doRetrieveAll() {
		Connection connection = null;
		PreparedStatement ps = null;
		List<GruppoDiStudio> gruppi = new ArrayList<>();

		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from gds;");

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				GruppoDiStudio b = new GruppoDiStudio();
				b.setNomeGruppo(result.getString("nome"));
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("creatore")));
				b.setId(result.getInt("id"));
				b.setMateria(result.getString("materia"));
				b.setOrario(result.getTimestamp("orainizio"), result.getTimestamp("oraFine"));
				b.setGiorno(result.getString("giorno"));
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				// aggiunge l'oggetto alla lista
				gruppi.add(b);
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
		return gruppi;
	}

	/**
	 * Interroga il database per trovare una lista di tutti gli oggetti GruppoDiStudio 
	 * ritorna la lista, se trova oggetti
	 * @return 	List<GruppoDiStudio>
	 * @see 	GruppoDiStudio
	 * */
	@Override
	public GruppoDiStudio doRetrieveById(int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			GruppoDiStudio b = new GruppoDiStudio();
			b.setId(id);

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from gds where id = ? ;");

			ps.setInt(1, id);

			//esegue lo statement
			ResultSet result = ps.executeQuery();
			//ricava i risultati
			if(result.next()) {
				b.setNomeGruppo(result.getString("nome"));
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("creatore")));
				b.setMateria(result.getString("materia"));
				b.setOrario(result.getTimestamp("orainizio"), result.getTimestamp("oraFine"));
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
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
	 * Interroga il database per trovare una lista di oggetti GruppoDiStudio 
	 * in base alla stringa inserita(anche con riferimento parziale)
	 *  ritorna la lista, se trova oggetti
	 * @param	subString l'attributo materia dell'oggetto(della classe GruppoDiStudio)
	 * @return 	List<GruppoDiStudio>
	 * @see 	GruppoDiStudio
	 * */
	public List<GruppoDiStudio> doSearch(String subString) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<GruppoDiStudio> gruppi = new ArrayList<>();

		try {

			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("SELECT * FROM gds where nome like ? or materia like ?;");

			ps.setString(1, "%" + subString + "%");
			ps.setString(2, "%" + subString + "%");


			ResultSet result = ps.executeQuery();

			while (result.next()) {
				GruppoDiStudio b = new GruppoDiStudio();

				b.setId(result.getInt("id"));
				b.setNomeGruppo(result.getString("nome"));
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveByKey(result.getString("creatore")));
				b.setMateria(result.getString("materia"));
				b.setOrario(result.getTimestamp("oraInizio"), result.getTimestamp("oraFine"));
				b.setGiorno(b.getOrario().getGiorno());
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				gruppi.add(b);
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
		return gruppi;
	}

}
