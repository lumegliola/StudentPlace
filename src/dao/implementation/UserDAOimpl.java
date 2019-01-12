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

			//se l'utente � amministratore ammminitratore
				
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

			//se l'utente � amministratore ammminitratore
				
					ps = connection.prepareStatement("update utente set password = ? where matricola = ?;");

					//inserisce i campi
					ps.setString(1, password);
					ps.setString(2, user.getMatricola());
				
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
		return doDelete(user.getMatricola());
	}

	@Override
	public boolean doDelete(String matricola) {
		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement psDel = null;
		int result = 0;

		try {
			Utente b = new Utente();
			b.setMatricola(matricola);

			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("delete * from studente where matricola = ?;");
			ps.setString(1, matricola);


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
			b.setMatricola(matricola);

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from utente where matricola = ?;");
			ps.setString(1, matricola);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//studente
			if(result.next()) {
				b.setNome(result.getString("nome"));
				b.setCognome(result.getString("cognome"));
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

}
