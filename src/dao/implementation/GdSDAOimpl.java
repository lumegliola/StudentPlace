package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import bean.GruppoDiStudio;
import bean.Orario;
import dao.DAOFactory;
import dao.interfaces.GdSDAO;
import db_connection.DriverManagerConnectionPool;



public class GdSDAOimpl implements GdSDAO {

	@Override
	public boolean doSave(GruppoDiStudio gds) {		//Inserisce nel DB  l'oggetto gds
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			//dichiara lo statement
			ps = connection.prepareStatement("insert into gds values (?, ?, ?, ?, ?, ?, ?);");

			//inserisce i campi
			ps.setString(1, gds.getNomeGruppo());
			ps.setObject(2, gds.getCreatore());
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

	@Override
	public boolean doSaveOrUpdate(GruppoDiStudio gds, String nomeGruppo, String nomeAula, GregorianCalendar fine) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			//dichiara lo statement
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("update gds set nome = ?, aula = ?, oraFine = ? where name ="+ gds.getNomeGruppo()+" ;");

			if(nomeGruppo != "")
				ps.setString(1, nomeGruppo);
			else
				ps.setString(1, gds.getNomeGruppo());

			if(nomeAula != "")
				ps.setString(2, nomeAula);
			else
				ps.setString(2, gds.getAula().getNomeAula());

			if(Orario.class.equals(null)) {
				ps.setTimestamp(3, gds.getOrario().getFine());
			}
			else
				ps.setTime(3, new java.sql.Time(fine.getTimeInMillis()));

			//esegue lo statement
			result = ps.executeUpdate();

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

	@Override
	public boolean doDelete(GruppoDiStudio gds) {
		return doDeleteByNameAndSubjet(gds.getNomeGruppo(),gds.getMateria());
	}

	@Override
	public boolean doDeleteByNameAndSubjet(String nomeGruppo,String materia) {

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

	@Override
	public GruppoDiStudio doRetrieveByName(String nomeGruppo) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			GruppoDiStudio b = new GruppoDiStudio();
			b.setNomeGruppo(nomeGruppo);

			connection = DriverManagerConnectionPool.getConnection();
			//dichiara lo statement
			ps = connection.prepareStatement("select * from gds where name = ?;");
			ps.setString(1, nomeGruppo);

			//esegue lo statement
			ResultSet result = ps.executeQuery();

			//ricava i risultati
			if(result.next()) {
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveAdminByKey(result.getString("creatore")));
				b.setMateria(result.getString("materia"));

				b.setGiorno();
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
	public GruppoDiStudio doRetrieveBySubject(String materia) {

		Connection connection = null;
		PreparedStatement ps = null;

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
			if(result.next()) {
				b.setNomeGruppo(result.getString("nome"));
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveAdminByKey(result.getString("creatore")));

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
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveAdminByKey(result.getString("creatore")));
				b.setMateria(materia);

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
				b.setCreatore(DAOFactory.getUserDAO().doRetrieveAdminByKey(result.getString("creatore")));
				b.setMateria(result.getString("materia"));
				b.setOrario(result.getTimestamp("orainizio"), result.getTimestamp("oraFine"));
				b.setGiorno();
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

}
