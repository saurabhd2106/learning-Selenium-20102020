package day5;

import java.sql.SQLException;

public class DemoPreparedStatement {

	public static void main(String[] args) {
		
		try {
			
			TestJdbc testJdbc = new TestJdbc();
			
			testJdbc.openConnection("localhost", "TestDatabase", 3306, "root", "admin@1234");
			
			System.out.println("Connection Established...");
			
			
			String sqlQuery = "INSERT INTO Person VALUES (?, ?, ?)";
			
			int Id = 8;
			String firstName = "Saurabh";
			String lastName = "Dhingra";
			
			testJdbc.executePreparedSqlQuery(sqlQuery, Id, firstName, lastName);
			
			System.out.println("SQL query executed successfully...");
			
			testJdbc.closeConnection();
			
			System.out.println("Connection closed....");
			
		} catch (SQLException e) {
			System.out.println("Some execption occured.. command exeution unsuccessful..");
			e.printStackTrace();
		}


	}

}
