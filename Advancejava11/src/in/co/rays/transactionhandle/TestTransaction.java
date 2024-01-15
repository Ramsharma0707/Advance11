package in.co.rays.transactionhandle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws Exception {

		Connection conn = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into emp values(17,'lavi',2000,3)");
			i = stmt.executeUpdate("insert into emp values(18,'vish',3000,2)");

			i = stmt.executeUpdate("insert into emp values (19,'lavish'3100,2 )");
			System.out.println("data inserted=" + i);
		
			conn.commit();
			conn.close();

		}

		catch (Exception e) {
			e.getMessage();
			conn.rollback();
		}

	}
}
