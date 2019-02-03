package dao.implementation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;

import bean.Aula;
import bean.AulaLibera;
import bean.GruppoDiStudio;
import bean.Orario;
import dao.DAOFactory;
import dao.interfaces.AulaLiberaDAO;
import db_connection.DriverManagerConnectionPool;

/**
 * 
 * AulaLiberaDAOimpl.java
 * Gestisce la persistenza degli oggetti di tipo AulaLibera 
 * tramite interazioni con il database
 * 
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 * 
 * */

public class AulaLiberaDAOimpl implements AulaLiberaDAO{

	/**
	 * Effettua il salvataggio nel database dell'oggetto aula libera, ritorna un boolean
	 * @param aula l'oggetto da salvare (della classe AulaLibera)
	 * @return  Boolean
	 * @see AulaLibera
	 * */
	@Override
	public boolean doSave(AulaLibera aula) {

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("insert into libera values (?, ?, ?);");
			Orario or = DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(aula.getOrario().getInizio(), aula.getOrario().getFine());
			if(or.getIdOrario() <= 0) {
				System.out.println("orario è null");
				or = new Orario(aula.getOrario().getInizio(), aula.getOrario().getFine());
				DAOFactory.getOrarioDAO().doSave(or);
			}
			ps.setString(1, aula.getAula().getNomeAula());
			ps.setString(2, aula.getOrario().getGiorno());
			ps.setInt(3, or.getIdOrario());
			//inserisce i campi

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
	 * Effettua il salvataggio nel database dell'oggetto aulaLibera, 
	 * se l'oggetto è già presente, lo modifica con i parametri inseriti, 
	 * ritorna l'esito dell'operazione
	 * @param aula l'oggetto da salvare (della classe AulaLibera)
	 * @param giorno il nuovo giorno in cui l'aula è libera(se si modifica)
	 * @param o il nuovo orario in cui l'aula è libera(se si modifica)
	 * @return  Boolean
	 * @see AulaLibera
	 * */
	@Override
	public boolean doSaveOrUpdate(AulaLibera aula, String giorno,  Orario o) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;
		Orario or = DAOFactory.getOrarioDAO().doRetrieveByKey(o.getIdOrario());
		if(or.getIdOrario() <= 0) {
			System.out.println("orario è null");
			or = new Orario(o.getInizio(), o.getFine());
			DAOFactory.getOrarioDAO().doSave(or);
			or.setIdOrario(DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(o.getInizio(), o.getFine()).getIdOrario());
		}
		try {
			//dichiara lo statement
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("update libera set giorno = ?, orario = ? where aula = ? and giorno =? and orario = ?;");

			ps.setString(1, giorno);
			ps.setInt(2, or.getIdOrario());
			ps.setString(3, aula.getAula().getNomeAula());
			ps.setString(4, aula.getGiorno());
			ps.setInt(5, aula.getOrario().getIdOrario());

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
	 * Effettua la cancellazione dal database dell'oggetto aulaLibera, 
	 * ritorna l'esito dell'operazione
	 * @param 	aula l'oggetto da eliminare(della classe AulaLibera)
	 * @return  Boolean
	 * @see 	AulaLibera
	 * */
	@Override
	public boolean doDelete(AulaLibera aula) {

		String nome=aula.getAula().getNomeAula();
		String giorno = aula.getGiorno();
		int id = aula.getOrario().getIdOrario();

		return doDeleteByKey(nome, giorno, id);
	}

	/**
	 * Effettua la cancellazione dal database dell'oggetto aulaLibera, 
	 * ritorna l'esito dell'operazione
	 * @param 	nomeAula l'attributo nome dell'oggetto da eliminare(della classe AulaLibera)
	 * @param 	giorno l'attributo giorno dell'oggetto da eliminare(della classe AulaLibera)
	 * @param 	idOrario l'attributo id dell'oggetto da eliminare(della classe AulaLibera)
	 * @return  Boolean
	 * @see 	AulaLibera
	 * */
	@Override
	public boolean doDeleteByKey(String nomeAula, String giorno, int idOrario) {

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("delete from libera where aula = ? and giorno=? and orario = ?;");
			ps.setString(1, nomeAula);
			ps.setString(2, giorno);
			ps.setInt(3, idOrario);

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
	 * Effettua la cancellazione dal database dell'oggetto aulaLibera, 
	 * ritorna l'esito dell'operazione
	 * @param 	idOrario l'attributo id dell'oggetto da eliminare(della classe AulaLibera)
	 * @return  Boolean
	 * @see 	AulaLibera
	 * */
	public boolean doDeleteByOrario(int idOrario) {

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("delete from libera where orario = ?;");
			ps.setInt(1, idOrario);

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
	 * Interroga il database per trovare l'oggetto aulaLibera in base ai parametri inseriti
	 * ritorna l'oggetto, se trovato
	 * @param	nomeAula l'attributo nome dell'oggetto(della classe AulaLibera)
	 * @param	giorno l'attributo giorno dell'oggetto(della classe AulaLibera)
	 * @param	idOrario l'attributo id dell'oggetto(della classe Orario)
	 * @return 	AulaLibera
	 * @see 	AulaLibera
	 * @see		Orario
	 * */
	@Override
	public AulaLibera doRetrieveByKey(String nomeAula, String giorno, int idOrario){
		Connection connection = null;
		PreparedStatement ps = null;
		AulaLibera b = new AulaLibera();
		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from libera where aula = ? and giorno = ? and orario = ?;");
			ps.setString(1, nomeAula);
			ps.setString(2, giorno);
			ps.setInt(3, idOrario);
			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			if (result.next()) {

				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				b.setOrario(DAOFactory.getOrarioDAO().doRetrieveByKey(result.getInt("orario")));
				b.setGiorno(giorno);


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
		return b;

	}

	/**
	 * Interroga il database per trovare una lista di oggetti aulaLibera 
	 * in base ai parametri inseriti, ritorna l'oggetto, se trovato
	 * @param	nomeAula l'attributo nome dell'oggetto(della classe AulaLibera)
	 * @return 	List<AulaLibera>
	 * @see 	AulaLibera
	 * */
	@Override
	public List<AulaLibera> doRetrieveByName(String nomeAula) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<AulaLibera> aule = new ArrayList<>();

		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from libera where aula = ?;");
			ps.setString(1, nomeAula);
			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				AulaLibera b = new AulaLibera();
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				b.setOrario(DAOFactory.getOrarioDAO().doRetrieveByKey(result.getInt("orario")));
				b.setGiorno(b.getOrario().getGiorno());

				// aggiunge l'oggetto alla lista
				aule.add(b);
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
		return aule;
	}	


	/**
	 * Interroga il database per trovare una lista di oggetti aulaLibera 
	 * in base ai parametri inseriti, ritorna l'oggetto, se trovato
	 * @param	data l'attributo inizio dell'oggetto(della classe Orario)che è attributo di AulaLibera
	 * @return 	List<AulaLibera>
	 * @see 	AulaLibera
	 * @see 	Orario
	 * */
	@Override
	public List<AulaLibera> doRetrieveByDate(Timestamp data) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<AulaLibera> aule = new ArrayList<>();

		System.out.println(data.getDate() +" "+data.getYear()+" "+data.getMonth());
		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from libera join orario on  orario.id=libera.orario where orario.inizio >= ? and orario.inizio < ?;");
			ps.setTimestamp(1, data);
			data.setHours(data.getHours()+10);
			System.out.println(data.getDay());
			ps.setTimestamp(2, data);
			data.setHours(data.getHours()-10);
			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				AulaLibera b = new AulaLibera();
				//	System.out.println(result.getString("aula")+" "+result.getInt("id"));
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				b.setOrario(DAOFactory.getOrarioDAO().doRetrieveByKey(result.getInt("id")));
				b.setGiorno(b.getOrario().getGiorno());
				//	System.out.println(b.getAula().getNomeAula()+" "+b.getOrario().getInizio());
				// aggiunge l'oggetto alla lista
				aule.add(b);
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
		return aule;
	}

	/**
	 * Interroga il database per trovare una lista di tutti gli oggetti aulaLibera 
	 * ritorna la lista, se trova oggetti
	 * @return 	List<AulaLibera>
	 * @see 	AulaLibera
	 * */
	@Override
	public List<AulaLibera> doRetrieveAll() {
		Connection connection = null;
		PreparedStatement ps = null;
		List<AulaLibera> aule = new ArrayList<>();

		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from libera;");

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				AulaLibera b = new AulaLibera();
				b.setAula(DAOFactory.getAulaDAO().doRetrieveByKey(result.getString("aula")));
				b.setOrario(DAOFactory.getOrarioDAO().doRetrieveByKey(result.getInt("orario")));
				b.setGiorno(b.getOrario().getGiorno());

				// aggiunge l'oggetto alla lista
				aule.add(b);
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
		return aule;
	}


}
