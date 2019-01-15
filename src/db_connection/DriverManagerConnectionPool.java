 package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool  {

	private static List<Connection> freeDbConnections;    //lista di connessioni

	static {
		freeDbConnections = new LinkedList<Connection>();				//il caricamento del driver deve avvenire prima che il collegamento sia stabilito
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");						//		in questo momento passiamo il nome del driver
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found:"+ e.getMessage());
		} 
	}
	
	private static synchronized Connection createDBConnection() throws SQLException {				//passiamo l'url contenetne il nome del db, Utente , password e parametri vari
		Connection newConnection = null;	
		String ip = "localhost";
		String port = "3306";
		String db = "StudentPlaceDB";
		String username = "root";
		String password = "root";

		newConnection = DriverManager.getConnection("jdbc:mysql://"+ ip + ":" + port + "/" + db + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
        
		newConnection.setAutoCommit(true);			//preserva l'integrità dei dati, inviando un unico pacchetto di informazioni
		return newConnection;
	}

	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {										//se la lista di connessioni non è vuota, preleva la prima
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())										//se la connessione e chiusa, la riottiene
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();									//altrimenti crea la connessione al db
		}

		return connection;
	}

	public static synchronized void releaseConnection(Connection connection) throws SQLException {
		if(connection != null) freeDbConnections.add(connection);									//rimette la connessione in lista, se esiste				
	}
}
