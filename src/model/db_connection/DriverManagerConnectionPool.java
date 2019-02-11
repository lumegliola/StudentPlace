 package model.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.bean.AulaLibera;

/**
*
* DriverManagerConnectionPool.java
* Gestisce la connessione dell'applicazione con il database
*
* @author F. Megliola & A. Capodanno
* @since 12-16-2018
*
*
* */


public class DriverManagerConnectionPool  {

	private static List<Connection> freeDbConnections;

	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found:"+ e.getMessage());
}
	}

	/**
	 * Crea una connessione con il database usando dei parametri preimpostati
	 * @return  Connection
	 * @see Connection
	 * */
	private static synchronized Connection createDBConnection() throws SQLException {
		Connection newConnection = null;
		String ip = "localhost";
		String port = "3306";
		String db = "StudentPlaceDB";
		String username = "root";
		String password = "root";

		newConnection = DriverManager.getConnection("jdbc:mysql://"+ ip + ":" + port + "/" + db + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);

		newConnection.setAutoCommit(true);
		return newConnection;
	}

	/**
	 * Effettua un controllo nella lista di connessioni libere, se questa è vuota,
	 * ne crea una invocando createDbConnecion()
	 * @return  Connection
	 * @see Connection
	 * */
	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();
		}

		return connection;
	}

	/**
	 * Effettua un controllo della connessione passata in input, se questa non è null,
	 * la rilascia, aggiungendola alla lista di connessioni libere
	 * @param connection la connessione da chiudere
	 * @return  Connection
	 * @see Connection
	 * */
	public static synchronized void releaseConnection(Connection connection) throws SQLException {
		if(connection != null) freeDbConnections.add(connection);
	}
}
