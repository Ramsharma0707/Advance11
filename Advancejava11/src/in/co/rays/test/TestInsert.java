package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance11", "root", "root");
		Statement stmt=conn.createStatement();
		
		int i=stmt.executeUpdate("insert into marksheet values(17,117,'mohit',45,15,65)");
		
		System.out.println("Data inserted =" +i);
	}

}
