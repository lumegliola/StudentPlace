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

public class UserDAOimpl implements UserDAO {

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

	@Override
	public boolean doDelete(Utente user) {
		return doDelete(user.getMail());
	}

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
