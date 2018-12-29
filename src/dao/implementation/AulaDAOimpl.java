package dao.implementation;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.Aula;
import dao.interfaces.AulaDAO;
import db_connection.DriverManagerConnectionPool;

public class AulaDAOimpl implements AulaDAO {

	@Override
	public boolean doSave(Aula aula) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("insert into category values (?, ?, ?);");

			ps.setString(1, aula.getNomeAula());
			ps.setString(2, aula.getEdificio());
			
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
	public boolean doSaveOrUpdate(Aula aula, String nomeAula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(Aula aula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(String nomeAula) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Aula doRetrieveByKey(String nomeAula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aula> doRetrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
