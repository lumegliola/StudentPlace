package test.testDAO;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class DataBase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentplacedb?serverTimezone = EST5EDT", "root", "root");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable("Aula","SELECT * FROM Aula ");
        partialDataSet.addTable("utente", "SELECT * FROM utente");
        partialDataSet.addTable("gds","SELECT * FROM gds");
        partialDataSet.addTable("iscrizione","SELECT * FROM iscrizione");
        partialDataSet.addTable("giorno","SELECT * FROM giorno");
        partialDataSet.addTable("orario","SELECT * FROM orario");
        partialDataSet.addTable("libera","SELECT * FROM libera");
        
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("database.  xml"));
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("aula.xml"));

	}

}