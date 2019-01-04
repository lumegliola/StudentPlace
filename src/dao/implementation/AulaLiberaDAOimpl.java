package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.AulaLibera;
import bean.GruppoDiStudio;
import bean.Orario;
import dao.DAOFactory;
import dao.interfaces.AulaLiberaDAO;
import db_connection.DriverManagerConnectionPool;

public class AulaLiberaDAOimpl implements AulaLiberaDAO{

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
			ps.setInt(3, DAOFactory.getOrarioDAO().doRetrieveByStartAndFinish(aula.getOrario().getInizio(), aula.getOrario().getFine()).getIdOrario());
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

	@Override
	public boolean doSaveOrUpdate(AulaLibera aula, Orario o) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			//dichiara lo statement
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("update libera set giorno = ?, orario = ? where aula = ? giorno =?, orario = ?;");

			ps.setString(1, o.getGiorno());
			ps.setInt(2, o.getIdOrario());
			ps.setString(3, aula.getAula().getNomeAula());
			ps.setString(4, aula.getOrario().getGiorno());
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

		@Override
		public boolean doDelete(AulaLibera aula) {
			
			String nome=aula.getAula().getNomeAula();
			String giorno = aula.getGiorno();
			int id = aula.getOrario().getIdOrario();
			
			return doDelete(nome, giorno, id);
		}

		@Override
		public boolean doDelete(String nomeAula, String giorno, int idOrario) {

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
		

		@Override
		public List<AulaLibera> doRetrieveByDate(Timestamp data) {
			Connection connection = null;
			PreparedStatement ps = null;
			List<AulaLibera> aule = new ArrayList<>();

			try {

				connection = DriverManagerConnectionPool.getConnection();

				//dichiara lo statement
				ps = connection.prepareStatement("select * from libera join orario where orario.inizio >= ?;");
				ps.setTimestamp(1, data);
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
