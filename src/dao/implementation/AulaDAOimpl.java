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
			ps = connection.prepareStatement("insert into aula values (?, ?);");

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
	public boolean doSaveOrUpdate(Aula aula, String nomeAula,String nomeEdificio) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();
		   
			if( nomeEdificio.isEmpty()==false || nomeEdificio==null) {
			
			ps = connection.prepareStatement("update aula set nome= ? where nome=?");
			
			ps.setString(1, nomeAula);
			
			ps.setString(2,aula.getNomeAula());
			
			result = ps.executeUpdate();
		   }
			
			if( (nomeEdificio.isEmpty()==true && nomeEdificio!=null) && (nomeAula.isEmpty() && nomeAula!=null)) {
				
				ps = connection.prepareStatement("update aula set nome = ? , edificio = ? where nome = ? and edificio = ?");
				
				ps.setString(1, nomeAula);
				
				ps.setString(2,nomeEdificio);
				
				ps.setString(3, aula.getNomeAula());
				
				ps.setString(4, aula.getEdificio());
				
				result = ps.executeUpdate();
			   }
			

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
	public boolean doDelete(Aula aula) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			
			ps = connection.prepareStatement("delete from aula where nome=? and edificio=?");
         	
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
	public boolean doDelete(String nomeAula) {
		
		Connection connection = null;
		
		PreparedStatement ps = null;
		
		int result = 0;

		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			
			ps = connection.prepareStatement("delete from aula where nome=? ");
         	
			ps.setString(1,nomeAula);
			
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
	public Aula doRetrieveByKey(String nomeAula) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("delete from aula where nome=? and edificio=?");
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
	public List<Aula> doRetrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
