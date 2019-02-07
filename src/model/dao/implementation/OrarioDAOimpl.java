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
import model.bean.GruppoDiStudio;
import model.bean.Iscrizione;
import model.bean.Orario;
import model.dao.DAOFactory;
import model.dao.interfaces.OrarioDAO;
import model.db_connection.DriverManagerConnectionPool;

/**
 *
 * OrarioDAOimpl.java
 * Gestisce la persistenza degli oggetti di tipo Orario
 * tramite interazioni con il database
 *
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 *
 * */

public class OrarioDAOimpl implements OrarioDAO {

	/**
	 * Effettua il salvataggio nel database dell'oggetto orario,
	 * ritorna un boolean
	 * @param or l'oggetto da salvare (della classe Orario)
	 * @return  Boolean
	 * @see Orario
	 * */

	@Override
	public boolean doSave(Orario or) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("insert into orario (inizio, fine) values (?, ?);");

			//inserisce i campi
			or.getInizio();
			or.getFine();
			ps.setTimestamp(1, or.getInizio());
			ps.setTimestamp(2, or.getFine());

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
	 * Effettua il salvataggio nel database dell'oggetto Orario,
	 * se l'oggetto è già presente, lo modifica con i parametri inseriti,
	 * ritorna l'esito dell'operazione
	 * @param or l'oggetto da salvare (della classe Orario)
	 * @param start il nuovo orario di inizio(se si modifica)
	 * @param end il nuovo orario di fine(se si modifica)
	 * @return  Boolean
	 * @see Orario
	 * */
	@Override
	public boolean doSaveOrUpdate(Orario or, Timestamp start, Timestamp end) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			Orario or2 = doRetrieveByStartAndFinish(or.getInizio(), or.getFine());
			int id = 0;
			if (or2 != null) {
				id  = or2.getIdOrario();
			}else
				System.out.println("orario non presente nel database");

			//dichiara lo statement
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("update orario set inizio = ?, fine = ? where id =? ;");

			//CONTROLLA CAMPI DA NON MODIFICARE

			ps.setTimestamp(1, start);
			ps.setTimestamp(2, end);
			System.out.println("id = "+id);
			ps.setInt(3, id);

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
	 * Effettua la cancellazione dal database dell'oggetto orario,
	 * ritorna l'esito dell'operazione
	 * @param 	or l'oggetto da eliminare(della classe Orario)
	 * @return  Boolean
	 * @see 	Orario
	 * */
	@Override
	public boolean doDelete(Orario or) {
		return doDelete(or.getIdOrario());
	}

	/**
	 * Effettua la cancellazione dal database dell'oggetto orario,
	 * ritorna l'esito dell'operazione
	 * @param 	id l'attributo id dell'oggetto da eliminare(della classe Orario)
	 * @return  Boolean
	 * @see 	Orario
	 * */
	@Override
	public boolean doDelete(int id) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("delete from orario where id = ?;");
			ps.setInt(1, id);

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
	 * Interroga il database per trovare un oggetto Orario
	 * in base ai paramentri inseriti, ritorna l'oggetto, se lo trova
	 * @param 	id l'attributo idOrario dell'oggetto(della classe Orario)
	 * @return 	Orario
	 * @see 	Orario
	 * */
	@Override
	public Orario doRetrieveByKey(int id) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			Orario b = new Orario();
			b.setIdOrario(id);

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from orario where id = ?;");
			ps.setInt(1, id);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			if(result.next()) {
				Timestamp inizio = result.getTimestamp("inizio");
				Timestamp fine = result.getTimestamp("fine");
				inizio.setYear(inizio.getYear()+1900);
				fine.setYear(fine.getYear()+1900);
				b.setInizio(inizio);
				b.setFine(fine);
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
	 * Interroga il database per trovare una lista di oggetti Orario
	 * in base ai paramentri inseriti, ritorna la lista, se trova oggetti
	 * @param 	start l'attributo inizio dell'oggetto(della classe Orario)
	 * @return 	Orario
	 * @see 	Orario
	 * */
	@Override
	public List<Orario> doRetrieveByStart(Timestamp start) {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Orario> orari = new ArrayList<>();

		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from orario where inizio = ?;");
			ps.setTimestamp(1, start);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				Orario b = new Orario();
				Timestamp inizio = result.getTimestamp("inizio");
				Timestamp fine = result.getTimestamp("fine");
				inizio.setYear(inizio.getYear()+1900);
				fine.setYear(fine.getYear()+1900);
				b.setIdOrario(result.getInt("id"));
				b.setInizio(inizio);
				b.setFine(fine);

			// aggiunge l'oggetto alla lista
				orari.add(b);
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
		return orari;
	}

	/**
	 * Interroga il database per trovare un oggetto Orario
	 * in base ai paramentri inseriti, ritorna l'oggetto, se lo trova
	 * @param 	start l'attributo inizio dell'oggetto(della classe Orario)
	 * @param 	finish l'attributo fine dell'oggetto(della classe Orario)
	 * @return 	Orario
	 * @see 	Orario
	 * */
	@Override
	public Orario doRetrieveByStartAndFinish(Timestamp start, Timestamp finish) {
		Connection connection = null;
		PreparedStatement ps = null;
		Orario b = new Orario();

		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from orario where inizio = ? and fine = ?;");

			ps.setTimestamp(1, start);
			ps.setTimestamp(2, finish);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			if (result.next()) {
				Timestamp inizio = result.getTimestamp("inizio");
				Timestamp fine = result.getTimestamp("fine");
				inizio.setYear(inizio.getYear()+1900);
				fine.setYear(fine.getYear()+1900);
				b.setIdOrario(result.getInt("id"));
				b.setInizio(inizio);
				b.setFine(fine);
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
	 * Interroga il database per trovare una lista di tutti gli oggetti Orario
	 * ritorna la lista, se trova oggetti
	 * @return 	List<Orario>
	 * @see 	Orario
	 * */
	@Override
	public List<Orario> doRetrieveAll() {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Orario> orari = new ArrayList<>();

		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from orario;");

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				Orario b = new Orario();
				Timestamp inizio = result.getTimestamp("inizio");
				Timestamp fine = result.getTimestamp("fine");
				inizio.setYear(inizio.getYear()+1900);
				fine.setYear(fine.getYear()+1900);
				b.setIdOrario(result.getInt("id"));
				b.setInizio(inizio);
				b.setFine(fine);

			// aggiunge l'oggetto alla lista
				orari.add(b);
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
		return orari;
	}
}
