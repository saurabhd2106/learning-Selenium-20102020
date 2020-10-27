package day5;

import java.sql.SQLException;

public class DemoTestJdbc {
	
	public static void main(String[] args) {
		
		try {
			
			TestJdbc testJdbc = new TestJdbc();
			
			testJdbc.openConnection("localhost", "TestDatabase", 3306, "root", "dmin@1234");
			
			System.out.println("Connection Established...");
			
			String sqlQuery = "CREATE TABLE Person (\n" + 
					"Id int NOT NULL UNIQUE,\n" + 
					"FirstName varchar(255) NOT NULL,\n" + 
					"LastName varchar(255) NOT NULL\n" + 
					")";
			
			testJdbc.executeSqlQuery(sqlQuery);
			
			System.out.println("SQL query executed successfully...");
			
			testJdbc.closeConnection();
			
			System.out.println("Connection closed....");
			
		} catch (SQLException e) {
			
			switch (e.getErrorCode()) {
			case 1045:
				System.out.println("Access denied, Username or password incorrect");
				System.out.println(e.getErrorCode() + " " + e.getMessage());
				break;

			default:
				System.out.println("Some execption occured.. command exeution unsuccessful..");
				
				
				break;
			}
			
			
			e.printStackTrace();
		}
	}

}
