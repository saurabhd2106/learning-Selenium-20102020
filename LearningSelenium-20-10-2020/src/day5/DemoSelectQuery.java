package day5;

import java.sql.SQLException;

public class DemoSelectQuery {

	public static void main(String[] args) {
		try {

			TestJdbc testJdbc = new TestJdbc();

			testJdbc.openConnection("localhost", "TestDatabase", 3306, "root", "admin@1234");

			System.out.println("Connection Established...");

			String sqlQuery = "Select * from Person";

			testJdbc.executeSelectSqlQuery(sqlQuery);

			System.out.println("SQL query executed successfully...");

			testJdbc.closeConnection();

			System.out.println("Connection closed....");

		} catch (SQLException e) {
			System.out.println("Some execption occured.. command exeution unsuccessful..");
			e.printStackTrace();
		}

	}

}
