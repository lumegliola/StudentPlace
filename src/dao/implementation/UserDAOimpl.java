package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.GruppoDiStudio;
import bean.Utente;
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
			if (user.getCredenziali().isAdmin()) {
				//dichiara lo statement
				ps = connection.prepareStatement("insert into amministratore values (?, ?, ?);");
			
				//inserisce i campi
				ps.setString(1, user.getMatricola());
				ps.setObject(2, user.getNome());
				ps.setString(3, user.getCognome());
			
				//esegue lo statement
				result = ps.executeUpdate();
			
			}
			else { // se l'utente è uno studente
				//dichiara lo statement
				ps = connection.prepareStatement("insert into studente values (?, ?, ?);");
			
				//inserisce i campi
				ps.setString(1, user.getMatricola());
				ps.setObject(2, user.getNome());
				ps.setString(3, user.getCognome());
			
				//esegue lo statement
				result = ps.executeUpdate();	
			
			}
			//salva anche le credenziali
			DAOFactory.getCredenzialiDAO().doSave(user.getCredenziali());

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
		return DAOFactory.getCredenzialiDAO().doSaveOrUpdate(user.getCredenziali(), password);
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
			ps = connection.prepareStatement("select * from studente where matricola = ?;");
			ps.setString(1, matricola);
			
			//esegue lo statement
			ResultSet result1 = ps.executeQuery();
			//ricava i risultati
			
			if(result1.next()) {
				
				//utente
				psDel = connection.prepareStatement("delete * from studente where matricola = ?");
				psDel.setString(1, matricola);
			}else {
				
				//Amministratore
				psDel = connection.prepareStatement("delete * from amministratore where matricola = ?");
				psDel.setString(1, matricola);
			}
			
			//elimina anche le credenziali
			DAOFactory.getCredenzialiDAO().doDelete(matricola);

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
	public Utente doRetrieveAdminByKey(String matricola) {
		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement psAmm = null;

		try {
			Utente b = new Utente();
			b.setMatricola(matricola);

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from amministratore where matricola = ?;");
			ps.setString(1, matricola);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//studente
			if(result.next()) {
				b.setNome(result.getString("nome"));
				b.setCognome(result.getString("cognome"));
				b.setCredenziali(DAOFactory.getCredenzialiDAO().doRetrieveByMatricola(matricola));
				return b;
			}else {
				return doRetrieveStudentByKey(matricola);
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
	public Utente doRetrieveStudentByKey(String matricola) {
		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement psAmm = null;

		try {
			Utente b = new Utente();
			b.setMatricola(matricola);

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from studente where matricola = ?;");
			ps.setString(1, matricola);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//studente
			if(result.next()) {
				b.setNome(result.getString("nome"));
				b.setCognome(result.getString("cognome"));
				b.setCredenziali(DAOFactory.getCredenzialiDAO().doRetrieveByMatricola(matricola));
				return b;
			}else {
				return doRetrieveStudentByKey(matricola);
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
		PreparedStatement ps2 = null;
		List <Utente> utenti = new ArrayList<>();

		try {

			connection = DriverManagerConnectionPool.getConnection();
			
			//dichiara lo statement
			ps = connection.prepareStatement("select * from amministratore;");

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				Utente b = new Utente();
				b.setMatricola(result.getString("matricola"));
				b.setNome(result.getString("nome"));
				b.setCognome("cognome");
				b.setCredenziali(DAOFactory.getCredenzialiDAO().doRetrieveByMatricola(b.getMatricola()));
				
			// aggiunge l'oggetto alla lista
				utenti.add(b);
			}
			ps2 = connection.prepareStatement("select * from studenti;");

			//esegue lo statement
			ResultSet result1 = ps.executeQuery();

			//ricava i risultati
			while (result.next()) {
				Utente b = new Utente();
				b.setMatricola(result1.getString("matricola"));
				b.setNome(result1.getString("nome"));
				b.setCognome("cognome");
				b.setCredenziali(DAOFactory.getCredenzialiDAO().doRetrieveByMatricola(b.getMatricola()));
				
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
