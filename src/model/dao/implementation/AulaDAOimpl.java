package model.dao.implementation;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Aula;
import model.bean.GruppoDiStudio;
import model.dao.DAOFactory;
import model.dao.interfaces.AulaDAO;
import model.db_connection.DriverManagerConnectionPool;
/**
 *
 * AulaDAOimpl.java
 * Gestisce la persistenza degli oggetti di tipo Aula
 * tramite interazioni con il database
 *
 * @author F. Megliola & A. Capodanno
 * @since 12-16-2018
 *
 *
 * */


public class AulaDAOimpl implements AulaDAO {

	/**
	 * Effettua il salvataggio nel database dell'oggetto aula, ritorna un boolean
	 * @param aula l'oggetto da salvare (della classe Aula)
	 * @return  Boolean
	 * @see Aula
	 * */
	@Override
	public boolean doSave(Aula aula) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();
            Aula valore = DAOFactory.getAulaDAO().doRetrieveByKey(aula.getNomeAula());
            if(valore!=null) {
            	return false;
            }
			ps = connection.prepareStatement("insert into aula values (?, ?);");                  //Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input

			ps.setString(1, aula.getNomeAula());                                                  // passiamo indice  e il valore che sarà inserito nel placeholder '?'
			ps.setString(2, aula.getEdificio());												  // passiamo indice  e il valore che sarà inserito nel placeholder '?'

			result = ps.executeUpdate();                                                          //Esegue la query e ritorna 1

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

	/**
	 * Effettua il salvataggio nel database dell'oggetto aula,
	 * se l'oggetto è già presente, lo modifica con i parametri inseriti,
	 * ritorna l'esito dell'operazione
	 * @param aula l'oggetto da salvare (della classe Aula)
	 * @param nomeAula il nuovo nome dell'aula(se si modifica)
	 * @param nomeEdificio il nuovo nome dell'edificio(se si modifica)
	 * @return  Boolean
	 * @see Aula
	 * */
	@Override
	public boolean doSaveOrUpdate(Aula aula, String nomeAula,String nomeEdificio) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			connection = DriverManagerConnectionPool.getConnection();

			if( nomeEdificio.isEmpty()==false || nomeEdificio==null) { // se il nome edificio è vuoto o null

				ps = connection.prepareStatement("update aula set nome= ? where nome=?");      										 //Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input

				ps.setString(1, nomeAula);																							 // passiamo indice  e il valore che sarà inserito nel placeholder '?'
				ps.setString(2,aula.getNomeAula());                                                                                  // passiamo indice  e il valore che sarà inserito nel placeholder '?'

				result = ps.executeUpdate();                                                                                         //Esegue la query e ritorna un oggetto Result set

			} else { // altrimenti

				ps = connection.prepareStatement("update aula set nome = ? , edificio = ? where nome = ? and edificio = ?");	//Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input

				ps.setString(1, nomeAula);                                                                                      // passiamo indice  e il valore che sarà inserito nel placeholder '?'
				ps.setString(2,nomeEdificio);                                                                                   // passiamo indice  e il valore che sarà inserito nel placeholder '?'
				ps.setString(3, aula.getNomeAula());                                                                      // passiamo indice  e il valore che sarà inserito nel placeholder '?'
				ps.setString(4, aula.getEdificio());                                                                            // passiamo indice  e il valore che sarà inserito nel placeholder '?'

				result = ps.executeUpdate();                                                                                    //Esegue la query e ritorna 1
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
		return (result == 1);
	}

	/**
	 * Effettua la cancellazione dal database dell'oggetto aula,
	 * ritorna l'esito dell'operazione
	 * @param 	aula l'oggetto da eliminare (della classe Aula)
	 * @return  Boolean
	 * @see 	Aula
	 * */
	@Override
	public boolean doDelete(Aula aula) {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("delete from aula where nome=? and edificio=?");	//Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
			ps.setString(1, aula.getNomeAula());                                                // passiamo indice  e il valore che sarà inserito nel placeholder  '?'
			ps.setString(2, aula.getEdificio());                                                // passiamo indice  e il valore che sarà inserito nel placeholder '?'
			result = ps.executeUpdate();                                                        //Esegue la query e ritorna 1

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

	/**
	 * Effettua la cancellazione dal database dell'oggetto aula,
	 * ritorna l'esito dell'operazione
	 * @param 	nomeAula l'attributo nome dell'oggetto da eliminare(della classe Aula)
	 * @return  Boolean
	 * @see 	Aula
	 * */
	@Override
	public boolean doDelete(String nomeAula) {

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("delete from aula where nome=? "); 	     //Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
			ps.setString(1,nomeAula);                                                    // passiamo indice  e il valore che sarà inserito nel placeholder '?'
			result = ps.executeUpdate();      											 //Esegue la query e ritorna 1

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

	/**
	 * Interroga il database per trovare l'oggetto aula in base ai parametri inseriti
	 * ritorna l'oggetto, se trovato
	 * @param	nomeAula il nome dell'oggetto(della classe Aula)
	 * @return 	Aula
	 * @see 	Aula
	 * */
	@Override
	public Aula doRetrieveByKey(String nomeAula) {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet result;
		Aula aula;

		try {

			connection = DriverManagerConnectionPool.getConnection();				    //
			ps = connection.prepareStatement("select * from aula where nome=?");	    //Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
			ps.setString(1, nomeAula);                                                  // passiamo indice  e il valore che sarà inserito nel placeholder
			result = ps.executeQuery();                                                 //Esegue la query e ritorna un oggetto Result set
			String nome="";														    	//variabile per contenere il risultato query
			String edificio="";														    //variabile per contenere il risultato query

			/*Per ottenre  i risultati query*/

			while(result.next()) { //inzio ciclo  condizione

				nome = result.getNString(1);										    	//restituisce il risultato della colonna 1 della query

				edificio=result.getNString(2);									      	//restituisce il  risulatato della  colonna 2 della query

			}//fine Ciclo

			if(nome.isEmpty() && edificio.isEmpty()) {						           /*Verifica Se nome == vuoto e edificio==vuoto return null*/
				return null;
			}else { 														           /* Altrimenti instanzia l'oggetto  Aula con nome e edificio return aula*/

				aula=new Aula(nome,edificio);
				return aula;
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

	/**
	 * Interroga il database per trovare una lista di tutti gli oggetti aula
	 * ritorna la lista, se trova oggetti
	 * @return 	List<Aula>
	 * @see 	Aula
	 * */
	@Override
	public List<Aula> doRetrieveAll() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet result;
		List <Aula> aula = new ArrayList <Aula>();//Istanzia Lista Aula

		try {

			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement("select * from aula ");					//Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
			result = ps.executeQuery();                                                //Esegue la query e ritorna un oggetto Result set

			/*Per ottenre  i risultati query*/

			while(result.next()) {//Inzio Ciclo

				String	nome = result.getNString(1);            							   //Istanzia la variabile con  il risultato della colonna 1 della query
				String 	edificio = result.getNString(2);          						   //Istanzia la variabile con  il risultato della colonna 2 della query
				aula.add(new Aula(nome,edificio));             							   //Istanzia e inserisce nella lista l'oggetto aula

			}//Fine

			if(aula.isEmpty())  													   //Se la lista è vuota return null
				return null;
			else 															   //altrimenti return la lista contente gli oggetti Aula
				return aula;


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

}
