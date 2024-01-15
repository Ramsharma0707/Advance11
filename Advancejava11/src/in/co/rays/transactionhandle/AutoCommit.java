package in.co.rays.transactionhandle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AutoCommit {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");

		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into emp values(1,'abc',1000,3)");
		i = stmt.executeUpdate("insert into emp values(1,'abc',1000,2)");
		i = stmt.executeUpdate("insert into emp values(2,'abc',1000,2)");

		conn.commit();
		System.out.println("data inserted" + i);
	}

}
