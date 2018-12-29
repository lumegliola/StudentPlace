package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import bean.Orario;
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
			ps = connection.prepareStatement("insert into  values (?, ?);");
			
			//inserisce i campi
			ps.setTimestamp(1,);
			ps.setObject(2, gds.getCreatore());
			
			//esegue lo statement
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				DriverManagerConnectionPool.releaseConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (result == 1);
	}

	@Override
	public boolean doSaveOrUpdate(Orario or, GregorianCalendar start, GregorianCalendar end) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(Orario or) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Orario doRetrieve(GregorianCalendar start, GregorianCalendar end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orario> doRetrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
