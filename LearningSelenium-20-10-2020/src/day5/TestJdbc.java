package day5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	private Connection connection;

	public void openConnection(String server, String database, int portNumber, String username, String userPassword)
			throws SQLException {

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

	public void executePreparedSqlQuery(String sqlQuery, int Id, String firstName, String lastName) throws SQLException {


		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

		preparedStatement.setInt(1, Id);
		
		preparedStatement.setString(2, firstName);
		
		preparedStatement.setString(3, lastName);

		preparedStatement.executeUpdate();

	}
	
	public void executeSelectSqlQuery(String sqlQuery) throws SQLException {
		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sqlQuery);
		
		while (result.next()) {
			
			int Id = result.getInt(1);
			
			String firstName = result.getString(2);
			
			String lastName = result.getString(3);
			
			System.out.println("Id - "+ Id +  " FirstName - " + firstName + "LastName - "+ lastName);
			
		}
		
	}

}
