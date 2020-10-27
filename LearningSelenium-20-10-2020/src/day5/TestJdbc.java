package day5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJdbc {
	
	private Connection connection;
	
	public void openConnection(String server, String database, int portNumber, String username, String userPassword) throws SQLException {
		
		
		String connectionString = String.format("jdbc:mysql://%s:%d/%s", server, portNumber, database);
		
		connection = DriverManager.getConnection(connectionString, username, userPassword);
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	public void executeSqlQuery(String sqlQuery) throws SQLException {
		
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(sqlQuery);
		
	}

}
