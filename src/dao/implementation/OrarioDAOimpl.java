package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import bean.GruppoDiStudio;
import bean.Orario;
import dao.DAOFactory;
import dao.interfaces.OrarioDAO;
import db_connection.DriverManagerConnectionPool;

public class OrarioDAOimpl implements OrarioDAO {

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

	@Override
	public boolean doSaveOrUpdate(Orario or, Timestamp start, Timestamp end) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;
         start.setYear(start.getYear()-1900);
         end.setYear(end.getYear()-1900);
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
		
	@Override
	public boolean doDelete(Orario or) {
		return doDelete(or.getIdOrario());
	}
	
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
				b.setIdOrario(result.getInt("id"));
				b.setInizio(start);
				b.setFine(result.getTimestamp("fine"));

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
				
				b.setIdOrario(result.getInt("id"));
				b.setInizio(result.getTimestamp("inizio"));
				b.setFine(result.getTimestamp("fine"));
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
				b.setIdOrario(result.getInt("id"));
				b.setInizio(result.getTimestamp("inizio"));
				b.setFine(result.getTimestamp("fine"));

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
