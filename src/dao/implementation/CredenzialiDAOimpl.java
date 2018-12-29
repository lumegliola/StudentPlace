package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import bean.Credenziali;
import dao.DAOFactory;
import dao.interfaces.CredenzialiDAO;
import db_connection.DriverManagerConnectionPool;

public class CredenzialiDAOimpl implements CredenzialiDAO {

	@Override
	public boolean doSave(Credenziali cred) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			ps = connection.prepareStatement("insert into credenziali values (?, ?,?,?);");             	     //Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
            
			ps.setString(1 , cred.getMatricola());													//passiamo indice  e il valore che sarà inserito nel placeholder '?'
			ps.setString(2 , cred.getMail());                                            	        //passiamo indice  e il valore che sarà inserito nel placeholder '?'
			ps.setString(3 ,  cred.getPassword());												    //passiamo indice  e il valore che sarà inserito nel placeholder '?'
			ps.setBoolean(4 , cred.isAdmin());													    //passiamo indice  e il valore che sarà inserito nel placeholder '?'
		
			result = ps.executeUpdate();                                                            //Esegue la query e ritorna 1

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
	public boolean doSaveOrUpdate(Credenziali cred,String password) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();
             
			if(password.isEmpty()) {
				
				return false;
				
			}else {
				
				 ps = connection.prepareStatement("update credenziale set password = ? where mail=?");     
			
				 ps.setString(1, password);
				 ps.setString(2, cred.getMail());
				
			}
		
			result = ps.executeUpdate();                                                            //Esegue la query e ritorna 1

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
	public boolean doDelete(Credenziali cred) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();

			ps = connection.prepareStatement("delete from credenziali where mail=? and password=? and matricola=? and amministratore=?");				//Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
			ps.setString(1, cred.getMail());                                             		    // passiamo indice  e il valore che sarà inserito nel placeholder  '?'
            ps.setString(2, cred.getPassword());
            ps.setString(3,cred.getMatricola());
            ps.setBoolean(4,cred.isAdmin());
            
            DAOFactory.getUserDAO().doDelete(cred.getMatricola());
            
			result = ps.executeUpdate();                                                    	    //Esegue la query e ritorna 1

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
	public boolean doDelete(String mail) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();

			ps = connection.prepareStatement("delete from credenziali where mail=?");				//Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
			ps.setString(1, mail);                                             		    // passiamo indice  e il valore che sarà inserito nel placeholder  '?'
	        
			result = ps.executeUpdate();                                                    	    //Esegue la query e ritorna 1

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
	public boolean isAdmin(Credenziali cred) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdmin(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Credenziali doRetrieveByKey(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credenziali doRetrieveByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Credenziali> doRetriveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
