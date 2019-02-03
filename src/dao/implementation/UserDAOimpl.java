package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.*;
import dao.DAOFactory;
import dao.interfaces.UserDAO;
import db_connection.DriverManagerConnectionPool;

/**
 * 
 * UserDAOimpl.java
 * Gestisce la persistenza degli oggetti di tipo Utente 
 * tramite interazioni con il database
 * 
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 * 
 * */

public class UserDAOimpl implements UserDAO {

	/**
	 * Effettua il salvataggio nel database dell'oggetto utente,
	 * ritorna un boolean
	 * @param user l'oggetto da salvare (della classe Utente)
	 * @return  Boolean
	 * @see Utente
	 * */
	@Override
	public boolean doSave(Utente user) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();

			//se l'utente è amministratore ammminitratore
				
					ps = connection.prepareStatement("insert into utente values (?, ?, ?, ?, ?, ?);");

					//inserisce i campi
					ps.setString(1, user.getMatricola());
					ps.setObject(2, user.getNome());
					ps.setString(3, user.getCognome());
					ps.setString(4, user.getMail());
					ps.setObject(5, user.getPassword());
					ps.setBoolean(6, user.isAdmin());
					
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
	 * Effettua il salvataggio nel database dell'oggetto utente, 
	 * se l'oggetto è già presente, lo modifica con i parametri inseriti, 
	 * ritorna l'esito dell'operazione
	 * @param user l'oggetto da salvare (della classe Utente)
	 * @param password la nuova password dell'utente(se si modifica)
	 * @return  Boolean
	 * @see Utente
	 * */
	@Override
	public boolean doSaveOrUpdate(Utente user, String password) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;		
		
		try {
			connection = DriverManagerConnectionPool.getConnection();

			//se l'utente è amministratore ammminitratore
				
					ps = connection.prepareStatement("update utente set password = ? where email = ?;");

					//inserisce i campi
					ps.setString(1, password);
					ps.setString(2, user.getMail());
				
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
	 * Effettua la cancellazione dal database dell'oggetto utente, 
	 * ritorna l'esito dell'operazione
	 * @param 	user l'oggetto da eliminare(della classe Utente)
	 * @return  Boolean
	 * @see 	Utente
	 * */
	@Override
	public boolean doDelete(Utente user) {
		return doDelete(user.getMail());
	}

	/**
	 * Effettua la cancellazione dal database dell'oggetto utente, 
	 * ritorna l'esito dell'operazione
	 * @param 	mail l'attributo mail dell'oggetto da eliminare(della classe Utente)
	 * @return  Boolean
	 * @see 	Utente
	 * */
	@Override
	public boolean doDelete(String mail) {
		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement psDel = null;
		int result = 0;
		Utente ut=DAOFactory.getUserDAO().doRetrieveByMail(mail);
		
		List<Iscrizione> listIscr= DAOFactory.getIscrizioneDAO().doRetrieveByUser(ut.getMatricola());
		for(Iscrizione iscr : listIscr) {
		DAOFactory.getIscrizioneDAO().doDeleteByUserAndGroup(iscr.getIscritto().getMatricola(), iscr.getGruppo().getId());
       }
		try {
			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("delete  from utente where email = ?;");
			ps.setString(1, mail);
			
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
	 * Interroga il database per trovare un oggetto utente 
	 * in base ai paramentri inseriti, ritorna l'oggetto, se lo trova
	 * @param 	matricola l'attributo matricola dell'oggetto(della classe Utente)
	 * @return 	Utente
	 * @see 	Utente
	 * */
	@Override
	public Utente doRetrieveByKey(String matricola) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			Utente b = new Utente();
		

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from utente where matricola = ?;");
			ps.setString(1, matricola);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//studente
			if(result.next()) {
				b.setNome(result.getString("nome"));
				b.setMatricola(result.getString("matricola"));
				b.setMail(result.getString("email"));
				b.setCognome(result.getString("cognome"));
				b.setPassword(result.getString("password"));
				b.setAdmin(result.getBoolean("amministratore"));
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
	 * Interroga il database per trovare una lista di tutti gli oggetti Utente
	 * ritorna la lista, se trova oggetti
	 * @return 	List<Utente>
	 * @see 	Utente
	 * */
	@Override
	public List<Utente> doRetrieveAll() {
		Connection connection = null;
		PreparedStatement ps = null;
		
		List <Utente> utenti = new ArrayList<>();

		try {

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("select * from utente;");

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				Utente b = new Utente();
				b.setNome(result.getString("nome"));
				b.setCognome(result.getString("cognome"));
				b.setMail(result.getString("email"));
				b.setPassword(result.getString("password"));
				b.setAdmin(result.getBoolean("amministratore"));

				// aggiunge l'oggetto alla lista
				utenti.add(b);
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
		return utenti;
	}

	/**
	 * Interroga il database per trovare un oggetto utente 
	 * in base ai paramentri inseriti, ritorna l'oggetto, se lo trova
	 * @param 	mail l'attributo mail dell'oggetto(della classe Utente)
	 * @param 	password l'attributo password dell'oggetto(della classe Utente)
	 * @return 	Utente
	 * @see 	Utente
	 * */
	@Override
	public Utente doRetrieveByMailAndPass(String mail, String password) {
		
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			Utente b = new Utente();
			b.setMail(mail);
			b.setPassword(password);

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from utente where email = ? and password = ? ;");
			ps.setString(1, mail);
			ps.setString(2, password);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//studente
			if(result.next()) {
				b.setNome(result.getString("nome"));
				b.setCognome(result.getString("cognome"));
				b.setMatricola(result.getString("matricola"));
				b.setMail(result.getString("email"));
				b.setPassword(result.getString("password"));
				b.setAdmin(result.getBoolean("amministratore"));
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
	 * Interroga il database per trovare un oggetto utente 
	 * in base ai paramentri inseriti, ritorna l'oggetto, se lo trova
	 * @param 	mail l'attributo mail dell'oggetto(della classe Utente)
	 * @return 	Utente
	 * @see 	Utente
	 * */
	@Override
	public Utente doRetrieveByMail(String mail) {
		
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			Utente b = new Utente();
			b.setMail(mail);
			

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from utente where email = ? ;");
			ps.setString(1, mail);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//studente
			if(result.next()) {
				b.setNome(result.getString("nome"));
				b.setCognome(result.getString("cognome"));
				b.setMail(result.getString("email"));
				b.setPassword(result.getString("password"));
				b.setAdmin(result.getBoolean("amministratore"));
				b.setMatricola(result.getString("matricola"));
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

}
