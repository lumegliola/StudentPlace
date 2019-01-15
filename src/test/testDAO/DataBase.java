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
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("aula.xml"));
	}

}