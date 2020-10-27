package day5;

import java.sql.SQLException;

public class DemoInsertQuery {

public static void main(String[] args) {
		
		try {
			
			TestJdbc testJdbc = new TestJdbc();
			
			testJdbc.openConnection("localhost", "TestDatabase", 3306, "root", "admin@1234");
			
			System.out.println("Connection Established...");
			
			String sqlQuery = "INSERT INTO Person VALUES (2, \"Pranjal\", \"Sarap\")";
			
			testJdbc.executeSqlQuery(sqlQuery);
			
			System.out.println("SQL query executed successfully...");
			
			testJdbc.closeConnection();
			
			System.out.println("Connection closed....");
			
		} catch (SQLException e) {
			System.out.println("Some execption occured.. command exeution unsuccessful..");
			e.printStackTrace();
		}
	}
}
