package in.co.rays.transactionhandle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Commit {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate("insert into emp values(2,'abc',1000,2)");
		 i=stmt.executeUpdate("insert into emp values   (2,'abc',1000,3)");
		 i=stmt.executeUpdate("insert into emp values    (3,'abc',1000,1)");
		 
		 System.out.println("data inserted"+i);
	}

}
