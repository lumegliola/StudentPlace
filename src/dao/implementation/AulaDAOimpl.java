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
			
			ps = connection.prepareStatement("insert into aula values (?, ?);");                  //Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
			
			ps.setString(1, aula.getNomeAula());                                                  // passiamo indice  e il valore che sarà inserito nel placeholder '?'
			
			ps.setString(2, aula.getEdificio());												  // passiamo indice  e il valore che sarà inserito nel placeholder '?'
			
			result = ps.executeUpdate();                                                          //Esegue la query e ritorna 1

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
		   
			if( nomeEdificio.isEmpty()==false || nomeEdificio==null) { // se il nome edificio è vuoto o null
			
			ps = connection.prepareStatement("update aula set nome= ? where nome=?");      										 //Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
			
			ps.setString(1, nomeAula);																							 // passiamo indice  e il valore che sarà inserito nel placeholder '?'
			
			ps.setString(2,aula.getNomeAula());                                                                                  // passiamo indice  e il valore che sarà inserito nel placeholder '?'
			
			result = ps.executeUpdate();                                                                                         //Esegue la query e ritorna un oggetto Result set
			
		   }else{ // altrimenti 
				
				ps = connection.prepareStatement("update aula set nome = ? , edificio = ? where nome = ? and edificio = ?");	//Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
				
				ps.setString(1, nomeAula);                                                                                      // passiamo indice  e il valore che sarà inserito nel placeholder '?'
				
				ps.setString(2,nomeEdificio);                                                                                   // passiamo indice  e il valore che sarà inserito nel placeholder '?'
				
				ps.setString(3, aula.getNomeAula());                                                                            // passiamo indice  e il valore che sarà inserito nel placeholder '?'
				
				ps.setString(4, aula.getEdificio());                                                                            // passiamo indice  e il valore che sarà inserito nel placeholder '?'
				
				result = ps.executeUpdate();                                                                                    //Esegue la query e ritorna 1
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
			
			ps = connection.prepareStatement("delete from aula where nome=? and edificio=?");	//Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
         	
			ps.setString(1, aula.getNomeAula());                                                // passiamo indice  e il valore che sarà inserito nel placeholder  '?'
			
         	ps.setString(2, aula.getEdificio());                                                // passiamo indice  e il valore che sarà inserito nel placeholder '?'
			
			result = ps.executeUpdate();                                                        //Esegue la query e ritorna 1

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
			
			ps = connection.prepareStatement("delete from aula where nome=? "); 	     //Crea un oggetto PreparedStatement relativo alla stringa SQL passata in input
         	
			ps.setString(1,nomeAula);                                                    // passiamo indice  e il valore che sarà inserito nel placeholder '?'
			
			result = ps.executeUpdate();      											 //Esegue la query e ritorna 1		
			
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
				
         		nome=result.getNString(1);										    	//restituisce il risultato della colonna 1 della query 
         			
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
		
			try {
			
				ps.close();
				
				DriverManagerConnectionPool.releaseConnection(connection);
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			
			}
		}
		return null;
	}

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
				
         	String	nome=result.getNString(1);            							   //Istanzia la variabile con  il risultato della colonna 1 della query 

         	String 	edificio=result.getNString(2);          						   //Istanzia la variabile con  il risultato della colonna 2 della query 
			
         	aula.add(new Aula(nome,edificio));             							   //Istanzia e inserisce nella lista l'oggetto aula
		
         	}//Fine
         	
         	if(aula.isEmpty()) {  													   //Se la lista è vuota return null
         		 
         		return null;
         	
         	}else {  																   //altrimenti return la lista contente gli oggetti Aula
         	
         		return aula;
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
		return null;
	}

}
